package ${package}.webapp.config;

import javax.servlet.ServletContext;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.servlet.GuiceServletContextListener;
import org.eurekaclinical.common.config.InjectorSupport;
import org.eurekaclinical.common.config.ClientSessionListener;
import org.eurekaclinical.common.config.ApiGatewayServletModule;
import ${package}.client.Client;
import ${package}.webapp.props.WebappProperties;

import javax.servlet.ServletContextEvent;

/**
 * Loaded on application startup, this class creates the Guice injector and
 * creates session listeners for managing the lifecycle of any 
 * {@link org.eurekaclinical.common.comm.clients.EurekaClinicalClient} REST API 
 * clients that this webapp accesses.
 */
public class ContextListener extends GuiceServletContextListener {

    private final WebappProperties properties;
    
    /**
     * Constructs an instance of this class.
     */
    public ContextListener() {
        this.properties = new WebappProperties();
    }

    /**
     * Binds any servlets, filters and classes, and creates and returns the 
     * Guice injector.
     * 
     * @return the Guice injector.
     */
    @Override
    protected Injector getInjector() {
        return new InjectorSupport(
                new Module[]{
                    new AppModule(this.properties),
                    new ApiGatewayServletModule(this.properties)},
                this.properties).getInjector();
    }

    /**
     * In addition to calling the superclass' <code>contextInitialized</code> 
     * method, it creates a session listener for each 
     * {@link org.eurekaclinical.common.comm.clients.EurekaClinicalClient} REST 
     * API client that this webapp accesses and adds it to the servlet context.
     * 
     * @param sce the servlet context event
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        super.contextInitialized(sce);
        ServletContext servletContext = sce.getServletContext();
        servletContext.addListener(new ClientSessionListener());
    }

}


