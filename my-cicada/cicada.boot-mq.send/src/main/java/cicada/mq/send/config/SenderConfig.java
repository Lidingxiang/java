package cicada.mq.send.config;

public interface SenderConfig {
    void load();

    SenderInfo get(String var1) throws Exception;
}
