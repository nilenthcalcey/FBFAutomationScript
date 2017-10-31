package com.fbf.automation.pageobjects;

import com.fbf.automation.utils.CommonOperations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by lahiru.k on 10/20/2017.
 */
public class FirebrandQuiz extends PageBase {
    WebDriver driver = null;
    WebDriverWait wait;

    By menuBtn = By.xpath("//a[@class='main-nav-btn']");
    By menuBtnActive = By.xpath("//a[@class='main-nav-btn active']");
    By quizfactsMenuBtn = By.xpath("//div[@class = 'main-toggle-menu-container active'] //a[contains(.,'Quiz Facts')]");
    By quizfactsPageHeader = By.xpath("//h2[@class='page-title logo-watermark-inner secondary-color']/div[@class='container']");
    By MenuLoginLabel = By.xpath("//a[contains(.,'LOG IN')]");


    public FirebrandQuiz(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 30);
        this.commonOperations = new CommonOperations();
        this.driver = driver;
    }

    public void expandMenuFQuizScreen(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(menuBtn));
        wait.until(ExpectedConditions.elementToBeClickable(menuBtn));
        driver.findElement(menuBtn).click();
    }

    public void navigateToQuizFactsPage(){

        wait.until(ExpectedConditions.visibilityOfElementLocated(quizfactsMenuBtn));
        wait.until(ExpectedConditions.elementToBeClickable(quizfactsMenuBtn));
        driver.findElement(quizfactsMenuBtn).click();
    }

    public String getQuizFactsPageHeader(){

        return driver.findElement(quizfactsPageHeader).getText();
    }
}
