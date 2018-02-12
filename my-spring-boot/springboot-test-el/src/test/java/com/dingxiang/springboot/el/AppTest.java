package com.dingxiang.springboot.el;

import junit.framework.TestCase;
import org.springframework.boot.autoconfigure.condition.ResourceCondition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase
{

    public void testApp() throws IOException {

        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(ResourceCondition.class);
        ElConfig resourceService=context.getBean(ElConfig.class);
        resourceService.outputResource();
        context.close();

    }
}
