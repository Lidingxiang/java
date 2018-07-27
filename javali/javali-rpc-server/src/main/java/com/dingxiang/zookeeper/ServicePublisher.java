package com.dingxiang.zookeeper;

import org.springframework.beans.factory.DisposableBean;

public interface ServicePublisher extends DisposableBean {

    void Init(String respository, ConnectionFailProcessMode mode, String path, String data);

    void publish();

    void cancel();
}
