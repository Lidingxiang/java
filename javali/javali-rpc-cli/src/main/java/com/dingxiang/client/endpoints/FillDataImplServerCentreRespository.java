package com.dingxiang.client.endpoints;

import com.dingxiang.client.EndpointInfo;
import org.apache.log4j.Logger;

public class FillDataImplServerCentreRespository implements FillData {
    private static final Logger log = Logger.getLogger(FillDataImplServerCentreRespository.class);

    /*
     * (non-Javadoc)
     * @see cicada.thrift.client.endpoints.FillData#fill(java.lang.String,
     * java.lang.String, java.lang.String, cicada.thrift.client.EndpointInfo)
     */
    @Override
    public boolean fill(String configName, String key, String data, EndpointInfo info) {

        String tmp = String.format("configName:%s;key:%s;data:%s;endpointinfo:%s", configName, key, data, info.toString());
        log.info("===>FillDataImplServerCentreRespository--->" + tmp);

        if (data == null || data.isEmpty()) return true;
        info.setServiceCentreRespositoryServer(data.trim());
        return true;
    }
}
