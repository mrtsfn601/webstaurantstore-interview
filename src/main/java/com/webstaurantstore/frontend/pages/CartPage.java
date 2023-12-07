package com.webstaurantstore.frontend.pages;

import static com.webstaurantstore.frontend.utils.SeleniumWaitUtils.waitForElementToBeClickable;
import static com.webstaurantstore.frontend.utils.SeleniumWaitUtils.waitForElementToBeVisible;
import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.By;

public class CartPage extends BasePage {

    private final By viewCartPanelBy = By.cssSelector("[data-hypernova-key='ViewCart']");
    private final By cartItemsBy = By.cssSelector("div.cartItem");
    private final By emptyCartButtonBy = By.cssSelector("button.emptyCartButton");
    private final By emptyCartModalButtonBy = By.cssSelector(".ReactModalPortal footer button:first-of-type");
    private final By emptyCartTextBy = By.cssSelector(".cartEmpty .empty-cart__text");

    public CartPage() {
        super();
    }

    public CartPage waitForPageToBeLoaded() {
        waitForElementToBeVisible(viewCartPanelBy);
        return this;
    }

    public CartPage assertCartContainsItems(int expectedItemCount) {
        int actualItemCount = findElements(cartItemsBy).size();
        assertEquals(String.format("Expected: cart contains %d items but was %s", expectedItemCount, actualItemCount),
                expectedItemCount, actualItemCount);
        return this;
    }

    public CartPage emptyCart() {
        waitForElementToBeClickable(emptyCartButtonBy).click();
        waitForElementToBeClickable(emptyCartModalButtonBy).click();
        waitForElementToBeVisible(emptyCartTextBy);
        return this;
    }

}
