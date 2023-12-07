package com.webstaurantstore.frontend.utils;

import com.webstaurantstore.frontend.drivers.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;


public class SeleniumUtils {

    private final WebDriver driver;

    public SeleniumUtils() {
        driver = DriverManager.getDriver();
    }

    public void scrollDown() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void scrollUp() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
    }

}
