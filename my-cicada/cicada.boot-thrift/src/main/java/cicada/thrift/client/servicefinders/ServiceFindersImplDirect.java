package cicada.thrift.client.servicefinders;


import cicada.core.Guard;
import cicada.thrift.client.EndpointInfo;
import cicada.thrift.client.model.Address;
import java.util.Map;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("direct")
@Scope("prototype")
public class ServiceFindersImplDirect implements ServiceFinder {
    private EndpointInfo _endpointInfo;
    private Address _serviceAddress;

    public ServiceFindersImplDirect() {
    }

    public void init(EndpointInfo endpointInfo) throws Exception {
        Guard.ThrowIfArgumentIsNull(endpointInfo, "endpointInfo");
        this._endpointInfo = endpointInfo;
        this._serviceAddress = new Address();
        this._serviceAddress.setIp(this._endpointInfo.getServer());
        this._serviceAddress.setPort(this._endpointInfo.getPort());
    }

    public Address getServiceLocation() {
        return this._serviceAddress;
    }

    public void reportInvalidServiceLocation(Map<String, Integer> serviceLocation) {
    }
}
