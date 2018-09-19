package com.ly;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration()
@MapperScan("com.ly.bll.dao")
@ComponentScan(basePackages = {"cicada", "com.ly.webapi.controller"})
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
