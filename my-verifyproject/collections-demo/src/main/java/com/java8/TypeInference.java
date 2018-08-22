package com.java8;

public class TypeInference {

    public static void main(String[] args) {
        final Value<String> value = new Value<>();
        String tmp = value.getOrDefault(null, Value.defaultValue());
        System.out.println(tmp);
    }
}
