package eshviewer;

import eshviewer.data.DiscreteTaskAssay;
import eshviewer.data.ProfileTaskR;
import java.math.BigDecimal;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * REST Web Service
 *
 * @author ghsmith
 */
@Path("DiscreteTaskAssay")
public class DiscreteTaskAssayResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public DiscreteTaskAssay getJson(@PathParam("id") BigDecimal id) {
            Session sess = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction tx = sess.beginTransaction();
            DiscreteTaskAssay discreteTaskAssay = sess.get(DiscreteTaskAssay.class, id);
            Hibernate.initialize(discreteTaskAssay.getProfileTaskRs());
            tx.commit();
            sess.close();
            return discreteTaskAssay;
    }

}
