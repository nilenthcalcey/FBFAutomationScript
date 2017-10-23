package com.fbf.automation.tests;

import com.fbf.automation.DriverFactory;
import com.fbf.automation.pageobjects.GuestCreateOwnMeal;
import com.fbf.automation.pageobjects.HomePage;
import com.fbf.automation.pageobjects.RegularProtein;
import com.fbf.automation.utils.FailureReport;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Created by lahiru.k on 10/21/2017.
 */

@Listeners(value = FailureReport.class)
public class GuestCreateOwnMealTest {
    WebDriver driver = null;
    GuestCreateOwnMeal guestCreateOwnMeal;
    HomePage homepage;
    RegularProtein regularProtein;
    HomePageTest homepageTest;

    String pageTitle = "Firebrand Fresh";



    @BeforeSuite
    public void SetUp() {
        driver = DriverFactory.getDriver();
        guestCreateOwnMeal =  new GuestCreateOwnMeal(driver);
        homepage = new HomePage(driver);
        regularProtein = new RegularProtein(driver);
    }

    @Test(description = "Verify Home page loaded", priority = 0)
    public void verifyPageElements() {
        String errorMessage = "Home page title not valid.";
        Assert.assertEquals(homepage.getHomePageTitle(), pageTitle, errorMessage);
    }

    @Test(description = "Navigate To the Crete Your Own Mela Page", priority = 1)
    public void navigateToCreateOwnMeal(){
        guestCreateOwnMeal.navigateToCreateNewPage();
        Assert.assertEquals(guestCreateOwnMeal.getCreateNewPageLabel(),"PROTEIN");
    }

    @Test(description = "Navigate To the Regular Protein Page",priority = 2)
    public void navigateToRegularProtein(){
        guestCreateOwnMeal.navigateToProteinPage();
        Assert.assertEquals(guestCreateOwnMeal.getProteinChickenPriceLabel(),"£2.99");
    }

    @Test(description = "Select the Regular Chicken for the Meal",priority = 3)
    public void selectRegularChicken(){
        guestCreateOwnMeal.selectRegularChickenInProteinPage();
        Assert.assertEquals(guestCreateOwnMeal.navigateToSelectedItemPage(),"£2.99");
    }

//    @Test(description = "Navigate to the Incompplete Platter popup Screen",priority = 4)
//    public void navigateToIncompletePlatterscreen(){
//        guestCreateOwnMeal.navigateToIncompletePlatterPopup();
//        Assert.assertEquals(guestCreateOwnMeal.getIncompletePlatterPopupLabel(),"Select a protein, carb & ten a day to create a meal. Drink is optional");
//    }

    @Test(description = "Navigate To the Regular Carb for the Meal",priority = 4)
    public void navigateToRegularCarb(){
        guestCreateOwnMeal.navigateToCarbPage();
        Assert.assertEquals(guestCreateOwnMeal.getCarbCassavaPriceLabel(),"£1.29");
}

    @Test(description = "Select the Regular Carb for the Meal",priority = 5)
    public void selectRegularCassava(){
        guestCreateOwnMeal.selectRegularCasavaInCarbinPage();
        Assert.assertEquals(guestCreateOwnMeal.navigateToSelectedItemPage(),"£4.28");
    }




}
