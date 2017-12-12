package eshviewer;

import eshviewer.data.OrderCatalog;
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
@Path("/orderCatalog")
public class OrderCatalogResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{catalogCd}")
    public OrderCatalog getJson(@PathParam("catalogCd") String catalogCd) {
        Session sess = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sess.beginTransaction();
        OrderCatalog orderCatalog = (OrderCatalog)sess.createQuery("from OrderCatalog where catalog_cd = :catalog_cd").setParameter("catalog_cd", catalogCd).getSingleResult();
        tx.commit();
        sess.close();
        return orderCatalog;
    }

}
