package com.fbf.automation.pageobjects;


import com.fbf.automation.utils.CommonOperations;
import org.openqa.selenium.WebDriver;

/**
 * Created by lahiru.k on 10/16/2017.
 */
public class CreateNewOrder extends PageBase {
    public CreateNewOrder(WebDriver driver) {
        super(driver);
        this.commonOperations = new CommonOperations();
        driver.get("http://fbf.qa/orders");
    }
}
