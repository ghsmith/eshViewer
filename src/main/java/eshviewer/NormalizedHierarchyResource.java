package eshviewer;

import eshviewer.data.NormalizedHierarchy;
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
@Path("/normalizedHierarchy")
public class NormalizedHierarchyResource {

    private static final Logger LOG = Logger.getLogger(NormalizedHierarchyResource.class.getName());

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public NormalizedHierarchy getJson(@PathParam("id") String id, @Context HttpServletResponse response) {
        response.setHeader("Expires", "0");
        loadCache();
        return normalizedHierarchyMapById.get(id);
        /* Session sess = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sess.beginTransaction();
        NormalizedHierarchy normalizedHierarchy = (NormalizedHierarchy)sess.createSQLQuery(
            "select x.* from (" + baseQuery + ") x where x.id = :id"
        )
            .addEntity(NormalizedHierarchy.class)
            .setParameter("id", id)
            .uniqueResult();
        tx.commit();
        sess.close();
        return normalizedHierarchy; */
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<NormalizedHierarchy> getJsonByParentId(@QueryParam("parentId") String parentId, @Context HttpServletResponse response) {
        response.setHeader("Expires", "0");
        loadCache();
        return normalizedHierarchyMapByParentId.get(parentId);
        /* Session sess = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sess.beginTransaction();
        List<NormalizedHierarchy> normalizedHierarchyList = (List<NormalizedHierarchy>)sess.createSQLQuery(
            "select x.* from (" + baseQuery + ") x where x.parent_id = :parent_id"
        )
            .addEntity(NormalizedHierarchy.class)
            .setParameter("parent_id", parentId)
            .list();
        tx.commit();
        sess.close();
        return normalizedHierarchyList; */
    }

    public static class JsTree {
        public String id;
        public String text;
        public Boolean children;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/jsTree")
    public List<JsTree> getJsonByIdJsTree(@QueryParam("parentId") String parentId, @Context HttpServletResponse response) {
        List jsTreeList = new ArrayList();
        for(NormalizedHierarchy normalizedHierarchy : getJsonByParentId(parentId, response)) {
            JsTree jsTree = new JsTree();
            jsTree.id = normalizedHierarchy.getId();
            jsTree.text = normalizedHierarchy.getDisp();
            jsTree.children = true;
            jsTreeList.add(jsTree);
        }
        return jsTreeList;
    }

    private static Boolean cached = false;
    private static Map<String, NormalizedHierarchy> normalizedHierarchyMapById = null;
    private static Map<String, List<NormalizedHierarchy>> normalizedHierarchyMapByParentId = null;
    
    private synchronized void loadCache() {
        if(!cached) {
            Session sess = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction tx = sess.beginTransaction();
            normalizedHierarchyMapById = new HashMap<String, NormalizedHierarchy>();
            normalizedHierarchyMapByParentId = new HashMap<String, List<NormalizedHierarchy>>();
            ScrollableResults results = sess.createSQLQuery(
                "select x.* from (" + baseQuery + ") x"
            )
                .addEntity(NormalizedHierarchy.class)
                .setFetchSize(25000)
                .scroll(ScrollMode.FORWARD_ONLY);
            int x = 0;
            while(results.next()) {
                NormalizedHierarchy normalizedHierarchy = (NormalizedHierarchy)results.get()[0];
                normalizedHierarchyMapById.put(normalizedHierarchy.getId(), normalizedHierarchy);
                if(normalizedHierarchyMapByParentId.get(normalizedHierarchy.getParentId()) == null) {
                    normalizedHierarchyMapByParentId.put(normalizedHierarchy.getParentId(), new ArrayList());
                }
                normalizedHierarchyMapByParentId.get(normalizedHierarchy.getParentId()).add(normalizedHierarchy);
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
    
    private static String baseQuery =
  "select "
+ "  sys_connect_by_path(hier.parent_event_set_cd, '.') || '.' || hier.event_set_cd id, "
+ "  sys_connect_by_path(hier.parent_event_set_cd, '.') parent_id, "
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
+ "  ) "
+ "  hier "
+ "start with "
+ "  hier.parent_event_set_cd = (select event_set_cd from v500_event_set_code where event_set_name_key = 'ALLOCFEVENTSETS') "
+ "connect by "
+ "  hier.parent_event_set_cd = prior hier.event_set_cd "
+ "order siblings by "
+ "  hier.event_set_collating_seq ";

}
