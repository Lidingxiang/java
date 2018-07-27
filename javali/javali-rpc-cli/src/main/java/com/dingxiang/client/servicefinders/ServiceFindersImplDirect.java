package com.dingxiang.client.servicefinders;

import com.dingxiang.Guard;
import com.dingxiang.client.EndpointInfo;
import com.dingxiang.model.Address;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("direct")
@Scope("prototype")
public class ServiceFindersImplDirect implements ServiceFinder {

    private EndpointInfo _endpointInfo;
    private Address _serviceAddress;

    @Override
    public void init(EndpointInfo endpointInfo) throws Exception {
        Guard.ThrowIfArgumentIsNull(endpointInfo, "endpointInfo");

        this._endpointInfo = endpointInfo;
        _serviceAddress = new Address();
        _serviceAddress.setIp(_endpointInfo.getServer());
        _serviceAddress.setPort(_endpointInfo.getPort());
    }

    @Override
    public Address getServiceLocation() {
        return _serviceAddress;
    }

    @Override
    public void reportInvalidServiceLocation(Map<String, Integer> serviceLocation) {

    }
}
