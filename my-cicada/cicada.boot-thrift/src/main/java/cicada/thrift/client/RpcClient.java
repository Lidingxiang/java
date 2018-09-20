package cicada.thrift.client;


import cicada.core.Guard;
import cicada.thrift.client.model.Address;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;

public class RpcClient {
    private EndpointInfo _endpointInfo;
    private TTransport transport;
    private static Logger logger = LoggerFactory.getLogger(RpcClient.class);

    public RpcClient(EndpointInfo endpointInfo) throws Exception {
        Guard.ThrowIfArgumentIsNull(endpointInfo, "endpointInfo");
        this._endpointInfo = endpointInfo;
    }

    public void before() throws Exception {
        Address address = this._endpointInfo.getServerceFinder().getServiceLocation();
        this.transport = new TSocket(address.getIp(), address.getPort().intValue(), 20000);
        if (logger.isDebugEnabled()) {
            String msg = String.format("RPC 连接IP:%s 端口:%s", address.getIp(), address.getPort());
            logger.debug(msg);
        }

        this.transport.open();
    }

    public void after() {
        if (this.transport != null && this.transport.isOpen()) {
            this.transport.close();
        }

    }

    public Object GenerateProxyObject() throws Exception {
        TCompactProtocol tcompactProtocol = new TCompactProtocol(this.transport);
        Class<?> clientType = this._endpointInfo.getClientType();
        Constructor<?> constructor = clientType.getConstructor(TProtocol.class);
        Object result = constructor.newInstance(tcompactProtocol);
        return result;
    }
}