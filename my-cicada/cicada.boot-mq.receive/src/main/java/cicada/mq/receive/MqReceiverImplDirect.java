package cicada.mq.receive;


import cicada.core.Guard;
import cicada.mq.receive.config.ReceiverInfo;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.AMQP.BasicProperties;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.TimeoutException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component("mqrecivedirect")
@Scope("prototype")
@Order(0)
public class MqReceiverImplDirect implements MqReceiver {
    private static final Logger log = LoggerFactory.getLogger(MqReceiverImplDirect.class);
    private ReceiverInfo _info;
    private Connection _connection;
    private Channel _chanel;
    private Object _receiver;
    private Method _receiveMethod;
    private MqReceiveConnectionFactory _connectionFactory;

    public MqReceiverImplDirect(MqReceiveConnectionFactory connectionFactory) {
        this._connectionFactory = connectionFactory;
    }

    public void init(ReceiverInfo info) throws Exception {
        Guard.ThrowIfArgumentIsNull(info, "info");
        this._info = info;
        Class<?> temp1 = this._info.getContractType();
        this._receiver = temp1.newInstance();
        this._receiveMethod = this._info.getContractType().getMethod("receive", this._info.getMessageType());
    }

    public void run() throws Exception {
        this._connection = this._connectionFactory.get(this._info);
        this._chanel = this._connection.createChannel();
        this._chanel.queueDeclare(this._info.getChannelName(), true, false, false, (Map)null);
        this._chanel.basicQos(0, 1, false);
        Consumer consumer = new DefaultConsumer(this._chanel) {
            public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");

                try {
                    MqReceiverImplDirect.this._receiveMethod.invoke(MqReceiverImplDirect.this._receiver, message);
                } catch (IllegalArgumentException | InvocationTargetException | IllegalAccessException var7) {
                    MqReceiverImplDirect.log.error("mqreive出错", var7);
                }

            }
        };
        this._chanel.basicConsume(this._info.getChannelName(), true, consumer);
    }

    public void close() {
        try {
            this._chanel.close();
            this._connection.close();
        } catch (TimeoutException | IOException var2) {
            var2.printStackTrace();
            log.error("mqreive关闭出错", var2);
        }

    }
}
