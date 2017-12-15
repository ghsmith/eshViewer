package eshviewer;

import eshviewer.data.V500EventSetExplode;
import java.math.BigDecimal;
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
@Path("V500EventSetExplode")
// THIS TABLE HAS NO PRIMARY KEY SO JPA MAPPED ENTIRE TABLE AS "ID"
public class V500EventSetExplodeResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}.{parentId}") // THIS TABLE HAS NO PRIMARY KEY
    public List<V500EventSetExplode> getJson(@PathParam("id") BigDecimal id, @PathParam("parentId") BigDecimal parentId) {
            Session sess = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction tx = sess.beginTransaction();
            List<V500EventSetExplode> v500EventSetExplodeList = sess.createQuery(
                "from V500EventSetExplode where event_cd = :event_cd and event_set_cd = :event_set_cd",
                V500EventSetExplode.class
            )
                .setParameter("event_cd", id)
                .setParameter("event_set_cd", parentId)
                .list();
            tx.commit();
            sess.close();
            return v500EventSetExplodeList;
    }

}
