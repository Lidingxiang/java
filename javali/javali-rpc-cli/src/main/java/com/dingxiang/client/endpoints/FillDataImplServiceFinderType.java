package com.dingxiang.client.endpoints;

import com.dingxiang.BeanFactory;
import com.dingxiang.client.EndpointInfo;
import com.dingxiang.client.servicefinders.ServiceFinder;
import org.apache.log4j.Logger;

public class FillDataImplServiceFinderType implements FillData {
    private static final Logger log = Logger.getLogger(FillDataImplServiceFinderType.class);

    @Override
    public boolean fill(String configName, String key, String data, EndpointInfo info) throws Exception {

        String tmp = String.format("configName:%s;key:%s;data:%s;endpointinfo:%s", configName, key, data, info.toString());
        log.info("===>FillDataImplServiceFinderType--->" + tmp);

        String text = (data == null || data.isEmpty()) ? "direct" : data.trim();
        text = text.toLowerCase();
        ServiceFinder serviceFinder = BeanFactory.getBeanByName(text);
        if (serviceFinder == null) {
            throw new Exception(String.format("您配置Rpc服务发现类型%s是无效的，请修改%s节点", data, configName));
        }
        info.setServiceFinderType(text);
        info.setServerceFinder(serviceFinder);
        return true;
    }
}
