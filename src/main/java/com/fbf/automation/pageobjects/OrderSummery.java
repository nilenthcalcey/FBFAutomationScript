package com.fbf.automation.pageobjects;

import com.fbf.automation.utils.CommonOperations;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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
    By emailaddressTextBox = By.xpath("//input[@name='email']");
    By passwordTextBox = By.xpath("//input[@formcontrolname='password']");
    By confirmpasswordTextBox = By.xpath("//input[@formcontrolname='confirmPassword']");
    By continueButton = By.xpath("//form[@class='ng-untouched ng-pristine ng-invalid']//div[5]");
    By successfullypageLabel = By.xpath("//div[@class='align-center padding-15']");


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
    public String getEmailAddress(){
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");

        wait.until(ExpectedConditions.visibilityOfElementLocated(emailaddressTextBox));
        return driver.findElement(emailaddressTextBox).getAttribute("value");
    }

    public void addPasswordDetailsContinue(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordTextBox));
        wait.until(ExpectedConditions.elementToBeClickable(passwordTextBox));
        driver.findElement(passwordTextBox).clear();
        driver.findElement(passwordTextBox).sendKeys(getProperties().getProperty("userPassword"));
        driver.findElement(confirmpasswordTextBox).clear();
        driver.findElement(confirmpasswordTextBox).sendKeys(getProperties().getProperty("userConfirmPassword"));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(continueButton));
//        wait.until(ExpectedConditions.elementToBeClickable(continueButton));
//        driver.findElement(continueButton).click();
        driver.findElement(confirmpasswordTextBox).sendKeys(Keys.ENTER);

    }

    public String navigateToConfirmationPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(successfullypageLabel));
        return driver.findElement(successfullypageLabel).getText();
    }
}
