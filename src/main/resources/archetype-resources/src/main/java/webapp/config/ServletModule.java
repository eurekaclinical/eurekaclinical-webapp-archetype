package ${package}.webapp.config;


import org.eurekaclinical.common.config.AbstractAuthorizingServletModule;
import org.eurekaclinical.common.servlet.DestroySessionServlet;
import org.eurekaclinical.common.servlet.PostMessageLoginServlet;
import org.eurekaclinical.common.servlet.ProxyServlet;
import ${package}.webapp.props.WebappProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by akalsan on 9/15/16.
 */
public class ServletModule extends AbstractAuthorizingServletModule {

    private final WebappProperties properties;

    public ServletModule(WebappProperties inProperties) {
        super(inProperties);
        this.properties = inProperties;
    }

    @Override
    protected void setupServlets() {
        serve("/protected/get-session").with(PostMessageLoginServlet.class);
        serve("/proxy-resource/*").with(ProxyServlet.class);
        serve("/destroy-session").with(DestroySessionServlet.class);
    }

    @Override
    protected Map<String, String> getCasValidationFilterInitParams() {
        Map<String, String> params = new HashMap<>();
        params.put("casServerUrlPrefix", this.properties.getCasUrl());
        params.put("serverName", this.properties.getProxyCallbackServer());
        params.put("proxyCallbackUrl", getCasProxyCallbackUrl());
        params.put("proxyReceptorUrl", getCasProxyCallbackPath());
        return params;
    }
}
