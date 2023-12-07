package com.webstaurantstore.frontend;

import com.webstaurantstore.frontend.pages.HomePage;
import org.testng.annotations.Test;

public class DemoTest extends BaseSeleniumTest {

    @Test
    public void addFoundLastItemToCartAndEmptyCart() {
        new HomePage()
                .goToHomePage()
                .search("stainless work table")
                .assertAllFoundItemsContain("Table")
                .addLastItemToCart()
                .goToCart()
                .assertCartContainsItems(1)
                .emptyCart()
                .assertCartContainsItems(0);
    }

}
