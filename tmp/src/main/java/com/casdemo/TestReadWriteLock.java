package com.casdemo;

public class TestReadWriteLock {
    public static void main(String[] args) {

        final ReadWriteLockDemo rw = new ReadWriteLockDemo();

        new Thread(new Runnable() {
            @Override
            public void run() {
                rw.set((int) (Math.random() * 101));
            }
        }, "Write:").start();

        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    rw.get();
                }
            }).start();
        }
    }

}
