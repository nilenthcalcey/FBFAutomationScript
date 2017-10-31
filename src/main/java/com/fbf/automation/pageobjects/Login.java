package com.fbf.automation.pageobjects;

import com.fbf.automation.utils.CommonOperations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Properties;

/**
 * Created by iresh.n on 10/24/2017.
 */
public class Login extends PageBase {

    WebDriver driver = null;
    WebDriverWait wait;
    Properties properties;
    CommonOperations commonOperations;

    By menuBtn = By.xpath("//div[@class='header-col user-col']/a[@class='main-nav-btn']");
    By loginbtn = By.xpath("//div[@class ='main-toggle-menu-container active']//a[contains(.,'LOG IN')]");
    By txt_useremail = By.xpath("//input[@name='email']");
    By txt_password = By.xpath("//input[@name='password']");
    By btn_SignIn = By.xpath("//div[@class='form-group']//button[contains(.,'Sign In')]");
    By lbl_username = By.xpath("//a[@class='main-nav-user']");
    By lbl_userverify = By.xpath("//a[@class='main-nav-user' and text()='Hi, " + getProperties().getProperty("name") + "']");
    By invalidmenuBtn = By.xpath("//a[@class='main-nav-btn   Hover']");
    By lbl_loginerror = By.xpath("//div[@class ='form-group']/div[contains(.,'Username or password is incorrect')]");
    By lbl_loginPageTitle = By.xpath("//h1[@class ='page-title logo-watermark-inner']");


    public Login(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 30);
        this.commonOperations = new CommonOperations();
    }


    public void expandMenuScreenLogin() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(menuBtn));
        wait.until(ExpectedConditions.elementToBeClickable(menuBtn));
        getDriver().findElement(menuBtn).click();

    }

    public void InvalidExpandMenuScreenLogin() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(invalidmenuBtn));
        wait.until(ExpectedConditions.elementToBeClickable(invalidmenuBtn));
        getDriver().findElement(invalidmenuBtn).click();
    }


    public void navigateLoginPage() {


        wait.until(ExpectedConditions.visibilityOfElementLocated(loginbtn));
        wait.until(ExpectedConditions.elementToBeClickable(loginbtn));
        getDriver().findElement(loginbtn).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(txt_useremail));


    }

    public void login() {
        WebElement loginEmailElement = getDriver().findElement(txt_useremail);
        loginEmailElement.clear();
        loginEmailElement.sendKeys(getProperties().getProperty("loginEmail"));
        WebElement loginpassword = getDriver().findElement(txt_password);
        loginpassword.clear();
        loginpassword.sendKeys(getProperties().getProperty("loginPassword"));
        getDriver().findElement(btn_SignIn).click();

    }

    public String getusername() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lbl_userverify));
        wait.until(ExpectedConditions.elementToBeClickable(lbl_username));
        return getDriver().findElement(lbl_username).getText();
    }


    public void InvalidLogin() {
        WebElement loginEmaElement = getDriver().findElement(txt_useremail);
        loginEmaElement.sendKeys(getProperties().getProperty("invalidloginEmail"));
        WebElement loginpassword = getDriver().findElement(txt_password);
        loginpassword.sendKeys(getProperties().getProperty("invalidloginPassword"));
        getDriver().findElement(btn_SignIn).click();

    }

    public String getInvalidLognError() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lbl_loginerror));
        wait.until(ExpectedConditions.elementToBeClickable(lbl_loginerror));
        return getDriver().findElement(lbl_loginerror).getText();
    }

    public String getLoginPageTitle() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lbl_loginPageTitle));
        wait.until(ExpectedConditions.elementToBeClickable(lbl_loginPageTitle));
        return getDriver().findElement(lbl_loginPageTitle).getText();
    }

}




