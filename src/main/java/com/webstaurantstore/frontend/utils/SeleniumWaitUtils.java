package com.webstaurantstore.frontend.utils;

import com.webstaurantstore.frontend.drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SeleniumWaitUtils {

    public static final long WAIT_TO_BE_INTRACTABLE = 8;
    public static final long WAIT_TO_BE_VISIBLE = 8;

    private SeleniumWaitUtils() {}

    public static WebElement waitForElementToBeClickable(By by) {
        return waitForElementToBeClickable(by, WAIT_TO_BE_INTRACTABLE);
    }

    public static WebElement waitForElementToBeClickable(By by, long sec) {
        return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(sec))
                .ignoring(WebDriverException.class)
                .until(ExpectedConditions.elementToBeClickable(by));
    }

    public static WebElement waitForElementToBeClickable(WebElement el) {
        return waitForElementToBeClickable(el, WAIT_TO_BE_INTRACTABLE);
    }

    public static WebElement waitForElementToBeClickable(WebElement el, long sec) {
        return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(sec))
                .ignoring(WebDriverException.class)
                .until(ExpectedConditions.elementToBeClickable(el));
    }

    public static WebElement waitForElementToBeVisible(By by) {
        return waitForElementToBeVisible(by, WAIT_TO_BE_VISIBLE);
    }

    public static WebElement waitForElementToBeVisible(By by, long sec) {
        return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(sec))
                .ignoring(WebDriverException.class)
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static List<WebElement> waitForElementsToBeVisible(By by) {
        return waitForElementsToBeVisible(by, WAIT_TO_BE_VISIBLE);
    }

    public static List<WebElement> waitForElementsToBeVisible(By by, long sec) {
        return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(sec))
                .ignoring(WebDriverException.class)
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

}
