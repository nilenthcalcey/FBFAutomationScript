package com.fbf.automation.tests;

import com.fbf.automation.DriverFactory;
import com.fbf.automation.pageobjects.*;
import com.fbf.automation.utils.CommonOperations;
import com.fbf.automation.utils.FailureReport;
import org.openqa.selenium.JavascriptExecutor;
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

    static WebDriver driver = null;
    GuestCreateOwnLargeMeal guestCreateOwnLargeMeal;
    HomePage homepage;
    GuestCreateOwnMeal guestCreateOwnMeal;
    AddGuestName addGuestName;
    YourOrder yourOrder;
    CheckoutOrder checkoutOrder;
    CardPayment cardPayment;
    OrderSummery orderSummery;
    CommonOperations common;

    String pageTitle = "Firebrand Fresh";

    @BeforeSuite
    public void setUp() {

        driver = DriverFactory.getDriver();
        guestCreateOwnLargeMeal = new GuestCreateOwnLargeMeal(driver);
        homepage = new HomePage(driver);
        guestCreateOwnMeal = new GuestCreateOwnMeal(driver);
        addGuestName = new AddGuestName(driver);
        yourOrder = new YourOrder(driver);
        checkoutOrder = new CheckoutOrder(driver);
        cardPayment = new CardPayment(driver);
        orderSummery = new OrderSummery(driver);
    }

    public static WebDriver getDriverDetails() {
        return driver;
    }

    @Test(description = "Verify Home page loaded", priority = 0)
    public void verifyPageElements() {
        String errorMessage = "Home page title not valid.";
        Assert.assertEquals(homepage.getHomePageTitle(), pageTitle, errorMessage);
    }

    @Test(description = "Verify Navigate Create New Page", priority = 1)
    public void navigateToCreateOrderPage() {
        guestCreateOwnLargeMeal.navigateToCreateNewPage();
        Assert.assertEquals(guestCreateOwnMeal.getCreateNewPageLabel(), "PROTEIN\nFOR MUSCLES AND NERVES");
    }

    @Test(description = "Verify Navigate Create New Page", priority = 2)
    public void navigateToLargeProteinPage() {
        guestCreateOwnLargeMeal.NavigateToLargeProteinPage();
        Assert.assertEquals(guestCreateOwnLargeMeal.getProteinLabel().substring(6), "Large");
    }

    @Test(description = "Verify add a Large Protein Item into the Platter", priority = 3)
    public void selectLargeProtein() {
        guestCreateOwnLargeMeal.selectLargeProteinItem();
        guestCreateOwnLargeMeal.getLargeProteinCalories();
        Assert.assertEquals(guestCreateOwnLargeMeal.getChickenLabel(), "CHICKEN | LARGE");
    }

    @Test(description = "Verify Navigate to Large Carbs Page", priority = 4)
    public void navigateToLargeCarbPage() {
        guestCreateOwnLargeMeal.navigateToLargeCarb();
        Assert.assertEquals(guestCreateOwnLargeMeal.getCarbsLable().substring(6), "Large");
    }

    @Test(description = "Verify add to Large Carbs item for platter", priority = 5)
    public void selectLargeCarbItem() {
        guestCreateOwnLargeMeal.selectLargeCarbItem();
        guestCreateOwnLargeMeal.getLargeCarbCalory();
        Assert.assertEquals(guestCreateOwnLargeMeal.getCarbText(), "CASSAVA | LARGE");
    }

    @Test(description = "Verify Navigate to Large Ten A Day Iems List", priority = 6)
    public void navigateLargeTenADay() {

        guestCreateOwnLargeMeal.navigateToLargeTenADay();
        Assert.assertEquals(guestCreateOwnLargeMeal.getTenADayLabel().substring(6), "Large");
    }

    @Test(description = "Verify add to Large Ten A Day item for platter", priority = 7)
    public void selectLargeTenADay() {
        guestCreateOwnLargeMeal.selectLargeTenADay();
        guestCreateOwnLargeMeal.getLargeTenADayCalory();
        Assert.assertEquals(guestCreateOwnLargeMeal.getTenADayText(), "KIWI, AVOCADO & CUCUMBER | LARGE");
    }

    @Test(description = "Verify Navigate to Large Drinks Items List", priority = 8)
    public void navigateLargeDrinks() {
        guestCreateOwnLargeMeal.navigateToLargeDrinks();
        Assert.assertEquals(guestCreateOwnLargeMeal.getDrinksLabel().substring(6), "250ml");
    }

    @Test(description = "Verify add to Large Drink item for platter", priority = 9)
    public void selectLargeDrinks() {
        guestCreateOwnLargeMeal.selectDrinks();
        guestCreateOwnLargeMeal.getDrinkCalories();
        Assert.assertEquals(guestCreateOwnLargeMeal.getDrinksText(), "AVOCADO MILKSHAKE | 250ML");
    }

    @Test(description = "Verify Total price value of platter", priority = 10)
    public void calculateTotalPrice() {
        guestCreateOwnLargeMeal.calculateTotalprice();
        Assert.assertEquals(guestCreateOwnLargeMeal.calculateTotalprice(), guestCreateOwnLargeMeal.getItemsTotal());
    }

    @Test(description = "Verify Total Calory value of platter", priority = 11)
    public void calculateTotalCalories() {
        guestCreateOwnLargeMeal.calculateTotalCalories();
        Assert.assertEquals(guestCreateOwnLargeMeal.calculateTotalCalories(), guestCreateOwnLargeMeal.getItemsCaloryTotal());
    }

    @Test(description = "Verify Total Calory value of platter", priority = 12)
    public void navigateToSaveName() {
        guestCreateOwnMeal.scrollingToBottomofAPage();
        guestCreateOwnLargeMeal.navigateToSaveMealPage();
        Assert.assertEquals(guestCreateOwnMeal.getWhoIsThisMealForLabel(), "ADDITIONAL MEAL DETAILS");
    }

    @Test(description = "Verify Enter The Meal Name ", priority = 13)
    public void saveName() {
        guestCreateOwnLargeMeal.saveName();
        Assert.assertEquals(addGuestName.navigateToYourOrderPage(), "GUEST NAME");
    }

    @Test(description = "Verify User enter delivery details", priority = 14)
    public void enterDeliveryDetails() {
        yourOrder.typePostalCard();
        yourOrder.getPostalCodeNotification();
        yourOrder.typeStreetAddress();
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");        //scroll down the page
        yourOrder.submitYourOrder();
        Assert.assertEquals(yourOrder.navigatetoCheckOrderPage(), "Please let us know your name, email to send you an eco-friendly receipt, and mobile number, to let you know your order status");
    }

    @Test(description = "Verify enter User details and redirect to the Card Page", priority = 15)
    public void enterUserDetails() {
        checkoutOrder.enterLargeUserDetails();
        Assert.assertEquals(checkoutOrder.navigateToPaymentCardPage(), "Pay with card");
    }

    @Test(description = "Verify enter User Card details and redirect to the Order Confirmation Page", priority = 16)
    public void enterCardDetails() {
        cardPayment.addCardDetails();
        cardPayment.clickPaymentProceedButton();
        Assert.assertEquals(orderSummery.getUserName(), checkoutOrder.getLargeUserName());
    }

    @AfterSuite
    public void tearDown() {
        driver.close();
    }

}
