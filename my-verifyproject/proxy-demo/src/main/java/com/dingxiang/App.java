package com.dingxiang;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        SellFisher sellFisher = new ConcreteSellFisher();
        InvocationHandler invocationHandler = new ProxySellFisher(sellFisher);

        Object object = Proxy.newProxyInstance(sellFisher.getClass().getClassLoader(), sellFisher.getClass().getInterfaces(), invocationHandler);
        int ret = ((SellFisher) object).sellFish();
        String hello = ((SellFisher) object).hello();
        System.out.println("===>main--->ret:" + ret);
        System.out.println("===>main--->hello:" + hello);
    }
}
