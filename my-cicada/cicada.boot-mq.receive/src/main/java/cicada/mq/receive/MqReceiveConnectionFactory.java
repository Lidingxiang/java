package cicada.mq.receive;

import com.rabbitmq.client.Connection;

public interface MqReceiveConnectionFactory {
    Connection get(MqServerInfo var1) throws Exception;
}
