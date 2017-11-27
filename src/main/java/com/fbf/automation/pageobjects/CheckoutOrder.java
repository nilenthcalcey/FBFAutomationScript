package com.fbf.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

/**
 * Created by lahiru.k on 10/30/2017.
 */
public class CheckoutOrder extends PageBase {

    WebDriver driver = null;
    WebDriverWait wait;

    String userName = getProperties().getProperty("userName");
    String guestEmail = "automation" + System.currentTimeMillis() + "@mailinator.com";

    By cartnumberLabel = By.xpath("//div[@class='mini-cart-outer']//a[@class='mini-cart']//span");
    By nameTextBox = By.xpath("//input[@id='nameFocus']");
    By emailTextBox = By.xpath("//input[@id='emailFocus']");
    By mobileNumberTextBox = By.xpath("//input[@id='mobileFocus']");
    By termsandconditionCheckBox = By.xpath("//div[@class='form-group terms']//div/label/i");
    By proceedPaymentButton = By.xpath("//div[@class='fbf-form fbf-location-pick']/div[@class='form-group']");
    By braintreeLabel = By.xpath("//div[@class='braintree-sheet__text']");
    By calendarButton = By.xpath("//div[@class='mydp']//div[@class='selectiongroup']");
    By calendarDefaultSelectDate = By.xpath("//div[@class='datevalue currmonth highlight']");
    By checkoutLabel = By.xpath("//div[@class='fbf-form fbf-location-pick']/div[1]//label");

    public CheckoutOrder(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 30);
        this.driver = driver;
    }

    public String getCartItemCount() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartnumberLabel));
        wait.until(ExpectedConditions.elementToBeClickable(cartnumberLabel));
        return driver.findElement(cartnumberLabel).getText();
    }

    public void selectDefaultSelectedDate() {
        //scroll up the page
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,-250)", "");
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutLabel));

        wait.until(ExpectedConditions.visibilityOfElementLocated(calendarButton));
        wait.until(ExpectedConditions.elementToBeClickable(calendarButton));
        driver.findElement(calendarButton).click();
        driver.findElement(calendarDefaultSelectDate).click();
    }

    public String addGuestDetails() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameTextBox));
        wait.until(ExpectedConditions.elementToBeClickable(nameTextBox));
        driver.findElement(nameTextBox).clear();
        driver.findElement(nameTextBox).sendKeys(userName);
        driver.findElement(emailTextBox).sendKeys(guestEmail);
        driver.findElement(mobileNumberTextBox).sendKeys(getProperties().getProperty("guestMobileNumber"));
        driver.findElement(termsandconditionCheckBox).click();
        driver.findElement(proceedPaymentButton).click();
        return guestEmail;

    }

    public String getGuestEmail() {
        return this.guestEmail;
    }

    public String navigateToPaymentCardPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(braintreeLabel));
        return driver.findElement(braintreeLabel).getText();
    }

    public String getUserName() {
        return this.userName;
    }

    public String getLargeUserName() {
        return getProperties().getProperty("userName");
    }


    public void enterLargeUserDetails() {
        WebElement UserName = getDriver().findElement(nameTextBox);
        UserName.clear();
        UserName.sendKeys(getProperties().getProperty("userName"));
        WebElement UserEmail = getDriver().findElement(emailTextBox);
        UserEmail.clear();
        UserEmail.sendKeys(guestEmail);
        WebElement UserMobile = getDriver().findElement(mobileNumberTextBox);
        UserMobile.clear();
        UserMobile.sendKeys(getProperties().getProperty("guestMobileNumber"));
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        driver.findElement(termsandconditionCheckBox).click();
        getDriver().findElement(proceedPaymentButton).click();
    }

}
