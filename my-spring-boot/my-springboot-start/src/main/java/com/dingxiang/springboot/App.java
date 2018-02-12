package com.dingxiang.springboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
public class App {

    @Value("${book.author}")
    private String bookAuthor;

    @Value("${book.name}")
    private String bookName;


    @RequestMapping("/")
    String index(){

        return  "book name is "+bookName +" book author is "+bookAuthor;
    }

    public static void main( String[] args ) {
        SpringApplication.run(App.class,args);
    }
}
