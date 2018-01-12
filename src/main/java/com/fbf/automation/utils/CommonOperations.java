package com.fbf.automation.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;


/**
 * Common methods
 */
public class CommonOperations {
    int sleepTime;
    private WebDriver driver;
    public CommonOperations() {
        this.sleepTime = 1000;
    }

    public CommonOperations(int sleep, int tries) {
        this.sleepTime = sleep;
    }

    public boolean isPageLoading(WebDriver d) {
        JavascriptExecutor js = (JavascriptExecutor)d;
        String strExec = "return document.readyState!=\'complete\';";
        return ((Boolean)js.executeScript(strExec, new Object[0])).booleanValue();
    }

    public void waitUntilPageLoaded(WebDriver driver) {
        while(this.isPageLoading(driver)) {
            try {
                Thread.sleep((long)this.sleepTime);
            } catch (InterruptedException var3) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public boolean waitForAnElementDisplayed(WebDriver driver, By condition, int tries, int sleeptime) {
        for(int count = 0; count < tries; ++count) {
            try {
                WebElement e = driver.findElement(condition);
                if(e.isDisplayed()) {
                    return true;
                }

                try {
                    Thread.sleep((long)sleeptime);
                } catch (InterruptedException var9) {
                    Thread.currentThread().interrupt();
                }
            } catch (Exception var10) {
                try {
                    Thread.sleep((long)sleeptime);
                } catch (InterruptedException var8) {
                    Thread.currentThread().interrupt();
                }
            }
        }

        return false;
    }

    public int randomInt(int min, int max) {
        if(min > max) {
            int rand = min;
            min = max;
            max = rand;
        }

        Random rand1 = new Random();
        int randomNumber = rand1.nextInt(max - min + 1) + min;
        return randomNumber;
    }

    public WebElement getVisibleElement(List<WebElement> errorMessageContainerList) {
        return errorMessageContainerList.stream().filter(errorMessageContainer -> errorMessageContainer
                .isDisplayed()).findFirst().get();
    }

    public WebElement waitUntilElementVisible(WebDriver driver, WebElement element, int delay) {
        WebDriverWait wait = new WebDriverWait(driver, delay);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitUntilElementVisible(WebDriver driver, By elementLocator, int delay) {
        WebDriverWait wait = new WebDriverWait(driver, delay);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
    }

    public boolean waitUntilElementInvisible(WebDriver driver, By elementLocator, int delay) {
        WebDriverWait wait = new WebDriverWait(driver, delay);
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(elementLocator));
    }

    public void takeScreenShotOnFailure(String methodName) {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + File.separator + "screenShots" + File.separator;
        System.out.println("Take screen shot to '" + path + "'.");
        try {
            FileUtils.copyFile(scrFile, new File(path + methodName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



