package com.ly;

import com.ly.driver.GetAppInfoRet;
import com.ly.driver.OAth2AppInfoService;
import org.apache.thrift.TException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 */
@SpringBootApplication
@ComponentScan("cicada")
public class App {
    public static void main(String[] args) throws TException {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(App.class, args);

        OAth2AppInfoService.Iface iface = applicationContext.getBean(OAth2AppInfoService.Iface.class);

        GetAppInfoRet ret = iface.GetAppInfo("ce0e4e2450c0414f9f9c30848e7621dd");

        System.out.println(ret.getStatus());
    }
}
