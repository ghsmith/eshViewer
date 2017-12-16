package eshviewer;

import eshviewer.data.OrderCatalog;
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
@Path("OrderCatalog")
public class OrderCatalogResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public OrderCatalog getJson(@PathParam("id") BigDecimal id) {
            Session sess = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction tx = sess.beginTransaction();
            OrderCatalog orderCatalog = sess.get(OrderCatalog.class, id);
            tx.commit();
            sess.close();
            return orderCatalog;
    }

}
