package cicada.thrift.client.servicefinders;


import cicada.thrift.client.EndpointInfo;
import cicada.thrift.client.model.Address;

import java.util.Map;

public interface ServiceFinder {
    void init(EndpointInfo var1) throws Exception;

    Address getServiceLocation();

    void reportInvalidServiceLocation(Map<String, Integer> var1);
}
