package com.fbf.automation.tests;

import com.fbf.automation.DriverFactory;
import com.fbf.automation.pageobjects.*;
import com.fbf.automation.utils.CommonOperations;
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
    CommonOperations common;

    @BeforeSuite
    public void setUp() {
        driver = DriverFactory.getDriver();
        login = new Login(driver, null);
        homepage = new HomePage(driver);
        mailClient = new MailClient(driver);
        common = new CommonOperations();
    }

    public WebDriver getDriverDetails() {
        return driver;
    }

    @Test(description = "Verify Expand the Menu", priority = 0)
    public void navigateloginpage() {
        login.expandMenuScreenLogin();
        login.navigateLoginPage();
    }

    @Test(description = "User login Sucessfully", priority = 2)
    public void successLogin() {
        login.login();
    }

    @Test(description = "User login withInvalidEmail", priority = 1)
    public void invalidLoginTest() {
        login.invalidLogin();
    }

    @Test(description = "Check User availability", priority = 3)
    public void userAvailability() {
        login.expandMenuScreenLogin();
        login.checkUserAvailability();
    }

    @Test(description = "Navigate To the Forgot Password Page", priority = 4, dependsOnMethods = "userAvailability")
    public void navigateToForgotPasswordPage() {
        login.navigateToForgotPassword();
    }

    @Test(description = "Insert Invalid Email", priority = 5, dependsOnMethods = "navigateToForgotPasswordPage")
    public void invalidResetEmailTest() throws InterruptedException {
        login.sendInvalidResetEmail();
    }

    @Test(description = "Verify credentials are sent to the specific email", priority = 6, dependsOnMethods = "invalidResetEmailTest")
    public void visibleResetEmailValidation() throws InterruptedException {
        login.sendResetEmail();
    }

    @Test(description = "Check Password reset Email Availability in Mailinator", priority = 7, dependsOnMethods = "visibleResetEmailValidation")
    public void pwResetEmaiAvailability() throws InterruptedException {
        mailClient.openNewTab();
        mailClient.navigateToMailList();
        mailClient.latestMailAvailability();
    }

    @Test(description = "User Navigate to Password Fixing Page", priority = 8, dependsOnMethods = "pwResetEmaiAvailability")
    public void navigatePwFixPage() {
        mailClient.navigateToPasswordFixPage();
        login.getPasswordFixTitle();
    }

    @Test(description = "Submit new password", priority = 9, dependsOnMethods = "navigatePwFixPage")
    public void submitNewPassword() throws InterruptedException {
        login.resetNewPassword();
        login.reLogin();
    }

    @AfterSuite
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}

