package com.fbf.automation.pageobjects;

import com.fbf.automation.utils.CommonOperations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Properties;

/**
 * Created by iresh.n on 11/1/2017.
 */
public class GuestCreateOwnLargeMeal extends PageBase {

    WebDriver driver = null;
    WebDriverWait wait;
    Properties properties;
    CommonOperations commonOperations;
    String LargeLabel;
    String LargeProtein;
    String LargeCabs;
    String ProteinCalory;
    String CabsCalory;
    String TenADayCalory;
    String DrinkCalory;
    String LargeTenADay;
    String LargeDrinks;
    String Large = null;
    String Chickenlabel;
    Double LargeProteinPrice;
    Double LargeCabsPrice;
    Double LargeTenADayPrice;
    Double LargeDrinkPrice;
    Double LargeProteinCalory;
    Double LargeCabsCalory;
    Double LargeTenADayCalory;
    Double LargeDrinkCalory;
    Double TotalItemsPrice;
    Double Total;
    Double CaloryTotal;
    String TotalText;
    Double RoundUPTotal;
    Double RoundUPCalory;






    By createyourownmealBtn = By.xpath("//div[@class ='fbf-small-container']//a[@class ='order-item-box bordered-item']");
    By proteinBtn = By.xpath("//div[@class='inner']//span[contains(.,'Protein')]");
    By btn_largebutton = By.xpath("//li[contains(.,'Large')]");
    By lbl_Largelabel = By.xpath("(//div[@class='price-tag'])[5]");
    By lbl_Lagellabelverify = By.xpath("(//div[@class='price-tag'])[5]/span/following-sibling::text()");
    By lbl_LargeChickenLabel = By.xpath("//div/span[@class='item-name']");
    By btn_Carb = By.xpath("//a[@class='order-item-box bordered-item'][1]");
    By lbl_LargeCarbs = By.xpath("(//div[@class='price-tag'])[3]");
    By lbl_Largecassava = By.xpath("(//div/span[@class='item-name'])[2]");
    By btn_TenADay = By.xpath("//a[@class='order-item-box bordered-item'][1]");
    By lbl_LargeTenADay = By.xpath("(//div[@class='price-tag'])[5]");
    By lbl_LargeTenADaylabel = By.xpath("(//div/span[@class='item-name'])[3]");
    By btn_Drinks = By.xpath("//a[@class='order-item-box bordered-item'][1]");
    By lbl_LargeDrinks = By.xpath("(//div[@class='price-tag'])[1]");
    By lbl_Drinkslabel = By.xpath("(//div/span[@class='item-name'])[4]");
    By lbl_ItemTotal = By.xpath("(//div/span[@class='value'])[2]");
    By lbl_ProtenCalory = By.xpath("//div/span[@class='calories']");
    By lbl_CabsCalory = By.xpath("(//div/span[@class='calories'])[2]");
    By lbl_TenADayCalory = By.xpath("(//div/span[@class='calories'])[3]");
    By lbl_DrinksCalory = By.xpath("(//div/span[@class='calories'])[4]");
    By lbl_TotalCalory = By.xpath("(//div/span[@class='value'])[1]");
    By btn_AddThisMeal = By.xpath("//div[@class='order-button-container item-has-selected']/button[@class='btn btn-primary btn-block']");
    By btn_SaveName = By.xpath("//form[@class='ng-untouched ng-pristine ng-valid']/button[@class='btn btn-primary btn-block']");


    public GuestCreateOwnLargeMeal(WebDriver driver)
    {
        super(driver);
        this.wait = new WebDriverWait(driver, 30);
        this.commonOperations = new CommonOperations();
        this.driver=driver;

    }


    public void navigateToCreateNewPage()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(createyourownmealBtn));
        wait.until(ExpectedConditions.elementToBeClickable(createyourownmealBtn));
        driver.findElement(createyourownmealBtn).click();
    }


    public void NavigateToLargeProteinPage()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(proteinBtn));
        wait.until(ExpectedConditions.elementToBeClickable(proteinBtn));
        driver.findElement(proteinBtn).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(btn_largebutton));
        getDriver().findElement(btn_largebutton).click();
    }


    public void SelectLargeProtein()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lbl_Largelabel));
        getDriver().findElement(lbl_Largelabel).click();

    }


    public String getProteinLabel()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lbl_Largelabel));
        wait.until(ExpectedConditions.elementToBeClickable(lbl_Largelabel));
        LargeLabel = driver.findElement(lbl_Largelabel).getText();
        //Large = String.valueOf(driver.findElement(lbl_Lagellabelverify).getText());
        return LargeLabel;
    }


 public void SelectLargeProteinItem()
 {

     wait.until(ExpectedConditions.visibilityOfElementLocated(lbl_Largelabel));
     this.getLargeProteinPrice();
     getDriver().findElement(lbl_Largelabel).click();


 }


    public String getChickenLabel()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lbl_LargeChickenLabel));
        return getDriver().findElement(lbl_LargeChickenLabel).getText();

    }


    public void navigateToLargeCarb()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(btn_Carb));
        getDriver().findElement(btn_Carb).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(btn_largebutton));
        getDriver().findElement(btn_largebutton).click();

    }

    public void SelectLargeCarbItem()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lbl_LargeCarbs));
        this.getLargeCrabsPrice();
        getDriver().findElement(lbl_LargeCarbs).click();

    }

    public String getCrabsLable()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lbl_LargeCarbs));
        wait.until(ExpectedConditions.elementToBeClickable(lbl_LargeCarbs));
        LargeLabel = driver.findElement(lbl_LargeCarbs).getText();
        return LargeLabel;
    }

    public String getCarbText()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lbl_Largecassava));
        wait.until(ExpectedConditions.elementToBeClickable(lbl_Largecassava));
        LargeLabel = driver.findElement(lbl_Largecassava).getText();
        return LargeLabel;

    }

    public void navigateToLargeTenADay()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(btn_TenADay));
        getDriver().findElement(btn_TenADay).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(btn_largebutton));
        getDriver().findElement(btn_largebutton).click();

    }

    public String getTenADayLabel() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lbl_LargeTenADay));
        wait.until(ExpectedConditions.elementToBeClickable(lbl_LargeTenADay));
        LargeLabel = driver.findElement(lbl_LargeTenADay).getText();
        //Large = String.valueOf(driver.findElement(lbl_Lagellabelverify).getText());
        return LargeLabel;
    }

    public void SelectLargeTenADay()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lbl_LargeTenADay));
        this.getLargeTenADayPrice();
        getDriver().findElement(lbl_LargeTenADay).click();
    }

     public String getTenADayText()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lbl_LargeTenADaylabel));
        wait.until(ExpectedConditions.elementToBeClickable(lbl_LargeTenADaylabel));
        LargeLabel = driver.findElement(lbl_LargeTenADaylabel).getText();
        //Large = String.valueOf(driver.findElement(lbl_Lagellabelverify).getText());
        return LargeLabel;
    }

    public void navigateToLargeDrinks()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(btn_Drinks));
        getDriver().findElement(btn_Drinks).click();

    }

    public String getDrinksLabel()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lbl_LargeDrinks));
        wait.until(ExpectedConditions.elementToBeClickable(lbl_LargeDrinks));
        LargeLabel = driver.findElement(lbl_LargeDrinks).getText();
        //Large = String.valueOf(driver.findElement(lbl_Lagellabelverify).getText());
        return LargeLabel;
    }

    public void SelectDrinks()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lbl_LargeDrinks));
        this.getDrinksPrice();
        getDriver().findElement(lbl_LargeDrinks).click();
    }

    public String getDrinksText()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lbl_Drinkslabel));
        wait.until(ExpectedConditions.elementToBeClickable(lbl_Drinkslabel));
        LargeLabel = driver.findElement(lbl_Drinkslabel).getText();
        //Large = String.valueOf(driver.findElement(lbl_Lagellabelverify).getText());
        return LargeLabel;
    }


    public double getLargeProteinPrice()
    {

        wait.until(ExpectedConditions.visibilityOfElementLocated(lbl_Largelabel));
        wait.until(ExpectedConditions.elementToBeClickable(lbl_Largelabel));
        LargeProtein = (driver.findElement(lbl_Largelabel).getText()).substring(1,5);
        LargeProteinPrice = Double.parseDouble(LargeProtein);
        return LargeProteinPrice;

    }
    public double getLargeProteinCalory()
    {

        wait.until(ExpectedConditions.visibilityOfElementLocated(lbl_ProtenCalory));
        wait.until(ExpectedConditions.elementToBeClickable(lbl_ProtenCalory));
        ProteinCalory = (driver.findElement(lbl_ProtenCalory).getText()).substring(0,4);
        LargeProteinCalory = Double.parseDouble(ProteinCalory);
        return LargeProteinCalory;

    }



    public double getLargeCrabsPrice()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lbl_LargeCarbs));
        wait.until(ExpectedConditions.elementToBeClickable(lbl_LargeCarbs));
        LargeCabs = (driver.findElement(lbl_LargeCarbs).getText()).substring(1,5);
        LargeCabsPrice = Double.parseDouble(LargeCabs);
        return LargeCabsPrice;
    }


    public double getLargeCarbCalory()
    {

        wait.until(ExpectedConditions.visibilityOfElementLocated(lbl_CabsCalory));
        wait.until(ExpectedConditions.elementToBeClickable(lbl_CabsCalory));
        CabsCalory = (driver.findElement(lbl_CabsCalory).getText()).substring(0,4);
        LargeCabsCalory = Double.parseDouble(CabsCalory);
        return LargeCabsCalory;

    }



    public double getLargeTenADayPrice() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lbl_LargeTenADay));
        wait.until(ExpectedConditions.elementToBeClickable(lbl_LargeTenADay));
        LargeTenADay = (driver.findElement(lbl_LargeTenADay).getText()).substring(1,5);
        LargeTenADayPrice = Double.parseDouble(LargeTenADay);
        return LargeTenADayPrice;
    }

    public double getLargeTenADayCalory()
    {

        wait.until(ExpectedConditions.visibilityOfElementLocated(lbl_TenADayCalory));
        wait.until(ExpectedConditions.elementToBeClickable(lbl_TenADayCalory));
        TenADayCalory = (driver.findElement(lbl_TenADayCalory).getText()).substring(0,4);
        LargeTenADayCalory = Double.parseDouble(TenADayCalory);
        return LargeTenADayCalory;

    }



    public double getDrinksPrice()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lbl_LargeDrinks));
        wait.until(ExpectedConditions.elementToBeClickable(lbl_LargeDrinks));
        LargeDrinks = (driver.findElement(lbl_LargeDrinks).getText()).substring(1,5);
        LargeDrinkPrice = Double.parseDouble(LargeDrinks);
        return LargeDrinkPrice;
    }

    public double getDrinkCalory()
    {

        wait.until(ExpectedConditions.visibilityOfElementLocated(lbl_DrinksCalory));
        wait.until(ExpectedConditions.elementToBeClickable(lbl_DrinksCalory));
        DrinkCalory = (driver.findElement(lbl_DrinksCalory).getText()).substring(0,4);
        LargeDrinkCalory = Double.parseDouble(DrinkCalory);
        return LargeDrinkCalory;

    }

    public String CalculateTotalprice()
    {
        RoundUPTotal = this.LargeProteinPrice + this.LargeCabsPrice + this.LargeTenADayPrice +this.LargeDrinkPrice;
       // TotalItemsPrice = (double)Math.round((RoundUPTotal*100)/100);
      //  TotalItemsPrice = (double)Math.round((RoundUPTotal*100)/100);
        String finalanswer = (String.format("%.2f",RoundUPTotal)).trim();
        return finalanswer;

    }


    public String CalculateTotalCalory()
    {
        RoundUPCalory =(this.LargeProteinCalory + this.LargeCabsCalory + this.LargeTenADayCalory + this.LargeDrinkCalory);
        String finalCalory = (String.format("%.1f",RoundUPCalory)).trim();
        return finalCalory;

    }

    public String getItemsTotal()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lbl_ItemTotal));
        wait.until(ExpectedConditions.elementToBeClickable(lbl_ItemTotal));
        TotalText = (driver.findElement(lbl_ItemTotal).getText()).substring(1,6);
        Total= (Double.parseDouble(TotalText));
        //Total = (double)Math.round((RoundUPTotal*1000)/1000);
        return String.valueOf(Total);
    }

    public String getItemsCaloryTotal()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lbl_TotalCalory));
        wait.until(ExpectedConditions.elementToBeClickable(lbl_TotalCalory));
        TotalText = (driver.findElement(lbl_TotalCalory).getText());
        CaloryTotal= (Double.parseDouble(TotalText));
        //Total = (double)Math.round((RoundUPTotal*1000)/1000);
        return String.valueOf(CaloryTotal);
    }

      public  void navigateToSaveMealPage()
      {
          wait.until(ExpectedConditions.visibilityOfElementLocated(btn_AddThisMeal));
          wait.until(ExpectedConditions.elementToBeClickable(btn_AddThisMeal));
          getDriver().findElement(btn_AddThisMeal).click();
      }

      public void saveName()
      {
          wait.until(ExpectedConditions.visibilityOfElementLocated(btn_SaveName));
          wait.until(ExpectedConditions.elementToBeClickable(btn_SaveName));
          getDriver().findElement(btn_SaveName).click();
      }

    public  void EnterDeliverifyDetails()
    {

    }


}






//TotalText = Math.round(RoundUPTotal*100)/100;