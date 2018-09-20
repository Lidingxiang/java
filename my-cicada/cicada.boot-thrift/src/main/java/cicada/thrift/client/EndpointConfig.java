package cicada.thrift.client;


import cicada.core.PropertyResolverCustom;
import cicada.core.config.ConfigManager;
import cicada.thrift.client.endpoints.*;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class EndpointConfig {
    private static final Map<String, FillData> fillDataStrategies;

    public EndpointConfig() {
    }

    public List<EndpointInfo> load() throws Exception {
        String cicadaPath = ConfigManager.getCicadaConfigPath();
        Map<String, String> config = PropertyResolverCustom.getConfigProperties(cicadaPath);
        Map<String, EndpointInfo> endpoints = new HashMap();
        Iterator var4 = config.entrySet().iterator();

        while(var4.hasNext()) {
            Map.Entry<String, String> entry = (Map.Entry)var4.next();
            String text = (String)entry.getKey();
            String regEx = "^Cicada.Rpc.Client.Endpoints.(\\w+).([\\w.]+)$";
            Pattern pattern = Pattern.compile(regEx, 2);
            Matcher matcher = pattern.matcher(text);
            if (matcher.matches() && matcher.groupCount() == 2) {
                EndpointInfo endpointInfo = null;
                String group1 = matcher.group(1);
                if (endpoints.containsKey(group1)) {
                    endpointInfo = (EndpointInfo)endpoints.get(group1);
                } else {
                    endpointInfo = new EndpointInfo();
                    endpoints.put(group1, endpointInfo);
                }

                String key = matcher.group(2).toLowerCase();
                if (!fillDataStrategies.containsKey(key)) {
                    throw new Exception(String.format("未知的配置，请检查节点%s是否配置正确", text));
                }

                FillData temp = (FillData)fillDataStrategies.get(key);
                String value = (String)entry.getValue();
                boolean result = temp.fill(text, key, value, endpointInfo);
                if (!result) {
                    throw new Exception(String.format("错误的配置，请检查节点%s是否配置正确", text));
                }
            }
        }

        ArrayList<EndpointInfo> result = new ArrayList(endpoints.values());
        return result;
    }

    static {
        Map<String, FillData> map = new HashMap();
        map.put("contract", new FillDataImplContract());
        map.put("server", new FillDataImplServer());
        map.put("servicefindertype", new FillDataImplServiceFinderType());
        map.put("servicecentre.respositoryserver", new FillDataImplServerCentreRespository());
        map.put("servicecentre.name", new FillDataImplServerCentreName());
        fillDataStrategies = map;
    }
}