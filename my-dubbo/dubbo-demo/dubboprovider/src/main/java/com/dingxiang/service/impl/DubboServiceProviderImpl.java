package com.dingxiang.service.impl;

import com.dingxiang.service.DubboServiceProvider;
import org.springframework.stereotype.Component;

@Component
public class DubboServiceProviderImpl implements DubboServiceProvider {

    @Override
    public String sayHello(String name) {
        return "hello " + name;
    }
}
