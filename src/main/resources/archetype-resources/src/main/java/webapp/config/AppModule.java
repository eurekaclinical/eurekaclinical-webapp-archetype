package ${package}.webapp.config;

import ${package}.webapp.client.WebappRouterTable;
import ${package}.webapp.props.WebappProperties;
import ${package}.client.Client;
import com.google.inject.AbstractModule;
import com.google.inject.servlet.SessionScoped;
import org.eurekaclinical.common.comm.clients.RouterTable;
import org.eurekaclinical.standardapis.props.CasEurekaClinicalProperties;

/**
 * Created by akalsan on 9/15/16.
 */
public class AppModule extends AbstractModule {

    private final WebappProperties properties;
    private final ClientProvider clientProvider;

    public AppModule(WebappProperties inProperties) {
        this.properties = inProperties;
        this.clientProvider = new ClientProvider(inProperties.getServiceUrl());
    }

    @Override
    protected void configure() {
        bind(RouterTable.class).to(WebappRouterTable.class).in(SessionScoped.class);
        bind(CasEurekaClinicalProperties.class).toInstance(this.properties);
        bind(Client.class).toProvider(this.clientProvider).in(SessionScoped.class);

    }
}
