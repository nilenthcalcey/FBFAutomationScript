package com.fbf.automation.pageobjects;

import com.fbf.automation.utils.CommonOperations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by lahiru.k on 11/8/2017.
 */
public class OrderSummery extends PageBase {
    WebDriver driver = null;
    WebDriverWait wait;

    By subttotalLabel = By.xpath("//tr[1]//td[@class='font-bold align-right']");

    public OrderSummery(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.commonOperations = new CommonOperations();
        this.wait = new WebDriverWait(driver,30);

    }
    public String getOrderSummeryTotal(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(subttotalLabel));
        return driver.findElement(subttotalLabel).getText();
    }
}
