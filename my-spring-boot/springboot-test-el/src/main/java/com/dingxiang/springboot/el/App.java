package com.dingxiang.springboot.el;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App 
{
    public static void main( String[] args ) throws IOException {

        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(ElConfig.class);
        ElConfig resourceService=context.getBean(ElConfig.class);
        resourceService.outputResource();
        context.close();
    }
}
