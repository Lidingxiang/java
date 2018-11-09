package com.casdemo;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDemo implements Runnable {

        private volatile int serialNumber = 0;
//    private AtomicInteger serialNumber = new AtomicInteger(0);

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
        }

        System.out.println(getSerialNumber());
    }

    public  int getSerialNumber() {
        return serialNumber++;

//        return serialNumber.getAndIncrement();
    }
}
