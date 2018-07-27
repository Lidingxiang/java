package com.dingxiang;

import com.dingxiang.hellodriver.HelloWorldService;
import com.dingxiang.server.RpcServer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class App implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        RpcServer server = BeanFactory.getBeanByType(RpcServer.class);
        server.run(HelloWorldService.Iface.class);
        System.out.println("rpc服务开始");
    }
}
