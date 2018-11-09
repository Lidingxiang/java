package com.sync;

public class TestSynchorized {

    public synchronized void test1() {
        int i = 5;
        while (i-- > 0) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {
            }
        }
    }

    public static synchronized void test2() {
        int i = 5;
        while (i-- > 0) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {
            }
        }
    }


    public static void main(String[] args) {

        final TestSynchorized testSynchorized = new TestSynchorized();
        final TestSynchorized testSynchorized1=new TestSynchorized();

        Thread test1 = new Thread(new Runnable() {
            @Override
            public void run() {
                testSynchorized.test2();
            }
        }, "test1");

        Thread test2 = new Thread(new Runnable() {
            @Override
            public void run() {
                testSynchorized1.test2();
            }
        }, "test2");

        test1.start();
        test2.start();
    }
}
