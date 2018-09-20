package com.ly;

import cicada.core.BeanFactory;
import cicada.thrift.server.RpcServer;
import com.ly.driver.OAth2AppInfoService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 */
@EnableAutoConfiguration()
@MapperScan("com.ly.bll.dao")
@ComponentScan(basePackages = {"cicada", "com.ly"})
//public class App implements CommandLineRunner {
public class App {
    public static void main(String[] args) {

        ConfigurableApplicationContext applicationContext = SpringApplication.run(App.class, args);
        RpcServer rpcServer = applicationContext.getBean(RpcServer.class);
        rpcServer.run(OAth2AppInfoService.Iface.class);
    }

// public static void main(String[] args)
//    {
//        SpringApplication.run(App.class, args);
//    }

//    @Override
//    public void run(String... args) {
//        @SuppressWarnings("resource")
//        RpcServer server = BeanFactory.getBeanByType(RpcServer.class);
//        server.run(OAth2AppInfoService.Iface.class);
//        System.out.println("rpc服务开始");
//    }
}
