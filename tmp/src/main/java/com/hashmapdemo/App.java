package com.hashmapdemo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class App {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("1", "value1");
        map.put("2", "value2");
        map.put("3", "value3");
        map.put("4", "value4");

        /*
        * 第一种*/
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            System.out.println(key + "\n" + value);
        }
        /*
        * 第二种*/
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + "\n" + value);
        }
        /*
        * 第三种*/
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + "\n" + value);
        }
        /*
        * 第四种*/
        for (String value : map.values()) {
            System.out.println("\n" + value);
        }
    }
}
