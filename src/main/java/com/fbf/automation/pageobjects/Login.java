package com.fbf.automation.pageobjects;

import com.fbf.automation.utils.CommonOperations;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login extends PageBase {

    WebDriver driver = null;
    WebDriverWait wait;

    By resetPassword = By.xpath("//form[@class='ng-untouched ng-pristine ng-invalid']/div[3]/a/u");
    By forgotPasswordHeader = By.xpath("//div[@class='fbf-main-content']/div/h2/div");
    By emailTextBox = By.xpath("//form[@class='ng-untouched ng-pristine ng-invalid']/div/input");
    By emailSubmitBtn = By.xpath("//form[@class='ng-untouched ng-dirty ng-valid']/div[2]/button");
    By resetEmailValid = By.xpath("//div[@class='alert-list']/div/nac-alert/div/span");
    //By loginBtn = By.xpath("//div[@class='fbf-main-navogation']/div/a[2]/i");

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

    

}
