/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eshviewer;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author ghsmith
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<Class<?>>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(eshviewer.CodeValueEventRResource.class);
        resources.add(eshviewer.CodeValueResource.class);
        resources.add(eshviewer.DiscreteTaskAssayResource.class);
        resources.add(eshviewer.JerseyMapperProvider.class);
        resources.add(eshviewer.NormalizedHierarchyNodeResource.class);
        resources.add(eshviewer.OrderCatalogResource.class);
        resources.add(eshviewer.OrderCatalogSynonymResource.class);
        resources.add(eshviewer.V500EventCodeResource.class);
        resources.add(eshviewer.V500EventSetCanonResource.class);
        resources.add(eshviewer.V500EventSetCodeResource.class);
        resources.add(eshviewer.V500EventSetExplodeResource.class);
    }
    
}
