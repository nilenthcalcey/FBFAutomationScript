package com.fbf.automation.tests;

import com.fbf.automation.DriverFactory;
import com.fbf.automation.pageobjects.HomePage;
import com.fbf.automation.utils.FailureReport;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


/**
 * Created by nilenth on 10/10/2017.
 */

@Listeners(value = FailureReport.class)
public class HomePageTest {
    WebDriver driver = null;
    HomePage homePage;

    String pageTitle = "Firebrand Fresh";

    @BeforeSuite
    public void SetUp() {
        driver = DriverFactory.getDriver();
        homePage = new HomePage(driver);
    }


    @Test(description = "Verify Home page loaded", priority = 0)
    public void verifyPageElements() {
        String errorMessage = "Home page title not valid.";
        Assert.assertEquals(homePage.getHomePageTitle(), pageTitle, errorMessage);
    }

    @Test(description = "Expand the Menu Screen", priority = 1 )
    public void exapandTheMenuScreen()  {
        homePage.expandMenuScreen();
        Assert.assertEquals(homePage.getMenuScreenDetails(),"CREATE NEW ORDER");
    }

    /*@Test(description = "Navigate to the Create New Order Page", priority = 2 )
    public void navigateToCreateNewOrderPage(){
        orderDetails.navigateToCreateNewOrderPage();
        Assert.assertEquals(orderDetails.getCreateNewOrderPageHeader(),"SELECT A FAVOURITE MEAL OR CREATE NEW");
    }
*/
    @Test(description = "Navigate to the FireBrand Quiz Page",priority = 2)
    public void navigateToFireBrandQuizPage(){
        homePage.navigateToPlayFirebrandQuiz();
        Assert.assertEquals(homePage.getFirebrandFreshQuizHeader(),"Firebrand");
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
