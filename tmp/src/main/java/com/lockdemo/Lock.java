package com.lockdemo;

public class Lock {

    private boolean isLocked = false;

    public synchronized void lock() throws InterruptedException {
        System.out.println("B");
        while (isLocked) {
            wait();
        }
        isLocked = true;
        System.out.println("C");
    }

    public synchronized void unlock() {
        isLocked = false;
        notify();
    }

}
