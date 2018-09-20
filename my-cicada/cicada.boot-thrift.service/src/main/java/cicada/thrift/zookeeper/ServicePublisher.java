package cicada.thrift.zookeeper;

import org.springframework.beans.factory.DisposableBean;

public interface ServicePublisher extends DisposableBean {
    void Init(String var1, ConnectionFailProcessMode var2, String var3, String var4);

    void publish();

    void cancel();
}
