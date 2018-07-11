package com.dingxiang;

import com.dingxiang.javaconfig.JavaConfig;
import com.dingxiang.javaconfig.UseFunctionService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        UseFunctionService useFunctionService = context.getBean(UseFunctionService.class);
        String sayHello = useFunctionService.SayHello("world");
        System.out.println(sayHello);
        context.close();
    }
}
