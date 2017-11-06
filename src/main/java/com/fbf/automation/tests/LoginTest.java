package com.fbf.automation.tests;

import com.fbf.automation.DriverFactory;
import com.fbf.automation.pageobjects.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

/**
 * Created by iresh.n on 10/24/2017.
 */
public class LoginTest {


    WebDriver driver = null;
    Login login;
    MailClient mailClient;
    HomePage homepage;
    HomePageTest homepageTest;


    @BeforeSuite
    public void SetUp() {
        driver = DriverFactory.getDriver();
        login = new Login(driver);
        homepage = new HomePage(driver);
        mailClient = new MailClient(driver);
    }

    @Test(description = "Verify Expand the Menu", priority = 0)
    public void navigateloginpage() {

        login.expandMenuScreenLogin();
        login.navigateLoginPage();
        Assert.assertEquals(login.getLoginPageTitle(), "LOG IN");

    }

    @Test(description = "User login withInvalidEmail", priority = 1)
    public void invalidloginTest() {
        login.InvalidLogin();
        Assert.assertEquals(login.getInvalidLognError(), "Username or password is incorrect");
    }


    @Test(description = "User login Sucessfully", priority = 2)
    public void sucesslogin() {
        login.login();
        Assert.assertEquals(login.getusername(), "HI, FBF");
    }

    @Test(description = "Check User availability", priority = 3)
    public void userAvailability() {
        login.expandMenuScreenLogin();
        login.checkUserAvailability();
    }


    @Test(description = "Navigate To the Forgot Password Page", priority = 4, dependsOnMethods = "userAvailability")
    public void navigateToForgotPasswordPage() {
        //login.expandMenuScreenLogin();
        //login.navigateLoginPage();
        login.navigateToForgotPassword();
        Assert.assertEquals(login.getForgotPasswordHeader(), "FORGOT PASSWORD");
    }

    @Test(description = "Verify credentials are sent to the specific email", priority = 5, dependsOnMethods = "navigateToForgotPasswordPage")
    public void visibleResetEmailValidation() throws InterruptedException {
        login.sendResetEmail();
        login.testVerifyPopup();
        //login.passResetEmail();
        //Assert.assertEquals(login.getResetEmailValid(), "Please check your E-mail to reset your password");
    }

   /* @Test(description = "Verify credentials are sent to the specific email", priority = 5, dependsOnMethods = "navigateToForgotPasswordPage")
    public void visibleResetEmailValidation() throws InterruptedException {
        login.testVerifyPopup();
        //login.sendResetEmail();
        //login.passResetEmail();
        //Assert.assertEquals(login.getResetEmailValid(), "Please check your E-mail to reset your password");
    }*/

    @Test(description = "Check Password reset Email Availability in Mailinator", priority = 6, dependsOnMethods ="visibleResetEmailValidation")
    public void pwResetEmaiAvailability() throws InterruptedException {
        mailClient.openNewTab();
        mailClient.navigateToMailList();
        mailClient.latestMailAvailability();
        Assert.assertEquals(mailClient.getResetEmaiTitle(), "Reset Password");
    }

    @Test(description = "User Navigate to Password Fixing Page", priority = 7, dependsOnMethods ="pwResetEmaiAvailability")
    public void navigatePwFixPage() {
        mailClient.navigateToPasswordFixPage();
        Assert.assertEquals(login.getPasswordFixTitle(), "PLEASE ENTER A NEW PASSWORD");
    }

    @Test(description = "Submit new password", priority = 8, dependsOnMethods = "navigatePwFixPage")
    public void submitNewPassword() throws InterruptedException {
        login.resetNewPassword();
        login.reLogin();
        Assert.assertEquals(login.getusername(), "HI, FBF");
    }
/*
    @AfterSuite
    public void TearDown() {

        driver.close();
    }*/
}

