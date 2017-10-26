package com.fbf.automation.tests;

import com.fbf.automation.DriverFactory;
import com.fbf.automation.pageobjects.GuestCreateOwnMeal;
import com.fbf.automation.pageobjects.HomePage;
import com.fbf.automation.pageobjects.RegularProtein;
import com.fbf.automation.utils.FailureReport;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Set;

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
        guestCreateOwnMeal = new GuestCreateOwnMeal(driver);
        homepage = new HomePage(driver);
        regularProtein = new RegularProtein(driver);
    }

    @Test(description = "Verify Home page loaded", priority = 0)
    public void verifyPageElements() {
        String errorMessage = "Home page title not valid.";
        Assert.assertEquals(homepage.getHomePageTitle(), pageTitle, errorMessage);
    }

    @Test(description = "Navigate To the Create Your Own Meal Page", priority = 1, dependsOnMethods = "verifyPageElements")
    public void navigateToCreateOwnMeal() {
        guestCreateOwnMeal.navigateToCreateNewPage();
        Assert.assertEquals(guestCreateOwnMeal.getCreateNewPageLabel(), "PROTEIN");
    }

    @Test(description = "Navigate To the Regular Protein Page", priority = 2, dependsOnMethods = "navigateToCreateOwnMeal")
    public void navigateToRegularProtein() {
        guestCreateOwnMeal.navigateToProteinPage();
        Assert.assertEquals(guestCreateOwnMeal.getProteinPriceLabel().substring(0, 1), "£");
    }

    @Test(description = "Select the Regular Chicken for the Meal", priority = 3, dependsOnMethods = "navigateToRegularProtein")
    public void selectRegularProtein() {
        guestCreateOwnMeal.selectProtein();
        Assert.assertEquals(guestCreateOwnMeal.navigateToSelectedItemPageAndCheckTotal().substring(0, 1), "£");
    }

    @Test(description = "Navigate To the Regular Carb for the Meal", priority = 4, dependsOnMethods = "selectRegularProtein")
    public void navigateToRegularCarb() {
        guestCreateOwnMeal.navigateToCarbPage();
        Assert.assertEquals(guestCreateOwnMeal.getCarbPriceLabel().substring(0, 1), "£");
    }

    @Test(description = "Select the Regular Carb for the Meal & Verify Total", priority = 5, dependsOnMethods = "navigateToRegularCarb")
    public void selectRegularCarbAndVerifyTotal() {
        guestCreateOwnMeal.selectRegularCarb();
        Assert.assertEquals(guestCreateOwnMeal.navigateToSelectedItemPageAndCheckTotal(), "£" + guestCreateOwnMeal.CalculatePrice());
    }

    @AfterSuite
    public void tearDown() {
// close the browser
        driver.close();
        driver.quit();
    }


}
