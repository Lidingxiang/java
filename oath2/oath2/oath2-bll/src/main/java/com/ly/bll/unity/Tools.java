package com.ly.bll.unity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Tools {

    public static String guid() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replace("-", "");
    }

    public static String getCurrentTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String result = df.format(new Date());
        return result;
    }

    public static String getStartTime() {
        final String result = "1970-01-01 00:00:00";
        return result;
    }

    private static byte[] lock = new byte[1];

    /**
     * 获取群号
     *
     * @return
     */
    public static String getNo() {
        synchronized (lock) {
            long mil = System.currentTimeMillis();
            String result = Long.toString(mil, 36);
            return result;
        }
    }
}
