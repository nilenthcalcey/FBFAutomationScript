package com.fbf.automation.pageobjects;

import com.fbf.automation.utils.CommonOperations;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

/**
 * Created by gishan.n on 11/14/2017.
 */

public class VegetarianFavourite extends PageBase {

    WebDriver driver = null;
    WebDriverWait wait;
    JavascriptExecutor jse;
    Double protein = 0.0;
    Double carb = 0.0;
    Double tenADay = 0.0;
    Double drink = 0.0;
    int proteinCal = 0;
    int carbCal = 0;
    int tenADayCal = 0;
    int drinkCal = 0;
    String proteinPrice;
    String carbPrice;
    String proteincaloriescount;
    String carbcaloriesCount;
    String tenadayPrice;
    String tenadaycaloriesCount;
    String drinkPrice;
    String drinkcalorieCount;
    Integer proteinCalLength;
    Integer carbCalLength;
    Integer tenADayCalLength;
    Integer drinkCalLength;

    CommonOperations commonOperations;
    CreateNewOrder createNewOrder;

    By vegFavBtn = By.xpath("//div[@class='fbf-small-container']/div/a[2]");
    By vegFavLabel = By.xpath("//a[@class='order-item-box bordered-item full-width selected-item']//span[@class='item-name']");
    By proteinBtn = By.xpath("//div[@class='fbf-small-container']/div/a[1]");
    By carbBtn = By.xpath("//div[@class='fbf-small-container']/div/a[2]");
    By tenADayBtn = By.xpath("//div[@class='fbf-small-container']/div/a[3]");

    By proteinItemLbl = By.xpath("//div[@class='fbf-small-container']//a[1]/div[@class='inner']/span[2]");
    By carbItemLbl = By.xpath("//div[@class='fbf-small-container']//a[2]/div[@class='inner']/span[2]");
    By tenADayItemLbl = By.xpath("//div[@class='fbf-small-container']//a[3]/div[@class='inner']/span[2]");
    By drinkItemLbl = By.xpath("//div[@class='fbf-small-container']//a[4]/div[@class='inner']/span[2]");

    By proteinCaloriesLbl = By.xpath("//div[@class='fbf-small-container']//a[1]//span[@class='calories']");
    By carbCaloriesLbl = By.xpath("//div[@class='fbf-small-container']//a[2]//span[@class='calories']");
    By tenADayCaloriesLbl = By.xpath("//div[@class='fbf-small-container']//a[3]//span[@class='calories']");
    By drinkCaloriesLbl = By.xpath("//div[@class='fbf-small-container']//a[4]//span[@class='calories']");

    By proteinPriceLbl = By.xpath("//div[@class='fbf-small-container']/div/a[1]/div/span[@class='price']");
    By carbPriceLbl = By.xpath("//div[@class='fbf-small-container']/div/a[2]/div/span[@class='price']");
    By tenADayPriceLbl = By.xpath("//div[@class='fbf-small-container']/div/a[3]/div/span[@class='price']");
    By drinkPriceLbl = By.xpath("//div[@class='fbf-small-container']/div/a[4]/div/span[@class='price']");

    By caloriesLbl = By.xpath("//div[@class='fbf-small-container']//div[1]/span[@class='value']");
    By priceLbl = By.xpath("//div[@class='fbf-small-container']//div[2]/span[@class='value']");

    By drinkBtn = By.xpath("//div[@class='fbf-small-container']//a[4]");
    By selectDrinkAvo = By.xpath("//div[@class='fbf-tabs-container']/div/div/div/div/div/a[1]");

    By vegProteinName = By.xpath("(//div[@class='item-info']/h3)[4]");
    By vegProteinPrice = By.xpath("(//div[@class='price-tag']//span)[4]");
    By vegProteinCal = By.xpath("(//li[@class='calories'])[4]");

    By vegFavBackBtn = By.xpath("//div[@class='fbf-main-navogation']/div[1]/ul/li/a");

    By vegCarbName = By.xpath("(//div[@class='item-info']/h3)[1]");
    By vegCarbPrice = By.xpath("(//div[@class='price-tag']//span)[1]");
    By vegCarbCal = By.xpath("(//li[@class='calories'])[1]");
    By BtnBean = By.xpath("//div[@class='price-tag']//span");

    By vegTenADayName = By.xpath("(//div[@class='item-info']/h3)[2]");
    By vegTenADayPrice = By.xpath("(//div[@class='price-tag']//span)[2]");
    By vegTenADayCal = By.xpath("(//li[@class='calories'])[2]");

    By vegDrinkName = By.xpath("(//div[@class='item-info']/h3)[1]");
    By vegDrinkPrice = By.xpath("(//div[@class='price-tag']//span)[1]");
    By vegDrinkCal = By.xpath("(//li[@class='calories'])[1]");


    public VegetarianFavourite(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 30);
        this.commonOperations = new CommonOperations();

        this.driver = driver;
        createNewOrder = new CreateNewOrder(driver);
    }

    public void navigateToVegFav() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(vegFavBtn));
        wait.until(ExpectedConditions.elementToBeClickable(vegFavBtn));
        driver.findElement(vegFavBtn).click();
    }

    public String getVegFavLabel() {
        return driver.findElement(vegFavLabel).getText();
    }

    public String getProteinSelection() {
        String atr = driver.findElement(proteinBtn).getAttribute("class");
        return atr;
    }

    public String getCarbSelection() {
        String atr = driver.findElement(carbBtn).getAttribute("class");
        return atr;
    }

    public String getTenADaySelection() {
        String atr = driver.findElement(tenADayBtn).getAttribute("class");
        return atr;
    }

    public void scrollToBottomofThePage() throws InterruptedException {
        Thread.sleep(1000);
        jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0, 125)");
    }

    public String getVegProteinNameX() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(proteinItemLbl));
        wait.until(ExpectedConditions.elementToBeClickable(proteinItemLbl));
        return driver.findElement(proteinItemLbl).getText().substring(0, 21);
    }

    public String getVegProteinPriceX() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(proteinPriceLbl));
        wait.until(ExpectedConditions.elementToBeClickable(proteinPriceLbl));
        proteinPrice = driver.findElement(proteinPriceLbl).getText();
        protein = Double.valueOf(driver.findElement(proteinPriceLbl).getText().substring(1));
        return proteinPrice;
    }

    public String getVegProteinCalX() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(proteinCaloriesLbl));
        wait.until(ExpectedConditions.elementToBeClickable(proteinCaloriesLbl));
        proteincaloriescount = driver.findElement(proteinCaloriesLbl).getText();
        proteinCalLength = Integer.valueOf(driver.findElement(proteinCaloriesLbl).getText().length());
        if (proteinCalLength == 5) {
            proteinCal = Integer.valueOf(driver.findElement(proteinCaloriesLbl).getText().substring(0, 1));
        } else if (proteinCalLength == 6) {
            proteinCal = Integer.valueOf(driver.findElement(proteinCaloriesLbl).getText().substring(0, 2));
        } else {
            proteinCal = Integer.valueOf(driver.findElement(proteinCaloriesLbl).getText().substring(0, 3));
        }
        return proteincaloriescount;
    }

    public void navigateToProteinSelection() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(proteinBtn));
        wait.until(ExpectedConditions.elementToBeClickable(proteinBtn));
        driver.findElement(proteinBtn).click();

    }

    public String getVegProteinName() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(BtnBean));
        wait.until(ExpectedConditions.elementToBeClickable(BtnBean));
        String vegname = driver.findElement(vegProteinName).getText();
        return vegname;
    }

    public String getVegProteinCal() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(BtnBean));
        wait.until(ExpectedConditions.elementToBeClickable(BtnBean));
        return driver.findElement(vegProteinCal).getText().substring(9, 12);
    }

    public String getVegProteinPrice() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(BtnBean));
        wait.until(ExpectedConditions.elementToBeClickable(BtnBean));
        return driver.findElement(vegProteinPrice).getText();
    }

    public void navigateBackToVegFav() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(vegFavBackBtn));
        wait.until(ExpectedConditions.elementToBeClickable(vegFavBackBtn));
        driver.findElement(vegFavBackBtn).click();
    }

    public String getVegTenADayNameX() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(tenADayItemLbl));
        wait.until(ExpectedConditions.elementToBeClickable(tenADayItemLbl));
        return driver.findElement(tenADayItemLbl).getText().substring(0, 27);
    }

    public String getVegTenADayPriceX() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(tenADayPriceLbl));
        wait.until(ExpectedConditions.elementToBeClickable(tenADayPriceLbl));
        tenadayPrice = driver.findElement(tenADayPriceLbl).getText();
        tenADay = Double.valueOf(driver.findElement(tenADayPriceLbl).getText().substring(1));
        return tenadayPrice;
    }

    public String getVegTenADayCalX() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(tenADayCaloriesLbl));
        wait.until(ExpectedConditions.elementToBeClickable(tenADayCaloriesLbl));
        tenadaycaloriesCount = driver.findElement(tenADayCaloriesLbl).getText();
        tenADayCalLength = Integer.valueOf(driver.findElement(tenADayCaloriesLbl).getText().length());
        if (tenADayCalLength == 5) {
            tenADayCal = Integer.valueOf(driver.findElement(tenADayCaloriesLbl).getText().substring(0, 1));
        } else if (tenADayCalLength == 6) {
            tenADayCal = Integer.valueOf(driver.findElement(tenADayCaloriesLbl).getText().substring(0, 2));
        } else {
            tenADayCal = Integer.valueOf(driver.findElement(tenADayCaloriesLbl).getText().substring(0, 3));
        }
        return tenadaycaloriesCount;
    }

    public void navigateToTenADaySelection() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(tenADayBtn));
        wait.until(ExpectedConditions.elementToBeClickable(tenADayBtn));
        driver.findElement(tenADayBtn).click();
    }

    public String getVegTenADayName() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(vegTenADayName));
        wait.until(ExpectedConditions.elementToBeClickable(vegTenADayName));
        return driver.findElement(vegTenADayName).getText();
    }

    public String getVegTenADayCal() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(vegTenADayCal));
        wait.until(ExpectedConditions.elementToBeClickable(vegTenADayCal));
        return driver.findElement(vegTenADayCal).getText().substring(9, 11);
    }

    public String getVegTenADayPrice() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(vegTenADayPrice));
        wait.until(ExpectedConditions.elementToBeClickable(vegTenADayPrice));
        return driver.findElement(vegTenADayPrice).getText();
    }

    public String getVegCarbNameX() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(carbItemLbl));
        wait.until(ExpectedConditions.elementToBeClickable(carbItemLbl));
        return driver.findElement(carbItemLbl).getText().substring(0, 7);
    }

    public String getVegCarbPriceX() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(carbPriceLbl));
        wait.until(ExpectedConditions.elementToBeClickable(carbPriceLbl));
        carbPrice = driver.findElement(carbPriceLbl).getText();
        carb = Double.valueOf(driver.findElement(carbPriceLbl).getText().substring(1));
        return carbPrice;
    }

    public String getVegCarbCalX() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(carbCaloriesLbl));
        wait.until(ExpectedConditions.elementToBeClickable(carbCaloriesLbl));
        carbcaloriesCount = driver.findElement(carbCaloriesLbl).getText();
        carbCalLength = Integer.valueOf(driver.findElement(carbCaloriesLbl).getText().length());
        if (carbCalLength == 5) {
            carbCal = Integer.valueOf(driver.findElement(carbCaloriesLbl).getText().substring(0, 1));
        } else if (carbCalLength == 6) {
            carbCal = Integer.valueOf(driver.findElement(carbCaloriesLbl).getText().substring(0, 2));
        } else {
            carbCal = Integer.valueOf(driver.findElement(carbCaloriesLbl).getText().substring(0, 3));
        }
        return carbcaloriesCount;
    }

    public void navigateToCarbSelection() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(carbBtn));
        wait.until(ExpectedConditions.elementToBeClickable(carbBtn));
        driver.findElement(carbBtn).click();
    }

    public String getVegCarbName() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(vegCarbName));
        wait.until(ExpectedConditions.elementToBeClickable(vegCarbName));
        return driver.findElement(vegCarbName).getText();
    }

    public String getVegCarbCal() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(vegCarbCal));
        wait.until(ExpectedConditions.elementToBeClickable(vegCarbCal));
        return driver.findElement(vegCarbCal).getText().substring(9, 12);
    }

    public String getVegCarbPrice() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(vegCarbPrice));
        wait.until(ExpectedConditions.elementToBeClickable(vegCarbPrice));
        return driver.findElement(vegCarbPrice).getText();
    }

    public String getCaloriesLbl() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(caloriesLbl));
        wait.until(ExpectedConditions.elementToBeClickable(caloriesLbl));
        return driver.findElement(caloriesLbl).getText();
    }

    public String getPriceLbl() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(priceLbl));
        wait.until(ExpectedConditions.elementToBeClickable(priceLbl));
        return driver.findElement(priceLbl).getText();
    }

    public String calculatePrice() {
        Double total = carb + protein + tenADay;
        String finalanswer = String.format("%.2f", total);
        return String.valueOf(finalanswer);
    }

    public String calculateCalories() {
        int total = carbCal + proteinCal + tenADayCal;
        return Integer.toString(total);
    }

    public String getDrinkSelection() {
        String atr = driver.findElement(drinkBtn).getAttribute("class");
        return atr;
    }

    public void navigateToDrinkSelection() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(drinkBtn));
        wait.until(ExpectedConditions.elementToBeClickable(drinkBtn));
        driver.findElement(drinkBtn).click();
    }

    public void getSelectDrinkAvo() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectDrinkAvo));
        wait.until(ExpectedConditions.elementToBeClickable(selectDrinkAvo));
        driver.findElement(selectDrinkAvo).click();
    }

    public String getVegDrinkNameX() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(drinkItemLbl));
        wait.until(ExpectedConditions.elementToBeClickable(drinkItemLbl));
        return driver.findElement(drinkItemLbl).getText().substring(0, 17);
    }

    public String getVegDrinkPriceX() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(drinkPriceLbl));
        wait.until(ExpectedConditions.elementToBeClickable(drinkPriceLbl));
        drinkPrice = driver.findElement(drinkPriceLbl).getText();
        drink = Double.valueOf(driver.findElement(drinkPriceLbl).getText().substring(1));
        return drinkPrice;
    }

    public String getVegDrinkCalX() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(drinkCaloriesLbl));
        wait.until(ExpectedConditions.elementToBeClickable(drinkCaloriesLbl));
        drinkcalorieCount = driver.findElement(drinkCaloriesLbl).getText();
        drinkCalLength = Integer.valueOf(driver.findElement(drinkCaloriesLbl).getText().length());
        if (drinkCalLength == 5) {
            drinkCal = Integer.valueOf(driver.findElement(drinkCaloriesLbl).getText().substring(0, 1));
        } else if (drinkCalLength == 6) {
            drinkCal = Integer.valueOf(driver.findElement(drinkCaloriesLbl).getText().substring(0, 2));
        } else {
            drinkCal = Integer.valueOf(driver.findElement(drinkCaloriesLbl).getText().substring(0, 3));
        }
        return drinkcalorieCount;
    }

    public String getVegDrinkName()  {
        wait.until(ExpectedConditions.visibilityOfElementLocated(vegDrinkName));
        wait.until(ExpectedConditions.elementToBeClickable(vegDrinkName));
        return driver.findElement(vegDrinkName).getText();
    }

    public String getVegDrinkCal() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(vegDrinkCal));
        wait.until(ExpectedConditions.elementToBeClickable(vegDrinkCal));
        return driver.findElement(vegDrinkCal).getText().substring(9, 12);
    }

    public String getVegDrinkPrice() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(vegDrinkPrice));
        wait.until(ExpectedConditions.elementToBeClickable(vegDrinkPrice));
        return driver.findElement(vegDrinkPrice).getText();
    }

    public String newCalculatePrice() {
        Double newTotal = carb + protein + tenADay + drink;
        String newFinalAnswer = String.format("%.2f", newTotal);
        return String.valueOf(newFinalAnswer);
    }

    public String newCalculateCalories() {
        int newTotal = carbCal + proteinCal + tenADayCal + drinkCal;
        return Integer.toString(newTotal);
    }

}