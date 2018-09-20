package cicada.mq.send;


import cicada.core.Guard;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class MqConnectionFactorySendImpl implements MqConnectionFactorySend {
    private final Map<MqServerInfo, ConnectionFactory> _factorys = new HashMap();

    public MqConnectionFactorySendImpl() {
    }

    public Connection get(MqServerInfo mqServerInfo) throws Exception {
        Guard.ThrowIfArgumentIsNull(mqServerInfo, "mqServerInfo");
        if (!this._factorys.containsKey(mqServerInfo)) {
            synchronized(this) {
                if (!this._factorys.containsKey(mqServerInfo)) {
                    ConnectionFactory connectionFactory = new ConnectionFactory();
                    connectionFactory.setHost(mqServerInfo.getServer());
                    if (mqServerInfo.getServerUserName() != null && !mqServerInfo.getServerUserName().isEmpty()) {
                        connectionFactory.setUsername(mqServerInfo.getServerUserName());
                    }

                    if (mqServerInfo.getServerPassword() != null && !mqServerInfo.getServerPassword().isEmpty()) {
                        connectionFactory.setPassword(mqServerInfo.getServerPassword());
                    }

                    if (mqServerInfo.getPort() != 0) {
                        connectionFactory.setPort(mqServerInfo.getPort());
                    }

                    connectionFactory.setRequestedHeartbeat(60);
                    connectionFactory.setAutomaticRecoveryEnabled(true);
                    this._factorys.put(mqServerInfo, connectionFactory);
                }
            }
        }

        return ((ConnectionFactory)this._factorys.get(mqServerInfo)).newConnection();
    }
}
