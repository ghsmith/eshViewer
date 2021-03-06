package eshviewer;

import eshviewer.data.OrderCatalog;
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
@Path("OrderCatalog")
public class OrderCatalogResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public OrderCatalog getJson(@PathParam("id") BigDecimal id, @Context HttpServletResponse response) {
        response.setHeader("Expires", "0");
        Session sess = HibernateUtil.getSessionFactory().getCurrentSession();
        OrderCatalog orderCatalog = sess.get(OrderCatalog.class, id);
        return orderCatalog;
    }

}
