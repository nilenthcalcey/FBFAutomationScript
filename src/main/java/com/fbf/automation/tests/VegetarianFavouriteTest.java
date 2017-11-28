package com.fbf.automation.tests;

import com.fbf.automation.DriverFactory;
import com.fbf.automation.pageobjects.*;
import com.fbf.automation.utils.FailureReport;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by gishan.n on 11/14/2017.
 */
//public class FailureReport implements ITestListener {

@Listeners(value = FailureReport.class)
public class VegetarianFavouriteTest {


    WebDriver driver = null;
    VegetarianFavourite vegetarianFavourite;
    GuestCreateOwnMeal guestCreateOwnMeal;


    @BeforeSuite
    public void SetUp() {
        driver = DriverFactory.getDriver();
        vegetarianFavourite = new VegetarianFavourite(driver);
        guestCreateOwnMeal = new GuestCreateOwnMeal(driver);
    }

    @Test(description = "Verify Navigate To Vegetarian Favourite Selection Page", priority = 0)
    public void navigateToVegFavPage() {
        vegetarianFavourite.navigateToVegFav();
        Assert.assertEquals(vegetarianFavourite.getVegFavLabel(), "SPROUTED 9 BEAN BROTH | REGULAR");
    }

    @Test(description = "Test Weather Protein is Selected", priority = 1 )
    public void testProteinSelection()  {
        Assert.assertEquals(vegetarianFavourite.getProteinSelection(),"order-item-box bordered-item full-width selected-item");
    }

    @Test(description = "Test Weather Carb is Selected", priority = 2 )
    public void testCarbSelection()  {
        Assert.assertEquals(vegetarianFavourite.getCarbSelection(),"order-item-box bordered-item selected-item");
    }

    @Test(description = "Test Weather Ten A Day is Selected", priority = 3 )
    public void testTenADaySelection()  {
        Assert.assertEquals(vegetarianFavourite.getTenADaySelection(),"order-item-box bordered-item selected-item");
    }

    @Test(description = "Navigate to the Vegetable Favourite Page, Extract elements and Test Protein, Carb and Ten A Day Selection Windows Labels ", priority = 4 )
    public void navigateToProteinSelectionPage() throws InterruptedException {
        String valNp = vegetarianFavourite.getVegProteinNameX();
        String valCp = vegetarianFavourite.getVegProteinCalX();
        String valPp = vegetarianFavourite.getVegProteinPriceX();
        String valNc = vegetarianFavourite.getVegCarbNameX();
        String valCc = vegetarianFavourite.getVegCarbCalX();
        String valPc = vegetarianFavourite.getVegCarbPriceX();
        String valNt = vegetarianFavourite.getVegTenADayNameX();
        String valCt = vegetarianFavourite.getVegTenADayCalX();
        String valPt = vegetarianFavourite.getVegTenADayPriceX();
        vegetarianFavourite.navigateToProteinSelection();
        vegetarianFavourite.scrollToBottomofThePage();
        String valNxp = vegetarianFavourite.getVegProteinName();
        Assert.assertEquals(valNp, valNxp);
        String valCxp = vegetarianFavourite.getVegProteinCal();
        Assert.assertEquals(valCp, valCxp+" CAL");
        String valPxp = vegetarianFavourite.getVegProteinPrice();
        Assert.assertEquals(valPp, valPxp);
        vegetarianFavourite.navigateBackToVegFav();
        vegetarianFavourite.navigateToCarbSelection();
        String valNxc = vegetarianFavourite.getVegCarbName();
        Assert.assertEquals(valNc, valNxc);
        String valCxc = vegetarianFavourite.getVegCarbCal();
        Assert.assertEquals(valCc, valCxc+" CAL");
        String valPxc = vegetarianFavourite.getVegCarbPrice();
        Assert.assertEquals(valPc, valPxc);
        vegetarianFavourite.navigateBackToVegFav();
        vegetarianFavourite.navigateToTenADaySelection();
        String valNxt = vegetarianFavourite.getVegTenADayName();
        Assert.assertEquals(valNt, valNxt);
        String valCxt = vegetarianFavourite.getVegTenADayCal();
        Assert.assertEquals(valCt, valCxt+" CAL");
        String valPxt = vegetarianFavourite.getVegTenADayPrice();
        Assert.assertEquals(valPt, valPxt);
        vegetarianFavourite.navigateBackToVegFav();
    }

    @Test(description = "Verify Default Total Price & Total Calorie Count",priority = 5 )
    public void VerifyTotal(){
        Assert.assertEquals(vegetarianFavourite.getPriceLbl(),"£" + vegetarianFavourite.calculatePrice());
        Assert.assertEquals(vegetarianFavourite.getCaloriesLbl(), vegetarianFavourite.calculateCalories());
    }

    @Test(description = "Test Weather Drink is Selected", priority = 6 )
    public void testDrinkSelection()  {
        vegetarianFavourite.getDrinkSelection();
        Assert.assertEquals(vegetarianFavourite.getDrinkSelection(),"order-item-box bordered-item");
    }

    @Test(description = "Test Weather item gets Selected and Added when user selects an item", priority = 7 )
    public void testDrinkSelectionAdding()  {
        vegetarianFavourite.navigateToDrinkSelection();
        vegetarianFavourite.getSelectDrinkAvo();
        Assert.assertEquals(vegetarianFavourite.getDrinkSelection(),"order-item-box bordered-item selected-item");
    }

    @Test(description = "Test Weather item gets Selected and Data Added when user selects an item", priority = 7 )
    public void testDrinkSelectionDataAdding()  {
        String valNd = vegetarianFavourite.getVegDrinkNameX();
        String valCd = vegetarianFavourite.getVegDrinkCalX();
        String valPd = vegetarianFavourite.getVegDrinkPriceX();
        vegetarianFavourite.navigateToDrinkSelection();
        String valNxd = vegetarianFavourite.getVegDrinkName();
        Assert.assertEquals(valNd, valNxd);
        String valCxd = vegetarianFavourite.getVegDrinkCal();
        Assert.assertEquals(valCd, valCxd+" CAL");
        String valPxd = vegetarianFavourite.getVegDrinkPrice();
        Assert.assertEquals(valPd, valPxd);
        vegetarianFavourite.navigateBackToVegFav();
    }

    @Test(description = "Verify New Total Price & Total Calorie Count",priority = 5 )
    public void VerifyNewTotal(){
        Assert.assertEquals(vegetarianFavourite.getPriceLbl(),"£" + vegetarianFavourite.newCalculatePrice());
        Assert.assertEquals(vegetarianFavourite.getCaloriesLbl(), vegetarianFavourite.newCalculateCalories());
    }

    @AfterSuite
    public void tearDown() {
        driver.close();
        driver.quit();
    }

}
