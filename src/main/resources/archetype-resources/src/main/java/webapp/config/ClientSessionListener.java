package ${package}.webapp.config;

import com.google.inject.ConfigurationException;
import com.google.inject.Inject;
import com.google.inject.Injector;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import ${package}.client.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Andrew Post
 */
public class ClientSessionListener implements HttpSessionListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientSessionListener.class);

    @Inject
    private Injector injector;

    @Override
    public void sessionCreated(HttpSessionEvent hse) {
        LOGGER.info("Creating session for " + hse.getSession().getServletContext().getContextPath());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent hse) {
        LOGGER.info("Destroying session for " + hse.getSession().getServletContext().getContextPath());
        try {
            this.injector.getInstance(Client.class).close();
        } catch (ConfigurationException ce) {
        }
    }

}
