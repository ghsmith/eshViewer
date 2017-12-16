package eshviewer;

import eshviewer.data.V500EventSetCanon;
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
@Path("V500EventSetCanon")
// THIS TABLE HAS NO PRIMARY KEY SO JPA MAPPED ENTIRE TABLE AS "ID"
public class V500EventSetCanonResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}.{parentId}") // THIS TABLE HAS NO PRIMARY KEY
    public List<V500EventSetCanon> getJson(@PathParam("id") BigDecimal id, @PathParam("parentId") BigDecimal parentId, @Context HttpServletResponse response) {
        response.setHeader("Expires", "0");
        Session sess = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sess.beginTransaction();
        List<V500EventSetCanon> v500EventSetCanonList = sess.createQuery(
            "from V500EventSetCanon where event_set_cd = :event_set_cd and parent_event_set_cd = :parent_event_set_cd",
            V500EventSetCanon.class
        )
            .setParameter("event_set_cd", id)
            .setParameter("parent_event_set_cd", parentId)
            .list();
        tx.commit();
        sess.close();
        return v500EventSetCanonList;
    }

}
