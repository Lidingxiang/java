package cicada.thrift.client.servicecentre;


import java.util.List;
import java.util.function.Consumer;

public interface Finder {
    void init(String var1) throws Exception;

    void add(String var1, Consumer<List<String>> var2) throws Exception;
}
