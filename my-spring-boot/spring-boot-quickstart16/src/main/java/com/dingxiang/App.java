package com.dingxiang;

import com.dingxiang.config.AuthorSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 */
@RestController
@SpringBootApplication
public class App {

/*    @Value("${book.author}")
    private String bookAuthor;

    @Value("${book.name}")
    private String bookName;


    @RequestMapping("/")
    String index() {

        return "book name is " + bookName + " book author is " + bookAuthor;
    }*/


    @Autowired
    private AuthorSettings authorSettings; //1

    @RequestMapping("/")
    public String index(){
        return "author name is "+ authorSettings.getName()+" and author age is "+authorSettings.getAge();
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
