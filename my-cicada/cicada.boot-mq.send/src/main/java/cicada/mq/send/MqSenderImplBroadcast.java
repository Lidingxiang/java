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

@Component("mqsendbroadcast")
@Scope("prototype")
public class MqSenderImplBroadcast implements MqSender {
    private final MqConnectionFactorySend _connectionFactory;

    public MqSenderImplBroadcast(MqConnectionFactorySend connectionFactory) {
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
                    String channelName = senderInfo.getChannelName();
                    channel.exchangeDeclare(channelName, "fanout", false);
                    channel.queueDeclare(channelName, true, false, false, (Map)null);
                    BasicProperties basicProperties = new BasicProperties();
                    basicProperties.builder().deliveryMode(Integer.valueOf(2));
                    ObjectMapper mapper = new ObjectMapper();
                    String s = mapper.writeValueAsString(mesasge);
                    byte[] bytes = s.getBytes(Charset.forName("UTF-8"));
                    channel.basicPublish(channelName, channelName, basicProperties, bytes);
                } finally {
                    if (channel != null && channel.isOpen()) {
                        channel.close();
                    }

                }
            } catch (Throwable var29) {
                var4 = var29;
                throw var29;
            } finally {
                if (connection != null) {
                    if (var4 != null) {
                        try {
                            connection.close();
                        } catch (Throwable var27) {
                            var4.addSuppressed(var27);
                        }
                    } else {
                        connection.close();
                    }
                }

            }
        } catch (IOException var31) {
            var31.printStackTrace();
        } catch (Exception var32) {
            var32.printStackTrace();
        }

    }
}