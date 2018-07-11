package com.dingxiang.beaninit;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class JSR250WayService {

    @PostConstruct  //构造函数执行完后执行
    public void init() {
        System.out.println("jsr250-init-method");
    }

    public JSR250WayService() {

        super();
        System.out.println("初始化构造函数-JSR250WayService");
    }

    @PreDestroy  //Bean销毁之前执行　
    public void destory() {

        System.out.println("jsr250-destory-method");
    }
}
