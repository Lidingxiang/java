package com.dingxiang.springboot;

import com.dingxiang.springboot.config.AuthorSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
public class App {

    @Autowired
    private AuthorSettings authorSettings;


    @RequestMapping("/")
    String index(){

        return  "book name is "+authorSettings.getName() +" author age is "+authorSettings.getAge();
    }

    public static void main( String[] args ) {
        SpringApplication.run(App.class,args);
    }
}
