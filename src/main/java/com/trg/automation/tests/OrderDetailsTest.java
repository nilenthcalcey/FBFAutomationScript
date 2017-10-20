package com.trg.automation.tests;

import com.trg.automation.DriverFactory;
import com.trg.automation.pageobjects.OrderDetails;
import com.trg.automation.utils.FailureReport;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


/**
 * Created by lahiru.k on 10/10/2017.
 */

@Listeners(value = FailureReport.class)
public class OrderDetailsTest {
    WebDriver driver = null;
    OrderDetails orderDetails;



    String pageTitle = "Firebrand Fresh";

    @BeforeSuite
    public void SetUp() {
        driver = DriverFactory.getDriver();
        orderDetails = new OrderDetails(driver);
    }


    @Test(description = "Verify Home page loaded", priority = 0)
    public void verifyPageElements() {
        String errorMessage = "Home page title not valid.";
        Assert.assertEquals(orderDetails.getHomePageTitle(), pageTitle, errorMessage);
    }

    @Test(description = "Expand the Menu Screen", priority = 1 )
    public void exapandTheMenuScreen()  {
        orderDetails.expandMenuScreen();
        Assert.assertEquals(orderDetails.getMenuScreenDetails(),"CREATE NEW ORDER");
    }

    @Test(description = "Navigate to the Create New Order Page", priority = 2 )
    public void navigateToCreateNewOrderPage(){
        orderDetails.navigateToCreateNewOrderPage();
        Assert.assertEquals(orderDetails.getCreateNewOrderPageHeader(),"SELECT A FAVOURITE MEAL OR CREATE NEW");
    }

    @Test(description = "Navigate to the FireBrand Quiz Page",priority = 3)
    public void navigateToFireBrandQuizPage(){
        orderDetails.navigateToPlayFirebrandQuiz();
        Assert.assertEquals(orderDetails.getFirebrandFreshQuizHeader(),"");
    }
//    @Test(description = "Navigate to Login page", priority = 1)
//    public void navigateToLoginPage() {
//        orderDetails.navigateToLoginPage();
//        Assert.assertEquals(orderDetails.getLoginPageHeader(),"LOG IN");
//    }
//
//    @Test(description = "Navigate to Registration page", priority = 2)
//    public void navigateToRegistrationPage() {
//        orderDetails.navigateToLoginPage();
//        Assert.assertEquals(orderDetails.getLoginPageHeader(),"LOG IN");
//    }

}
