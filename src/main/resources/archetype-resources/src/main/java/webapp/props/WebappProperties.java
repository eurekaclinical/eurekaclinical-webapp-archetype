package ${package}.webapp.props;


import org.eurekaclinical.standardapis.props.CasEurekaClinicalProperties;

/**
 * Created by akalsan on 9/15/16.
 */
public class WebappProperties extends CasEurekaClinicalProperties {

    public String getServiceUrl() {
        return getValue("${propertyNamespace}.service.url");
    }

    public String getUrl() {
        return getValue("${propertyNamespace}.webapp.url");
    }

    public WebappProperties() {
        super("/etc/${shortNamespace}");
    }

    @Override
    public String getProxyCallbackServer() {
        return getValue("${propertyNamespace}.webapp.callbackserver");
    }
}
