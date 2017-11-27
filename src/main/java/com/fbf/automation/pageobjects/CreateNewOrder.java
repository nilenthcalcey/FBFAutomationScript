package com.fbf.automation.pageobjects;


import com.fbf.automation.utils.CommonOperations;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by lahiru.k on 10/16/2017.
 */
public class CreateNewOrder extends PageBase {

    WebDriver driver = null;
    WebDriverWait wait;

    By menuBtn = By.xpath("//a[@class='main-nav-btn']");
    By menuBtnActive = By.xpath("//a[@class='main-nav-btn active']");
    By createNewOrderLabel = By.xpath("//div[@class='fbf-ordertime-container']/div[2]/label/span");
    By firebrandQuizMenuBtn = By.xpath("//a[contains(.,'FAQ')]");
    By firebrandQuizPageHeader = By.xpath("//div[@class='fbf-main-content']/div/h2/div");
    By MenuLoginLabel = By.xpath("//a[contains(.,'LOG IN')]");

    public CreateNewOrder(WebDriver driver) {
        /*super(driver);
        this.commonOperations = new CommonOperations();
        driver.get("http://fbf.qa/orders");*/
        super(driver);
        this.wait = new WebDriverWait(driver, 30);
        this.commonOperations = new CommonOperations();
        this.driver = driver;
    }

    public void expandCreateNewOrderMenu() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(menuBtn));
        wait.until(ExpectedConditions.elementToBeClickable(menuBtn));
        driver.findElement(menuBtn).click();
    }

    public void closeCreateNewOrderMenu() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(menuBtnActive));
        wait.until(ExpectedConditions.elementToBeClickable(menuBtnActive));
       /* WebElement element = driver.findElement(menuBtnActive);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()", element);*/
        driver.findElement(menuBtnActive).click();
    }

    public String getCreateNewOrderLabel() {
        return driver.findElement(createNewOrderLabel).getText();
    }


}
