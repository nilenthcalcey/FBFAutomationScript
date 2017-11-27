package com.fbf.automation.pageobjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by lahiru.k on 10/27/2017.
 */
public class YourOrder extends PageBase {

    WebDriver driver = null;
    WebDriverWait wait;

    String subtotal;
    String multiplierNumber;
    String postalCode = "NW1 5QT";
    String streetAddress = "Stewart House,32 Russell Square,London";
    CheckoutOrder checkoutOrder;


    By subTotalPriceLabel = By.xpath("//div[@class='order-button-container item-has-selected']/div[1]//span[2]");
    By continueGuestNameRadioButton = By.xpath("//div[@class='cart-guest-options']//label[3]//i[@class='radio-placeholder']");
    By continueButton = By.xpath("//button[@class='btn btn-primary btn-block']");
    By checkOrderLabel = By.xpath("//label[contains(.,' Please let us know your name, email to send you an eco-friendly receipt, and mobile number, to let you know your order status')]");
    By mealAddButton = By.xpath("//div[@class='ordered-items']/div[1]//div[@class='increase-items']/button[2]/i");
    By multipleAddNumbersLabel = By.xpath("//div[@class='order-item-box select-item zig-zag-top summary-item']/div[3]//span");
    By enterPostalCodeInputTextBox = By.xpath("//input[@name='postalCode']");
    By enterStreetDetailsTextBox = By.xpath("//input[contains(@name,'streetDetails')]");
    By postalCodeNotificationLabel = By.xpath("//div[@class='form-group']/div/span");
    By brainTreeLabel = By.xpath("//div[@class='braintree-sheet__text']");

    //String guestEmail="";

    public YourOrder(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 30);
        this.driver = driver;
        checkoutOrder = new CheckoutOrder(driver);

    }

    public String getSubtotal() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(subTotalPriceLabel));
        subtotal = driver.findElement(subTotalPriceLabel).getText();
        return subtotal;
    }

    public void addtheMealsCount() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(mealAddButton));
        wait.until(ExpectedConditions.elementToBeClickable(mealAddButton));
        driver.findElement(mealAddButton).click();
    }

    public String checkGuestNameSelector(Boolean getOrderNowType) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(continueGuestNameRadioButton));
        boolean bgvalue;
        String guestEmail="";
        bgvalue = driver.findElement(continueGuestNameRadioButton).isSelected();
        if (bgvalue = true) {

            // This will select Second radio button, if the first radio button is selected by default
            driver.findElement(continueButton).click();
            //wait.until(ExpectedConditions.visibilityOfElementLocated(checkorderLabel));
            if (getOrderNowType == true) {
                wait.until(ExpectedConditions.visibilityOfElementLocated(checkOrderLabel));
                guestEmail = checkoutOrder.addGuestDetails();
            } else {
                checkoutOrder.selectDefaultSelectedDate();
                ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
                guestEmail = checkoutOrder.addGuestDetails();
            }
        } else {

            // If the first radio button is not selected by default, the first will be selected
            System.out.println("Selecting Wrong Radio button");
        }
        return guestEmail;
    }



    public void submitYourOrder() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(continueButton));
        wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        driver.findElement(continueButton).click();
    }

    public String getBrainTreeLabel() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(brainTreeLabel));
        return driver.findElement(brainTreeLabel).getText();
    }

    public String typePostalCard() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(enterPostalCodeInputTextBox));
        wait.until(ExpectedConditions.elementToBeClickable(enterPostalCodeInputTextBox));
        driver.findElement(enterPostalCodeInputTextBox).sendKeys(postalCode);
        return postalCode;
    }

    public String typeStreetAddress() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(enterStreetDetailsTextBox));
        wait.until(ExpectedConditions.elementToBeClickable(enterStreetDetailsTextBox));
        driver.findElement(enterStreetDetailsTextBox).sendKeys(streetAddress);
        return streetAddress;
    }

    public String getPostalCodeNotification() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(postalCodeNotificationLabel));
        return driver.findElement(postalCodeNotificationLabel).getText();
    }

    public String navigatetoCheckOrderPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkOrderLabel));
        return driver.findElement(checkOrderLabel).getText();
    }

    public String getMultiplier() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(multipleAddNumbersLabel));
        multiplierNumber = driver.findElement(multipleAddNumbersLabel).getText();
        return multiplierNumber;
    }

    public String getTotal() {
        return this.subtotal;
    }


}
