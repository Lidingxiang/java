package cicada.web.tomcat;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.boot.context.embedded.EmbeddedServletContainer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.servlet.ServletContextInitializer;

public class CicadaEmbeddedServletContainerFactory extends TomcatEmbeddedServletContainerFactory {
    public CicadaEmbeddedServletContainerFactory() {
    }

    public EmbeddedServletContainer getEmbeddedServletContainer(ServletContextInitializer... initializers) {
        return super.getEmbeddedServletContainer(initializers);
    }

    protected void customizeConnector(Connector connector) {
        super.customizeConnector(connector);
        Http11NioProtocol protocol = (Http11NioProtocol)connector.getProtocolHandler();
        protocol.setMaxConnections(2000);
        protocol.setMaxThreads(2000);
        protocol.setConnectionTimeout(30000);
    }
}
