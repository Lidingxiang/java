package com.dingxiang.client;

import com.dingxiang.Guard;
import com.dingxiang.model.Address;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

import java.lang.reflect.Constructor;

public class RpcClient {

    private EndpointInfo _endpointInfo;
    private TTransport transport;

    public RpcClient(EndpointInfo endpointInfo) throws Exception {
        Guard.ThrowIfArgumentIsNull(endpointInfo, "endpointInfo");
        _endpointInfo = endpointInfo;
    }

    public void before() throws Exception {
        Address address = this._endpointInfo.getServerceFinder().getServiceLocation();
        transport = new TSocket(address.getIp(), address.getPort(), 20000);
        transport.open();
    }

    public void after() {
        if (transport != null && transport.isOpen()) {
            transport.close();
        }
    }

    public Object GenerateProxyObject() throws Exception {
        TCompactProtocol tcompactProtocol = new TCompactProtocol(transport);
        Class<?> clientType = _endpointInfo.getClientType();
        Constructor<?> constructor = clientType.getConstructor(TProtocol.class);
        Object result = constructor.newInstance(tcompactProtocol);
        return result;
    }
}
