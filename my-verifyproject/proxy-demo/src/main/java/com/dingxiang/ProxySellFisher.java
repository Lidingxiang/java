package com.dingxiang;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxySellFisher implements InvocationHandler {

    private SellFisher sellFisher;

    public ProxySellFisher(SellFisher sellFisher) {
        this.sellFisher = sellFisher;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("the fish price higher");
        Object obj = method.invoke(sellFisher, args);
        System.out.println("===>Proxy--->invoke---obj:" + obj);
        return obj;
    }
}
