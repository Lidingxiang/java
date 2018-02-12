package com.dingxiang.springboot.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class DemoListener implements ApplicationListener<DemoEvent> {

    @Override
    public void onApplicationEvent(DemoEvent domoEvent) {
        String msg = domoEvent.getMsg();

        System.out.println("我DemoListener收到DemoPublisher发布的消息：" + msg);
    }
}
