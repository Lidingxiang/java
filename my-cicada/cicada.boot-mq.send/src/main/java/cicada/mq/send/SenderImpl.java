package cicada.mq.send;

import cicada.core.Guard;
import cicada.mq.send.config.SenderConfig;
import cicada.mq.send.config.SenderInfo;
import org.springframework.stereotype.Component;

@Component
public class SenderImpl implements Sender {
    private SenderConfig _sendConfig;

    public SenderImpl(SenderConfig sendconfig) {
        this._sendConfig = sendconfig;
    }

    public <T> void send(String channel, T mesasge) throws Exception {
        Guard.ThrowIfArgumentIsNullOrEmpty(channel, "channel");
        SenderInfo senderInfo = this._sendConfig.get(channel);
        if (senderInfo == null) {
            throw new IllegalArgumentException(String.format("无效的消息队列渠道名称%s，请首先配置此渠道信息", channel));
        } else {
            MqSender sender = senderInfo.getMqSender();
            sender.send(senderInfo, mesasge);
        }
    }
}