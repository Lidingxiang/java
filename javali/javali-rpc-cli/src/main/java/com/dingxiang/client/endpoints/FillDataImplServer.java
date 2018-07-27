package com.dingxiang.client.endpoints;

import com.dingxiang.client.EndpointInfo;
import org.apache.log4j.Logger;

public class FillDataImplServer implements FillData {
    private static final Logger log = Logger.getLogger(FillDataImplServer.class);

    @Override
    public boolean fill(String configName, String key, String data, EndpointInfo info) throws Exception {
        String tmp = String.format("configName:%s;key:%s;data:%s;endpointinfo:%s", configName, key, data, info.toString());
        log.info("===>FillDataImplServer--->" + tmp);

        if (data == null || data.isEmpty()) return true;
        String[] array = data.split(":");
        if (array == null || array.length != 2) {
            return false;
        }
        info.setServer(array[0].trim());
        try {
            int port = Integer.parseInt(array[1]);
            info.setPort(port);
        } catch (Exception e) {
            throw new Exception(String.format("配置的值%s不是有效的端口号，请检查%s配置项", data, configName));
        }
        return true;
    }
}
