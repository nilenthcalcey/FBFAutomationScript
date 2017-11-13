package com.fbf.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    By subtotalpriceLabel = By.xpath("//div[@class='order-button-container item-has-selected']/div[1]//span[2]");
    By continueguestnameradioButton = By.xpath("//div[@class='cart-guest-options']//label[3]//i[@class='radio-placeholder']");
    By continueButton = By.xpath("//div[@class='cart-guest-options']//button[@class='btn btn-primary btn-block']");
    By checkorderLabel = By.xpath("//label[contains(.,'Where would you like your meal delivered')]");
    By mealaddlusButton = By.xpath("//div[@class='ordered-items']/div[1]//div[@class='increase-items']/button[2]/i");
    By multipleaddnumbersLabel = By.xpath("//div[@class='order-item-box select-item zig-zag-top summary-item']/div[3]//span");
    By txt_PostCode = By.xpath("//div//input[@class='form-control ng-untouched ng-pristine ng-invalid'][@name='postalCode']");
    By Txt_StreetCode = By.xpath("//div//input[@class='form-control ng-untouched ng-pristine ng-invalid'][@name='streetDetails']");

    public YourOrder(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 30);
        this.driver = driver;
    }

    public String getSubtotal(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(subtotalpriceLabel));
        subtotal = driver.findElement(subtotalpriceLabel).getText();
        return subtotal;
    }

    public void addtheMealsCount(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(mealaddlusButton));
        wait.until(ExpectedConditions.elementToBeClickable(mealaddlusButton));
        driver.findElement(mealaddlusButton).click();

    }

    public void checkGuestNameSelector(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(continueguestnameradioButton));
        boolean bvalue = false;

        bvalue = driver.findElement(continueguestnameradioButton).isSelected();
        if(bvalue = true){

            // This will select Second radio button, if the first radio button is selected by default
            driver.findElement(continueButton).click();

        }else {

            // If the first radio button is not selected by default, the first will be selected
            System.out.println("Selecting Wrong Radio button");
        }

    }

    public String navigatetoCheckOrderPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkorderLabel));
        return driver.findElement(checkorderLabel).getText();
    }

    public String getMultiplier(){

        wait.until(ExpectedConditions.visibilityOfElementLocated(multipleaddnumbersLabel));
        multiplierNumber = driver.findElement(multipleaddnumbersLabel).getText();
        return  multiplierNumber;
    }

}
