package cicada.mq.receive.config;
import java.util.List;

public interface ReceiverConfig {
    List<ReceiverInfo> getReceivers() throws Exception;
}
