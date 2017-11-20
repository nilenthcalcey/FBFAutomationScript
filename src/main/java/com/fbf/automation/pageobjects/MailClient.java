package com.fbf.automation.pageobjects;

import com.fbf.automation.utils.CommonOperations;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Properties;

/**
 * Created by gishan.n on 10/26/2017.
 */

public class MailClient extends PageBase {

    WebDriver driver = null;
    WebDriverWait wait;

    Properties properties;
    CommonOperations commonOperations;
    CheckoutOrder checkoutOrder;


    //Mailinator Tags
    By mailText = By.xpath("//div[@class=\"input-group\"]/input");
    By goButton = By.xpath("//div[@class=\"input-group\"]//button");
    By fbfPwResetMail = By.xpath("//ul[@id='inboxpane']/li[1]/div");
    By resetEmailTitle = By.xpath("//div[@id='msgpane']/div/div[contains(.,'Reset Password')]");
    By resetPasswordMailBtn = By.xpath("html/body/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[6]/td/div/a");


    public MailClient(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 30);
        this.commonOperations = new CommonOperations();

        this.driver = driver;
        //driver.get("http://fbf.qa/orders");
    }

    public void openNewTab() throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://www.mailinator.com");
    }

    public void navigateToMailList() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(mailText));
        wait.until(ExpectedConditions.elementToBeClickable(mailText));
        WebElement mailinatorEmailEntry = getDriver().findElement(mailText);
        mailinatorEmailEntry.sendKeys(getProperties().getProperty("resetEmail"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(goButton));
        wait.until(ExpectedConditions.elementToBeClickable(goButton));
        getDriver().findElement(goButton).click();
    }

    public void latestMailAvailability() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(fbfPwResetMail));
        wait.until(ExpectedConditions.elementToBeClickable(fbfPwResetMail));
        getDriver().findElement(fbfPwResetMail).click();
    }

    public String getResetEmaiTitle() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(resetEmailTitle));
        wait.until(ExpectedConditions.elementToBeClickable(resetEmailTitle));
        return getDriver().findElement(resetEmailTitle).getText();
    }

    public void navigateToPasswordFixPage() {
        driver.switchTo().frame(driver.findElement(By.xpath("html/body/main/section/div[1]/iframe")));
        driver.findElement(resetPasswordMailBtn).click();
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(2));
    }

    public void navigateToConfirmationMailList(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(mailText));
        wait.until(ExpectedConditions.elementToBeClickable(mailText));
        driver.findElement(mailText).sendKeys(checkoutOrder.guestEmail);
        wait.until(ExpectedConditions.visibilityOfElementLocated(goButton));
        wait.until(ExpectedConditions.elementToBeClickable(goButton));
        getDriver().findElement(goButton).click();
    }
}

