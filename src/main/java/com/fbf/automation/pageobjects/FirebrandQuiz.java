package com.fbf.automation.pageobjects;

import com.fbf.automation.utils.CommonOperations;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by lahiru.k on 10/20/2017.
 */
public class FirebrandQuiz extends PageBase {
    WebDriver driver = null;
    WebDriverWait wait;

    By menuBtn = By.xpath("//a[@class='main-nav-btn']");
    By menuBtnActive = By.xpath("//a[@class='main-nav-btn active']");
    By aboutUsBtn = By.xpath("//a[contains(.,'About us')]");
    By aboutUsPageHeader = By.xpath("//div[@class='manifesto-inner fbf-script']/h1");
    By MenuLoginLabel = By.xpath("//a[contains(.,'LOG IN')]");

    public FirebrandQuiz(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 5);
        this.commonOperations = new CommonOperations();
        this.driver = driver;
        //driver.get("http://fbf.qa/orders");
    }

    public void expandMenuFQuizScreen(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(menuBtn));
        wait.until(ExpectedConditions.elementToBeClickable(menuBtn));
        driver.findElement(menuBtn).click();
    }

    public void navigateToAboutUsPage(){

        wait.until(ExpectedConditions.visibilityOfElementLocated(aboutUsBtn));
        wait.until(ExpectedConditions.elementToBeClickable(aboutUsBtn));
        WebElement element = driver.findElement(aboutUsBtn);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()", element);
        //driver.findElement(aboutUsBtn).click();
    }


    public String getAboutUsPageHeader(){
        return driver.findElement(aboutUsPageHeader).getText();
    }
}
