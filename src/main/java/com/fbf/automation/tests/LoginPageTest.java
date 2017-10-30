package com.fbf.automation.tests;

import com.fbf.automation.DriverFactory;
import com.fbf.automation.pageobjects.GuestCreateOwnMeal;
import com.fbf.automation.pageobjects.HomePage;
import com.fbf.automation.pageobjects.Login;
import com.fbf.automation.pageobjects.RegularProtein;
import com.fbf.automation.utils.FailureReport;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(value = FailureReport.class)
public class LoginPageTest {
    WebDriver driver = null;
    Login login;

    //String pageTitle = "Firebrand Fresh";

    @BeforeSuite
    public void SetUp() {
        driver = DriverFactory.getDriver();
        login = new Login(driver);
    }

    @Test(description = "Navigate To the Forgot Password Page", priority = 1/*, dependsOnMethods = ""*/)
    public void navigateToForgotPasswordPage() {
        login.navigateToForgotPassword();
        Assert.assertEquals(login.getForgotPasswordHeader(), "FORGOT PASSWORD");
    }

    @Test(description = "Verify credentials are sent to the specific email", priority = 2, dependsOnMethods = "navigateToForgotPasswordPage")
    public void visibleResetEmailValidation() {
        login.sendResetEmail();
        Assert.assertEquals(login.getResetEmailValid(), "Please check your E-mail to reset your password");
    }
}