package com.fbf.automation.pageobjects;

import com.fbf.automation.utils.CommonOperations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by lahiru.k on 11/7/2017.
 */
public class CardPayment extends PageBase {
    WebDriver driver = null;
    WebDriverWait wait;
    CheckoutOrder checkoutOrder;

    By cardnumberTextBox = By.xpath("//div[@class='braintree-sheet__content braintree-sheet__content--form']/div[1]//div[@class='braintree-form__field']");
    By expirationdateTextBox = By.xpath("//div[@class='braintree-sheet__content braintree-sheet__content--form']/div[2]//div[@class='braintree-form__hosted-field braintree-form-expiration']");
    By cvvTextBox = By.xpath("//div[@class='braintree-sheet__content braintree-sheet__content--form']/div[2]//div[@class='braintree-form__hosted-field braintree-form-cvv']");
    By paymentproceedButton = By.xpath("//button[@class='btn btn-primary btn-block']");
    By ordersummerynameLabel = By.xpath("//table[@class='summary-table']//tr[1]//td[@class='font-bold']");

    public CardPayment(WebDriver driver) {
        super(driver);
        this.commonOperations = new CommonOperations();
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        CheckoutOrder checkoutOrder = new CheckoutOrder(driver);
        String guestuserName = checkoutOrder.userName;
    }

    public void addCardDetails() {
        File file = new File("src\\main\\resources\\CardPayment.properties");

        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Properties prop = new Properties();

        //load properties file
        try {
            prop.load(fileInput);
        } catch (IOException e) {
            e.printStackTrace();
        }
        WebElement CardnumberTextBox = getDriver().findElement(cardnumberTextBox);
        WebElement ExpiredateTextBox = getDriver().findElement(expirationdateTextBox);
        WebElement CvvnumberTextBox = getDriver().findElement(cvvTextBox);
        Actions actions = new Actions(driver);
        //AddCardNumber
        actions.moveToElement(CardnumberTextBox);
        actions.click();
        actions.sendKeys(prop.getProperty("cardNumber"));
        actions.build().perform();
        //Add Expiredate
        actions.moveToElement(ExpiredateTextBox);
        actions.click();
        actions.sendKeys(prop.getProperty("expireDate"));
        actions.build().perform();
        //Add CVV Number
        actions.moveToElement(CvvnumberTextBox);
        actions.click();
        actions.sendKeys(prop.getProperty("cvvNumber"));
        actions.build().perform();
    }

    public void clickPaymentProceedButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(paymentproceedButton));
        wait.until(ExpectedConditions.elementToBeClickable(paymentproceedButton));
        driver.findElement(paymentproceedButton).click();
    }

    public String navigateToOrderSummeryPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ordersummerynameLabel));
        return driver.findElement(ordersummerynameLabel).getText();

    }

}
