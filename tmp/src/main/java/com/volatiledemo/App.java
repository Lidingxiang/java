package com.volatiledemo;

public class App {
    public static void main(String[] args) {
        ThreadDemo td = new ThreadDemo();
        new Thread(td).start();
        while (true) {
            if (td.isFlag()) {
                System.out.println("------------------");
                break;
            }
        }

    }
}
