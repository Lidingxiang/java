package cicada.mq.send;


import cicada.mq.send.config.SenderInfo;

public interface MqSender {
    <T> void send(SenderInfo var1, T var2);
}
