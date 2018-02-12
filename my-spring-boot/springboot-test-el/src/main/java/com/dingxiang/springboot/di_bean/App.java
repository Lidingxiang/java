package com.dingxiang.springboot.di_bean;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(JavaConfig.class);

        UseFunctionService useFunctionService=context.getBean(UseFunctionService.class);

        System.out.println(useFunctionService.SayHello("di"));

        context.close();
    }
}
