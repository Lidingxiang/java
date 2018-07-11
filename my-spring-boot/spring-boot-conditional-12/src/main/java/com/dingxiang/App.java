package com.dingxiang;


import com.dingxiang.conditional.ConditionConifg;
import com.dingxiang.conditional.ListService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;


/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConditionConifg.class);

        ListService listService = context.getBean(ListService.class);
        System.out.println(context.getEnvironment().getProperty("os.name") + "系统下的列表命令： " + listService.showListCmd());

        context.close();
    }
}
