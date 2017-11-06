package com.fbf.automation.pageobjects;

import com.fbf.automation.utils.CommonOperations;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class PageBase {
    public WebDriver driver;
    private Properties properties;
    CommonOperations commonOperations;

    By loadingSpinner = By.id("loading-bar-spinner");
    String URL = "http://fbf.qa/create-order";

    public PageBase(WebDriver driver) {
        this.driver = driver;
        this.commonOperations = new CommonOperations();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        String propertiesPath = getClass().getSimpleName();
        InputStream input = HomePage.class.getClassLoader().getResourceAsStream(propertiesPath + ".properties");
        properties = new Properties();
        try {
            if (input.available() > 0) {
                properties.load(input);
            }
        } catch (Exception e) {
        }
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public Properties getProperties() {
        return this.properties;
    }

    boolean waitUntilLoadingSpinnerInvisible() {
        return commonOperations.waitUntilElementInvisible(getDriver(), loadingSpinner, 5);
    }

//    //scroll down the page
//    public void scrollingToBottomofAPage() {
//        driver.navigate().to(URL);
//        ((JavascriptExecutor) driver)
//                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
//    }

}
