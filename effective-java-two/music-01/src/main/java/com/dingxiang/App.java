package com.dingxiang;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
 /*       AppStore.registerProvider("NetEase", new NetEaseMusicProvider()); //以下为用户的操作
        MusicApp musicApp = AppStore.installApp("NetEase");
        musicApp.play();
        */

        int i=1,a=0;

        System.out.println("a=i++===>  "+(a=i++));//1
        System.out.println("a=++i===>  "+(a=++i));//2

    }
}
