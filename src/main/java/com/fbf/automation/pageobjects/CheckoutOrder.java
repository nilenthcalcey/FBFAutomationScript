package com.fbf.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by lahiru.k on 10/30/2017.
 */
public class CheckoutOrder extends PageBase{

    WebDriver driver = null;
    WebDriverWait wait;

    By cartnumberLabel = By.xpath("//div[@class='mini-cart-outer']//a[@class='mini-cart']//span");

    public CheckoutOrder(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 30);
        this.driver = driver;
    }

    public String getCartitemCount(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartnumberLabel));
        wait.until(ExpectedConditions.elementToBeClickable(cartnumberLabel));
        return driver.findElement(cartnumberLabel).getText();
    }
}
