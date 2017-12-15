package eshviewer;

import eshviewer.data.V500EventSetCode;
import java.math.BigDecimal;
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
@Path("V500EventSetCode")
public class V500EventSetCodeResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public V500EventSetCode getJson(@PathParam("id") BigDecimal id) {
            Session sess = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction tx = sess.beginTransaction();
            V500EventSetCode v500EventSetCode = sess.get(V500EventSetCode.class, id);
            tx.commit();
            sess.close();
            return v500EventSetCode;
    }

}
