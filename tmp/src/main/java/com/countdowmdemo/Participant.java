package com.countdowmdemo;

public class Participant implements Runnable {

    private VideoConference videoConference;
    private String name;

    public Participant(String name, VideoConference videoConference) {
        this.name = name;
        this.videoConference = videoConference;
    }

    @Override
    public void run() {
        try {
            //do something
            Thread.sleep(50); //
            videoConference.arrive(name);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
