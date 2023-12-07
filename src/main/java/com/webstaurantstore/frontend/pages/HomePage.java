package com.webstaurantstore.frontend.pages;

import static com.webstaurantstore.frontend.utils.SeleniumWaitUtils.waitForElementToBeVisible;

import com.webstaurantstore.common.utils.ConfigManager;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    private final By globalHeaderBy = By.cssSelector(".global-header");

    public HomePage() {
        super();
    }

    public HomePage goToHomePage() {
        driver.navigate().to(ConfigManager.getProperty(ConfigManager.BASE_URL));
        waitForElementToBeVisible(globalHeaderBy);
        return this;
    }

}
