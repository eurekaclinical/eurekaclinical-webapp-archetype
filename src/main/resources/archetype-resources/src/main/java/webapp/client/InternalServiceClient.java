package ${package}.webapp.client;

import org.eurekaclinical.common.comm.clients.EurekaClinicalClient;


/**
 * Created by akalsan on 9/21/16.
 */
public class InternalServiceClient extends EurekaClinicalClient {

    private final String serviceUrl;

    public InternalServiceClient(String inServiceUrl) {
        super(null);
        this.serviceUrl = inServiceUrl;
    }

    @Override
    protected String getResourceUrl() {
        return this.serviceUrl;
    }

}
