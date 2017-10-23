package com.fbf.automation.pageobjects;

import com.fbf.automation.utils.CommonOperations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.*;

/**
 * Created by nilenth on 10/10/2017.
 */
public class HomePage extends PageBase {
    WebDriver driver = null;
    WebDriverWait wait;

    By loginBtn = By.xpath("//a[contains(.,'login')]");
    By ordernowBtnText = By.xpath("//span[contains(.,'Order Now')]");
    By menuBtn = By.xpath("//a[@class='main-nav-btn']");
    By createneworderBtn = By.xpath("//a[contains(.,'Create new Order')]");
    By selectFavouriteText = By.xpath("//div[@class='fbf-main-content']//h3");
    By playfirebrandquizBtn = By.xpath("//a[contains(.,'Play Firebrand quiz')]");
    By playnowBtn = By.xpath("//a[contains(.,'Play Now')]");
    By firebrandLabel = By.xpath("//div[@class = 'container']//h2/span");
    By quizfactsMenuBtn = By.xpath("//a[contains(.,'Quiz Facts')]");
    By quizfactsPageHeader = By.xpath("//h2[@class='page-title logo-watermark-inner secondary-color']/div[@class='container']");
    By MenuLoginLabel = By.xpath("//a[contains(.,'LOG IN')]");


    //By loginPageTitle = By.xpath("//h1[@class='page-title logo-watermark-inner']");
    //By registrationBtn = By.xpath("//a[contains(.,'Register')]");

    public HomePage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 5);
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
        wait.until(ExpectedConditions.presenceOfElementLocated(MenuLoginLabel));
        getDriver().findElement(playfirebrandquizBtn).click();
    }

    public String getFirebrandFreshQuizHeader(){
        return getDriver().findElement(firebrandLabel).getText();
    }

    public void navigateToQuizFactsPage(){

        wait.until(ExpectedConditions.presenceOfElementLocated(MenuLoginLabel));
        driver.findElement(quizfactsMenuBtn).click();
    }

    public String getQuizFactsPageHeader(){
        return driver.findElement(quizfactsPageHeader).getText();
    }






//    public String getLoginPageHeader() {
//        return getDriver().findElement(loginPageTitle).getText();
//    }

    public void navigateToRegistrationPage(){
        getDriver().findElement(loginBtn).click();

    }


}

