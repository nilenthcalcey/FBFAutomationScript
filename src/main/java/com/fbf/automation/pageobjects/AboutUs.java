package com.fbf.automation.pageobjects;

import com.fbf.automation.utils.CommonOperations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AboutUs extends PageBase {

    WebDriver driver = null;
    WebDriverWait wait;

    By menuBtn = By.xpath("//a[@class='main-nav-btn']");
    By menuBtnActive = By.xpath("//a[@class='main-nav-btn active']");
    By aboutUsBtn = By.xpath("//a[contains(.,'About us')]");
    By aboutUsPageHeader = By.xpath("//div[@class='manifesto-inner fbf-script']/h1");
    By MenuLoginLabel = By.xpath("//a[contains(.,'LOG IN')]");

    public AboutUs(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 30);
        this.commonOperations = new CommonOperations();
        this.driver = driver;
        //driver.get("http://fbf.qa/orders");
    }

    public void expandAboutUsMenu(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(menuBtn));
        wait.until(ExpectedConditions.elementToBeClickable(menuBtn));
        driver.findElement(menuBtn).click();
    }

    public void navigateToCreateNewOrder(){

        wait.until(ExpectedConditions.visibilityOfElementLocated(aboutUsBtn));
        wait.until(ExpectedConditions.elementToBeClickable(aboutUsBtn));
        driver.findElement(aboutUsBtn).click();
    }

    public String getPageHeader(){
        return driver.findElement(aboutUsPageHeader).getText();
    }
}
