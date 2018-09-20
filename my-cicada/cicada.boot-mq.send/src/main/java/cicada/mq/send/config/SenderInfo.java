package cicada.mq.send.config;

import cicada.mq.send.MqSender;
import cicada.mq.send.MqServerInfo;

public class SenderInfo extends MqServerInfo {
    private String channelName;
    private String type;
    private MqSender mqSender;

    public SenderInfo() {
    }

    public String getChannelName() {
        return this.channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public MqSender getMqSender() {
        return this.mqSender;
    }

    public void setMqSender(MqSender mqSender) {
        this.mqSender = mqSender;
    }
}
