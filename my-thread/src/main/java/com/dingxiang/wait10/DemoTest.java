package com.dingxiang.wait10;

public class DemoTest {

    private static void demo() { //定义个空对象,后面我们将在这个对象上面执行wait和notify操作

        final Object lock = new Object();

        Thread workerA = new Thread(new Runnable() {
            public void run() { //先获取到lock 对象的锁
                synchronized (lock) {
                    System.out.println("A first");
                    try { //在lock对象上执行wait()方法,让其进入休眠,等待有人唤醒自己
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    for (int i = 0; i < 3; i++) {
                        System.out.println("A" + i);
                    }
                }
            }
        });

        Thread workerB = new Thread(new Runnable() {
            public void run() { //获取lock的锁
                synchronized (lock) {
                    for (int i = 0; i < 3; i++) {
                        System.out.println("B" + i);
                    } //唤醒正在lock对象上等待的线程
                    lock.notify();
                }
            }
        });

        workerA.start();
        workerB.start();
    }

    public static void main(String[] args) {
        demo();
    }

}
