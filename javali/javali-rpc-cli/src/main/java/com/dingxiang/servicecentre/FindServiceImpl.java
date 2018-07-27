package com.dingxiang.servicecentre;

import com.dingxiang.BeanFactory;
import com.dingxiang.Guard;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

@Component
public class FindServiceImpl implements FindService {

    private final Map<String, Finder> _finders = new HashMap<String, Finder>();

    @Override
    public void init(String respository, String path, Consumer<List<String>> serviceListChangedAction) throws Exception {

        Guard.ThrowIfArgumentIsNullOrEmpty(respository, "respository");
        Guard.ThrowIfArgumentIsNullOrEmpty(path, "path");
        Guard.ThrowIfArgumentIsNull(serviceListChangedAction, "action");

        Finder finder;
        if (!this._finders.containsKey(respository)) {
            finder = BeanFactory.getBeanByType(Finder.class);
            finder.init(respository);
            _finders.put(respository, finder);
        } else {
            finder = this._finders.get(respository);
        }
        finder.add(path, serviceListChangedAction);
    }
}
