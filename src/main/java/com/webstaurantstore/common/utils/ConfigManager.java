package com.webstaurantstore.common.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {

    private static final String PATH_TO_APPLICATION_PROPERTIES = "src/test/resources/application.properties";
    public static final String BASE_URL = "base.url";
    public static final String BROWSER = "ui.browser";
    private static volatile Properties properties;

    private ConfigManager() {
        // private constructor to prevent instantiation
    }

    public static String getProperty(String key) {
        return getProperties().getProperty(key);
    }

    public static Properties getProperties() {
        if (properties == null) {
            synchronized (ConfigManager.class) {
                if (properties == null) {
                    try (InputStream inputStream = new FileInputStream(PATH_TO_APPLICATION_PROPERTIES)) {
                        properties = new Properties();
                        properties.load(inputStream);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return properties;
    }

}
