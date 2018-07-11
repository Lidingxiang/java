package com.dingxiang.helloImpl;

import com.dingxiang.hellodriver.HelloWorldService;
import org.apache.thrift.TException;

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
