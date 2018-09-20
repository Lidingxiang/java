package cicada.core;

import java.util.Random;
import java.util.UUID;

public class RandomUtil {
    public RandomUtil() {
    }

    public static Random GetRandom() {
        return new Random((long) UUID.randomUUID().hashCode());
    }

    public static int GetRandomNext(int minValue, int maxValue) {
        return GetRandom().nextInt(maxValue - minValue + minValue);
    }

    public static int GetRandomNext(int maxValue) {
        return GetRandom().nextInt(maxValue);
    }

    public static int GetRandomNext() {
        return GetRandom().nextInt();
    }
}
