package com.dingxiang;

public class ConcreteSellFisher implements SellFisher {

    public int sellFish() {
        System.out.println("my fish is delicious!!");
        return 10;
    }

    @Override
    public String hello() {
        return "hello ldx";
    }

}