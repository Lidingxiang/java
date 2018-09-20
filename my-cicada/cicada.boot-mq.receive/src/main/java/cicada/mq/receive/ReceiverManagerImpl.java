package cicada.mq.receive;


import cicada.mq.receive.config.ReceiverConfig;
import cicada.mq.receive.config.ReceiverInfo;
import java.util.Iterator;
import java.util.List;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1000)
public class ReceiverManagerImpl implements ReceiverManager {
    public ReceiverConfig _receiverConfig;

    public ReceiverManagerImpl(ReceiverConfig receiverConfig) throws Exception {
        this._receiverConfig = receiverConfig;
        List<ReceiverInfo> receivers = this._receiverConfig.getReceivers();
        Iterator var3 = receivers.iterator();

        while(var3.hasNext()) {
            ReceiverInfo current = (ReceiverInfo)var3.next();
            MqReceiver receiver = current.getMqReceiver();
            receiver.init(current);
        }

    }

    public void run() throws Exception {
        List<ReceiverInfo> receivers = this._receiverConfig.getReceivers();
        Iterator var2 = receivers.iterator();

        while(var2.hasNext()) {
            ReceiverInfo current = (ReceiverInfo)var2.next();
            MqReceiver receiver = current.getMqReceiver();
            receiver.run();
        }

    }

    public void close() throws Exception {
        List<ReceiverInfo> receivers = this._receiverConfig.getReceivers();
        Iterator var2 = receivers.iterator();

        while(var2.hasNext()) {
            ReceiverInfo current = (ReceiverInfo)var2.next();
            MqReceiver receiver = current.getMqReceiver();
            receiver.close();
        }

    }
}
