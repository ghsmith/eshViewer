/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eshviewer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

@Provider
public class JerseyMapperProvider implements ContextResolver<ObjectMapper> {
    private static ObjectMapper om = null;
    @Override
    public ObjectMapper getContext(Class<?> type) {
        if(om == null) {
            om = new ObjectMapper();
            om.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        }
        return om;
    }
}