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


    By guestnameinputfield = By.xpath("//input[@class='form-control ng-untouched ng-pristine ng-valid']");
    By savenamebutton = By.xpath("//button[@class='btn btn-primary btn-block']");
    By yourheaderLabel = By.xpath("//div[@class='container']");
    By guestameLabel = By.xpath("//div[@class='item-info']//h3[1]");


    public AddGuestName(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 30);
        this.driver = driver;

    }

    public String TypeGuestName(){
        Random rand = new Random(System.currentTimeMillis());
        wait.until(ExpectedConditions.visibilityOfElementLocated(guestnameinputfield));
        wait.until(ExpectedConditions.elementToBeClickable(guestnameinputfield));
        driver.findElement(guestnameinputfield).clear();
        driver.findElement(guestnameinputfield).sendKeys(guestName);
        return guestName;
    }

    public void ClickSaveNameButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(savenamebutton));
        wait.until(ExpectedConditions.elementToBeClickable(savenamebutton));
        driver.findElement(savenamebutton).click();
    }

    public String navigateToYourOrderPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(guestameLabel));
        wait.until(ExpectedConditions.elementToBeClickable(guestameLabel));
        return driver.findElement(guestameLabel).getText();

    }
//get guest user name
    public String getGuestName() {
        return this.guestName;
    }


}
