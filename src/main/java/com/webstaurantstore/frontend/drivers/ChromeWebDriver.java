package com.webstaurantstore.frontend.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class ChromeWebDriver implements BrowserWebDriver{

    public static final Duration DEFAULT_WAIT = Duration.ofSeconds(8);

    public ChromeWebDriver() {
    }

    public WebDriver build() {
        return build(false);
    }

    public WebDriver build(boolean headless) {
        // TODO specify chrome options and driver configuration
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT);
        return driver;
    }

}
