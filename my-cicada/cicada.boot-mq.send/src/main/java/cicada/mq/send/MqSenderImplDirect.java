package cicada.mq.send;


import cicada.mq.send.config.SenderInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.AMQP.BasicProperties;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("mqsenddirect")
@Scope("prototype")
public class MqSenderImplDirect implements MqSender {
    private final MqConnectionFactorySend _connectionFactory;

    public MqSenderImplDirect(MqConnectionFactorySend connectionFactory) {
        this._connectionFactory = connectionFactory;
    }

    public <T> void send(SenderInfo senderInfo, T mesasge) {
        try {
            Connection connection = this._connectionFactory.get(senderInfo);
            Throwable var4 = null;

            try {
                Channel channel = null;

                try {
                    channel = connection.createChannel();
                    channel.queueDeclare(senderInfo.getChannelName(), true, false, false, (Map)null);
                    BasicProperties basicProperties = new BasicProperties();
                    basicProperties.builder().deliveryMode(Integer.valueOf(2));
                    ObjectMapper mapper = new ObjectMapper();
                    String s = mapper.writeValueAsString(mesasge);
                    byte[] bytes = s.getBytes(Charset.forName("UTF-8"));
                    channel.basicPublish("", senderInfo.getChannelName(), basicProperties, bytes);
                } finally {
                    if (channel != null && channel.isOpen()) {
                        channel.close();
                    }

                }
            } catch (Throwable var28) {
                var4 = var28;
                throw var28;
            } finally {
                if (connection != null) {
                    if (var4 != null) {
                        try {
                            connection.close();
                        } catch (Throwable var26) {
                            var4.addSuppressed(var26);
                        }
                    } else {
                        connection.close();
                    }
                }

            }
        } catch (IOException var30) {
            var30.printStackTrace();
        } catch (Exception var31) {
            var31.printStackTrace();
        }

    }
}
