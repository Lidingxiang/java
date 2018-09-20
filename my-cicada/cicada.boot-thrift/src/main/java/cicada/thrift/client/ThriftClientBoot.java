package cicada.thrift.client;


import java.lang.reflect.Proxy;
import java.util.Iterator;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class ThriftClientBoot implements CommandLineRunner {
    private Logger log = LoggerFactory.getLogger(ThriftClientBoot.class);
    @Autowired
    private EndpointConfig _endpointConfig;
    @Autowired
    ApplicationContext context;

    public ThriftClientBoot() {
    }

    public void run(String... args) throws Exception {
        List<EndpointInfo> list = this._endpointConfig.load();
        if (list != null && list.size() > 0) {
            ConfigurableApplicationContext configurableApplicationContext = (ConfigurableApplicationContext)this.context;
            DefaultListableBeanFactory facotry = (DefaultListableBeanFactory)configurableApplicationContext.getBeanFactory();
            Iterator var5 = list.iterator();

            while(var5.hasNext()) {
                EndpointInfo endpointInfo = (EndpointInfo)var5.next();

                try {
                    RpcClient client = new RpcClient(endpointInfo);
                    ThriftClientInterceptor thriftClientInterceptor = new ThriftClientInterceptor(endpointInfo, client);
                    Class<?> type = endpointInfo.getContractType();
                    Class<?>[] interfaces = new Class[]{type};
                    Object proxy = Proxy.newProxyInstance(type.getClassLoader(), interfaces, thriftClientInterceptor);
                    String beanName = type.getName().toLowerCase().trim();
                    facotry.registerSingleton(beanName, proxy);
                    if (this.log.isInfoEnabled()) {
                        this.log.info("rpc 客户端注册成功,name:{},class:{},loader:{}", new Object[]{beanName, proxy.getClass().getName(), proxy.getClass().getClassLoader().toString()});
                    }
                } catch (Exception var13) {
                    this.log.error("注入cicada_thrift客户端:{} 出错:{} 详细信息:{}", new Object[]{endpointInfo.getContractType().getName(), var13.getMessage(), var13.getStackTrace()});
                }
            }
        }

    }
}