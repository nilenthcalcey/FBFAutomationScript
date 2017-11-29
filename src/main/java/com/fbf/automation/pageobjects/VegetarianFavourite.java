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
    String drinkprice;
    String drinkcaloriecount;
    Integer proteinCalLength;
    Integer carbCalLength;
    Integer tenADayCalLength;


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

    By proteinCaloriesLbl = By.xpath("//div[@class='fbf-small-container']//a[1]//span[@class='calories']");
    By carbCaloriesLbl = By.xpath("//div[@class='fbf-small-container']//a[2]//span[@class='calories']");
    By tenADayCaloriesLbl = By.xpath("//div[@class='fbf-small-container']//a[3]//span[@class='calories']");

    By proteinPriceLbl = By.xpath("//div[@class='fbf-small-container']/div/a[1]/div/span[@class='price']");
    By carbPriceLbl = By.xpath("//div[@class='fbf-small-container']/div/a[2]/div/span[@class='price']");
    By tenADayPriceLbl = By.xpath("//div[@class='fbf-small-container']/div/a[3]/div/span[@class='price']");

    By caloriesLbl = By.xpath("//div[@class='fbf-small-container']//div[1]/span[@class='value']");
    By priceLbl = By.xpath("//div[@class='fbf-small-container']//div[2]/span[@class='value']");

    By drinkBtn = By.xpath("//div[@class='fbf-small-container']//a[@class='order-item-box bordered-item']");
    By selectDrinkAvo = By.xpath("//div[@class='fbf-tabs-container']/div/div/div/div/div/a[1]");
    By selectDrinkAvoFinal = By.xpath("//div[@class='fbf-small-container']/div/a[4]");

    By vegProteinName = By.xpath("(//div[@class='item-info']/h3)[4]");
    By vegProteinPrice = By.xpath("(//div[@class='price-tag']//span)[4]");
    By vegProteinCal = By.xpath("(//li[@class='calories'])[4]");

    By vegFavBackBtn = By.xpath("//div[@class='fbf-main-navogation']/div[1]/ul/li/a");

    By vegCarbName = By.xpath("//div[@id='#dv']/div[1]//a[1]/div[@class='item-info']/h3");
    By vegCarbPrice = By.xpath("html/body/app-root/div/app-select-product/div/div[2]/div/div/div/div[1]/div/div[1]/div/a[1]/div[1]/div/span");
    By vegCarbCal = By.xpath("html/body/app-root/div/app-select-product/div/div[2]/div/div/div/div[1]/div/div[1]/div/a[1]/div[3]/ul/li[1]");
    By BtnBean = By.xpath("//div[@class='price-tag']//span");


    By vegTenADayName = By.xpath("//div[@class='fbf-tabs clearfix']/div[1]/div/div[2]/div/a[2]/div/h3");
    By vegTenADayPrice = By.xpath("//div[@class='fbf-tabs clearfix']/div[1]/div/div[2]/div/a[2]/div/div/span");
    By vegTenADayCal = By.xpath("//div[@class='fbf-tabs clearfix']/div[1]/div/div[2]/div/a[2]/div/ul/li[@class='calories']");


    public VegetarianFavourite(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 30);
        this.commonOperations = new CommonOperations();

        this.driver = driver;
        createNewOrder = new CreateNewOrder(driver);
        //driver.get("http://fbf.qa/orders");
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


    public String getProteinItemLbl() {
        return driver.findElement(proteinItemLbl).getText();
    }

    public String getProteinCaloriesCount() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(proteinCaloriesLbl));
        wait.until(ExpectedConditions.elementToBeClickable(proteinCaloriesLbl));
        proteincaloriescount = driver.findElement(proteinCaloriesLbl).getText();
        proteinCalLength = Integer.valueOf(driver.findElement(proteinCaloriesLbl).getText().length());
        //System.out.println("#####################################"+proteinCalLength);
        if (proteinCalLength == 5) {
            proteinCal = Integer.valueOf(driver.findElement(proteinCaloriesLbl).getText().substring(0, 1));
        } else if (proteinCalLength == 6) {
            proteinCal = Integer.valueOf(driver.findElement(proteinCaloriesLbl).getText().substring(0, 2));
        } else {
            proteinCal = Integer.valueOf(driver.findElement(proteinCaloriesLbl).getText().substring(0, 3));
        }
        return proteincaloriescount;
    }

    public String getProteinPrice() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(proteinPriceLbl));
        wait.until(ExpectedConditions.elementToBeClickable(proteinPriceLbl));
        proteinPrice = driver.findElement(proteinPriceLbl).getText();
        protein = Double.valueOf(driver.findElement(proteinPriceLbl).getText().substring(1));
        return proteinPrice;
    }

    public void scrollToBottomofThePage() throws InterruptedException {
        Thread.sleep(1000);
        jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0, 125)");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public String getVegProteinNameX() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(proteinItemLbl));
        wait.until(ExpectedConditions.elementToBeClickable(proteinItemLbl));
        return driver.findElement(proteinItemLbl).getText().substring(0, 21);
    }

    public String getVegProteinPriceX() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(proteinPriceLbl));
        wait.until(ExpectedConditions.elementToBeClickable(proteinPriceLbl));
        return driver.findElement(proteinPriceLbl).getText();
    }

    public String getVegProteinCalX() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(proteinCaloriesLbl));
        wait.until(ExpectedConditions.elementToBeClickable(proteinCaloriesLbl));
        return driver.findElement(proteinCaloriesLbl).getText().substring(0, 3);
    }

    public void navigateToProteinSelection() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(proteinBtn));
        wait.until(ExpectedConditions.elementToBeClickable(proteinBtn));
        driver.findElement(proteinBtn).click();

    }

    public String getVegProteinName() throws InterruptedException {
     //    Thread.sleep(10000);
        //  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
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
        return driver.findElement(tenADayPriceLbl).getText();
    }

    public String getVegTenADayCalX() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(tenADayCaloriesLbl));
        wait.until(ExpectedConditions.elementToBeClickable(tenADayCaloriesLbl));
        return driver.findElement(tenADayCaloriesLbl).getText().substring(0, 2);
    }

    public void navigateToTenADaySelection() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(tenADayBtn));
        wait.until(ExpectedConditions.elementToBeClickable(tenADayBtn));
        driver.findElement(tenADayBtn).click();
    }

    public String getVegTenADayName() throws InterruptedException {
        Thread.sleep(5000);
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
        return driver.findElement(carbPriceLbl).getText();
    }

    public String getVegCarbCalX() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(carbCaloriesLbl));
        wait.until(ExpectedConditions.elementToBeClickable(carbCaloriesLbl));
        return driver.findElement(carbCaloriesLbl).getText().substring(0, 3);
    }

    public void navigateToCarbSelection() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(carbBtn));
        wait.until(ExpectedConditions.elementToBeClickable(carbBtn));
        driver.findElement(carbBtn).click();
    }

    public String getVegCarbName() throws InterruptedException {
        Thread.sleep(5000);
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


    public String getCarbItemLbl() {
        return driver.findElement(carbItemLbl).getText();
    }

    public String getCarbCaloriesCount() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(carbCaloriesLbl));
        wait.until(ExpectedConditions.elementToBeClickable(carbCaloriesLbl));
        carbcaloriesCount = driver.findElement(carbCaloriesLbl).getText();
        carbCalLength = Integer.valueOf(driver.findElement(carbCaloriesLbl).getText().length());
        //System.out.println("#####################################"+carbCalLength);
        if (carbCalLength == 5) {
            carbCal = Integer.valueOf(driver.findElement(carbCaloriesLbl).getText().substring(0, 1));
        } else if (carbCalLength == 6) {
            carbCal = Integer.valueOf(driver.findElement(carbCaloriesLbl).getText().substring(0, 2));
        } else {
            carbCal = Integer.valueOf(driver.findElement(carbCaloriesLbl).getText().substring(0, 3));
        }
        return carbcaloriesCount;
    }

    public String getCarbPrice() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(carbPriceLbl));
        wait.until(ExpectedConditions.elementToBeClickable(carbPriceLbl));
        carbPrice = driver.findElement(carbPriceLbl).getText();
        carb = Double.valueOf(driver.findElement(carbPriceLbl).getText().substring(1));
        return carbPrice;
    }

    public String getTenADayItemLbl() {
        return driver.findElement(tenADayItemLbl).getText();
    }

    public String getTenADayCaloriesCount() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(tenADayCaloriesLbl));
        wait.until(ExpectedConditions.elementToBeClickable(tenADayCaloriesLbl));
        tenadaycaloriesCount = driver.findElement(tenADayCaloriesLbl).getText();
        tenADayCalLength = Integer.valueOf(driver.findElement(tenADayCaloriesLbl).getText().length());
        //System.out.println("#####################################"+tenADayCalLength);
        if (tenADayCalLength == 5) {
            tenADayCal = Integer.valueOf(driver.findElement(tenADayCaloriesLbl).getText().substring(0, 1));
        } else if (tenADayCalLength == 6) {
            tenADayCal = Integer.valueOf(driver.findElement(tenADayCaloriesLbl).getText().substring(0, 2));
        } else {
            tenADayCal = Integer.valueOf(driver.findElement(tenADayCaloriesLbl).getText().substring(0, 3));
        }
        return tenadaycaloriesCount;
    }

    public String getTenADayPrice() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(tenADayPriceLbl));
        wait.until(ExpectedConditions.elementToBeClickable(tenADayPriceLbl));
        tenadayPrice = driver.findElement(tenADayPriceLbl).getText();
        tenADay = Double.valueOf(driver.findElement(tenADayPriceLbl).getText().substring(1));
        return tenadayPrice;

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
        Double Total = carb + protein + tenADay;
        String finalanswer = String.format("%.2f", Total);
        return String.valueOf(finalanswer);
    }

    public String calculateCalories() {
        int Total = carbCal + proteinCal + tenADayCal;
        return Integer.toString(Total);
    }

    public String getDrinkSelection() {
        String atr = driver.findElement(tenADayBtn).getAttribute("class");
        if (atr == "order-item-box bordered-item") {
            wait.until(ExpectedConditions.visibilityOfElementLocated(drinkBtn));
            wait.until(ExpectedConditions.elementToBeClickable(drinkBtn));
            driver.findElement(drinkBtn).click();
        } else {
            //**********************Calculation************************
        }
        return atr;
    }

    public void getSelectDrinkAvo() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectDrinkAvo));
        wait.until(ExpectedConditions.elementToBeClickable(selectDrinkAvo));
        driver.findElement(selectDrinkAvo).click();
    }

    public String getDrinkSelectionFinal() {
        String atr = driver.findElement(selectDrinkAvoFinal).getAttribute("class");
        return atr;
    }


}
