package com.ThreadDemo;

public class ExtendThread {

    public static void main(String args[]) {

        Thread t = new Thread() {
            public void run() {
                pong();
            }
        };

//        t.run();
        t.start();
        System.out.print("ping");
    }

    static void pong() {
        System.out.print("pong");
    }
}
