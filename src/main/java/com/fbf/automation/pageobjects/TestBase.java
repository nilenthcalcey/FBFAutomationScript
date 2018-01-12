package com.fbf.automation.pageobjects;

import com.fbf.automation.DriverFactory;
import com.fbf.automation.utils.CommonOperations;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.annotations.*;

public abstract class TestBase {
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeSuite
    public void setUp() {
        driver = DriverFactory.getDriver();
    }

    @AfterSuite
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
