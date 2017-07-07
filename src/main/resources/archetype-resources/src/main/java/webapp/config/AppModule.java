package ${package}.webapp.config;

import ${package}.webapp.client.ExternalClient;
import ${package}.webapp.client.InternalServiceClient;
import ${package}.webapp.client.ServiceClientRouterTable;
import ${package}.webapp.props.WebappProperties;
import com.google.inject.AbstractModule;
import org.eurekaclinical.common.comm.clients.RouterTable;
import org.eurekaclinical.standardapis.props.CasEurekaClinicalProperties;

/**
 * Created by akalsan on 9/15/16.
 */
public class AppModule extends AbstractModule {

    private final WebappProperties properties;
    private final InternalServiceClient serviceClient;
    private final ExternalClient externalWebappClient;

    public AppModule(WebappProperties inProperties) {
        this.properties = inProperties;
        this.serviceClient = new InternalServiceClient(this.properties.getServiceUrl());
        this.externalWebappClient = new ExternalClient(this.properties.getUrl());
    }

    @Override
    protected void configure() {
        bind(RouterTable.class).to(ServiceClientRouterTable.class);
        bind(CasEurekaClinicalProperties.class).toInstance(this.properties);
        bind(InternalServiceClient.class).toInstance(this.serviceClient);
        bind(ExternalClient.class).toInstance(this.externalWebappClient);

    }
}
