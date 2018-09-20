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

@Component("mqrecivebroadcast")
@Scope("prototype")
@Order(0)
public class MqReceiverImplBroadcast implements MqReceiver {
    private static final Logger log = LoggerFactory.getLogger(MqReceiverImplBroadcast.class);
    private final MqReceiveConnectionFactory _connectionFactory;
    private ReceiverInfo _info;
    private Connection _connection;
    private Channel _chanel;
    private Object _receiver;
    private Method _receiveMethod;

    public MqReceiverImplBroadcast(MqReceiveConnectionFactory connectionFactory) {
        this._connectionFactory = connectionFactory;
    }

    public void init(ReceiverInfo info) throws Exception {
        Guard.ThrowIfArgumentIsNull(info, "info");
        this._info = info;
        this._receiver = this._info.getContractType().newInstance();
        Class<?> contractType = this._info.getContractType();
        Class<?> paramType = this._info.getMessageType();
        this._receiveMethod = contractType.getMethod("receive", paramType);
    }

    public void run() throws Exception {
        this._connection = this._connectionFactory.get(this._info);
        this._chanel = this._connection.createChannel();
        this._chanel.exchangeDeclare(this._info.getChannelName(), "fanout", false);
        String text = this._chanel.queueDeclare("", false, true, true, (Map)null).getQueue();
        this._chanel.queueBind(text, this._info.getChannelName(), "");
        this._chanel.basicQos(0, 1, false);
        Consumer consumer = new DefaultConsumer(this._chanel) {
            public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");

                try {
                    MqReceiverImplBroadcast.this._receiveMethod.invoke(MqReceiverImplBroadcast.this._receiver, message);
                } catch (IllegalArgumentException | InvocationTargetException | IllegalAccessException var7) {
                    var7.printStackTrace();
                    MqReceiverImplBroadcast.log.error("mq出错", var7);
                }

            }
        };
        this._chanel.basicConsume("", true, consumer);
    }

    public void close() {
        try {
            this._chanel.close();
            this._connection.close();
        } catch (TimeoutException | IOException var2) {
            log.error("mq关闭出错", var2);
        }

    }
}
