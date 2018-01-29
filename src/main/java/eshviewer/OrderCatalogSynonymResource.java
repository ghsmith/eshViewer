package eshviewer;

import eshviewer.data.OrderCatalogSynonym;
import java.math.BigDecimal;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import org.hibernate.Session;

/**
 * REST Web Service
 *
 * @author ghsmith
 */
@Path("OrderCatalogSynonym")
public class OrderCatalogSynonymResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public OrderCatalogSynonym getJson(@PathParam("id") BigDecimal id, @Context HttpServletResponse response) {
        response.setHeader("Expires", "0");
        Session sess = HibernateUtil.getSessionFactory().getCurrentSession();
        OrderCatalogSynonym orderCatalogSynonym = sess.get(OrderCatalogSynonym.class, id);
        return orderCatalogSynonym;
    }

}
