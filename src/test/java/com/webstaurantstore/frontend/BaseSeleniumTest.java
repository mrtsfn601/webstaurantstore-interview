package com.webstaurantstore.frontend;

import com.webstaurantstore.frontend.drivers.DriverManager;
import org.testng.annotations.AfterTest;

public abstract class BaseSeleniumTest {

    @AfterTest
    protected void afterTest() {
        DriverManager.getDriver().close();
    }

}
