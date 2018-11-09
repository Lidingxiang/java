package com.dingxiang.countDownLatch09.demo02;

public class App {

    public static void main(String[] args) {

        VideoConference videoConference = new VideoConference(10);
        Thread videoThread = new Thread(videoConference);
        videoThread.start();

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Participant("participant:" + i, videoConference));
            thread.start();
        }
    }
}
