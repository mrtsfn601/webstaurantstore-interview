package com.webstaurantstore.common.utils;

import com.google.common.flogger.FluentLogger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {

    private static final FluentLogger log = FluentLogger.forEnclosingClass();
    public static final String BASE_URL = "base.url";
    private static final String PATH_TO_APPLICATION_PROPERTIES = "src/test/resource/application.properties";
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
                        log.atWarning().log("failed to load application properties from path=" + PATH_TO_APPLICATION_PROPERTIES);
                        e.printStackTrace();
                    }
                }
            }
        }
        return properties;
    }
}