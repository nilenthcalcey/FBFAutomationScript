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
    }

    public void expandMenuFQuizScreen() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(menuBtn));
        wait.until(ExpectedConditions.elementToBeClickable(menuBtn));
        driver.findElement(menuBtn).click();
    }

    public void navigateToAboutUsPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(aboutUsBtn));
        wait.until(ExpectedConditions.elementToBeClickable(aboutUsBtn));
        WebElement element = driver.findElement(aboutUsBtn);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", element);
    }


    public String getAboutUsPageHeader() {
        return driver.findElement(aboutUsPageHeader).getText();
    }

    public String getAboutUsSelectTextColor() {
        String color = driver.findElement(aboutUsBtn).getCssValue("color");
        return color;
    }

    public String getAboutUsSelectBackColor() {
        String css = driver.findElement(aboutUsBtn).getCssValue("background-color");
        return css;
    }

    public String getAboutUsTextColor() {
        String color = driver.findElement(aboutUsBtn).getCssValue("color");
        return color;
    }

    public String getAboutUsBackColor() {
        String css = driver.findElement(aboutUsBtn).getCssValue("background-color");
        return css;
    }
}
