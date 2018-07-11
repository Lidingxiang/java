package com.dingxiang;

import com.dingxiang.di.DiConfig;
import com.dingxiang.di.UseFunctionService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DiConfig.class);
        UseFunctionService useFunctionService = context.getBean(UseFunctionService.class);
        String sayHello = useFunctionService.SayHello("world");
        System.out.println(sayHello);
        context.close();
    }
}
