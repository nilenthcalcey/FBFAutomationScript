package com.fbf.automation.pageobjects;

import com.fbf.automation.utils.CommonOperations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by nilenth.s on 10/20/2017.
 */
public class FaqPage extends PageBase {

    WebDriver driver = null;
    WebDriverWait wait;

    By menuBtn = By.xpath("//a[@class='main-nav-btn']");

    public FaqPage(WebDriver driver){
        super(driver);
        this.wait = new WebDriverWait(driver, 5);
        this.commonOperations = new CommonOperations();
        this.driver = driver;
    }

    public String getFaqPageTitle() {
        return getDriver().getTitle();
    }

    public void expandMenuScreen(){
        getDriver().findElement(menuBtn).click();
    }
}
