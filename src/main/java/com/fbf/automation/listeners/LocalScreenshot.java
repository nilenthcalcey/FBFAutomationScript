package com.fbf.automation.listeners;

import com.fbf.automation.DriverFactory;
import com.fbf.automation.pageobjects.PageBase;
import com.fbf.automation.tests.HomePageTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
import java.io.File;
import java.lang.reflect.InvocationTargetException;

public class LocalScreenshot extends TestListenerAdapter {
    String Seperator = System.getProperty("file.separator");

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = null;
        Reporter.setCurrentTestResult(result);
        String sTestClassName = result.getTestClass().getRealClass().getSimpleName();
        System.out.println("Test class name ..." + sTestClassName);
        String sFileName = result.getName();
        System.out.println("Test method name ..." + sFileName);

        /*Object currentClass = result.getInstance();
        WebDriver webDriver = ((PageBase) currentClass).getDriver();
        driver = HomePageTest.getDriverDetails();
        driver = result.getInstance().getClass(result.getTestClass().getName());
        driver = result.getInstance().getDriverDetails(result.getTestClass().getName());*/

        // The following method is used in order to call the getdrivermethod from each test class
        try {
            driver = (WebDriver) result.getInstance().getClass().getMethod("getDriverDetails").invoke(null);
            String imagePathInHost = "file:///" + System.getProperty("user.dir") + Seperator + "screenshots" + Seperator + "LatestResults" + Seperator + sTestClassName + Seperator + captureScreenshot(driver, sTestClassName, sFileName);
            System.out.println("Image path...." + imagePathInHost);
            Reporter.log("<a href=" + imagePathInHost + "> <img width='100' height='100' src=" + imagePathInHost + "> </a>");
            Reporter.setCurrentTestResult(null);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

    public String captureScreenshot(WebDriver driver, String sTestClassName, String sFileName) {
        sFileName = sFileName + ".png";
        try {
            File file = new File("screenshots" + Seperator + "LatestResults");
            if (!file.exists()) {
                System.out.println("File created somewhere" + file);
                file.mkdir();
            }

            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File targetFile = new File("screenshots" + Seperator + "LatestResults" + Seperator + sTestClassName, sFileName);
            FileUtils.copyFile(sourceFile, targetFile);
            return sFileName;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
