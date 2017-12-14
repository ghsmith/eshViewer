package eshviewer;

import eshviewer.data.NormalizedHierarchyNode;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * REST Web Service
 *
 * @author ghsmith
 */
@Path("/normalizedHierarchyNode")
public class NormalizedHierarchyNodeResource {

    private static final Logger LOG = Logger.getLogger(NormalizedHierarchyNodeResource.class.getName());

    public static class JsTree {
        public String id;
        public String text;
        public Boolean children;
        public String nodeType;
        public String cd;
        public String parentCd;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public NormalizedHierarchyNode getJson(@PathParam("id") String id, @Context HttpServletResponse response) {
        response.setHeader("Expires", "0");
        loadCache();
        return nhnMapById.get(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<NormalizedHierarchyNode> getJsonByParentId(@QueryParam("parentId") String parentId, @Context HttpServletResponse response) {
        response.setHeader("Expires", "0");
        loadCache();
        return nhnMapById.get(parentId).getChildren();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/jsTree")
    public List<JsTree> getJsonByParentIdJsTree(@QueryParam("parentId") String parentId, @Context HttpServletResponse response) {
        List jsTreeList = new ArrayList();
        for(NormalizedHierarchyNode nhn : getJsonByParentId(parentId, response)) {
            JsTree jsTree = new JsTree();
            jsTree.id = nhn.getId();
            if("event_set".equals(nhn.getNodeType())) {
                jsTree.text = "[S] " + nhn.getDisp();
            }
            else if("event_code".equals(nhn.getNodeType())) {
                jsTree.text = "[C] " + nhn.getDisp();
            }
            else if("discrete_task_assay".equals(nhn.getNodeType())) {
                jsTree.text = "[D] " + nhn.getDisp();
            }
            else if("primary_mnemonic".equals(nhn.getNodeType())) {
                jsTree.text = "[M] " + nhn.getDisp();
            }
            else {
                jsTree.text = "[?] " + nhn.getDisp();
            }
            jsTree.children = (getJsonByParentId(nhn.getId(), response) != null);
            jsTree.nodeType = nhn.getNodeType();
            jsTree.cd = nhn.getCd();
            jsTree.parentCd = nhn.getParentCd();
            jsTreeList.add(jsTree);
        }
        return jsTreeList;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/searchResult")
    public Map<String, Integer> getJsonSearchResult(@QueryParam("searchString") String searchString, @Context HttpServletResponse response) {
        response.setHeader("Expires", "0");
        loadCache();
        Map<String, Integer> searchResultMap = new HashMap();
        search(rootNhn, searchString, searchResultMap);
        return searchResultMap;
    }

    private static Boolean cached = false;
    private static NormalizedHierarchyNode rootNhn;
    private static Map<String, NormalizedHierarchyNode> nhnMapById = null;
    
    private synchronized void loadCache() {
        if(!cached) {
            Session sess = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction tx = sess.beginTransaction();
            nhnMapById = new HashMap<String, NormalizedHierarchyNode>();
            rootNhn = (NormalizedHierarchyNode)sess.createSQLQuery(
                "select x.* from (" + rootQuery + ") x"
            )
                .addEntity(NormalizedHierarchyNode.class)
                .uniqueResult();
            nhnMapById.put(rootNhn.getId(), rootNhn);
            ScrollableResults results = sess.createSQLQuery(
                "select x.* from (" + hierarchicalQuery + ") x"
            )
                .addEntity(NormalizedHierarchyNode.class)
                .setFetchSize(25000)
                .scroll(ScrollMode.FORWARD_ONLY);
            int x = 0;
            while(results.next()) {
                NormalizedHierarchyNode nhn = (NormalizedHierarchyNode)results.get()[0];
                nhnMapById.put(nhn.getId(), nhn);
                NormalizedHierarchyNode parentNhn = nhnMapById.get(nhn.getParentId());
                if(parentNhn != null) {
                    nhn.setParent(parentNhn);
                    if(parentNhn.getChildren() == null) {
                        parentNhn.setChildren(new ArrayList());
                    }
                    parentNhn.getChildren().add(nhn);
                }
                x++;
                if(x % 5000 == 0) {
                    LOG.info(x + " rows cached");
                }
            }
            tx.commit();
            sess.close();
            cached = true;
        }
    }
    
    private void search(NormalizedHierarchyNode nhn, String searchString, Map<String, Integer> searchResultMap) {
        if(
            (nhn.getDisp() != null && nhn.getDisp().toUpperCase().contains(searchString.toUpperCase()))
            || (nhn.getCd() != null && nhn.getCd().toUpperCase().contains(searchString.toUpperCase()))
        ) {
            NormalizedHierarchyNode nhnWalker = nhn;
            while(nhnWalker != null) {
                if(searchResultMap.get(nhnWalker.getId()) == null) {
                    searchResultMap.put(nhnWalker.getId(), 0);
                }
                searchResultMap.put(nhnWalker.getId(), searchResultMap.get(nhnWalker.getId()).intValue() + 1);
                nhnWalker = nhnWalker.getParent();
            }
        }
        if(nhn.getChildren() != null) {
            for(NormalizedHierarchyNode childNhn : nhn.getChildren()) {
                search(childNhn, searchString, searchResultMap);
            }
        }
        return;
    }
    
    private final static String rootQuery =    
  "select "
+ "  lower(rawtohex(utl_raw.cast_to_raw(sys.dbms_obfuscation_toolkit.md5(input_string => '.' || event_set_cd)))) id, "
+ "  NULL parent_id, "
+ "  'event_set' node_type, "
+ "  event_set_cd cd, "
+ "  NULL parent_cd, "
+ "  0 seq, "
+ "  event_set_cd_disp disp "
+ "from "
+ "  v500_event_set_code "
+ "where "
+ "  event_set_name_key = 'ALLOCFEVENTSETS' ";

    private final static String hierarchicalQuery =
  "select "
+ "  lower(rawtohex(utl_raw.cast_to_raw(sys.dbms_obfuscation_toolkit.md5(input_string => sys_connect_by_path(hier.parent_event_set_cd, '.') || '.' || hier.event_set_cd)))) id, "
+ "  lower(rawtohex(utl_raw.cast_to_raw(sys.dbms_obfuscation_toolkit.md5(input_string => sys_connect_by_path(hier.parent_event_set_cd, '.'))))) parent_id, "
+ "  hier.hierarchy_node_type node_type, "
+ "  hier.event_set_cd cd, "
+ "  hier.parent_event_set_cd parent_cd, "
+ "  hier.event_set_collating_seq seq, "
+ "  hier.event_set_cd_disp disp "
+ "from "
+ "  ( "
+ "    /*-- ************************************************************************* "
+ "    -- in-line view normalizes (1) event set, (2) event code, and (3) DTA "
+ "    -- hierarchies to use event set hierarchy column names; this assumes no "
+ "    -- intersecting IDs between the three hierarchies (which is true as of the "
+ "    -- time of writing) "
+ "    -- **************************************************************************/ "
+ "      select "
+ "        'event_set' hierarchy_node_type, "
+ "        esc.event_set_cd, "
+ "        esc.parent_event_set_cd, "
+ "        esc.event_set_collating_seq, "
+ "        (select event_set_cd_disp from v500_event_set_code where event_set_cd = esc.event_set_cd) event_set_cd_disp "
+ "      from "
+ "        v500_event_set_canon esc "
+ "    union all "
+ "      select "
+ "        'event_code' hierarchy_node_type, "
+ "        ese.event_cd event_set_cd, "
+ "        ese.event_set_cd parent_event_set_cd, "
+ "        ese.event_cd event_set_collating_seq, "
+ "        (select event_cd_disp from v500_event_code where event_cd = ese.event_cd) event_set_cd_disp "
+ "      from "
+ "        v500_event_set_explode ese "
+ "      where "
+ "        /*-- make sure this is associated with a terminal event set record*/ "
+ "        ese.event_set_cd in "
+ "        ( "
+ "          select "
+ "            event_set_cd "
+ "          from "
+ "            v500_event_set_canon "
+ "          where "
+ "            connect_by_isleaf = 1 "
+ "          start with "
+ "            parent_event_set_cd = (select event_set_cd from v500_event_set_code where event_set_name_key = 'ALLOCFEVENTSETS') "
+ "          connect by "
+ "            parent_event_set_cd = prior event_set_cd "
+ "        ) "
+ "    union all "
+ "      select "
+ "        'discrete_task_assay' hierarchy_node_type, "
+ "        cver.parent_cd event_set_cd, "
+ "        cver.event_cd parent_event_set_cd, "
+ "        0 event_set_collating_seq, "
+ "        (select mnemonic from discrete_task_assay where task_assay_cd = cver.parent_cd) event_set_cd_disp "
+ "      from "
+ "        code_value_event_r cver "
+ "      union all "
+ "        select "
+ "          'primary_mnemonic' hierarchy_node_type, "
+ "          oc.catalog_cd event_set_cd, "
+ "          ptr.task_assay_cd parent_event_set_cd, "
+ "          0 event_set_collating_seq, "
+ "          oc.primary_mnemonic event_set_cd_disp "
+ "        from "
+ "          profile_task_r ptr, "
+ "          order_catalog oc "
+ "        where "
+ "          ptr.catalog_cd = oc.catalog_cd "
+ "  ) "
+ "  hier "
+ "start with "
+ "  hier.parent_event_set_cd = (select event_set_cd from v500_event_set_code where event_set_name_key = 'ALLOCFEVENTSETS') "
+ "connect by "
+ "  hier.parent_event_set_cd = prior hier.event_set_cd "
+ "order siblings by "
+ "  hier.event_set_collating_seq ";
    
}
