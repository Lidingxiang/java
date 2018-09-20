package cicada.mq.receive.config;

import cicada.core.BeanFactory;
import cicada.mq.receive.MqReceiver;

public class FillDataImplType implements FillData {
    public FillDataImplType() {
    }

    public boolean fill(String configName, String key, String data, ReceiverInfo info) throws Exception {
        String text = data != null && !data.isEmpty() ? data.trim() : "direct";
        text = "mqrecive" + text.toLowerCase();
        MqReceiver mqReceiver = (MqReceiver)BeanFactory.getBeanByName(text);
        if (mqReceiver == null) {
            throw new Exception(String.format("您配置的消息队列类型%s是无效的，请修改%s节点", data, configName));
        } else {
            info.setType(text);
            info.setMqReceiver(mqReceiver);
            return true;
        }
    }
}
