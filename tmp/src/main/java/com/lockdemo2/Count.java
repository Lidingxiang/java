package com.lockdemo2;

import com.lockdemo.Lock;

public class Count {


    Lock lock = new Lock();

    public void print() throws InterruptedException {
        System.out.println("A");
        lock.lock();
        System.out.println("D");

        doAdd();
        lock.unlock();
    }

    public void doAdd() throws InterruptedException {
        System.out.println("E");
        lock.lock(); //do something lock.unlock(); }
    }
}
