package com.dingxiang;


import org.junit.Test;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class RandomUtilTest {
    @Test
    public void getRandomTmp() {

        Random ran1 = new Random(UUID.randomUUID().hashCode());
        System.out.println("使用种子为10的Random对象生成[0,10)内随机整数序列: ");
        for (int i = 0; i < 10; i++) {
            System.out.print(ran1.nextInt(10) + " ");
        }
        System.out.println();
        Random ran2 = new Random(UUID.randomUUID().hashCode());
        System.out.println("使用另一个种子为10的Random对象生成[0,10)内随机整数序列: ");
        for (int i = 0; i < 10; i++) {
            System.out.print(ran2.nextInt(10) + " ");
        }

        // 另外，直接使用Random无法避免生成重复的数字，如果需要生成不重复的随机数序列，需要借助数组和集合类
        List list = new RandomUtilTest().getDiffNO(10);
        System.out.println();
        System.out.println("产生的n个不同的随机数：" + list);
    }

    public List getDiffNO(int n) {
        // 生成 [0-n) 个不重复的随机数
        // list 用来保存这些随机数
        List list = new ArrayList();
        Random rand = new Random();
        boolean[] bool = new boolean[n];
        int num = 0;
        for (int i = 0; i < n; i++) {
            do {
                // 如果产生的数相同继续循环
                num = rand.nextInt(n);
            } while (bool[num]);
            bool[num] = true;
            list.add(num);
        }
        return list;
    }

    @Test
    public void getRandom() throws Exception {

/*        for (int i = 0; i < 10; i++)
            System.out.println(RandomUtil.GetRandomNext(10, 20));
        System.out.println("===1==");

        for (int i = 0; i < 10; i++)
            System.out.println(RandomUtil.GetRandomNext(20));
        System.out.println("===2==");

        for (int i = 0; i < 10; i++)
            System.out.println(RandomUtil.GetRandomNext());
        System.out.println("===3==");*/


        int tmp = LocalTime.now().getNano();
        Random random = new Random(tmp);
        for (int i = 0; i < 10; i++) {
            System.out.println("====>"+tmp);
            System.out.println(random.nextInt(tmp));
        }
    }

    @Test
    public void getRandomNext() throws Exception {
    }

    @Test
    public void getRandomNext1() throws Exception {
    }

    @Test
    public void getRandomNext2() throws Exception {
    }
}
