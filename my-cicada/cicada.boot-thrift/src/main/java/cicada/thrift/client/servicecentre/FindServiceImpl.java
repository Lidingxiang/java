package cicada.thrift.client.servicecentre;

import cicada.core.BeanFactory;
import cicada.core.Guard;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import org.springframework.stereotype.Component;

@Component
public class FindServiceImpl implements FindService {
    private final Map<String, Finder> _finders = new HashMap();

    public FindServiceImpl() {
    }

    public void init(String respository, String path, Consumer<List<String>> serviceListChangedAction) throws Exception {
        Guard.ThrowIfArgumentIsNullOrEmpty(respository, "respository");
        Guard.ThrowIfArgumentIsNullOrEmpty(path, "path");
        Guard.ThrowIfArgumentIsNull(serviceListChangedAction, "action");
        Finder finder;
        if (!this._finders.containsKey(respository)) {
            finder = (Finder)BeanFactory.getBeanByType(Finder.class);
            finder.init(respository);
            this._finders.put(respository, finder);
        } else {
            finder = (Finder)this._finders.get(respository);
        }

        finder.add(path, serviceListChangedAction);
    }
}