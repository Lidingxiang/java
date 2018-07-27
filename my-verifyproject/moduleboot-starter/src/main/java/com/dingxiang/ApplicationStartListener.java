package com.dingxiang;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

@Service
public class ApplicationStartListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        System.out.println("我的父容器为：" + event.getApplicationContext().getParent());
        System.out.println("初始化时我被调用了。");
    }
}
