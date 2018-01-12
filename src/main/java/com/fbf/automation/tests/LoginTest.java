package com.fbf.automation.tests;

import com.fbf.automation.DriverFactory;
import com.fbf.automation.pageobjects.*;
import com.fbf.automation.utils.CommonOperations;
import com.fbf.automation.utils.FailureReport;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.Assert;
import org.testng.annotations.*;
import com.fbf.automation.pageobjects.HomePage;

/**
 * Created by iresh.n on 10/24/2017.
 */
@Listeners(value = FailureReport.class)
public class LoginTest extends TestBase {

    Login login;
    MailClient mailClient;

    @BeforeClass(alwaysRun = true)
    public void SetUp() throws Exception {
        login = new Login(getDriver(), null);
        mailClient = new MailClient(getDriver());
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
}

