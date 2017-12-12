package com.fbf.automation.tests;

import com.fbf.automation.DriverFactory;
import com.fbf.automation.pageobjects.*;
import com.fbf.automation.utils.FailureReport;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


/**
 * Created by nilenth on 10/10/2017.
 */

@Listeners(value = FailureReport.class)
public class HomePageTest {
    WebDriver driver = null;
    HomePage homePage;
    FirebrandQuiz firebrandQuiz;
    QuizFacts quizFacts;
    ContactUs contactUs;
    TermsandCond termsandCond;
    CreateNewOrder createNewOrder;
    AboutUs aboutUs;
    FaqPage faqPage;


    String pageTitle = "Firebrand Fresh - Fabulous flame roasted food";

    @BeforeSuite
    public void setUp() {
        driver = DriverFactory.getDriver();
        homePage = new HomePage(driver);
        firebrandQuiz = new FirebrandQuiz(driver);
        contactUs = new ContactUs(driver);
        quizFacts = new QuizFacts(driver);
        termsandCond = new TermsandCond(driver);
        createNewOrder = new CreateNewOrder(driver);
        aboutUs = new AboutUs(driver);
        faqPage = new FaqPage(driver);
    }


    @Test(description = "Verify Home page loaded", priority = 0)
    public void verifyPageElements() {
        String errorMessage = "Home page title not valid.";
        Assert.assertEquals(homePage.getHomePageTitle(), pageTitle, errorMessage);
    }

    @Test(description = "Expand the Menu Screen", priority = 1)
    public void expandTheMenuScreen() {
        homePage.expandMenuScreen();
        Assert.assertEquals(homePage.getMenuScreenDetails(), "CREATE NEW ORDER");
    }

    @Test(description = "Test Create New Order Select Text Color", priority = 2)
    public void testCreateNewOrderSelectTextColor() {
        Assert.assertEquals(homePage.getCreateNewOrderSelectTextColor(), "rgba(5, 97, 65, 1)");
    }

    @Test(description = "Test Create New Order Select Background Color", priority = 3)
    public void testCreateNewOrderSelectBackColor() {
        Assert.assertEquals(homePage.getCreateNewOrderSelectBackColor(), "rgba(239, 239, 239, 1)");
    }

    @Test(description = "Navigate to the FireBrand Quiz Page", priority = 4)
    public void navigateToFireBrandQuizPage() {
        homePage.navigateToPlayFirebrandQuiz();
        Assert.assertEquals(homePage.getFirebrandFreshQuizHeader(), "Firebrand");
    }

    @Test(description = "Test Create New Order Text Color", priority = 5)
    public void testCreateNewOrderTextColor() {
        firebrandQuiz.expandMenuFQuizScreen();
        Assert.assertEquals(homePage.getCreateNewOrderTextColor(), "rgba(239, 65, 54, 1)");
    }

    @Test(description = "Test Create New Order Background Color", priority = 6)
    public void testCreateNewOrderBackColor() {
        Assert.assertEquals(homePage.getCreateNewOrderBackColor(), "rgba(0, 0, 0, 0)");
    }

    @Test(description = "Test Firebrand Quiz Select Text Color", priority = 7)
    public void testFbQuizSelectTextColor() {
        Assert.assertEquals(homePage.getFbQuizSelectTextColor(), "rgba(5, 97, 65, 1)");
    }

    @Test(description = "Test Firebrand Quiz Select Background Color", priority = 8)
    public void testFbQuizSelectBackColor() {
        Assert.assertEquals(homePage.getFbQuizSelectBackColor(), "rgba(239, 239, 239, 1)");
    }


    @Test(description = "Navigate to the About Us Page", priority = 9)
    public void navigateToAboutUsPage() {
        firebrandQuiz.navigateToAboutUsPage();
        Assert.assertEquals(firebrandQuiz.getAboutUsPageHeader(), "Firebrand Manifesto");
    }

    @Test(description = "Test Firebrand Quiz Text Color", priority = 10)
    public void testFbQuizTextColor() {
        aboutUs.expandAboutUsMenu();
        Assert.assertEquals(homePage.getFbQuizTextColor(), "rgba(239, 65, 54, 1)");
    }

    @Test(description = "Test Firebrand Quiz Background Color", priority = 11)
    public void testFbQuizBackColor() {
        Assert.assertEquals(homePage.getFbQuizBackColor(), "rgba(0, 0, 0, 0)");
    }

    @Test(description = "Test About Us Select Text Color", priority = 12)
    public void testAboutUsSelectTextColor() {
        Assert.assertEquals(firebrandQuiz.getAboutUsSelectTextColor(), "rgba(5, 97, 65, 1)");
    }

    @Test(description = "Test About Us Select Background Color", priority = 13)
    public void testAboutUsSelectBackColor() {
        Assert.assertEquals(firebrandQuiz.getAboutUsSelectBackColor(), "rgba(239, 239, 239, 1)");
    }

    @Test(description = "Navigate to the FAQ Page", priority = 14)
    public void navigateToFaqPage() {
        //aboutUs.expandAboutUsMenu();
        aboutUs.navigateToFaq();
        Assert.assertEquals(aboutUs.getFaqPageHeader(), "FIREBRAND FRESH FAQ");
    }

    @Test(description = "Test About Us Text Color", priority = 15)
    public void testAboutUsTextColor() {
        faqPage.expandFaqMenu();
        Assert.assertEquals(firebrandQuiz.getAboutUsTextColor(), "rgba(239, 65, 54, 1)");
    }

    @Test(description = "Test About Us Background Color", priority = 16)
    public void testAboutUsBackColor() {
        Assert.assertEquals(firebrandQuiz.getAboutUsBackColor(), "rgba(0, 0, 0, 0)");
    }

    @Test(description = "Test FAQ Page Select Text Color", priority = 17)
    public void testFaqPageSelectTextColor() {
        Assert.assertEquals(aboutUs.getFaqPageSelectTextColor(), "rgba(5, 97, 65, 1)");
    }

    @Test(description = "Test FAQ Page Select Background Color", priority = 18)
    public void testFaqPageSelectBackColor() {
        Assert.assertEquals(aboutUs.getFaqPageSelectBackColor(), "rgba(239, 239, 239, 1)");
    }

    @Test(description = "Navigate to the Quiz Facts Page", priority = 19)
    public void navigateToQuizFacts() {
        faqPage.navigateToQuizfactsPage();
        Assert.assertEquals(faqPage.getQuizfactsPageHeader(), "FIREBRAND FRESH FACTS");
    }

    @Test(description = "Test FAQ Page Text Color", priority = 20)
    public void testFaqPageTextColor() {
        quizFacts.expandMenuScreenQuizFactsPage();
        Assert.assertEquals(aboutUs.getFaqPageTextColor(), "rgba(239, 65, 54, 1)");
    }

    @Test(description = "Test FAQ Page Background Color", priority = 21)
    public void testFaqPageBackColor() {
        Assert.assertEquals(aboutUs.getFaqPageBackColor(), "rgba(0, 0, 0, 0)");
    }

    @Test(description = "Test Quiz Facts Select Text Color", priority = 22)
    public void testQuizFactsSelectTextColor() {
        Assert.assertEquals(faqPage.getQuizFactsSelectTextColor(), "rgba(5, 97, 65, 1)");
    }

    @Test(description = "Test Quiz Facts Select Background Color", priority = 23)
    public void testQuizFactsSelectBackColor() {
        Assert.assertEquals(faqPage.getQuizFactsSelectBackColor(), "rgba(239, 239, 239, 1)");
    }


    @Test(description = "Navigate to the Contact Us Page", priority = 24)
    public void navigateToContactUs() {

        //quizFacts.expandMenuScreenQuizFactsPage();
        quizFacts.navigateToContactUsPage();
        Assert.assertEquals(quizFacts.getContactUsPageHeader(), "CONTACT US");
    }

    @Test(description = "Test Quiz Facts Text Color", priority = 25)
    public void testQuizFactsTextColor() {
        contactUs.expandMenuScreenContUsScreen();
        Assert.assertEquals(faqPage.getQuizFactsTextColor(), "rgba(239, 65, 54, 1)");
    }

    @Test(description = "Test Quiz Facts Background Color", priority = 26)
    public void testQuizFactsBackColor() {
        Assert.assertEquals(faqPage.getQuizFactsBackColor(), "rgba(0, 0, 0, 0)");
    }

    @Test(description = "Test Contact Us Select Text Color", priority = 27)
    public void testContactUsSelectTextColor() {
        Assert.assertEquals(quizFacts.getContactUsSelectTextColor(), "rgba(5, 97, 65, 1)");
    }

    @Test(description = "Test Contact Us Select Background Color", priority = 28)
    public void testContactUsSelectBackColor() {
        Assert.assertEquals(quizFacts.getContactUsSelectBackColor(), "rgba(239, 239, 239, 1)");
    }


    @Test(description = "Navigate to the Terms & Condition Page", priority = 29)
    public void navigateToTermsandCondition() {
        contactUs.navigateToTermsandConditionPage();
        Assert.assertEquals(contactUs.getTermsandConditionPageLabel(), "FIREBRAND FRESH WEBSITE TERMS AND CONDITIONS");
    }

    @Test(description = "Test Contact Us Text Color", priority = 30)
    public void testContactUsTextColor() {
        termsandCond.expandTheMenuScreeninTermCondScreen();
        Assert.assertEquals(quizFacts.getContactUsTextColor(), "rgba(239, 65, 54, 1)");
    }

    @Test(description = "Test Contact Us Background Color", priority = 31)
    public void testContactUsBackColor() {
        Assert.assertEquals(quizFacts.getContactUsBackColor(), "rgba(0, 0, 0, 0)");
    }

    @Test(description = "Test Terms and Conditions Select Text Color", priority = 32)
    public void testTermsandCondSelectTextColor() {
        Assert.assertEquals(contactUs.getTermsandCondSelectTextColor(), "rgba(5, 97, 65, 1)");
    }

    @Test(description = "Test Terms and Conditions Select Background Color", priority = 33)
    public void testTermsandCondSelectBackColor() {
        Assert.assertEquals(contactUs.getTermsandCondSelectBackColor(), "rgba(239, 239, 239, 1)");
    }


    @Test(description = "Naviate to the Create New Order Page", priority = 34)
    public void navigateToCreatenewOrder() {
        //termsandCond.expandTheMenuScreeninTermCondScreen();
        termsandCond.navigateToCreateNewOrderPage();
        Assert.assertEquals(termsandCond.getCreateNewOrderPageLabel(), "Order For Later");
    }

    @Test(description = "Test Terms and Conditions Text Color", priority = 35)
    public void testTermsandCondTextColor() {
        createNewOrder.expandCreateNewOrderMenu();
        Assert.assertEquals(contactUs.getTermsandCondTextColor(), "rgba(239, 65, 54, 1)");
    }

    @Test(description = "Test Terms and Conditions Background Color", priority = 36)
    public void testTermsandCondBackColor() {
        Assert.assertEquals(contactUs.getTermsandCondBackColor(), "rgba(0, 0, 0, 0)");
    }

    @Test(description = "Close down the Menu Screen", priority = 37)
    public void closeTheMenuScreen() {
        createNewOrder.closeCreateNewOrderMenu();
        Assert.assertEquals(createNewOrder.getCreateNewOrderLabel(), "Order For Later");
    }

    @AfterSuite
    public void tearDown() {
        driver.close();
        driver.quit();
    }

}



