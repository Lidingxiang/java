package com.dingxiang;

@FunctionalInterface
public interface Action<T> {

    T execute() throws Exception;
}
