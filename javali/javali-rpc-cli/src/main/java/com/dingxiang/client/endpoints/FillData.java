package com.dingxiang.client.endpoints;

import com.dingxiang.client.EndpointInfo;

public interface FillData {

    boolean fill(String configName, String key, String data, EndpointInfo info) throws Exception;
}
