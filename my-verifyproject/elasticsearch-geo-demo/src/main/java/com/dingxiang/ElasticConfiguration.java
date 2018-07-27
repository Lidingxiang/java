package com.dingxiang;

import com.google.common.base.Strings;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.xpack.client.PreBuiltXPackTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.net.InetSocketAddress;

@Configuration
@ComponentScan("com.dingxiang")
//@EnableAutoConfiguration
public class ElasticConfiguration {

    @Value("${elasticsearch.user:}")
    String user;

    @Value("${elasticsearch.clusterNodes}")
    String clusterNodes;

    @Bean
    public Client client() {
        Settings.Builder builder = Settings.builder().put("client.transport.sniff", true);

        if (!Strings.isNullOrEmpty(user)) {
            builder.put("xpack.security.user", user);
        }
        PreBuiltXPackTransportClient client = new PreBuiltXPackTransportClient(builder.build());

        String[] nodes = clusterNodes.split(",");
        for (String node : nodes) {
            String[] items = node.split(":");

            client.addTransportAddress(new InetSocketTransportAddress(new InetSocketAddress(items[0], Integer.parseInt(items[1]))));
        }
        return client;
    }
}
