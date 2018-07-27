package com.dingxiang.server;

public interface RpcServer {

    <T> void run(Class<T> classzz);

    void close();
}
