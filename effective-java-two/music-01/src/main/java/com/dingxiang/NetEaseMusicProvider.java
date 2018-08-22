package com.dingxiang;

//网易云音乐服务提供者实现
public class NetEaseMusicProvider implements MusicProvider {
    @Override
    public MusicApp getMusicApp() {
        boolean isDeviceAndroid = true;
        if (isDeviceAndroid) {
            return new NetEaseMusicApp();
        } else {
            return new NetEaseMusicPC();
        }
    }
}