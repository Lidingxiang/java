package com.dingxiang.servicecentre;

import java.util.List;
import java.util.function.Consumer;

public interface Finder {

    void init(String respository) throws Exception;

    void add(String path, Consumer<List<String>> serviceListChangedAction) throws Exception;
}
