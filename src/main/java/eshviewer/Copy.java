package eshviewer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;

public class Copy {

    static Connection connectionT = null;
    static Connection connectionS = null;

    public static void copyTable(String tableName) throws SQLException {

        ResultSet rs = connectionT.createStatement().executeQuery(String.format("select * from %s where 1 = 2", tableName));
        ResultSetMetaData rsmd = rs.getMetaData();
        List colListS = new ArrayList();
        List colListT = new ArrayList();
        for(int col = 1; col <= rsmd.getColumnCount(); col++) {
            colListS.add(rsmd.getColumnName(col));
            colListT.add("?");
        }
        String colStringS = String.join(",", (String[])colListS.toArray(new String[0]));
        String colStringT = String.join(",", (String[])colListT.toArray(new String[0]));

        PreparedStatement pstmtT = connectionT.prepareStatement(String.format("insert into %s values (%s)", tableName, colStringT));
        
        Statement stmtS = connectionS.createStatement();
        stmtS.setFetchSize(1000);
        ResultSet rsS = stmtS.executeQuery(String.format("select %s from hnamdwh.%s", colStringS, tableName));
        int rowCount = 0;
        while(rsS.next()) {
            pstmtT.clearParameters();
            for(int col = 1; col <= rsmd.getColumnCount(); col++) {
                if("NUMBER".equals(rsmd.getColumnTypeName(col))) {
                    ((OraclePreparedStatement)pstmtT).setNUMBER(col, ((OracleResultSet)rsS).getNUMBER(col));
                }
                else if("VARCHAR2".equals(rsmd.getColumnTypeName(col))) {
                    ((OraclePreparedStatement)pstmtT).setString(col, ((OracleResultSet)rsS).getString(col));
                }
                else if("DATE".equals(rsmd.getColumnTypeName(col))) {
                    ((OraclePreparedStatement)pstmtT).setDATE(col, ((OracleResultSet)rsS).getDATE(col));
                }
                else if("TIMESTAMP".equals(rsmd.getColumnTypeName(col))) {
                    ((OraclePreparedStatement)pstmtT).setTIMESTAMP(col, ((OracleResultSet)rsS).getTIMESTAMP(col));
                }
                else {
                    throw new RuntimeException("unknown type " + rsmd.getColumnTypeName(col));
                }
            }
            pstmtT.addBatch();
            rowCount++;
            if(rowCount % 1000 == 0) {
                System.out.println(String.format("%s: %d", tableName, rowCount));
                pstmtT.executeBatch();
                connectionT.commit();
                pstmtT.clearBatch();
            }
        }
        System.out.println(String.format("%s: %d", tableName, rowCount));
        pstmtT.executeBatch();
        connectionT.commit();
        stmtS.close();
        
        pstmtT.close();
        
    }
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("oracle.jdbc.driver.OracleDriver");
        connectionS = DriverManager.getConnection("","","");
        connectionS.setAutoCommit(false);
        connectionS.createStatement().execute("set role hnam_sel_all");
        connectionT = DriverManager.getConnection("","","");
        connectionT.setAutoCommit(false);
        
        copyTable("CODE_VALUE");
        copyTable("CODE_VALUE_ALIAS");
        copyTable("CODE_VALUE_EVENT_R");
        copyTable("CODE_VALUE_SET");
        copyTable("DISCRETE_TASK_ASSAY");
        copyTable("OCS_FACILITY_R");
        copyTable("ORDER_CATALOG");
        copyTable("ORDER_CATALOG_SYNONYM");
        copyTable("PROFILE_TASK_R");
        copyTable("V500_EVENT_CODE");
        copyTable("V500_EVENT_SET_CANON");
        copyTable("V500_EVENT_SET_CODE");
        copyTable("V500_EVENT_SET_EXPLODE");
        
        connectionS.close();
        connectionT.close();
        
    }
    
}
