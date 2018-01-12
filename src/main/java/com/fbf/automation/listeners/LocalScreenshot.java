package com.fbf.automation.listeners;

import com.fbf.automation.DriverFactory;
import com.fbf.automation.pageobjects.PageBase;
import com.fbf.automation.pageobjects.TestBase;
import com.fbf.automation.tests.HomePageTest;
import com.fbf.automation.utils.CommonOperations;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import static com.fbf.automation.DriverFactory.getDriver;

public class LocalScreenshot extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult result)
    {
        Object currentClass = result.getInstance();
        WebDriver webDriver = ((TestBase) currentClass).getDriver();
        String sTestClassName = result.getTestClass().getRealClass().getSimpleName();
        System.out.println("Test class name ..." + sTestClassName);
        String sFileName = result.getName();
        System.out.println("Test method name ..." + sFileName);
        sFileName = sFileName + ".png";
        String separator = System.getProperty("file.separator");

        if (webDriver != null)
        {
            try {
                File sourceFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
                File targetFile = new File("screenshots" + separator + "LatestResults" + separator + sTestClassName, sFileName);
                FileUtils.copyFile(sourceFile, targetFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String imagePathInHost = "file:///" + System.getProperty("user.dir") + separator + "screenshots" + separator + "LatestResults" + separator + sTestClassName  + separator +sFileName;
            System.out.println("Image path...." + imagePathInHost);
            Reporter.log("<a href=" + imagePathInHost + "> <img width='100' height='100' src=" + imagePathInHost + "> </a>");
            Reporter.setCurrentTestResult(null);
        }
    }
}


