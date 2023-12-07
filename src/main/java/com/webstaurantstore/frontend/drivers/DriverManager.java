package com.webstaurantstore.frontend.drivers;

import com.webstaurantstore.common.utils.ConfigManager;
import org.apache.commons.lang3.NotImplementedException;
import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static volatile WebDriver instance;

    private DriverManager() {
        // private constructor to prevent instantiation
    }

    public static WebDriver getDriver() {
        if (instance == null) {
            synchronized (DriverManager.class) {
                if (instance == null) {
                    String browser = ConfigManager.getProperty(ConfigManager.BROWSER);
                    // headless
                    switch(browser) {
                        case "edge":
                            throw new NotImplementedException("edge driver is not implemented yet");
                        default:
                            instance = new ChromeWebDriver().build();
                    }
                }
            }
        }
        return instance;
    }

}
