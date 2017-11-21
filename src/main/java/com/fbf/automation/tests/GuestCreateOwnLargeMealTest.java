package com.fbf.automation.tests;

import com.fbf.automation.DriverFactory;
import com.fbf.automation.pageobjects.*;
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

    WebDriver driver = null;
    GuestCreateOwnLargeMeal guestCreateOwnLargeMeal;
    HomePage homepage;
    GuestCreateOwnMeal guestCreateOwnMeal;
    AddGuestName addGuestName;
    YourOrder yourOrder;
    CheckoutOrder checkoutOrder;
    CardPayment cardPayment;
    OrderSummery orderSummery;

    String pageTitle = "Firebrand Fresh";

    @BeforeSuite
    public void SetUp()
    {

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

        guestCreateOwnMeal.scrollingToBottomofAPage();
        guestCreateOwnLargeMeal.navigateToSaveMealPage();
        Assert.assertEquals(guestCreateOwnMeal.getWhoIsThisMealForLabel(),"WHO IS THIS MEAL FOR?");

    }

    @Test(description = "Verify Enter The Meal Name ", priority = 13)
    public void SaveName()
    {


        guestCreateOwnLargeMeal.saveName();
        Assert.assertEquals(addGuestName.navigateToYourOrderPage(),"GUEST NAME");
    }

    @Test(description = "Verify User enter delivery details", priority = 14)
    public void EnterDeliveryDetails()
    {
        yourOrder.TypePostalCard();
        yourOrder.TypeStreetAddress();
        yourOrder.getPostalCodeNotification();

        //scroll down the page
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        yourOrder.checkLargeGuestNameSelector();
        Assert.assertEquals(yourOrder.navigatetoCheckOrderPage(),"Please let us know your name, email to send you an eco-friendly receipt, and mobile number, to let you know your order status");
    }



    @Test(description = "Verify enter User details and redirect to the Card Page", priority = 15)
    public void EnterUserDetails()
    {
        checkoutOrder.EnterLargeUserDetails();
        Assert.assertEquals(checkoutOrder.navigateToPaymentCardPage(),"Pay with card");
    }



    @Test(description = "Verify enter User Card details and redirect to the Order Confirmation Page", priority = 16)
    public void EnterCardDetails()
    {
        cardPayment.addCardDetails();
        cardPayment.clickPaymentProceedButton();
        Assert.assertEquals(orderSummery.getUserName(),checkoutOrder.getLargeUserName());
    }


   @AfterSuite
    public void TearDown()
   {

        driver.close();
   }


}
