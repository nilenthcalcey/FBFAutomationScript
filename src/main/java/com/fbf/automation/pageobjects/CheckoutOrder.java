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
public class CheckoutOrder extends PageBase{

    WebDriver driver = null;
    WebDriverWait wait;

    String userName;

    By cartnumberLabel = By.xpath("//div[@class='mini-cart-outer']//a[@class='mini-cart']//span");
    By nameTextBox = By.xpath("//input[@id='nameFocus']");
    By emailTextBox = By.xpath("//input[@id='emailFocus']");
    By mobilenumberTextBox = By.xpath("//input[@id='mobileFocus']");
    By termsandconditionCheckBox = By.xpath("//div[@class='form-group terms']//div/label/i");
    By proceedpaymentButton = By.xpath("//button[@class='btn btn-primary btn-block']");
    By baintreeLabel = By.xpath("//div[@class='braintree-sheet__text']");
    By calenderButton = By.xpath("//div[@class='mydp']//div[@class='selectiongroup']");
    By calenderdefaultselectDate = By.xpath("//div[@class='datevalue currmonth highlight']");
    By checkoutLabel = By.xpath("//div[@class='fbf-form fbf-location-pick']/div[1]//label");


    public CheckoutOrder(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 30);
        this.driver = driver;
    }


    public String getCartitemCount(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartnumberLabel));
        wait.until(ExpectedConditions.elementToBeClickable(cartnumberLabel));
        return driver.findElement(cartnumberLabel).getText();
    }

    public void selectDefaultSelectedDate(){
        //scroll up the page
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,-250)", "");
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutLabel));

        wait.until(ExpectedConditions.visibilityOfElementLocated(calenderButton));
        wait.until(ExpectedConditions.elementToBeClickable(calenderButton));
        driver.findElement(calenderButton).click();
        driver.findElement(calenderdefaultselectDate).click();
    }

    public String addGuestDetails(){
        File file = new File("src\\main\\resources\\CheckoutOrder.properties");

        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Properties prop = new Properties();

        //load properties file
        try {
            prop.load(fileInput);
        } catch (IOException e) {
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameTextBox));
        wait.until(ExpectedConditions.elementToBeClickable(nameTextBox));
        driver.findElement(nameTextBox).clear();
        userName = prop.getProperty("userName");
        driver.findElement(nameTextBox).sendKeys(userName);
        driver.findElement(emailTextBox).sendKeys(prop.getProperty("guestEmail"));
        driver.findElement(mobilenumberTextBox).sendKeys(prop.getProperty("guestMobileNumber"));
        driver.findElement(termsandconditionCheckBox).click();
        driver.findElement(proceedpaymentButton).click();
        return userName;

    }

    public String navigateToPaymentCardPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(baintreeLabel));
        return driver.findElement(baintreeLabel).getText();
    }

    public String getUserName(){
        return this.userName;
    }

    public  String getLargeUserName()
    {
        return getProperties().getProperty("LuserName");
    }


    public void EnterLargeUserDetails()
    {


        WebElement UserName = getDriver().findElement(nameTextBox);
        UserName.clear();
        UserName.sendKeys(getProperties().getProperty("LuserName"));
        WebElement UserEmail = getDriver().findElement(emailTextBox);
        UserEmail.clear();
        UserEmail.sendKeys(getProperties().getProperty("LguestEmail"));
        WebElement UserMobile = getDriver().findElement(mobilenumberTextBox);
        UserMobile.clear();
        UserMobile.sendKeys(getProperties().getProperty("LguestMobileNumber"));
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        driver.findElement(termsandconditionCheckBox).click();
        getDriver().findElement(proceedpaymentButton).click();
    }

}
