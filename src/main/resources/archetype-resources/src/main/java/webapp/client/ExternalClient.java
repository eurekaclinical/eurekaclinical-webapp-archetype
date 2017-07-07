package ${package}.webapp.client;

import org.eurekaclinical.common.comm.clients.EurekaClinicalClient;

/**
 * Created by akalsan on 9/29/16.
 */
public final class ExternalClient extends EurekaClinicalClient {

    private final String webappURL;

    public ExternalClient(String inWebappUrl) {
        super(null);
        this.webappURL = inWebappUrl;
    }

    @Override
    protected String getResourceUrl() {
        return this.webappURL;
    }
}
