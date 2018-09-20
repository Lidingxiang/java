package cicada.mq.send.config;


import cicada.core.BeanFactory;
import cicada.mq.send.MqSender;

public class FillDataImplType implements FillData {
    private final String defaultType = "direct";

    public FillDataImplType() {
    }

    public Boolean fill(String configName, String key, String data, SenderInfo info) {
        String text = data != null && !data.isEmpty() ? data.trim() : "direct";
        text = "mqsend" + text.toLowerCase();
        MqSender mqSender = (MqSender)BeanFactory.getBeanByName(text);
        if (mqSender == null) {
            throw new IllegalArgumentException(String.format("您配置的消息队列类型%s是无效的，请修改%s节点", data, configName));
        } else {
            info.setType(text);
            info.setMqSender(mqSender);
            return true;
        }
    }
}