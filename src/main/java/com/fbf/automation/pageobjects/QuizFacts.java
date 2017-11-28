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
public class QuizFacts extends PageBase {

    WebDriver driver = null;
    WebDriverWait wait;

    By menuBtn = By.xpath("//a[@class='main-nav-btn']");
    By menuContactUsBtn = By.xpath("//a[contains(.,'Contact us')]");
    By contactUsPageHeader = By.xpath("//h2[@class = 'page-title logo-watermark-inner secondary-color']//div[@class = 'container']");


    public QuizFacts(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 60);
        this.commonOperations = new CommonOperations();
        this.driver = driver;
    }

    public void expandMenuScreenQuizFactsPage() {
        wait.until(ExpectedConditions.elementToBeClickable(menuBtn));
        driver.findElement(menuBtn).click();
    }

    public void navigateToContactUsPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(menuContactUsBtn));
        wait.until(ExpectedConditions.elementToBeClickable(menuContactUsBtn));
        WebElement element = driver.findElement(menuContactUsBtn);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", element);
    }

    public String getContactUsPageHeader() {
        return driver.findElement(contactUsPageHeader).getText();
    }

    public String getContactUsSelectTextColor() {
        String color = driver.findElement(menuContactUsBtn).getCssValue("color");
        return color;
    }

    public String getContactUsSelectBackColor() {
        String css = driver.findElement(menuContactUsBtn).getCssValue("background-color");
        return css;
    }

    public String getContactUsTextColor() {
        String color = driver.findElement(menuContactUsBtn).getCssValue("color");
        return color;
    }

    public String getContactUsBackColor() {
        String css = driver.findElement(menuContactUsBtn).getCssValue("background-color");
        return css;
    }

}
