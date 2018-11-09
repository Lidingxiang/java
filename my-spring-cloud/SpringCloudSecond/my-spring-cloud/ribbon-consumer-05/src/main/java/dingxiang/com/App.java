package dingxiang.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Hello world!
 */
@EnableDiscoveryClient /*通过 @EnableDiscoveryClient 注解让该应用注册为 Eureka 客户端应用, 以获得服务发现的能力*/
@SpringBootApplication
public class App {

    /*
    * 并通过 @LoadBalanced 注解开启客户端负载均衡*/
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
