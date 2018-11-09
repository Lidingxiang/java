package com.dingxiang;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyResolverCustom {
    private static final Logger log = Logger.getLogger(PropertyResolverCustom.class);

    public static Map<String, String> getConfigProperties(String fileFullPath) throws IOException {
        InputStreamReader inputStream = null;
        Map<String, String> result = new HashMap<>();
        try {
            inputStream = new InputStreamReader(PropertyResolverCustom.class.getClassLoader().getResourceAsStream(fileFullPath.toLowerCase()), "UTF-8");
            Properties properties = new Properties();
            properties.load(inputStream);
            Enumeration<?> keys = properties.propertyNames();

            while (keys.hasMoreElements()) {
                String key = (String) keys.nextElement();
                String value = properties.getProperty(key);
                result.put(key, value);
            }
        } catch (Exception e) {
            log.error(e);
            e.printStackTrace();
        } finally {
            if (inputStream != null) inputStream.close();
        }
        return result;
    }
}
