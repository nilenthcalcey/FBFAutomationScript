package com.fbf.automation.tests;

import com.fbf.automation.DriverFactory;
import com.fbf.automation.pageobjects.*;
import com.fbf.automation.utils.FailureReport;
import org.openqa.selenium.JavascriptExecutor;
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
    PageBase pagebase;
    RegularProtein regularProtein;
    HomePageTest homepageTest;
    AddGuestName addguestName;
    YourOrder yourOrder;
    String orderSubTotal;
    CheckoutOrder checkoutOrder;
    CardPayment cardPayment;
    OrderSummery orderSummery;


    int multiplier= 1;


    String pageTitle = "Firebrand Fresh";

    @BeforeSuite
    public void SetUp() {
        driver = DriverFactory.getDriver();
        guestCreateOwnMeal = new GuestCreateOwnMeal(driver);
        homepage = new HomePage(driver);
        regularProtein = new RegularProtein(driver);
        addguestName = new AddGuestName(driver);
        yourOrder = new YourOrder(driver);
        checkoutOrder = new CheckoutOrder(driver);
        cardPayment = new CardPayment(driver);
        orderSummery = new OrderSummery(driver);
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
        Assert.assertEquals(guestCreateOwnMeal.getProteinPriceLabel().substring(0,1), "£");
        Assert.assertEquals(guestCreateOwnMeal.getProteinCaloriesLabel().substring(0,8),"CALORIES");
    }

    @Test(description = "Select the Regular Chicken for the Meal and Check the Calories Count & Total Value", priority = 3, dependsOnMethods = "navigateToRegularProtein")
    public void selectRegularProtein() {
        guestCreateOwnMeal.selectProtein();
        Assert.assertEquals(guestCreateOwnMeal.navigateToSelectedItemPageAndCheckTotal(), "£2.99");
        Assert.assertEquals(guestCreateOwnMeal.navigateToSelectedItemPageAndCaloriesCount(),"263");
    }

    @Test(description = "Navigate To the Regular Carb for the Meal", priority = 4, dependsOnMethods = "selectRegularProtein")
    public void navigateToRegularCarb() {
        guestCreateOwnMeal.navigateToCarbPage();
        Assert.assertEquals(guestCreateOwnMeal.getCarbPriceLabel().substring(0,1), "£");
        Assert.assertEquals(guestCreateOwnMeal.getCarbCalorieCountLabel().substring(0,8),"CALORIES");
    }

    @Test(description = "Select the Regular Carb for the Meal & Verify Total Price & Total Calorie Count", priority = 5, dependsOnMethods = "navigateToRegularCarb")
    public void selectRegularCarbAndVerifyTotal() {
        guestCreateOwnMeal.selectRegularCarb();
        Assert.assertEquals(guestCreateOwnMeal.navigateToSelectedItemPageAndCheckTotal(), "£" + guestCreateOwnMeal.calculatePrice());
        Assert.assertEquals(guestCreateOwnMeal.navigateToSelectedItemPageAndCaloriesCount(),guestCreateOwnMeal.calculateCalories());
    }

    @Test(description = "Navigate To the Regular Ten A Day for the Meal",priority = 6,dependsOnMethods = "selectRegularCarbAndVerifyTotal")
    public void navigateToRegularTenaDay() {
        guestCreateOwnMeal.navigateToTenADayPage();
        Assert.assertEquals(guestCreateOwnMeal.getTenADayPriceLabel().substring(0,1),"£");
        Assert.assertEquals(guestCreateOwnMeal.getTenaDayCalorieCountLabel().substring(0,8),"CALORIES");
    }

    @Test(description = "Select the Regular Ten A Day for the Meal & Verify Total Price & Total Calorie Count",priority = 7,dependsOnMethods = "navigateToRegularTenaDay" )
    public void selectRegularTenADayAndVerifyTotal(){
        guestCreateOwnMeal.selectRegularTenADay();
        Assert.assertEquals(guestCreateOwnMeal.navigateToSelectedItemPageAndCheckTotal(),"£" + guestCreateOwnMeal.calculatePrice());
        Assert.assertEquals(guestCreateOwnMeal.navigateToSelectedItemPageAndCaloriesCount(),guestCreateOwnMeal.calculateCalories());
    }

    @Test(description = "Navigate To the Regular Drink for the Meal",priority =8,dependsOnMethods = "selectRegularTenADayAndVerifyTotal")
    public void navigateToDrink(){
        guestCreateOwnMeal.navigateToDrinkPage();
        Assert.assertEquals(guestCreateOwnMeal.getDrinkPriceLabel().substring(0,1),"£");
        Assert.assertEquals(guestCreateOwnMeal.getDrinkCalorieCountLabel().substring(0,8),"CALORIES");
    }

    @Test(description = "Select the Regular Drink for the Meal & Verify Total Price & Total Calorie Count",priority = 9,dependsOnMethods = "navigateToDrink")
    public void selectRegularDrinkAndVerifyTotal(){
        guestCreateOwnMeal.selectRegularDrink();
        Assert.assertEquals(guestCreateOwnMeal.navigateToSelectedItemPageAndCheckTotal(),"£" + guestCreateOwnMeal.calculatePrice());
        Assert.assertEquals(guestCreateOwnMeal.navigateToSelectedItemPageAndCaloriesCount(),guestCreateOwnMeal.calculateCalories());
    }

    @Test(description = "Select all the Meals & Navigate to the Who is this Meal Page",priority = 10,dependsOnMethods = "selectRegularDrinkAndVerifyTotal")
      public void navigateToWhoIstHisMeal(){
        orderSubTotal = guestCreateOwnMeal.navigateToSelectedItemPageAndCheckTotal();
        guestCreateOwnMeal.scrollingToBottomofAPage("http://fbf.calcey.net/create-order");
        guestCreateOwnMeal.navigateToWhoIsThisMealForPage();
        Assert.assertEquals(guestCreateOwnMeal.getWhoIsThisMealForLabel(),"WHO IS THIS MEAL FOR?");
    }

    @Test(description = "Add the GuestName and Click Save Button",priority = 11,dependsOnMethods = "navigateToWhoIstHisMeal")
    public void saveGuestName(){
        addguestName.TypeGuestName();
        addguestName.ClickSaveNameButton();
        Assert.assertTrue(addguestName.navigateToYourOrderPage().equals(addguestName.getGuestName()));
    }


    @Test(description = "Check the Sub Total of the selected items",priority = 12,dependsOnMethods = "saveGuestName")
    public void checkSubTotal(){
        Assert.assertTrue( orderSubTotal.equals(yourOrder.getSubtotal()) );
    }

    @Test(description = "Check the Multiple Sub Total of Item Multiply",priority = 13,dependsOnMethods = "checkSubTotal")
    public void checkItemMultiplySubTotal(){
        //Multiply Meal count
        yourOrder.addtheMealsCount();
        Assert.assertTrue(Double.parseDouble(yourOrder.getSubtotal().substring(1)) == Double.parseDouble(guestCreateOwnMeal.calculatePrice()) * Double.parseDouble(yourOrder.getMultiplier()));

    }

    @Test(description = "Check the Guest Name Label and navigate to Order Page",priority = 14,dependsOnMethods = "checkItemMultiplySubTotal")
    public void checkGuestNameAndNavigateToOrder(){
        guestCreateOwnMeal.scrollingToBottomofAPage("http://fbf.calcey.net/cart");
        yourOrder.TypePostalCard();
        yourOrder.TypeStreetAddress();
        yourOrder.getPostalCodeNotification();

        //scroll down the page
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        yourOrder.checkGuestNameSelector();
        Assert.assertEquals(yourOrder.navigatetoCheckOrderPage(),"Please let us know your name, email to send you an eco-friendly receipt, and mobile number, to let you know your order status");
    }


    @Test(description = "Check the Order count in the Cart",priority = 15,dependsOnMethods = "checkGuestNameAndNavigateToOrder")
    public void checkOrderCount(){

        Assert.assertEquals(checkoutOrder.getCartitemCount(),"1");
    }

    @Test(description = "Add the Guest Details and navigate to the Payment card Page",priority = 16,dependsOnMethods = "checkOrderCount")
    public void addGuestDetailsNavigateToPayment(){
        checkoutOrder.selectDefaultSelectedDate();
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        checkoutOrder.addGuestDetails();
        Assert.assertEquals(checkoutOrder.navigateToPaymentCardPage(),"Pay with card");
    }

    @Test(description = "Add the Card Details and Proceed the Payment",priority = 17,dependsOnMethods = "addGuestDetailsNavigateToPayment")
    public void addCardDetailsProceedPayment(){
        cardPayment.addCardDetails();
    }

    @Test(description = "Navigate To the Order Summery Page and Check the Guest name",priority = 18,dependsOnMethods = "addCardDetailsProceedPayment")
    public void navigateToOrderSummery(){
        cardPayment.clickPaymentProceedButton();
        Assert.assertTrue(cardPayment.navigateToOrderSummeryPage().equals(checkoutOrder.getUserName()));
    }

    @Test(description = "Check the SubTotal from Your Order page and OrderSummery Page",priority = 19,dependsOnMethods = "navigateToOrderSummery")
    public void checkSubtotalValue(){
        Assert.assertTrue(yourOrder.getTotal().equals(orderSummery.getOrderSummeryTotal()));
    }


    @AfterSuite
    public void tearDown() {
// close the browser
        driver.close();
        driver.quit();
    }


}
