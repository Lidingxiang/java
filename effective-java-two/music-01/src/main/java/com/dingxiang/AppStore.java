package com.dingxiang;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AppStore {

    private AppStore() {
    }

    private static final Map<String, MusicProvider> providers = new ConcurrentHashMap<>();

    //服务注册API  网易云音乐（商家）向应用市场注册
    public static void registerProvider(String name, MusicProvider p) {
        providers.put(name, p);
    }

    //服务访问API
    public static MusicApp installApp(String name) {
        MusicProvider p = providers.get(name);
        if (p == null) {
            throw new IllegalArgumentException("No provider registerd with name:" + name);
        }
        return p.getMusicApp();
    }
}
