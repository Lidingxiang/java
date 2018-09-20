package cicada.mq.receive;

public interface ReceiverManager {
    void run() throws Exception;

    void close() throws Exception;
}
