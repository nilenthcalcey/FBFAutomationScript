package com.fbf.automation.pageobjects;

import com.fbf.automation.utils.CommonOperations;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by nilenth.s on 10/20/2017.
 */
public class FaqPage extends PageBase {

    WebDriver driver = null;
    WebDriverWait wait;

    By menuBtn = By.xpath("//a[@class='main-nav-btn']");
    By menuBtnActive = By.xpath("//a[@class='main-nav-btn active']");
    By quizfactsMenuBtn = By.xpath("//div[@class = 'main-toggle-menu-container active'] //a[contains(.,'Quiz Facts')]");
    By quizfactsPageHeader = By.xpath("//h2[@class='page-title logo-watermark-inner secondary-color']/div[@class='container']");
    By MenuLoginLabel = By.xpath("//a[contains(.,'LOG IN')]");

    public FaqPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 5);
        this.commonOperations = new CommonOperations();
        this.driver = driver;
    }

    public void expandFaqMenu(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(menuBtn));
        wait.until(ExpectedConditions.elementToBeClickable(menuBtn));
        driver.findElement(menuBtn).click();
    }

    public void navigateToQuizfactsPage(){

        wait.until(ExpectedConditions.visibilityOfElementLocated(quizfactsMenuBtn));
        wait.until(ExpectedConditions.elementToBeClickable(quizfactsMenuBtn));
        WebElement element = driver.findElement(quizfactsMenuBtn);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()", element);
        //driver.findElement(quizfactsMenuBtn).click();
    }

    public String getQuizfactsPageHeader(){
        return driver.findElement(quizfactsPageHeader).getText();
    }

    public String getQuizFactsSelectTextColor() {
        String color = driver.findElement(quizfactsMenuBtn).getCssValue("color");
        return color;
    }

    public String getQuizFactsSelectBackColor() {
        String css = driver.findElement(quizfactsMenuBtn).getCssValue("background-color");
        return css;
    }

    public String getQuizFactsTextColor() {
        String color = driver.findElement(quizfactsMenuBtn).getCssValue("color");
        return color;
    }

    public String getQuizFactsBackColor() {
        String css = driver.findElement(quizfactsMenuBtn).getCssValue("background-color");
        return css;
    }

    /*public String getFaqPageTitle() {
        return getDriver().getTitle();
    }

    public void expandMenuScreen() {
        getDriver().findElement(menuBtn).click();
    }*/
}
