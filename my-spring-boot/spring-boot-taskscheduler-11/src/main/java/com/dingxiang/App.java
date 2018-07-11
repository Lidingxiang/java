package com.dingxiang;


import com.dingxiang.taskscheduler.TaskSchedulerConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;


/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskSchedulerConfig.class);
//        context.close();
    }
}
