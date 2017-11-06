package com.fbf.automation.pageobjects;

import com.fbf.automation.utils.CommonOperations;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

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
    By resetPassword = By.xpath("//form[@class='ng-untouched ng-pristine ng-invalid']/div[3]/a/u");
    By forgotPasswordHeader = By.xpath("//div[@class='fbf-main-content']/div/h2/div");
    By emailTextBox = By.xpath("//form[@class='ng-untouched ng-pristine ng-invalid']/div/input");
    By emailSubmitBtn = By.xpath("//form[@class='ng-untouched ng-dirty ng-valid']/div[2]/button");
    By resetEmailValid = By.xpath("//div[@class='alert-list']/div/nac-alert/div/span");
    //By loginBtn = By.xpath("//div[@class='fbf-main-navogation']/div/a[2]/i");

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

        this.driver = driver;
        //driver.get("http://fbf.qa/orders");
    }

    /*public void navigateToLoginPage(){

        wait.until(ExpectedConditions.visibilityOfElementLocated(loginBtn));
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        WebElement element = driver.findElement(loginBtn);
        *//*JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()", element);*//*
        driver.findElement(loginBtn).click();
    }*/

    public void navigateToForgotPassword(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(resetPassword));
        wait.until(ExpectedConditions.elementToBeClickable(resetPassword));
        /*WebElement element = driver.findElement(resetPassword);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()", element);*/
        driver.findElement(resetPassword).click();
    }

    public String getForgotPasswordHeader(){
        return driver.findElement(forgotPasswordHeader).getText();
    }

    public void sendResetEmail(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailTextBox));
        driver.findElement(emailTextBox).sendKeys("fbfauto@mailinator.com");
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailSubmitBtn));
        wait.until(ExpectedConditions.elementToBeClickable(emailSubmitBtn));
        /*WebElement element = driver.findElement(emailTextBox);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()", element);*/
        driver.findElement(emailSubmitBtn).click();
    }

    public String getResetEmailValid(){
        return driver.findElement(resetEmailValid).getText();
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




