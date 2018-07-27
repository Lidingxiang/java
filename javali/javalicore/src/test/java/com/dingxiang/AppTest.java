package com.dingxiang;

import org.junit.Test;

import java.util.*;
import java.util.regex.Pattern;


/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        Guard.tryDo(3, 3000, () -> {
            System.out.println(33);
            return 33;
        });

        Guard.tryDo(1, 3333, new Action<Integer>() {
            @Override
            public Integer execute() throws Exception {
                System.out.println(888);
                return 33;
            }
        });
    }

    @Test
    public void formatTest() {
        System.out.println(String.format("%s=%d", "ldx", 33));
        System.out.printf("My name is: %s%n", "joe");

        StringBuilder sbuf = new StringBuilder();
        Formatter fmt = new Formatter(sbuf);
        fmt.format("PI = %f%n", Math.PI);
        fmt.format("name = %s%n", "ldx");
        System.out.print(sbuf.toString());
    }

    @Test
    public void hashTest() {
        Map<String, String> hasMap = new HashMap<>();
        hasMap.put("1", "A");
        hasMap.put("2", "B");
        hasMap.put("3", "C");
        hasMap.put("4", "D");

        System.out.println(hasMap.toString());
        Set<Map.Entry<String, String>> set = hasMap.entrySet();

        for (Map.Entry<String, String> entry : set) {

            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    @Test
    public void hashTest2() {
        /*
        * 遍历Map，并获取其 <Key, Value> 的方法有两种：
        （1）KeySet<KeyType>
        （2）EntrySet<KeyType, VlaueType>
        * */
    }

    public class MapDemo {
        public Map<Integer, String> map;

        public MapDemo() {
            map = new HashMap<>();
            for (int i = 0; i < 1000000; i++) {
                map.put(3 * i + 1, "China");
                map.put(3 * i + 2, "America");
                map.put(3 * i + 3, "Japan");
            }
        }

        public long MapKeySetMethod() {
            long startTime = System.currentTimeMillis();
            Set<Integer> keySet = map.keySet();
            Iterator<Integer> iterator = keySet.iterator();
            while (iterator.hasNext()) {
                Integer key = iterator.next();
                String value = map.get(key);
                //System.out.println(key + " = " + value);
            }
            long endTime = System.currentTimeMillis();
            return endTime - startTime;
        }

        public long MapEntrySetMethod() {
            long startTime = System.currentTimeMillis();
            Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
            Iterator<Map.Entry<Integer, String>> iterator = entrySet.iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer, String> entry = iterator.next();
                Integer key = entry.getKey();
                String value = entry.getValue();
                //System.out.println(key + " = " + value);
            }
            long endTime = System.currentTimeMillis();
            return endTime - startTime;
        }
    }

    @Test
    public void MatcherTest() {
        Pattern p = Pattern.compile("\\d+");

        Pattern java = Pattern.compile("java");
        System.out.println(java.pattern());
    }
}
