package com.fbf.automation.tests;

import com.fbf.automation.DriverFactory;
import com.fbf.automation.pageobjects.*;
import com.fbf.automation.utils.FailureReport;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Created by iresh.n on 10/24/2017.
 */
//public class FailureReport implements ITestListener {
@Listeners(value = FailureReport.class)
public class LoginTest {


    WebDriver driver = null;
    Login login;
    MailClient mailClient;
    HomePage homepage;
    HomePageTest homepageTest;


    @BeforeSuite
    public void setUp() {
        driver = DriverFactory.getDriver();
        login = new Login(driver,null);
        homepage = new HomePage(driver);
        mailClient = new MailClient(driver);
    }

    @Test(description = "Verify Expand the Menu", priority = 0)
    public void navigateloginpage() {
        login.expandMenuScreenLogin();
        login.navigateLoginPage();
        Assert.assertEquals(login.getLoginPageTitle(), "LOG IN");
    }

    @Test(description = "User login Sucessfully", priority = 2)
    public void successLogin() {
        login.login();
        Assert.assertEquals(login.getUsername(), "HI, FBF");
    }

    @Test(description = "User login withInvalidEmail", priority = 1)
    public void invalidLoginTest() {
        login.invalidLogin();
        Assert.assertEquals(login.getInvalidLoginError(), "Username or password is incorrect");
    }

    @Test(description = "Check User availability", priority = 3)
    public void userAvailability() {
        login.expandMenuScreenLogin();
        login.checkUserAvailability();
    }

    @Test(description = "Navigate To the Forgot Password Page", priority = 4, dependsOnMethods = "userAvailability")
    public void navigateToForgotPasswordPage() {
        login.navigateToForgotPassword();
        Assert.assertEquals(login.getForgotPasswordHeader(), "FORGOT PASSWORD");
    }

    @Test(description = "Insert Invalid Email", priority = 5, dependsOnMethods = "navigateToForgotPasswordPage")
    public void invalidResetEmailTest() throws InterruptedException {
        login.sendInvalidResetEmail();
        Assert.assertEquals(login.getForgotPasswordHeader(), "FORGOT PASSWORD");
    }

    @Test(description = "Verify credentials are sent to the specific email", priority = 6, dependsOnMethods = "invalidResetEmailTest")
    public void visibleResetEmailValidation() throws InterruptedException {
        login.sendResetEmail();
        Assert.assertNull(login.testVerifyPopup());
    }

    @Test(description = "Check Password reset Email Availability in Mailinator", priority = 7, dependsOnMethods = "visibleResetEmailValidation")
    public void pwResetEmaiAvailability() throws InterruptedException {
        mailClient.openNewTab();
        mailClient.navigateToMailList();
        mailClient.latestMailAvailability();
        Assert.assertEquals(mailClient.getResetEmailTitle(), "Reset Password");
    }

    @Test(description = "User Navigate to Password Fixing Page", priority = 8, dependsOnMethods = "pwResetEmaiAvailability")
    public void navigatePwFixPage() {
        mailClient.navigateToPasswordFixPage();
        Assert.assertEquals(login.getPasswordFixTitle(), "RESET YOUR PASSWORD");
    }

    @Test(description = "Submit new password", priority = 9, dependsOnMethods = "navigatePwFixPage")
    public void submitNewPassword() throws InterruptedException {
        //login.getRandomNumber();
        login.resetNewPassword();
        login.reLogin();
        Assert.assertEquals(login.getUsername(), "HI, FBF");
    }

    @AfterSuite
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}

