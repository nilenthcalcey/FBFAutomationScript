package com.fbf.automation.pageobjects;

import com.fbf.automation.utils.CommonOperations;
import com.gargoylesoftware.htmlunit.Page;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by lahiru.k on 10/21/2017.
 */
public class GuestCreateOwnMeal extends PageBase {
    WebDriver driver = null;
    WebDriverWait wait;
    String proteinPrice;
    String carbPrice;

    By createyourownmealBtn = By.xpath("//div[@class ='fbf-small-container']//a[@class ='order-item-box bordered-item']");
    By proteinLbl = By.xpath("//div[@class='inner']//span[contains(.,'Protein')]");
    By proteinBtn = By.xpath("//div[@class='inner']//span[contains(.,'Protein')]");
    By chickenregularpriceLabel = By.xpath("//div[@class='price-tag']//span");
    By selectchickenBtn = By.xpath("//div[contains(@class,'price-tag')]");
    By regularchickenLabel = By.xpath("//span[contains(.,'Chicken | Regular')]");
    By totalpriceLabel = By.xpath("//div[@class='details']//div[2]//span[@class='value']");
    By addthismealBtn = By.xpath("//div[@class='order-button-container item-has-selected']//button[@class='btn btn-primary btn-block']");
    By incompleteplatterLabel = By.xpath("//div[@class='modal-body']//p[contains(.,'Select a protein, carb & ten a day to create a meal. Drink is optional')]");
    By carbBtn = By.xpath("//div[@class='inner']//span[contains(.,'Carb')]");
    By cassavaregularpriceLabel = By.xpath("//div[@class='order-item-grid select-option']/a[1]//span");
    By selectcassavaBtn = By.xpath("//div[@class='price-tag']");

    public GuestCreateOwnMeal(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 30);
        this.commonOperations = new CommonOperations();
        this.driver = driver;

    }

    public void navigateToCreateNewPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(createyourownmealBtn));
        wait.until(ExpectedConditions.elementToBeClickable(createyourownmealBtn));
        driver.findElement(createyourownmealBtn).click();
    }

    public String getCreateNewPageLabel() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(proteinLbl));
        wait.until(ExpectedConditions.elementToBeClickable(proteinLbl));
        return driver.findElement(proteinLbl).getText();

    }

    public void navigateToProteinPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(proteinBtn));
        wait.until(ExpectedConditions.elementToBeClickable(proteinBtn));
        driver.findElement(proteinBtn).click();
    }

    public String getProteinPriceLabel() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(chickenregularpriceLabel));
        wait.until(ExpectedConditions.elementToBeClickable(chickenregularpriceLabel));
        proteinPrice = driver.findElement(chickenregularpriceLabel).getText();
        return proteinPrice;

    }


    public void selectProtein() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectchickenBtn));
        wait.until(ExpectedConditions.elementToBeClickable(selectchickenBtn));
        driver.findElement(selectchickenBtn).click();
    }

    public String navigateToSelectedItemPageAndCheckTotal() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(regularchickenLabel));
        wait.until(ExpectedConditions.elementToBeClickable(regularchickenLabel));
        return driver.findElement(totalpriceLabel).getText();

    }

    public void navigateToIncompletePlatterPopup() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addthismealBtn));
        wait.until(ExpectedConditions.elementToBeClickable(addthismealBtn));
        driver.findElement(addthismealBtn).click();
    }

    public String getIncompletePlatterPopupLabel() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(incompleteplatterLabel));
        return driver.findElement(incompleteplatterLabel).getText();

    }

    public void navigateToCarbPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(carbBtn));
        wait.until(ExpectedConditions.elementToBeClickable(carbBtn));
        driver.findElement(carbBtn).click();
    }

    public String getCarbPriceLabel() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cassavaregularpriceLabel));
        wait.until(ExpectedConditions.elementToBeClickable(cassavaregularpriceLabel));
        carbPrice = driver.findElement(cassavaregularpriceLabel).getText();
        return carbPrice;
    }

    public void selectRegularCarb() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectcassavaBtn));
        wait.until(ExpectedConditions.elementToBeClickable(selectcassavaBtn));
        driver.findElement(selectcassavaBtn).click();
    }


    public String CalculatePrice() {
        Double Total = Double.valueOf(proteinPrice.substring(1)) + Double.valueOf(carbPrice.substring(1));
        return Double.toString(Total);
    }


}
