package cicada.web.tomcat;


import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;

import java.io.File;
import java.nio.charset.Charset;

public class TomcatConfig {
    public TomcatConfig() {
    }

    public EmbeddedServletContainerFactory servletContainer() {
        TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();
        tomcat.setUriEncoding(Charset.forName("UTF-8"));
        tomcat.addAdditionalTomcatConnectors(new Connector[]{this.createSslConnector()});
        return tomcat;
    }

    private Connector createSslConnector() {
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        Http11NioProtocol protocol = (Http11NioProtocol)connector.getProtocolHandler();

        try {
            File truststore = new File("/Users/liaokailin/software/ca1/keystore");
            connector.setScheme("https");
            protocol.setSSLEnabled(true);
            connector.setSecure(true);
            connector.setPort(8443);
            protocol.setKeystoreFile(truststore.getAbsolutePath());
            protocol.setKeystorePass("123456");
            protocol.setKeyAlias("springboot");
            return connector;
        } catch (Exception var4) {
            throw new IllegalStateException("cant access keystore: [keystore]  ", var4);
        }
    }

    private void customizeConnector(Connector connector) {
        Http11NioProtocol protocol = (Http11NioProtocol)connector.getProtocolHandler();
        protocol.setMaxConnections(2000);
        protocol.setMaxThreads(2000);
        protocol.setConnectionTimeout(30000);
    }
}
