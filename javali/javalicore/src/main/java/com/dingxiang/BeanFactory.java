package com.dingxiang;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class BeanFactory implements ApplicationContextAware {

    protected static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    public static <T> T getBeanByType(Class<T> t) {
        if (context == null) return null;
        T client = (T) context.getBean(t);
        return client;
    }

    public static <T> T getBeanByName(String name) {
        if (context == null) return null;
        @SuppressWarnings("unchecked")
        T client = (T) context.getBean(name);
        return client;
    }
}
