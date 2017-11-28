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

    By subtotalLabel = By.xpath("//tr[1]//td[@class='font-bold align-right']");
    By emailAddressTextBox = By.xpath("//input[@name='email']");
    By passwordTextBox = By.xpath("//input[@formcontrolname='password']");
    By confirmPasswordTextBox = By.xpath("//input[@formcontrolname='confirmPassword']");
    By continueButton = By.xpath("//form[@class='ng-untouched ng-pristine ng-invalid']//div[5]");
    By successfulPageLabel = By.xpath("//div[@class='align-center padding-15']");
    By lbl_username = By.xpath("//table[@class='summary-table']/tbody/tr[1]/td[@class='font-bold']");

    String userPassword = getProperties().getProperty("userPassword");


    public OrderSummery(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.commonOperations = new CommonOperations();
        this.wait = new WebDriverWait(driver, 30);

    }

    public String getOrderSummeryTotal() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(subtotalLabel));
        return driver.findElement(subtotalLabel).getText();
    }

    public String getEmailAddress() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");

        wait.until(ExpectedConditions.visibilityOfElementLocated(emailAddressTextBox));
        return driver.findElement(emailAddressTextBox).getAttribute("value");
    }

    public String addPasswordDetailsContinue() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordTextBox));
        wait.until(ExpectedConditions.elementToBeClickable(passwordTextBox));
        driver.findElement(passwordTextBox).clear();
        driver.findElement(passwordTextBox).sendKeys(userPassword);
        driver.findElement(confirmPasswordTextBox).clear();
        driver.findElement(confirmPasswordTextBox).sendKeys(getProperties().getProperty("userConfirmPassword"));
        driver.findElement(confirmPasswordTextBox).sendKeys(Keys.ENTER);
        return userPassword;

    }


    public String getUserName() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lbl_username));
        wait.until(ExpectedConditions.elementToBeClickable(lbl_username));
        return getDriver().findElement(lbl_username).getText();
    }

    public String navigateToConfirmationPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(successfulPageLabel));
        return driver.findElement(successfulPageLabel).getText();
    }

    public void loginGuestUser (){
        getEmailAddress();

    }

    public String getUserPassword(){
        return this.userPassword;
    }

}
