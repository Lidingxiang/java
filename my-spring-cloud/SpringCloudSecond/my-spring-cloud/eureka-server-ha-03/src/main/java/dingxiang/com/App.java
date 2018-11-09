package dingxiang.com;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Hello world!
 *
 */
@EnableEurekaServer /*通过 @EnableEurekaServer 注解启动 一 个服务注册中心提供给其他应用进行对话*/
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        new SpringApplicationBuilder(App.class).web(true).run(args);
    }
}
