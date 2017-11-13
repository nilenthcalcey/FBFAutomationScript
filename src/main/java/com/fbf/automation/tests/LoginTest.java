package com.fbf.automation.tests;

import com.fbf.automation.DriverFactory;
import com.fbf.automation.pageobjects.GuestCreateOwnMeal;
import com.fbf.automation.pageobjects.HomePage;
import com.fbf.automation.pageobjects.Login;
import com.fbf.automation.pageobjects.RegularProtein;
import com.fbf.automation.utils.FailureReport;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestListener;
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
        HomePage homepage;
        HomePageTest homepageTest;


        @BeforeSuite
        public void SetUp() {
            driver = DriverFactory.getDriver();
            login = new Login(driver);
            homepage = new HomePage(driver);
        }

        @Test(description = "Verify Expand the Menu", priority = 0)
        public void navigateloginpage() {

            login.expandMenuScreenLogin();
            login.navigateLoginPage();
            Assert.assertEquals(login.getLoginPageTitle(), "LOG IN");

        }


        @Test(description = "User login Sucessfully", priority = 2)
        public void sucesslogin() {

            login.login();
            Assert.assertEquals(login.getusername(), "HI, IRESH");
        }

        @Test(description = "User login withInvalidEmail", priority = 1)
        public void invalidloginTest() {
            login.InvalidLogin();
            Assert.assertEquals(login.getInvalidLognError(), "Username or password is incorrect");
        }

        @AfterSuite
        public void TearDown() {

            driver.close();
        }

}

