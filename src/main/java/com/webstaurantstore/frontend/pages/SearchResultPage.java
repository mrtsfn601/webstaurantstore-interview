package com.webstaurantstore.frontend.pages;

import static com.webstaurantstore.frontend.utils.SeleniumWaitUtils.waitForElementToBeClickable;
import static com.webstaurantstore.frontend.utils.SeleniumWaitUtils.waitForElementsToBeVisible;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import com.webstaurantstore.frontend.utils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SearchResultPage extends BasePage {

    private final By itemDescriptionTextsBy = By.cssSelector("[data-testid='itemDescription']");
    private final By paginationBarBy = By.cssSelector("#paging");
    private final By currentPageLinkBy = By.cssSelector("a[aria-label*='current page']");
    private final By lastPageLinkBy = By.cssSelector("a[aria-label*='last page, page ']");
    private final By addToCartButtonsBy = By.cssSelector("input[data-testid='itemAddCart']");
    private final By addToCartButtonContainersBy = By.cssSelector(".btn-container");
    private final By addToCartNotificationBy = By.cssSelector("[data-role='notification']");
    private final By viewCartNotificationActionButtonBy = By.cssSelector("a[href='/viewcart.cfm']");

    // another approach would be to locate web elements with @FindBy
    @FindBy(css = "a[aria-label*='current page']")
    private WebElement currentPageLink;

    public SearchResultPage() {
        super();
    }

    public SearchResultPage assertAllFoundItemsContain(String description) {
        do {
            assertItemsOnTheCurrentPageContain(description);
        } while (goToNextPage());
        return this;
    }

    public SearchResultPage assertItemsOnTheCurrentPageContain(String description) {
        String expectedDesc = description.toLowerCase();
        List<WebElement> items = waitForElementsToBeVisible(itemDescriptionTextsBy);
        assertFalse(items.isEmpty(), "Expected: non-empty search result but was empty");
        items.forEach(item -> {
            String actualDesc = item.getText().toLowerCase();
            assertTrue(actualDesc.contains(expectedDesc)
        // found item with description=metro cr2430dss drive-thru order prep station with stainless steel shelving - 31 3/4" x 27 3/4" x 65 3/4" contains table
                            || actualDesc.contains("drive-thru order prep station with stainless steel shelving"),
                    String.format("Expected: found item with description=%s contains %s", actualDesc, expectedDesc));
        });
        return this;
    }

    public boolean goToNextPage() {
        new SeleniumUtils().scrollDown();
        if (!isElementFound(paginationBarBy) || !isElementFound(lastPageLinkBy)) {
            return false;
        }
        String currentUrl = driver.getCurrentUrl();
        String currentPage = findElement(currentPageLinkBy).getText();
        int nextPage = Integer.parseInt(currentPage) + 1;
        By nextPageBy = By.cssSelector(String.format("a[aria-label$='page %d']", nextPage));
        if (isElementFound(nextPageBy)) {
            findElement(nextPageBy).click();
        }
        String nextUrl = driver.getCurrentUrl();
        return !currentUrl.equals(nextUrl);
    }

    public SearchResultPage addLastItemToCart() {
        List<WebElement> addToCartButtonContainers = findElements(addToCartButtonContainersBy);
        // if item contains dropdown, which requires selection, then select any option
        List<WebElement> nestedDropDown =
                addToCartButtonContainers.get(addToCartButtonContainers.size() - 1).findElements(By.tagName("select"));
        if (!nestedDropDown.isEmpty()) {
            new Select(nestedDropDown.get(0)).selectByIndex(1);
        }
        // TODO handle items that are out of stock, cause not able to add to cart such items
        List<WebElement> addItemToCartButtons = findElements(addToCartButtonsBy);
        addItemToCartButtons.get(addItemToCartButtons.size() - 1).click();
        return this;
    }

    @Override
    public CartPage goToCart() {
        if (isElementFound(addToCartNotificationBy)) {
            try {
                waitForElementToBeClickable(viewCartNotificationActionButtonBy).click();
                return new CartPage().waitForPageToBeLoaded();
            } catch (WebDriverException ignored) {
            }
        }
        super.goToCart();
        return new CartPage().waitForPageToBeLoaded();
    }

}
