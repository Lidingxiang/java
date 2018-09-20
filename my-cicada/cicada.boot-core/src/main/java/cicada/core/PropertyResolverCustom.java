package cicada.core;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyResolverCustom {
    private static final Logger log = LoggerFactory.getLogger(PropertyResolverCustom.class);

    public PropertyResolverCustom() {
    }

    public static Map<String, String> getConfigProperties(String fileFullPath) {
        Map<String, String> result = new HashMap();
        Properties properties = new Properties();

        try {
            InputStream inputStream = getFileStream(fileFullPath);
            Throwable var4 = null;

            try {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
                Throwable var6 = null;

                try {
                    properties.load(inputStream);
                } catch (Throwable var31) {
                    var6 = var31;
                    throw var31;
                } finally {
                    if (inputStreamReader != null) {
                        if (var6 != null) {
                            try {
                                inputStreamReader.close();
                            } catch (Throwable var30) {
                                var6.addSuppressed(var30);
                            }
                        } else {
                            inputStreamReader.close();
                        }
                    }

                }

                Enumeration keys = properties.propertyNames();

                while(keys.hasMoreElements()) {
                    String key = (String)keys.nextElement();
                    String value = properties.getProperty(key);
                    result.put(key, value);
                }
            } catch (Throwable var33) {
                var4 = var33;
                throw var33;
            } finally {
                if (inputStream != null) {
                    if (var4 != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable var29) {
                            var4.addSuppressed(var29);
                        }
                    } else {
                        inputStream.close();
                    }
                }

            }
        } catch (Exception var35) {
            log.error("解析属性文件:{}出错:{},详细信息:{}", new Object[]{fileFullPath, var35.getMessage(), var35.getStackTrace()});
        }

        return result;
    }

    private static InputStream getFileStream(String fileFullPath) throws FileNotFoundException {
        InputStream inputStream = PropertyResolverCustom.class.getClassLoader().getResourceAsStream(fileFullPath.toLowerCase());
        if (inputStream == null) {
            inputStream = new FileInputStream(fileFullPath);
        }

        return (InputStream)inputStream;
    }
}