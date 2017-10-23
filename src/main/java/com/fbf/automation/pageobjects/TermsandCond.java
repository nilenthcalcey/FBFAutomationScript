package com.fbf.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by lahiru.k on 10/21/2017.
 */
public class TermsandCond extends PageBase {

    WebDriver driver = null;
    WebDriverWait wait;

    By menuBtn = By.xpath("//a[@class='main-nav-btn']");
    By createneworderMenuBtn = By.xpath("//div[@class = 'main-toggle-menu']//li[2]/a");
    By createorderpageLabel = By.xpath("//div[@class='ordertime-col']//span[contains(.,'Order For Later')]");

    public TermsandCond(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 30);
        this.driver = driver;
    }

    public void expandTheMenuScreeninTermCondScreen(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(menuBtn));
        wait.until(ExpectedConditions.elementToBeClickable(menuBtn));
        driver.findElement(menuBtn).click();

    }

    public void navigateToCreateNewOrderPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(createneworderMenuBtn));
        wait.until(ExpectedConditions.visibilityOfElementLocated(createneworderMenuBtn));
        driver.findElement(createneworderMenuBtn).click();
    }

    public String getCreateNewOrderPageLabel(){
        return driver.findElement(createorderpageLabel).getText();
    }


}