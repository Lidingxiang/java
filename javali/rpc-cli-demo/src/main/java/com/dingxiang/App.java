package com.dingxiang;

import com.dingxiang.hellodriver.HelloWorldService;
import org.apache.thrift.TException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Hello world!
 */
@SpringBootApplication
public class App {
    public static void main(String[] args) throws TException {

        ConfigurableApplicationContext applicationContext = SpringApplication.run(App.class);
        HelloWorldService.Iface iface = applicationContext.getBean(HelloWorldService.Iface.class);

        String ret = iface.sayHello("ldx");
        System.out.println("sayHello:" + ret);

        String random = iface.getRandom();
        System.out.println("getRandom:" + random);
    }
}
