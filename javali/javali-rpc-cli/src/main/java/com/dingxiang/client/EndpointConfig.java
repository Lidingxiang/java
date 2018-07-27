package com.dingxiang.client;

import com.dingxiang.PropertyResolverCustom;
import com.dingxiang.client.endpoints.*;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class EndpointConfig {
    private static final Map<String, FillData> fillDataStrategies;

    static {
        Map<String, FillData> map = new HashMap<>();
        map.put("contract", new FillDataImplContract());
        map.put("server", new FillDataImplServer());
        map.put("servicefindertype", new FillDataImplServiceFinderType());
        map.put("servicecentre.respositoryserver", new FillDataImplServerCentreRespository());
        map.put("servicecentre.name", new FillDataImplServerCentreName());
        fillDataStrategies = map;
    }

    public List<EndpointInfo> load() throws Exception {
        Map<String, String> config = PropertyResolverCustom.getConfigProperties("conf/cicada.properties");
        Map<String, EndpointInfo> endpoints = new HashMap<>();
        for (Map.Entry<String, String> entry : config.entrySet()) {
            String text = entry.getKey();
            String regEx = "^Cicada.Rpc.Client.Endpoints.(\\w+).([\\w.]+)$";
            Pattern pattern = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(text);

            if (matcher.matches() && matcher.groupCount() == 2) {
                EndpointInfo endpointInfo;
                String group1 = matcher.group(1); //2

                if (endpoints.containsKey(group1)) {
                    endpointInfo = endpoints.get(group1);
                } else {
                    endpointInfo = new EndpointInfo();
                    endpoints.put(group1, endpointInfo);
                }
                String key = matcher.group(2).toLowerCase();//ServiceCentre.RespositoryServer
                if (!EndpointConfig.fillDataStrategies.containsKey(key)) {
                    throw new Exception(String.format("未知的配置，请检查节点%s是否配置正确", text));
                }

                FillData temp = EndpointConfig.fillDataStrategies.get(key);
                boolean result = temp.fill(text, key, entry.getValue(), endpointInfo);
                if (!result) {
                    throw new Exception(String.format("错误的配置，请检查节点%s是否配置正确", text));
                }
            }
        }
        ArrayList<EndpointInfo> result = new ArrayList<>(endpoints.values());
        return result;
    }
}
