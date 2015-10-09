package atos.knowledgelab.capture.stream.config;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import com.sun.jersey.api.json.JSONConfiguration;
import com.sun.jersey.api.json.JSONJAXBContext;

import atos.knowledgelab.capture.bean.stream.StreamItem;

@Provider
public class JSONJAXBContextResolver implements ContextResolver<JAXBContext> {

    private JAXBContext context;
    private Class[] types = {StreamItem.class};

    public JSONJAXBContextResolver() throws JAXBException {
        this.context = new JSONJAXBContext(
                JSONConfiguration.mapped().build(),
                types);
    }

    public JAXBContext getContext(Class<?> objectType) {
        return (types[0].equals(objectType)) ? context : null;
    }
}
