package eshviewer;

import eshviewer.data.V500EventCode;
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
@Path("V500EventCode")
public class V500EventCodeResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public V500EventCode getJson(@PathParam("id") BigDecimal id, @Context HttpServletResponse response) {
        response.setHeader("Expires", "0");
        Session sess = HibernateUtil.getSessionFactory().getCurrentSession();
        V500EventCode v500EventCode = sess.get(V500EventCode.class, id);
        return v500EventCode;
    }

}
