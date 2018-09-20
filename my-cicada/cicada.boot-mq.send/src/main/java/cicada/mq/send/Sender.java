package cicada.mq.send;

public interface Sender {
    <T> void send(String var1, T var2) throws Exception;
}
