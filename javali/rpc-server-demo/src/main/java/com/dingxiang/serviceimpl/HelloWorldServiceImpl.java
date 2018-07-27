package com.dingxiang.serviceimpl;

import com.dingxiang.hellodriver.HelloWorldService;
import org.apache.thrift.TException;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldServiceImpl implements HelloWorldService.Iface {
    @Override
    public String sayHello(String username) throws TException {
        return "hello " + username;
    }

    @Override
    public String getRandom() throws TException {
        return "random";
    }
}
