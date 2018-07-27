package com.dingxiang.client.endpoints;

import com.dingxiang.client.EndpointInfo;
import org.apache.log4j.Logger;

public class FillDataImplContract implements FillData {

    private static final Logger log = Logger.getLogger(FillDataImplContract.class);

    @Override
    public boolean fill(String configName, String key, String data, EndpointInfo info) throws Exception {
        String tmp = String.format("configName:%s;key:%s;data:%s;endpointinfo:%s", configName, key, data, info.toString());
        log.info("===>FillDataImplContract--->" + tmp);

        if (data == null || data.isEmpty()) return false;
        try {
            Class<?> contractType = Class.forName(data);
            if (contractType != null && contractType.isInterface()) {
                info.setContractType(contractType);
                data = data.replace("Iface", "Client");
                Class<?> client = Class.forName(data);
                if (client != null) {
                    info.setClientType(Class.forName(data));
                } else
                    throw new Exception(String.format("您配置接口类型%s不是Thrift生成的接口类型，请修改%s节点", data, configName));
            } else
                return false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            log.error(e);
        }
        return true;
    }
}
