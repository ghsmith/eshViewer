/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eshviewer;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import org.hibernate.SessionFactory;
import org.hibernate.StaleObjectStateException;

/**
 * Servlet filter to release the Hibernate database session from the thread.
 * This is an implementation of the "open session in view" pattern of session
 * management, where the Hibernate database session is open during the view
 * rendering, preventing the controller from having to eagerly load any
 * associations. This is modified from:
 *
 * https://community.jboss.org/wiki/OpenSessionInView
 *
 * @author geoffrey.hughes.smith@gmail.com
 */
@WebFilter(filterName = "HibernateSessionRequestFilter", urlPatterns = {"/*"})
public class HibernateSessionRequestFilter implements Filter {

    private static Logger log = Logger
            .getLogger(HibernateSessionRequestFilter.class.getName());
    private SessionFactory sf;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        try {
            // log.debug("Starting a database transaction");
            sf.getCurrentSession().beginTransaction();

            // Call the next filter (continue request processing)
            chain.doFilter(request, response);

            // Commit and cleanup
            if (sf.getCurrentSession().getTransaction().isActive()) {
                //log.fine("Committing the database transaction");
                sf.getCurrentSession().getTransaction().rollback();
            }

        } catch (StaleObjectStateException staleEx) {
            log.log(Level.SEVERE, "This interceptor does not implement optimistic concurrency control!");
            log.log(Level.SEVERE, "Your application will not work until you add compensation actions!");
            // Rollback, close everything, possibly compensate for any permanent changes
            // during the conversation, and finally restart business conversation. Maybe
            // give the user of the application a chance to merge some of his work with
            // fresh data... what you do here depends on your applications design.
            throw staleEx;
        } catch (Throwable ex) {
            // Rollback only
            ex.printStackTrace();
            try {
                if (sf.getCurrentSession().getTransaction().isActive()) {
                    log.fine("Trying to rollback database transaction after exception");
                    sf.getCurrentSession().getTransaction().rollback();
                }
            } catch (Throwable rbEx) {
                log.log(Level.SEVERE, "Could not rollback transaction after exception!",
                        rbEx);
            }

            // Let others handle it... maybe another interceptor for exceptions?
            throw new ServletException(ex);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.fine("Initializing filter...");
        log.fine("Obtaining SessionFactory from static HibernateUtil singleton");
        sf = HibernateUtil.getSessionFactory();
    }

    @Override
    public void destroy() {
    }
    
}
