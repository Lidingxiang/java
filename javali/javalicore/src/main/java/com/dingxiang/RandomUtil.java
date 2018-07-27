package com.dingxiang;

import java.util.Random;
import java.util.UUID;

public class RandomUtil {

    public static Random GetRandom() {
        return new Random(UUID.randomUUID().hashCode());
    }

    public static int GetRandomNext(int minValue, int maxValue) {
        return GetRandom().nextInt((maxValue - minValue) + minValue);
    }


    public static int GetRandomNext(int maxValue) {
        return GetRandom().nextInt(maxValue);
    }

    public static int GetRandomNext() {
        return GetRandom().nextInt();
    }
}
