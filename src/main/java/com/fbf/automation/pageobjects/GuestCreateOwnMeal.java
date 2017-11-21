package com.fbf.automation.pageobjects;

import com.fbf.automation.utils.CommonOperations;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by lahiru.k on 10/21/2017.
 */
public class GuestCreateOwnMeal extends PageBase {
    WebDriver driver = null;
    WebDriverWait wait;
    Double protein = 0.0;
    Double carb = 0.0;
    Double tenADay = 0.0;
    Double drink = 0.0;
    int proteinCal = 0;
    int CarbCal = 0;
    int TenADayCal = 0;
    int DrinkCal = 0;
    String proteinPrice;
    String carbPrice;
    String proteincaloriescount;
    String carbcaloriesCount;
    String tenadayPrice;
    String tenadaycaloriesCount;
    String drinkprice;
    String drinkcaloriecount;
    Boolean bvalue;


    By createyourownmealBtn = By.xpath("//div[@class ='fbf-small-container']//a[@class ='order-item-box bordered-item']");
    By proteinLbl = By.xpath("//div[@class='inner']//span[contains(.,'Protein')]");
    By proteinBtn = By.xpath("//div[@class='inner']//span[contains(.,'Protein')]");
    By chickenregularpriceLabel = By.xpath("//div[@class='price-tag']//span");
    By selectchickenBtn = By.xpath("//div[contains(@class,'price-tag')]");
    By regularchickenLabel = By.xpath("//span[contains(.,'Chicken | Regular')]");
    By totalpriceLabel = By.xpath("//div[@class='details']//div[2]//span[@class='value']");
    By addthismealBtn = By.xpath("//div[@class='fbf-small-container']//div[2]//button[@class='btn btn-primary btn-block']");
    By incompleteplatterLabel = By.xpath("//div[@class='modal-body']//p[contains(.,'Select a protein, carb & ten a day to create a meal. Drink is optional')]");
    By carbBtn = By.xpath("//div[@class='inner']//span[contains(.,'Carb')]");
    By cassavaregularpriceLabel = By.xpath("//div[@class='order-item-grid select-option']/a[1]//span");
    By selectcassavaBtn = By.xpath("//div[@class='price-tag']");
    By proteincalories = By.xpath("//div[@class='order-item-grid select-option']//a[1]//li[@class='calories']");
    By caloriescountLabel = By.xpath("//div[@class='details']/div[1]/span[@class='value']");
    By carbcaloriesLabel = By.xpath("//div[@class='order-item-grid select-option']//a[1]//div[@class='nutrition']//li[@class='calories']");
    By tenadayLabel = By.xpath("//span[contains(.,'Ten a day')]");
    By regularkiwiavacadocucumberpriceLabel = By.xpath("//div[@class='order-item-grid select-option']/a[1]//span[contains(@class,'price')]");
    By tenadaycalories = By.xpath("//div[@class='order-item-grid select-option']/a[1]//div[@class='nutrition']//li[@class='calories']");
    By drinkLabel = By.xpath("//div[@class='order-item-grid create-order']//a[4]//span");
    By avacadomilshakepriceLabel = By.xpath("//div[@class='order-item-grid select-option']//a[1]//span[@class='price']");
    By avacadocalories = By.xpath("//div[@class='order-item-grid select-option']//a[1]//div[3]//li[@class='calories']");
    By whoisthismealforLabel = By.xpath("//h3[contains(.,'WHO IS THIS MEAL FOR?')]");
    By orderlaterradioButton = By.xpath("//div[@class='fbf-ordertime-container']/div[2]//i[@class='radio-placeholder']");
    By orderfornowradioButton = By.xpath("//div[@class='fbf-ordertime-container']/div[1]//i[@class='radio-placeholder']");


    public GuestCreateOwnMeal(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 30);
        this.commonOperations = new CommonOperations();
        this.driver = driver;

    }


    public void navigateToCreateNewPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(createyourownmealBtn));
        wait.until(ExpectedConditions.elementToBeClickable(createyourownmealBtn));

        //click order later radio button
        bvalue = driver.findElement(orderfornowradioButton).isSelected();
        if (bvalue = true) {

            String now;
            // This will select Second radio button, if the first radio button is selected by default
            driver.findElement(createyourownmealBtn).click();

        } else {

            // If the first radio button is not selected by default, the first will be selected
            String later;
            System.out.println("Click the  order Later Button");
            //driver.findElement(oderlaterradioButton).click();
            driver.findElement(createyourownmealBtn).click();
        }

//        driver.findElement(oderlaterradioButton).click();
//        driver.findElement(createyourownmealBtn).click();
    }

    public Boolean getOrderNowType() {
        return bvalue;
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
        protein = Double.valueOf(driver.findElement(chickenregularpriceLabel).getText().substring(1));
        return proteinPrice;

    }

    //get the Chicken Calories
    public String getProteinCaloriesLabel() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(proteincalories));
        wait.until(ExpectedConditions.elementToBeClickable(proteincalories));
        proteincaloriescount = driver.findElement(proteincalories).getText();
        proteinCal = Integer.valueOf(driver.findElement(proteincalories).getText().substring(9));
        return proteincaloriescount;
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

    //Calories total count

    public String navigateToSelectedItemPageAndCaloriesCount() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(regularchickenLabel));
        wait.until(ExpectedConditions.elementToBeClickable(regularchickenLabel));
        return driver.findElement(caloriescountLabel).getText();
    }

    public String getWhoIsThisMealForLabel() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(whoisthismealforLabel));
        wait.until(ExpectedConditions.elementToBeClickable(whoisthismealforLabel));
        return driver.findElement(whoisthismealforLabel).getText();
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
        carb = Double.valueOf(driver.findElement(cassavaregularpriceLabel).getText().substring(1));
        return carbPrice;

    }

    //carb calories count is cassava
    public String getCarbCalorieCountLabel() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(carbcaloriesLabel));
        wait.until(ExpectedConditions.elementToBeClickable(carbcaloriesLabel));
        carbcaloriesCount = driver.findElement(carbcaloriesLabel).getText();
        CarbCal = Integer.valueOf(driver.findElement(carbcaloriesLabel).getText().substring(9));
        return carbcaloriesCount;

    }

    public void selectRegularCarb() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectcassavaBtn));
        wait.until(ExpectedConditions.elementToBeClickable(selectcassavaBtn));
        driver.findElement(selectcassavaBtn).click();
    }

    //click the Ten a Day Box

    public void navigateToTenADayPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(tenadayLabel));
        wait.until(ExpectedConditions.elementToBeClickable(tenadayLabel));
        driver.findElement(tenadayLabel).click();

    }

    public String getTenADayPriceLabel() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(regularkiwiavacadocucumberpriceLabel));
        wait.until(ExpectedConditions.elementToBeClickable(regularkiwiavacadocucumberpriceLabel));
        tenadayPrice = driver.findElement(regularkiwiavacadocucumberpriceLabel).getText();
        tenADay = Double.valueOf(driver.findElement(regularkiwiavacadocucumberpriceLabel).getText().substring(1));
        return tenadayPrice;
    }

    //Ten a Day calorie count kiwi,Avacado&Cucumber
    public String getTenaDayCalorieCountLabel() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(tenadaycalories));
        wait.until(ExpectedConditions.elementToBeClickable(tenadaycalories));
        tenadaycaloriesCount = driver.findElement(tenadaycalories).getText();
        TenADayCal = Integer.valueOf(driver.findElement(carbcaloriesLabel).getText().substring(9));
        return tenadaycaloriesCount;
    }

    public void selectRegularTenADay() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(regularkiwiavacadocucumberpriceLabel));
        wait.until(ExpectedConditions.elementToBeClickable(regularkiwiavacadocucumberpriceLabel));
        driver.findElement(regularkiwiavacadocucumberpriceLabel).click();
    }

    //click Drink Box

    public void navigateToDrinkPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(drinkLabel));
        wait.until(ExpectedConditions.elementToBeClickable(drinkLabel));
        driver.findElement(drinkLabel).click();
    }

    public String getDrinkPriceLabel() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(avacadomilshakepriceLabel));
        wait.until(ExpectedConditions.elementToBeClickable(avacadomilshakepriceLabel));
        drinkprice = driver.findElement(avacadomilshakepriceLabel).getText();
        drink = Double.valueOf(driver.findElement(avacadomilshakepriceLabel).getText().substring(1));
        return drinkprice;
    }

    //Drink calorie count Avacado Milkshake
    public String getDrinkCalorieCountLabel() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(avacadocalories));
        wait.until(ExpectedConditions.elementToBeClickable(avacadocalories));
        drinkcaloriecount = driver.findElement(avacadocalories).getText();
        DrinkCal = Integer.valueOf(driver.findElement(avacadocalories).getText().substring(9));
        return drinkcaloriecount;
    }

    public void selectRegularDrink() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(avacadomilshakepriceLabel));
        wait.until(ExpectedConditions.elementToBeClickable(avacadomilshakepriceLabel));
        driver.findElement(avacadomilshakepriceLabel).click();
    }

    public void navigateToWhoIsThisMealForPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addthismealBtn));
        wait.until(ExpectedConditions.elementToBeClickable(addthismealBtn));
        driver.findElement(addthismealBtn).click();
    }

    //scroll down the page
    public void scrollingToBottomofAPage() {
        //driver.navigate().to(URL);
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public String calculatePrice() {
        Double Total = carb + protein + tenADay + drink;
        String finalanswer = String.format("%.2f", Total);
        return String.valueOf(finalanswer);
    }

    public String calculateCalories() {
        int Total = CarbCal + proteinCal + TenADayCal + DrinkCal;
        return Integer.toString(Total);
    }

}
