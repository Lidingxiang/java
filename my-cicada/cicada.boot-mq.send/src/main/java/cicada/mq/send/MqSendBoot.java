package cicada.mq.send;


import cicada.core.BeanFactory;
import cicada.mq.send.config.SenderConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class MqSendBoot implements CommandLineRunner {
    @Autowired
    ApplicationContext context;

    public MqSendBoot() {
    }

    public void run(String... args) throws Exception {
        if (this.context.getParent() == null) {
            try {
                SenderConfig config = (SenderConfig)BeanFactory.getBeanByType(SenderConfig.class);
                config.load();
            } catch (Exception var3) {
                throw var3;
            }
        }

    }
}
