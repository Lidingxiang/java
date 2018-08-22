package com.java8;

public class Value<T> {

    public static <T> T defaultValue() {
        return (T) "33";
//        return null;
    }

    public T getOrDefault(T value, T defaultValue) {
        return (value != null) ? value : defaultValue;
    }
}
