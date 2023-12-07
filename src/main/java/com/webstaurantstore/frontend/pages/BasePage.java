package com.webstaurantstore.frontend.pages;

import static com.webstaurantstore.frontend.utils.SeleniumWaitUtils.waitForElementToBeClickable;
import static com.webstaurantstore.frontend.utils.SeleniumWaitUtils.waitForElementToBeVisible;

import com.webstaurantstore.frontend.drivers.DriverManager;
import com.webstaurantstore.frontend.utils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class BasePage {


    private final By searchInputBy = By.cssSelector("input#searchval");
    private final By searchResultHeaderBy = By.cssSelector("h1.search--title");
    private final By cartButtonBy = By.cssSelector("a[data-testid='cart-button']");

    protected WebDriver driver;

    protected BasePage() {
        driver = DriverManager.getDriver();
    }

    protected WebElement findElement(By by) {
        return driver.findElement(by);
    }

    protected List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    protected boolean isElementFound(By by) {
        return !findElements(by).isEmpty();
    }

    public SearchResultPage search(String text) {
        waitForElementToBeClickable(searchInputBy).sendKeys(text + Keys.ENTER);
        waitForElementToBeVisible(searchResultHeaderBy);
        return new SearchResultPage();
    }

    public CartPage goToCart() {
        new SeleniumUtils().scrollUp();
        waitForElementToBeClickable(cartButtonBy).click();
        return new CartPage().waitForPageToBeLoaded();
    }
}
