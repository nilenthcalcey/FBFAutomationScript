package com.fbf.automation.pageobjects;

import com.fbf.automation.utils.CommonOperations;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * Created by lahiru.k on 10/21/2017.
 */
public class ContactUs extends PageBase {

    WebDriver driver = null;
    WebDriverWait wait;

    By menuBtn = By.xpath("//a[@class='main-nav-btn']");
    By termsandcondmenuBtn = By.xpath("//div[@class ='main-toggle-menu-container active']//a[contains(.,'Terms and conditions')]");
    By getTermsandcondpageLabel = By.xpath("//div[@class='fbf-small-container']//h2");

    public ContactUs(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 30);
        this.commonOperations = new CommonOperations();
        this.driver = driver;
    }

    public void exapandMenuScreenContUsScreen(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(menuBtn));
        wait.until(ExpectedConditions.elementToBeClickable(menuBtn));
        driver.findElement(menuBtn).click();
    }

    public void navigateToTermsandConditionPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(termsandcondmenuBtn));
        wait.until(ExpectedConditions.elementToBeClickable(termsandcondmenuBtn));
        WebElement element = driver.findElement(termsandcondmenuBtn);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()", element);
        //driver.findElement(termsandcondmenuBtn).click();
    }

    public String getTermsandConditionPageLabel(){
        return driver.findElement(getTermsandcondpageLabel).getText();
    }

}
