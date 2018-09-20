package cicada.thrift.client.servicefinders;


import cicada.core.RandomUtil;
import cicada.thrift.client.EndpointInfo;
import cicada.thrift.client.model.Address;
import cicada.thrift.client.servicecentre.FindService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Consumer;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("servicecentre")
@Scope("prototype")
public class ServiceFindersImplCentre implements ServiceFinder {
    private static final Logger log = Logger.getLogger(ServiceFindersImplCentre.class);
    @Autowired
    private FindService _findService;
    private EndpointInfo _endpointInfo;
    private final List<String> _services = new ArrayList();
    private int _index = -1;

    public ServiceFindersImplCentre() {
    }

    public void init(EndpointInfo endpointInfo) throws Exception {
        this._endpointInfo = endpointInfo;
        String serverAddress = this._endpointInfo.getServiceCentreRespositoryServer();
        this._findService.init(serverAddress, this._endpointInfo.getServiceCentreName(), (serviceList) -> {
            synchronized(this) {
                this._services.clear();
                Iterator var3 = serviceList.iterator();

                while(var3.hasNext()) {
                    String current = (String)var3.next();
                    this._services.add(current);
                }

            }
        });
    }

    public Address getServiceLocation() {
        String text;
        synchronized(this) {
            if (this._services.size() == 0) {
                log.info(String.format("目前在仓库%s上，没有针对%s的可用服务", this._endpointInfo.getServiceCentreRespositoryServer(), this._endpointInfo.getServiceCentreName()));
            }

            if (this._index == -1) {
                this._index = this._services.size() == 1 ? 0 : RandomUtil.GetRandomNext(this._services.size());
            } else if (this._index > this._services.size() - 1) {
                this._index = 0;
            }

            text = (String)this._services.get(this._index);
            ++this._index;
        }

        String[] array = text.split(":");
        Address address = new Address();
        address.setIp(array[0]);
        address.setPort(Integer.parseInt(array[1]));
        return address;
    }

    public void reportInvalidServiceLocation(Map<String, Integer> serviceLocation) {
        synchronized(this) {
            Iterator var3 = serviceLocation.entrySet().iterator();

            while(var3.hasNext()) {
                Entry<String, Integer> entry = (Entry)var3.next();
                this._services.remove(entry.getValue());
            }

        }
    }
}