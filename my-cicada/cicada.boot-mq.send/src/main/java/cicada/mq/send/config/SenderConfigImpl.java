package cicada.mq.send.config;


import cicada.core.Guard;
import cicada.core.PropertyResolverCustom;
import cicada.core.config.ConfigManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.stereotype.Component;

@Component
public class SenderConfigImpl implements SenderConfig {
    private static final Map<String, FillData> fillDataStrategies;
    private final Map<String, SenderInfo> _senders = new HashMap();
    private final Map<String, String> _configurationDataRespository;

    public SenderConfigImpl() {
        String cicadaPath = ConfigManager.getCicadaConfigPath();
        this._configurationDataRespository = PropertyResolverCustom.getConfigProperties(cicadaPath);
    }

    public void load() {
        Map<String, SenderInfo> senderInfos = new HashMap();
        Iterator var2 = this._configurationDataRespository.entrySet().iterator();

        Entry entry;
        String text;
        while(var2.hasNext()) {
            entry = (Entry)var2.next();
            text = (String)entry.getKey();
            String regEx = "^Cicada.Mq.Senders.(\\w+).([\\w.]+)$";
            Pattern pattern = Pattern.compile(regEx, 2);
            Matcher matcher = pattern.matcher(text);
            if (matcher.matches() && matcher.groupCount() == 2) {
                SenderInfo senderInfo = null;
                String group1 = matcher.group(1);
                if (senderInfos.containsKey(group1)) {
                    senderInfo = (SenderInfo)senderInfos.get(group1);
                } else {
                    senderInfo = new SenderInfo();
                    senderInfos.put(group1, senderInfo);
                }

                String key = matcher.group(2).toLowerCase();
                if (!fillDataStrategies.containsKey(key)) {
                    throw new IllegalArgumentException(String.format("未知的配置，请检查节点%s是否配置正确", text));
                }

                FillData temp = (FillData)fillDataStrategies.get(key);
                boolean result = temp.fill(text, key, (String)entry.getValue(), senderInfo).booleanValue();
                if (!result) {
                    throw new IllegalArgumentException(String.format("错误的配置，请检查节点%s是否配置正确", text));
                }
            }
        }

        var2 = senderInfos.entrySet().iterator();

        while(var2.hasNext()) {
            entry = (Entry)var2.next();
            text = ((SenderInfo)entry.getValue()).getChannelName();
            SenderInfo value = (SenderInfo)entry.getValue();
            this._senders.put(text, value);
        }

    }

    public SenderInfo get(String channel) throws Exception {
        Guard.ThrowIfArgumentIsNullOrEmpty(channel, "channel");
        String key = channel.trim().toLowerCase();
        return !this._senders.containsKey(key) ? null : (SenderInfo)this._senders.get(key);
    }

    static {
        Map<String, FillData> map = new HashMap();
        map.put("channel", new FillDataImplChannelName());
        map.put("type", new FillDataImplType());
        map.put("server", new FillDataImplServer());
        map.put("server.port", new FillDataImplPort());
        map.put("server.username", new FillDataImplServerUserName());
        map.put("server.password", new FillDataImplServerPassword());
        fillDataStrategies = map;
    }
}
