package cicada.core.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.*;
import java.util.Properties;

@Configuration
@PropertySource(
        value = {"file:config/cicada-${spring.profiles.active}.properties", "config/cicada-${spring.profiles.active}.properties", "file:config/cicada.properties", "config/cicada.properties"},
        ignoreResourceNotFound = true,
        encoding = "UTF-8"
)
public class RootConfig {
    public RootConfig() {
    }

    private Properties getProperties(File file) throws FileNotFoundException, IOException {
        Properties prop = new Properties();
        FileInputStream in = new FileInputStream(file);
        Throwable var4 = null;

        Object var7;
        try {
            InputStreamReader reader = new InputStreamReader(in, "UTF-8");
            Throwable var6 = null;

            try {
                prop.load(reader);
                var7 = prop;
            } catch (Throwable var30) {
                var7 = var30;
                var6 = var30;
                throw var30;
            } finally {
                if (reader != null) {
                    if (var6 != null) {
                        try {
                            reader.close();
                        } catch (Throwable var29) {
                            var6.addSuppressed(var29);
                        }
                    } else {
                        reader.close();
                    }
                }

            }
        } catch (Throwable var32) {
            var4 = var32;
            throw var32;
        } finally {
            if (in != null) {
                if (var4 != null) {
                    try {
                        in.close();
                    } catch (Throwable var28) {
                        var4.addSuppressed(var28);
                    }
                } else {
                    in.close();
                }
            }

        }

        return (Properties) var7;
    }
}