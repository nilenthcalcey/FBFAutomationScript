package com.fbf.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
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

    CardPayment cardPayment;
    String userName;
    String guestEmail = "automation" + System.currentTimeMillis()+"@mailinator.com";
   // YourOrder yourOrder;

    By cartnumberLabel = By.xpath("//div[@class='mini-cart-outer']//a[@class='mini-cart']//span");
    By nameTextBox = By.xpath("//input[@id='nameFocus']");
    By emailTextBox = By.xpath("//input[@id='emailFocus']");
    By mobilenumberTextBox = By.xpath("//input[@id='mobileFocus']");
    By termsandconditionCheckBox = By.xpath("//div[@class='form-group terms']//div/label/i");
    By proceedpaymentButton = By.xpath("//div[@class='fbf-form fbf-location-pick']/div[@class='form-group']");
    By baintreeLabel = By.xpath("//div[@class='braintree-sheet__text']");
    By calenderButton = By.xpath("//div[@class='mydp']//div[@class='selectiongroup']");
    By calenderdefaultselectDate = By.xpath("//div[@class='datevalue currmonth highlight']");
    By checkoutLabel = By.xpath("//div[@class='fbf-form fbf-location-pick']/div[1]//label");

//    YourOrder yourOrder = new YourOrder(driver);
//    String guestuserName = yourOrder.userName;
//    int theHeight = frame.height;


    public CheckoutOrder(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 30);
        this.driver = driver;
        //yourOrder = new YourOrder(driver);

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

    public String addGuestDetails() {
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
        //guestEmail = prop.getProperty("guestEmail");
        driver.findElement(emailTextBox).sendKeys(guestEmail);
        driver.findElement(mobilenumberTextBox).sendKeys(prop.getProperty("guestMobileNumber"));
        driver.findElement(termsandconditionCheckBox).click();
        driver.findElement(proceedpaymentButton).click();
        return userName;
    }
        public String getGuestEmail(){
            return this.guestEmail;

    }

    public String getUserName(){
        return this.userName;
    }


}
