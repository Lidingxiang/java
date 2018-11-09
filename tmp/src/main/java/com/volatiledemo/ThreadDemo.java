package com.volatiledemo;

public class ThreadDemo implements Runnable {

    private volatile boolean flag = false;

    @Override
    public void run() {
        try {
            Thread.sleep(3000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        flag = true;

        System.out.println("flag=" + isFlag());
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
