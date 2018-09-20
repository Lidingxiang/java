package cicada.mq.receive.config;


import cicada.mq.receive.MqReceiver;
import cicada.mq.receive.MqServerInfo;

public class ReceiverInfo extends MqServerInfo {
    private Class<?> contractType;
    private Class<?> messageType;
    private String channelName;
    private String type;
    private MqReceiver mqReceiver;

    public ReceiverInfo() {
    }

    public Class<?> getContractType() {
        return this.contractType;
    }

    public void setContractType(Class<?> contractType) {
        this.contractType = contractType;
    }

    public Class<?> getMessageType() {
        return this.messageType;
    }

    public void setMessageType(Class<?> messageType) {
        this.messageType = messageType;
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

    public MqReceiver getMqReceiver() {
        return this.mqReceiver;
    }

    public void setMqReceiver(MqReceiver mqReceiver) {
        this.mqReceiver = mqReceiver;
    }
}
