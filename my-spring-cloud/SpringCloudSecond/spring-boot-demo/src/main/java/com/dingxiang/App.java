package com.dingxiang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 */
@SpringBootApplication
public class App {
    public static void main(String[] args) {

        SpringApplication.run(App.class, args);
    }

    /*
    * 服务启动的另一种方式：mvn spring-boot:run
    * mvn spring-boot:run -Dspring-boot.run.profiles=xxx
    * */
}
