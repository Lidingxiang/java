package cicada.mq.receive.config;

import cicada.core.PropertyResolverCustom;
import cicada.core.config.ConfigManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.stereotype.Component;

@Component
public class ReceiverConfigImpl implements ReceiverConfig {
    private static final Map<String, FillData> fillDataStrategies;
    private final List<ReceiverInfo> _receivers = new ArrayList();
    private final Map<String, String> _configurationDataRespository;
    private boolean _loaded;

    public ReceiverConfigImpl() {
        String cicadaPath = ConfigManager.getCicadaConfigPath();
        this._configurationDataRespository = PropertyResolverCustom.getConfigProperties(cicadaPath);
    }

    public List<ReceiverInfo> getReceivers() throws Exception {
        if (!this._loaded) {
            synchronized(this) {
                if (!this._loaded) {
                    List<ReceiverInfo> list = this.loadByConfig();
                    Iterator var3 = list.iterator();

                    while(var3.hasNext()) {
                        ReceiverInfo current = (ReceiverInfo)var3.next();
                        this._receivers.add(current);
                    }
                }

                this._loaded = true;
            }
        }

        return this._receivers;
    }

    private List<ReceiverInfo> loadByConfig() throws Exception {
        Map<String, ReceiverInfo> receiverInfos = new HashMap();
        Iterator var2 = this._configurationDataRespository.entrySet().iterator();

        while(var2.hasNext()) {
            Entry<String, String> entry = (Entry)var2.next();
            String text = (String)entry.getKey();
            String regEx = "^Cicada.Mq.Receivers.(\\w+).([\\w.]+)$";
            Pattern pattern = Pattern.compile(regEx, 2);
            Matcher matcher = pattern.matcher(text);
            if (matcher.matches() && matcher.groupCount() == 2) {
                ReceiverInfo receiverInfo = null;
                String group1 = matcher.group(1);
                if (receiverInfos.containsKey(group1)) {
                    receiverInfo = (ReceiverInfo)receiverInfos.get(group1);
                } else {
                    receiverInfo = new ReceiverInfo();
                    receiverInfos.put(group1, receiverInfo);
                }

                String key = matcher.group(2).toLowerCase();
                if (!fillDataStrategies.containsKey(key)) {
                    throw new Exception(String.format("未知的配置，请检查节点%s是否配置正确", text));
                }

                FillData temp = (FillData)fillDataStrategies.get(key);
                boolean result = temp.fill(text, key, (String)entry.getValue(), receiverInfo);
                if (!result) {
                    throw new Exception(String.format("错误的配置，请检查节点%s是否配置正确", text));
                }
            }
        }

        ArrayList<ReceiverInfo> result = new ArrayList(receiverInfos.values());
        return result;
    }

    static {
        Map<String, FillData> map = new HashMap();
        map.put("contract", new FillDataImplContract());
        map.put("channel", new FillDataImplChannelName());
        map.put("type", new FillDataImplType());
        map.put("server", new FillDataImplServer());
        map.put("server.port", new FillDataImplPort());
        map.put("server.username", new FillDataImplServerUserName());
        map.put("server.password", new FillDataImplServerPassword());
        fillDataStrategies = map;
    }
}
