package com.dingxiang.client;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import java.lang.reflect.Proxy;
import java.util.List;

@Service
public class ModuleBoot implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger log = Logger.getLogger(ModuleBoot.class);

    @Autowired
    private EndpointConfig _endpointConfig;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        log.info("===>ModuleBoot");

        ApplicationContext context = event.getApplicationContext();
        if (context.getParent() == null) {
            try {
                List<EndpointInfo> list = this._endpointConfig.load();
                if (list != null && list.size() > 0) {

                    DefaultListableBeanFactory facotry = (DefaultListableBeanFactory) context.getAutowireCapableBeanFactory();
                    for (EndpointInfo endpointInfo : list) {
                        RpcClient client = new RpcClient(endpointInfo);
                        ThriftClientInterceptor thriftClientInterceptor = new ThriftClientInterceptor(endpointInfo, client);
                        Class<?> type = endpointInfo.getContractType();
                        Class<?>[] interfaces = new Class<?>[]{type};
                        Object proxy = Proxy.newProxyInstance(client.getClass().getClassLoader(), interfaces, thriftClientInterceptor);
                        String beanName = type.toString();
                        facotry.registerSingleton(beanName, proxy);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
