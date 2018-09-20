package cicada.thrift.server;


public interface RpcServer {
    <T> void run(Class<T> var1);

    void close();
}
