package com.fbf.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

/**
 * Created by lahiru.k on 10/26/2017.
 */
public class AddGuestName extends PageBase {
    WebDriver driver = null;
    WebDriverWait wait;
    String guestName = "AUTOMATION" + System.currentTimeMillis();
    //String calprice = "£" + guestCreateOwnMeal.CalculatePrice();


    By guestNameInputField = By.xpath("//input[@class='form-control ng-untouched ng-pristine ng-valid']");
    By saveNameButton = By.xpath("//button[@class='btn btn-primary btn-block']");
    By yourHeaderLabel = By.xpath("//div[@class='container']");
    By guestNameLabel = By.xpath("//div[@class='item-info']//h3[1]");


    public AddGuestName(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 30);
        this.driver = driver;

    }

    public String TypeGuestName() {
        Random rand = new Random(System.currentTimeMillis());
        wait.until(ExpectedConditions.visibilityOfElementLocated(guestNameInputField));
        wait.until(ExpectedConditions.elementToBeClickable(guestNameInputField));
        driver.findElement(guestNameInputField).clear();
        driver.findElement(guestNameInputField).sendKeys(guestName);
        return guestName;
    }

    public void ClickSaveNameButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(saveNameButton));
        wait.until(ExpectedConditions.elementToBeClickable(saveNameButton));
        driver.findElement(saveNameButton).click();
    }

    public String navigateToYourOrderPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(guestNameLabel));
        wait.until(ExpectedConditions.elementToBeClickable(guestNameLabel));
        return driver.findElement(guestNameLabel).getText();

    }

    //get guest user name
    public String getGuestName() {
        return this.guestName;
    }


}
