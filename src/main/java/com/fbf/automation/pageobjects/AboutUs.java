package com.fbf.automation.pageobjects;

import com.fbf.automation.utils.CommonOperations;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AboutUs extends PageBase {

    WebDriver driver = null;
    WebDriverWait wait;

    By menuBtn = By.xpath("//a[@class='main-nav-btn']");
    By menuBtnActive = By.xpath("//a[@class='main-nav-btn active']");
    By faqMenuBtn = By.xpath("//a[contains(.,'FAQ')]");
    By faqPageHeader = By.xpath("//div[@class='fbf-main-content']/div/h2/div");
    By MenuLoginLabel = By.xpath("//a[contains(.,'LOG IN')]");

    public AboutUs(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 30);
        this.commonOperations = new CommonOperations();
        this.driver = driver;
        //driver.get("http://fbf.qa/orders");
    }

    public void expandAboutUsMenu() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(menuBtn));
        wait.until(ExpectedConditions.elementToBeClickable(menuBtn));
        driver.findElement(menuBtn).click();
    }

    public void navigateToFaq() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(faqMenuBtn));
        wait.until(ExpectedConditions.elementToBeClickable(faqMenuBtn));
        WebElement element = driver.findElement(faqMenuBtn);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", element);
    }

    public String getFaqPageHeader() {
        return driver.findElement(faqPageHeader).getText();
    }

    public String getFaqPageSelectTextColor() {
        String color = driver.findElement(faqMenuBtn).getCssValue("color");
        return color;
    }

    public String getFaqPageSelectBackColor() {
        String css = driver.findElement(faqMenuBtn).getCssValue("background-color");
        return css;
    }

    public String getFaqPageTextColor() {
        String color = driver.findElement(faqMenuBtn).getCssValue("color");
        return color;
    }

    public String getFaqPageBackColor() {
        String css = driver.findElement(faqMenuBtn).getCssValue("background-color");
        return css;
    }


}
