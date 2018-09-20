package cicada.mq.send;


import com.rabbitmq.client.Connection;

public interface MqConnectionFactorySend {
    Connection get(MqServerInfo var1) throws Exception;
}
