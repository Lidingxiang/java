package cicada.core;


import org.springframework.context.ApplicationContext;

public class BeanFactory {
    private static ApplicationContext context;

    public BeanFactory() {
    }

    public static void setApplicationContext(ApplicationContext applicationContext) {
        if (context == null) {
            context = applicationContext;
        }

    }

    public static ApplicationContext getApplicationContext() {
        return context;
    }

    public static <T> T getBeanByType(Class<T> t) {
        if (context == null) {
            return null;
        } else {
            T client = context.getBean(t);
            return client;
        }
    }

    public static <T> T getBeanByType(String name, Class<T> t) {
        if (context == null) {
            return null;
        } else {
            T client = context.getBean(name, t);
            return client;
        }
    }

    public static <T> T getBeanByName(String name) {
        if (context == null) {
            return null;
        } else {
            T client = (T)context.getBean(name);
            return client;
        }
    }
}
