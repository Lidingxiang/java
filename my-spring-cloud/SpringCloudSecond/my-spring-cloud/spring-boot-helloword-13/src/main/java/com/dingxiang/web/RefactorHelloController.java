package com.dingxiang.web;

import dingxiang.com.dto.User;
import dingxiang.com.service.HelloService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RefactorHelloController implements HelloService {

    @Override
    public String hello(String name) {
        return null;
    }

    @Override
    public User hello(String name, Integer age) {
        return null;
    }

    @Override
    public String hello(User user) {
        return null;
    }
}
