package eshviewer;

import eshviewer.data.CodeValueEventR;
import java.math.BigDecimal;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * REST Web Service
 *
 * @author ghsmith
 */
@Path("CodeValueEventR")
// THIS TABLE HAS NO PRIMARY KEY SO JPA MAPPED ENTIRE TABLE AS "ID"
public class CodeValueEventRResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}.{parentId}") // THIS TABLE HAS NO PRIMARY KEY
    public List<CodeValueEventR> getJson(@PathParam("id") BigDecimal id, @PathParam("parentId") BigDecimal parentId, @Context HttpServletResponse response) {
        response.setHeader("Expires", "0");
        Session sess = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sess.beginTransaction();
        List<CodeValueEventR> codeValueEventRList = sess.createQuery(
            "from CodeValueEventR where parent_cd = :parent_cd and event_cd = :event_cd",
            CodeValueEventR.class
        )
            .setParameter("parent_cd", id)
            .setParameter("event_cd", parentId)
            .list();
        tx.commit();
        sess.close();
        return codeValueEventRList;
    }

}
