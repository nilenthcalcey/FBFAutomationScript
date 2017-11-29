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

    @Test(description = "Navigate to the Vegetable Protein Selection Window and Test the Labels ", priority = 4 )
    public void navigateToProteinSelectionPage() throws InterruptedException {
        String valNp = vegetarianFavourite.getVegProteinNameX();
        System.out.println("**********************"+valNp);
        String valCp = vegetarianFavourite.getVegProteinCalX();
        System.out.println("**********************"+valCp);
        String valPp = vegetarianFavourite.getVegProteinPriceX();
        System.out.println("**********************"+valPp);

        String valNc = vegetarianFavourite.getVegCarbNameX();
        System.out.println("**********************"+valNc);
        String valCc = vegetarianFavourite.getVegCarbCalX();
        System.out.println("**********************"+valCc);
        String valPc = vegetarianFavourite.getVegCarbPriceX();
        System.out.println("**********************"+valPc);

        String valNt = vegetarianFavourite.getVegTenADayNameX();
        System.out.println("**********************"+valNt);
        String valCt = vegetarianFavourite.getVegTenADayCalX();
        System.out.println("**********************"+valCt);
        String valPt = vegetarianFavourite.getVegTenADayPriceX();
        System.out.println("**********************"+valPt);

        vegetarianFavourite.navigateToProteinSelection();

        vegetarianFavourite.scrollToBottomofThePage();
        //Thread.sleep(5000);
        String valNxp = vegetarianFavourite.getVegProteinName();
        System.out.println("**********************"+valNxp);
        Assert.assertEquals(valNp, valNxp);
        String valCxp = vegetarianFavourite.getVegProteinCal();
        System.out.println("**********************"+valCxp);
        Assert.assertEquals(valCp, valCxp);
        String valPxp = vegetarianFavourite.getVegProteinPrice();
        System.out.println("**********************"+valPxp);
        Assert.assertEquals(valPp, valPxp);

        vegetarianFavourite.navigateBackToVegFav();

        vegetarianFavourite.navigateToCarbSelection();

        //Thread.sleep(3000);

        String valNxc = vegetarianFavourite.getVegCarbName();
        System.out.println("**********************"+valNxc);
        Assert.assertEquals(valNc, valNxc);
        String valCxc = vegetarianFavourite.getVegCarbCal();
        System.out.println("**********************"+valCxc);
        Assert.assertEquals(valCc, valCxc);
        String valPxc = vegetarianFavourite.getVegCarbPrice();
        System.out.println("**********************"+valPxc);
        Assert.assertEquals(valPc, valPxc);


        vegetarianFavourite.navigateBackToVegFav();

        vegetarianFavourite.navigateToTenADaySelection();


        String valNxt = vegetarianFavourite.getVegTenADayName();
        System.out.println("**********************"+valNxt);
        Assert.assertEquals(valNt, valNxt);
        String valCxt = vegetarianFavourite.getVegTenADayCal();
        System.out.println("**********************"+valCxt);
        Assert.assertEquals(valCt, valCxt);
        String valPxt = vegetarianFavourite.getVegTenADayPrice();
        System.out.println("**********************"+valPxt);
        Assert.assertEquals(valPt, valPxt);

        vegetarianFavourite.navigateBackToVegFav();
    }


   /* @Test(description = "Navigate to the Vegetable Carb Selection Window and Test the Labels ", priority = 5 )
    public void navigateToCarbSelectionPage() {
        vegetarianFavourite.navigateBackToVegFav();
        String valN = vegetarianFavourite.getVegCarbNameX();
        System.out.println("**********************"+valN);
        String valC = vegetarianFavourite.getVegCarbCalX();
        System.out.println("**********************"+valC);
        String valP = vegetarianFavourite.getVegCarbPriceX();
        System.out.println("**********************"+valP);
        vegetarianFavourite.navigateToCarbSelection();
        //vegetarianFavourite.scrollToBottomofThePage();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String valNx = vegetarianFavourite.getVegCarbName();
        System.out.println("**********************"+valNx);
        Assert.assertEquals(valN, valNx);
        String valCx = vegetarianFavourite.getVegCarbCal();
        System.out.println("**********************"+valCx);
        Assert.assertEquals(valC, valCx);
        String valPx = vegetarianFavourite.getVegCarbPrice();
        System.out.println("**********************"+valPx);
        Assert.assertEquals(valP, valPx);
        vegetarianFavourite.navigateBackToVegFav();
    }*/

   /* @Test(description = "Test Weather Protein Item's data are correctly transfered", priority = 4 )
    public void testProteinData()  {
        Assert.assertEquals(vegetarianFavourite.getProteinItemLbl(),"SPROUTED 9 BEAN BROTH | REGULAR");
        Assert.assertEquals(vegetarianFavourite.getProteinCaloriesCount(),"158 CAL");
        Assert.assertEquals(vegetarianFavourite.getProteinPrice(),"£1.99");
    }

    @Test(description = "Test Weather Carb Item's data are correctly transfered", priority = 5 )
    public void testCarbData()  {
        Assert.assertEquals(vegetarianFavourite.getCarbItemLbl(),"CASSAVA | REGULAR");
        Assert.assertEquals(vegetarianFavourite.getCarbCaloriesCount(),"119 CAL");
        Assert.assertEquals(vegetarianFavourite.getCarbPrice(),"£1.29");
    }

    @Test(description = "Test Weather TenA Day Item's data are correctly transfered", priority = 6 )
    public void testTenADayData()  {
        Assert.assertEquals(vegetarianFavourite.getTenADayItemLbl(),"MANGO & SWEET YELLOW PEPPER | REGULAR");
        Assert.assertEquals(vegetarianFavourite.getTenADayCaloriesCount(),"32 CAL");
        Assert.assertEquals(vegetarianFavourite.getTenADayPrice(),"£1.69");
    }*/

    @Test(description = "Verify Default Total Price & Total Calorie Count",priority = 5 )
    public void VerifyTotal(){
        Assert.assertEquals(vegetarianFavourite.getPriceLbl(),"£" + vegetarianFavourite.calculatePrice());
        Assert.assertEquals(vegetarianFavourite.getCaloriesLbl(), vegetarianFavourite.calculateCalories());
    }

    @Test(description = "Test Weather Drink is Selected", priority = 6 )
    public void testDrinkSelection()  {
        Assert.assertEquals(vegetarianFavourite.getDrinkSelection(),"order-item-box bordered-item");
    }





  /*  @AfterSuite
    public void tearDown() {
        driver.close();
        driver.quit();
    }*/

}
