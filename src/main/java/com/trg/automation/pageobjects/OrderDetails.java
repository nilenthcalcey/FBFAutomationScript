package com.trg.automation.pageobjects;

import com.trg.automation.DriverType;
import com.trg.automation.utils.CommonOperations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.lang.*;
import java.util.Properties;

/**
 * Created by nilenth on 10/10/2017.
 */
public class OrderDetails extends PageBase {
    WebDriver driver = null;

    By loginBtn = By.xpath("//a[contains(.,'login')]");
    By ordernowBtnText = By.xpath("//span[contains(.,'Order Now')]");
    By menuBtn = By.xpath("//a[@class='main-nav-btn']");
    By createneworderBtn = By.xpath("//a[contains(.,'Create new Order')]");
    By selectFavouriteText = By.xpath("//div[@class='fbf-main-content']//h3");
    By playfirebrandquizBtn = By.xpath("//a[contains(.,'Play Firebrand quiz')]");
    By playnowBtn = By.xpath("//a[contains(.,'Play Now')]");
    By firebrandLabel = By.xpath("//div[@class = 'container']//h2/span");

    //By loginPageTitle = By.xpath("//h1[@class='page-title logo-watermark-inner']");
    //By registrationBtn = By.xpath("//a[contains(.,'Register')]");

    public OrderDetails(WebDriver driver) {
        super(driver);
        this.commonOperations = new CommonOperations();
        this.driver = driver;
        //driver.get("http://fbf.qa/orders");
    }
    boolean bValue = false;

    public String getHomePageTitle() {
        return getDriver().getTitle();
    }




    public void navigateToLoginPage() {
        driver.findElement(loginBtn).click();
    }

    public void expandMenuScreen(){
        getDriver().findElement(menuBtn).click();
    }

    public String getMenuScreenDetails(){
        return getDriver().findElement(createneworderBtn).getText();
    }

    public void navigateToCreateNewOrderPage(){
        getDriver().findElement(createneworderBtn).click();
    }

    public String getCreateNewOrderPageHeader(){
        return getDriver().findElement(selectFavouriteText).getText();
    }

    public void navigateToPlayFirebrandQuiz(){
        getDriver().findElement(playfirebrandquizBtn).click();
    }

    public String getFirebrandFreshQuizHeader(){
        return getDriver().findElement(firebrandLabel).getText();
    }





//    public String getLoginPageHeader() {
//        return getDriver().findElement(loginPageTitle).getText();
//    }

    public void navigateToRegistrationPage(){
        getDriver().findElement(loginBtn).click();

    }


}

