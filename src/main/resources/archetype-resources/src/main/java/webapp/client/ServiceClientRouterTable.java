package ${package}.webapp.client;

import org.eurekaclinical.common.comm.clients.Route;
import org.eurekaclinical.common.comm.clients.RouterTable;

import javax.inject.Inject;

/**
 * Created by akalsan on 9/15/16.
 */
public class ServiceClientRouterTable implements RouterTable {

    private final InternalServiceClient client;

    @Inject
    public ServiceClientRouterTable(InternalServiceClient inClient) {
        this.client = inClient;
    }

    @Override
    public Route[] load() {
        return new Route[]{new Route("/", "/api/protected/", this.client)};
    }

}
