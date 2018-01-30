package eshviewer;

import eshviewer.data.CodeValue;
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
@Path("CodeValue")
public class CodeValueResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public CodeValue getJson(@PathParam("id") BigDecimal id, @Context HttpServletResponse response) {
        response.setHeader("Expires", "0");
        Session sess = HibernateUtil.getSessionFactory().getCurrentSession();
        CodeValue codeValue = sess.get(CodeValue.class, id);
        codeValue.getCodeValueAliases();
        return codeValue;
    }

}
