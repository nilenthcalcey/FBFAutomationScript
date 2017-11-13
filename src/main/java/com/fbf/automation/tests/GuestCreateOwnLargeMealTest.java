package com.fbf.automation.tests;

import com.fbf.automation.DriverFactory;
import com.fbf.automation.pageobjects.AddGuestName;
import com.fbf.automation.pageobjects.GuestCreateOwnLargeMeal;
import com.fbf.automation.pageobjects.GuestCreateOwnMeal;
import com.fbf.automation.pageobjects.HomePage;
import com.fbf.automation.utils.FailureReport;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Created by iresh.n on 11/1/2017.
 */
@Listeners(value = FailureReport.class)
public class GuestCreateOwnLargeMealTest {

    WebDriver driver = null;
    GuestCreateOwnLargeMeal guestCreateOwnLargeMeal;
    HomePage homepage;
    GuestCreateOwnMeal guestCreateOwnMeal;
    AddGuestName addGuestName;

    String pageTitle = "Firebrand Fresh";

    @BeforeSuite
    public void SetUp()
    {

        driver = DriverFactory.getDriver();
        guestCreateOwnLargeMeal = new GuestCreateOwnLargeMeal(driver);
        homepage = new HomePage(driver);
        guestCreateOwnMeal = new GuestCreateOwnMeal(driver);
        addGuestName = new AddGuestName(driver);
    }

    @Test(description = "Verify Home page loaded", priority = 0)
    public void verifyPageElements()
    {
        String errorMessage = "Home page title not valid.";
        Assert.assertEquals(homepage.getHomePageTitle(), pageTitle, errorMessage);
    }

    @Test(description = "Verify Navigate Create New Page", priority = 1)
    public void NavigateToCreateOrderPage()
    {
        guestCreateOwnLargeMeal.navigateToCreateNewPage();
        Assert.assertEquals(guestCreateOwnMeal.getCreateNewPageLabel(), "PROTEIN");
    }


    @Test(description = "Verify Navigate Create New Page", priority = 2)
    public void NavigateToLargeProteinPage()
   {

       guestCreateOwnLargeMeal.NavigateToLargeProteinPage();
       Assert.assertEquals(guestCreateOwnLargeMeal.getProteinLabel().substring(6),"Large");
   }


    @Test(description = "Verify add a Large Protein Item into the Platter", priority = 3)
    public  void selectLargeProtein()
    {


        guestCreateOwnLargeMeal.SelectLargeProteinItem();
        guestCreateOwnLargeMeal.getLargeProteinCalory();
        Assert.assertEquals(guestCreateOwnLargeMeal.getChickenLabel(),"CHICKEN | LARGE");


    }

    @Test(description = "Verify Navigate to Large Carbs Page", priority = 4)
    public void NavigateToLargeCarbPage()
    {
        guestCreateOwnLargeMeal.navigateToLargeCarb();
        Assert.assertEquals(guestCreateOwnLargeMeal.getCrabsLable().substring(6),"Large");
    }


    @Test(description = "Verify add to Large Carbs item for platter", priority = 5)
    public void selectLargeCarbItem()
    {
        guestCreateOwnLargeMeal.SelectLargeCarbItem();
        guestCreateOwnLargeMeal.getLargeCarbCalory();
        Assert.assertEquals(guestCreateOwnLargeMeal.getCarbText(),"CASSAVA | LARGE");
    }

    @Test(description = "Verify Navigate to Large Ten A Day Iems List", priority = 6)
    public  void navigateLargeTenADay()
    {

        guestCreateOwnLargeMeal.navigateToLargeTenADay();
        Assert.assertEquals(guestCreateOwnLargeMeal.getTenADayLabel().substring(6),"Large");
    }

    @Test(description = "Verify add to Large Ten A Day item for platter", priority = 7)
    public void selectLargeTenADay()
    {
        guestCreateOwnLargeMeal.SelectLargeTenADay();
        guestCreateOwnLargeMeal.getLargeTenADayCalory();
        Assert.assertEquals(guestCreateOwnLargeMeal.getTenADayText(),"KIWI, AVOCADO & CUCUMBER | LARGE");
    }



    @Test(description = "Verify Navigate to Large Drinks Items List", priority = 8)
    public  void navigateLargeDrinks()
    {

        guestCreateOwnLargeMeal.navigateToLargeDrinks();
        Assert.assertEquals(guestCreateOwnLargeMeal.getDrinksLabel().substring(6),"250ml");
    }

    @Test(description = "Verify add to Large Drink ittem for platter", priority = 9)
    public void selectLargeDrinks()
    {
        guestCreateOwnLargeMeal.SelectDrinks();
        guestCreateOwnLargeMeal.getDrinkCalory();
        Assert.assertEquals(guestCreateOwnLargeMeal.getDrinksText(),"AVOCADO MILKSHAKE | 250ML");
    }

    @Test(description = "Verify Total price value of platter", priority = 10)
    public void CalculateTotalPrice()
    {
        guestCreateOwnLargeMeal.CalculateTotalprice();
        Assert.assertEquals(guestCreateOwnLargeMeal.CalculateTotalprice(),guestCreateOwnLargeMeal.getItemsTotal());

    }
    @Test(description = "Verify Total Calory value of platter", priority = 11)
    public void CalculateTotalCalory()
    {

        guestCreateOwnLargeMeal.CalculateTotalCalory();
        Assert.assertEquals(guestCreateOwnLargeMeal.CalculateTotalCalory(),guestCreateOwnLargeMeal.getItemsCaloryTotal());
    }

    @Test(description = "Verify Total Calory value of platter", priority = 12)
    public void NavigateToSaveName()
    {

        guestCreateOwnMeal.scrollingToBottomofAPage("http://fbf.calcey.net/create-order");
        guestCreateOwnLargeMeal.navigateToSaveMealPage();
        Assert.assertEquals(guestCreateOwnMeal.getWhoIsThisMealForLabel(),"WHO IS THIS MEAL FOR?");

    }

    @Test(description = "Verify Total Calory value of platter", priority = 13)
    public void SaveName()
    {


        guestCreateOwnLargeMeal.saveName();
        Assert.assertEquals(addGuestName.navigateToYourOrderPage(),"GUEST NAME");
    }




   @AfterSuite
    public void TearDown()
   {

        driver.close();
   }


}
