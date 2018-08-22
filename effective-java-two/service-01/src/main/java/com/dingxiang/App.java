package com.dingxiang;

import java.util.HashMap;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        boolean bol = new Boolean(true);
        boolean boolret = Boolean.valueOf(true);

        HashMap<String, Integer> tmpInstance = App.newInstance();
        tmpInstance.put("ldx", 1);
        tmpInstance.put("ldh", 2);


    }


    public static <K, V> HashMap<K, V> newInstance() {
        return new HashMap<K, V>();
    }
}
