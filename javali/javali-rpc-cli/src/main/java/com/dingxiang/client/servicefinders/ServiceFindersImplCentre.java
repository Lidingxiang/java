package com.dingxiang.client.servicefinders;

import com.dingxiang.RandomUtil;
import com.dingxiang.client.EndpointInfo;
import com.dingxiang.model.Address;
import com.dingxiang.servicecentre.FindService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component("servicecentre")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ServiceFindersImplCentre implements ServiceFinder {

    private static final Logger log = Logger.getLogger(ServiceFindersImplCentre.class);
    @Autowired
    private FindService _findService;
    private EndpointInfo _endpointInfo;
    private final List<String> _services = new ArrayList<>();

    private int _index = -1;

    @Override
    public void init(EndpointInfo endpointInfo) throws Exception {
        this._endpointInfo = endpointInfo;
        String serverAddress = this._endpointInfo.getServiceCentreRespositoryServer();
        this._findService.init(serverAddress, _endpointInfo.getServiceCentreName(), (serviceList) ->
        {
            synchronized (this) {
                this._services.clear();
                for (String current : serviceList) {
                    this._services.add(current);
                }
            }
        });
    }

    @Override
    public Address getServiceLocation() {
        String text;
        synchronized (this) {
            if (this._services.size() == 0) {
                log.info(String.format("目前在仓库%s上，没有针对%s的可用服务", this._endpointInfo.getServiceCentreRespositoryServer(), this._endpointInfo.getServiceCentreName()));
            }
            if (this._index == -1) {
                this._index = (this._services.size() == 1) ? 0 : RandomUtil.GetRandomNext(this._services.size());
            } else if (this._index > this._services.size() - 1) {
                this._index = 0;
            }
            text = this._services.get(this._index);
            this._index++;
        }
        String[] array = text.split(":");
        Address address = new Address();
        address.setIp(array[0]);
        address.setPort(Integer.parseInt(array[1]));
        return address;
    }

    @Override
    public void reportInvalidServiceLocation(Map<String, Integer> serviceLocation) {
        synchronized (this) {
            for (Map.Entry<String, Integer> entry : serviceLocation.entrySet()) {
                this._services.remove(entry.getValue());
            }
        }
    }
}
