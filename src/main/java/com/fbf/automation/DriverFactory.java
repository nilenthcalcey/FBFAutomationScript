package com.fbf.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DriverFactory {

    public static WebDriver getDriver(DriverType driverType) {
        return getDriver(driverType, getProperties());
    }

    public static WebDriver getDriver() {
        Properties properties = getProperties();
        return getDriver(DriverType.valueOf(properties.getProperty("driverType")), properties);
    }

    private static Properties getProperties() {
        Properties properties = new Properties();
        try {
            InputStream input = DriverFactory.class.getClassLoader().getResourceAsStream("PageBase.properties");
            properties.load(input);
            input.close();
        } catch (IOException exception) {
            // Log the error message.
        }

        return properties;
    }

    private static WebDriver getDriver(DriverType driverType, Properties properties) {
        WebDriver driver = null;

        if (driverType == DriverType.CHROME) {
            System.setProperty("webdriver.chrome.driver", properties.getProperty("chromeDriverLocation"));
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            DesiredCapabilities chromeCapabilities = DesiredCapabilities.chrome();
            chromeCapabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
            driver.navigate().to(properties.getProperty("appURL"));
            return driver;
        } else if (driverType == DriverType.IE) {
            driver = new InternetExplorerDriver();
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
            ieCapabilities.setCapability(InternetExplorerDriver.ENABLE_ELEMENT_CACHE_CLEANUP, true);
            driver.navigate().to(properties.getProperty("appURL"));
            return driver;
        } else if (driverType == DriverType.FIREFOX) {
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.navigate().to(properties.getProperty("appURL"));
            return driver;
        }
        return driver;
    }

}
