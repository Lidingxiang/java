package com.dingxiang;


public final class Guard {

    public static <T> T tryDo(int tryCount, int interval, Action<T> action) {
        T ret = null;
        for (int i = 0; i < tryCount; i++) {
            try {
                ret = action.execute();
                break;
            } catch (Exception e) {
                if (i == tryCount - 1)
                    e.printStackTrace();
            }
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                if (i == tryCount - 1)
                    e.printStackTrace();
            }
        }
        return ret;
    }

    public static void ThrowIfArgumentIsNull(Object argumentValue, String argumentName) throws Exception {
        if (argumentValue == null) {
            throw new Exception(String.format("参数:%s 不能为空值", argumentName));
        }
    }

    public static void ThrowIfArgumentIsNullOrEmpty(String argumentValue, String argumentName) throws Exception {
        if (argumentValue == null || argumentValue.length() == 0) {
            throw new Exception(String.format("参数:%s 不能为空值", argumentName));
        }
    }
}
