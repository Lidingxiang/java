package cicada.core.config;

import cicada.core.BeanFactory;
import org.springframework.core.env.Environment;

public class ConfigManager {
    private static final String cicadaConfigPath = getConfigFile();

    public static String getCicadaConfigPath() {
        return cicadaConfigPath;
    }

    private ConfigManager() {
    }

    private static String getConfigFile() {
        Environment env = (Environment) BeanFactory.getBeanByType(Environment.class);
        String prux = env.getProperty("spring.profiles.active");
        if (prux != null && !prux.equals((Object)null) && !prux.isEmpty()) {
            String cicadaPath = String.format("config/cicada%s%s.properties", "-", prux);
            return cicadaPath;
        } else {
            return "config/cicada.properties";
        }
    }
}