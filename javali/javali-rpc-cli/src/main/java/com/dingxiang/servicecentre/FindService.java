package com.dingxiang.servicecentre;

import java.util.List;
import java.util.function.Consumer;

public interface FindService {

    void init(String respository, String path, Consumer<List<String>> serviceListChangedAction) throws Exception;
}
