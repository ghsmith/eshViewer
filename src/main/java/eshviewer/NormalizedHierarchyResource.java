package eshviewer;

import eshviewer.data.NormalizedHierarchy;
import java.util.List;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * REST Web Service
 *
 * @author ghsmith
 */
@Path("/normalizedHierarchy")
public class NormalizedHierarchyResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public NormalizedHierarchy getJson(@PathParam("id") String id) {
        Session sess = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sess.beginTransaction();
        NormalizedHierarchy normalizedHierarchy = (NormalizedHierarchy)sess.createSQLQuery(
            "select cd || '.' || parent_cd id, x.* from (" + baseQuery + ") x where cd || '.' || parent_cd = :id"
        )
            .addEntity(NormalizedHierarchy.class)
            .setParameter("id", id)
            .uniqueResult();
        tx.commit();
        sess.close();
        return normalizedHierarchy;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/parentCd={parentCd}")
    public List<NormalizedHierarchy> getJsonByParentCd(@PathParam("parentCd") String parentCd) {
        Session sess = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sess.beginTransaction();
        List<NormalizedHierarchy> normalizedHierarchyList = (List<NormalizedHierarchy>)sess.createSQLQuery(
            "select cd || '.' || parent_cd id, x.* from (" + baseQuery + ") x where x.parent_cd = :parent_cd order by x.seq"
        )
            .addEntity(NormalizedHierarchy.class)
            .setParameter("parent_cd", parentCd)
            .list();
        tx.commit();
        sess.close();
        return normalizedHierarchyList;
    }

    private static String baseQuery =
        "select                                                                                                                    " +
        "    'event_set' node_type,                                                                                                " +
        "    esc.event_set_cd cd,                                                                                                  " +
        "    esc.parent_event_set_cd parent_cd,                                                                                    " +
        "    esc.event_set_collating_seq seq,                                                                                      " +
        "    (select event_set_cd_disp from v500_event_set_code where event_set_cd = esc.event_set_cd) disp                        " +
        "  from                                                                                                                    " +
        "    v500_event_set_canon esc                                                                                              " +
        "union all                                                                                                                 " +
        "  select                                                                                                                  " +
        "    'event_code' hierarchy_node_type,                                                                                     " +
        "    ese.event_cd event_set_cd,                                                                                            " +
        "    ese.event_set_cd parent_event_set_cd,                                                                                 " +
        "    ese.event_cd event_set_collating_seq,                                                                                 " +
        "    (select event_cd_disp from v500_event_code where event_cd = ese.event_cd) event_set_cd_disp                           " +
        "  from                                                                                                                    " +
        "    v500_event_set_explode ese                                                                                            " +
        "  where                                                                                                                   " +
        "    /* make sure this is associated with a terminal event set record */                                                   " +
        "    ese.event_set_cd in                                                                                                   " +
        "    (                                                                                                                     " +
        "      select                                                                                                              " +
        "        event_set_cd                                                                                                      " +
        "      from                                                                                                                " +
        "        v500_event_set_canon                                                                                              " +
        "      where                                                                                                               " +
        "        connect_by_isleaf = 1                                                                                             " +
        "      start with                                                                                                          " +
        "        parent_event_set_cd = (select event_set_cd from v500_event_set_code where event_set_name_key = 'ALLOCFEVENTSETS') " +
        "      connect by                                                                                                          " +
        "        parent_event_set_cd = prior event_set_cd                                                                          " +
        "    )                                                                                                                     " +
        "union all                                                                                                                 " +
        "  select                                                                                                                  " +
        "    'discrete_task_assay' hierarchy_node_type,                                                                            " +
        "    cver.parent_cd event_set_cd,                                                                                          " +
        "    cver.event_cd parent_event_set_cd,                                                                                    " +
        "    0 event_set_collating_seq,                                                                                            " +
        "    (select mnemonic from discrete_task_assay where task_assay_cd = cver.parent_cd) event_set_cd_disp                     " +
        "  from                                                                                                                    " +
        "    code_value_event_r cver                                                                                               ";
    
}
