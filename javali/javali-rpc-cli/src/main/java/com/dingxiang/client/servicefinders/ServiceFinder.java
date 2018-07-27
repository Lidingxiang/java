package com.dingxiang.client.servicefinders;

import com.dingxiang.client.EndpointInfo;
import com.dingxiang.model.Address;

import java.util.Map;

public interface ServiceFinder {

    void init(EndpointInfo endpointInfo) throws Exception;

    Address getServiceLocation();

    void reportInvalidServiceLocation(Map<String, Integer> serviceLocation);
}
