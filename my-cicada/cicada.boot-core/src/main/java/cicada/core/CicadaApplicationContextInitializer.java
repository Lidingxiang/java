package cicada.core;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

public class CicadaApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    private static final Logger log = LoggerFactory.getLogger(CicadaApplicationContextInitializer.class);

    public CicadaApplicationContextInitializer() {
    }

    public void initialize(ConfigurableApplicationContext applicationContext) {
        BeanFactory.setApplicationContext(applicationContext);
    }
}