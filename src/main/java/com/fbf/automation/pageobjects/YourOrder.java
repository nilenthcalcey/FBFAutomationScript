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

    By subtotalpriceLabel = By.xpath("//div[@class='order-button-container item-has-selected']/div[1]//span[2]");
    By continueguestnameradioButton = By.xpath("//div[@class='cart-guest-options']//label[3]//i[@class='radio-placeholder']");
    By continueButton = By.xpath("//button[@class='btn btn-primary btn-block']");
    By checkorderLabel = By.xpath("//label[contains(.,' Please let us know your name, email to send you an eco-friendly receipt, and mobile number, to let you know your order status')]");
    By mealaddlusButton = By.xpath("//div[@class='ordered-items']/div[1]//div[@class='increase-items']/button[2]/i");
    By multipleaddnumbersLabel = By.xpath("//div[@class='order-item-box select-item zig-zag-top summary-item']/div[3]//span");
    By enterpostalcodeinputTextBox = By.xpath("//input[@name='postalCode']");
    By entersreetdetailsTextBox = By.xpath("//input[contains(@name,'streetDetails')]");
    By postalcodenotificationLabel = By.xpath("//div[@class='form-group']/div/span");
    By braintreeLabel = By.xpath("//div[@class='braintree-sheet__text']");

    public YourOrder(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 30);
        this.driver = driver;
        checkoutOrder = new CheckoutOrder(driver);

    }

    public String getSubtotal() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(subtotalpriceLabel));
        subtotal = driver.findElement(subtotalpriceLabel).getText();
        return subtotal;
    }

    public void addtheMealsCount() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(mealaddlusButton));
        wait.until(ExpectedConditions.elementToBeClickable(mealaddlusButton));
        driver.findElement(mealaddlusButton).click();

    }

    public String checkGuestNameSelector(Boolean getOrderNowType) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(continueguestnameradioButton));
        boolean bgvalue;

        bgvalue = driver.findElement(continueguestnameradioButton).isSelected();
        if (bgvalue = true) {

            // This will select Second radio button, if the first radio button is selected by default
            driver.findElement(continueButton).click();
            //wait.until(ExpectedConditions.visibilityOfElementLocated(checkorderLabel));
            if (getOrderNowType == true) {
                wait.until(ExpectedConditions.visibilityOfElementLocated(checkorderLabel));
                checkoutOrder.addGuestDetails();

            } else {

                checkoutOrder.selectDefaultSelectedDate();
                ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
                checkoutOrder.addGuestDetails();

            }
        } else {

            // If the first radio button is not selected by default, the first will be selected
            System.out.println("Selecting Wrong Radio button");
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(braintreeLabel));
        return driver.findElement(braintreeLabel).getText();

    }

    public void submitYourOrder() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(continueButton));
        wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        driver.findElement(continueButton).click();
    }

    public String TypePostalCard() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(enterpostalcodeinputTextBox));
        wait.until(ExpectedConditions.elementToBeClickable(enterpostalcodeinputTextBox));
        driver.findElement(enterpostalcodeinputTextBox).sendKeys(postalCode);
        return postalCode;

    }

    public String TypeStreetAddress() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(entersreetdetailsTextBox));
        wait.until(ExpectedConditions.elementToBeClickable(entersreetdetailsTextBox));
        driver.findElement(entersreetdetailsTextBox).sendKeys(streetAddress);
        return streetAddress;
    }

    public String getPostalCodeNotification() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(postalcodenotificationLabel));
        return driver.findElement(postalcodenotificationLabel).getText();
    }

    public String navigatetoCheckOrderPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkorderLabel));
        return driver.findElement(checkorderLabel).getText();
    }

    public String getMultiplier() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(multipleaddnumbersLabel));
        multiplierNumber = driver.findElement(multipleaddnumbersLabel).getText();
        return multiplierNumber;
    }


    public String getTotal() {
        return this.subtotal;
    }


}
