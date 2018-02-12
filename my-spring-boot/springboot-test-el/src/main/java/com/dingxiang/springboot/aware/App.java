package com.dingxiang.springboot.aware;

import com.dingxiang.springboot.aop.AopConfig;
import com.dingxiang.springboot.aop.DemoAnnotationService;
import com.dingxiang.springboot.aop.DemoMethodService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 */
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AwareConfig.class);
        AwareService awareService = context.getBean(AwareService.class);
        awareService.outputResult();

        context.close();
    }
}
