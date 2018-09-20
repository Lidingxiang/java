package cicada.thrift.client.servicecentre;

import java.util.List;
import java.util.function.Consumer;

public interface FindService {
    void init(String var1, String var2, Consumer<List<String>> var3) throws Exception;
}
