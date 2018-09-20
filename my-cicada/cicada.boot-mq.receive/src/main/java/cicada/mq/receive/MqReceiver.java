package cicada.mq.receive;

import cicada.mq.receive.config.ReceiverInfo;

public interface MqReceiver {
    void init(ReceiverInfo var1) throws Exception;

    void run() throws Exception;

    void close();
}
