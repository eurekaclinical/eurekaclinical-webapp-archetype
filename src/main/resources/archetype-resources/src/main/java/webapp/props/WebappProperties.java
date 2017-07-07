#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
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

    public WebappProperties(String projectName) {
        super("/etc/" + projectName);

    }

    @Override
    public String getProxyCallbackServer() {
        return getValue("${propertyNamespace}.webapp.callbackserver");
    }
}
