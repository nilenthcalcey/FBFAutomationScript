package com.fbf.automation.pageobjects;

import com.fbf.automation.utils.CommonOperations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by lahiru.k on 10/22/2017.
 */
public class RegularProtein extends PageBase {

    WebDriver driver= null;
    WebDriverWait wait;

    By selectchickenBtn = By.xpath("//div[contains(@class,'price-tag')]");
    By regularchickenLabel = By.xpath("//span[contains(.,'Chicken | Regular')]");
    By totalpriceLabel = By.xpath("//span[contains(.,'£2.99')]");


    public RegularProtein(WebDriver driver) {
        super(driver);
        this.commonOperations = new CommonOperations();
        this.wait = new WebDriverWait(driver, 30);
        this.driver = driver;
    }

//    public void selectRegularChickenInProteinPage(){
//        wait.until(ExpectedConditions.visibilityOfElementLocated(selectchickenBtn));
//        wait.until(ExpectedConditions.elementToBeClickable(selectchickenBtn));
//        driver.findElement(selectchickenBtn);
//    }

//    public String navigateToSelectedItemPage(){
//        wait.until(ExpectedConditions.visibilityOfElementLocated(regularchickenLabel));
//        wait.until(ExpectedConditions.elementToBeClickable(regularchickenLabel));
//        //now only check the Price check the calorie count also
//        return driver.findElement(totalpriceLabel).getText();
//
//    }
}
