package com.fbf.automation.tests;

import com.fbf.automation.DriverFactory;
import com.fbf.automation.pageobjects.*;
import com.fbf.automation.utils.FailureReport;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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


    String pageTitle = "Firebrand Fresh";

    @BeforeSuite
    public void SetUp() {
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

    @Test(description = "Expand the Menu Screen", priority = 1 )
    public void exapandTheMenuScreen()  {
        homePage.expandMenuScreen();
        Assert.assertEquals(homePage.getMenuScreenDetails(),"CREATE NEW ORDER");
    }

    @Test(description = "Navigate to the FireBrand Quiz Page",priority = 2)
    public void navigateToFireBrandQuizPage(){
        homePage.navigateToPlayFirebrandQuiz();
        Assert.assertEquals(homePage.getFirebrandFreshQuizHeader(),"Firebrand");
    }

    @Test(description = "Navigate to the About Us Page",priority = 3)
    public void navigateToAboutUsPage(){
        firebrandQuiz.expandMenuFQuizScreen();
        firebrandQuiz.navigateToAboutUsPage();
        Assert.assertEquals(firebrandQuiz.getAboutUsPageHeader(),"Firebrand Manifesto");
    }

    @Test(description = "Navigate to the FAQ Page",priority = 4)
    public void navigateToFaqPage(){
        aboutUs.expandAboutUsMenu();
        aboutUs.navigateToFaq();
        Assert.assertEquals(aboutUs.getFaqPageHeader(),"Firebrand Manifesto");
    }


    @Test(description = "Navigate to the Quiz Facts Page",priority = 5)
    public void navigateToQuizFacts(){
        faqPage.expandFaqMenu();
        faqPage.navigateToQuizfactsPage();
        Assert.assertEquals(faqPage.getQuizfactsPageHeader(),"FIREBRAND FRESH FACTS");
    }

    @Test(description = "Navigate to the Contact Us Page",priority = 6)
    public void navigateToContactUs(){

        quizFacts.expandMenuScreenQuizFactsPage();
        quizFacts.navigateToContactUsPage();
        Assert.assertEquals(quizFacts.getContactUsPageHeader(),"CONTACT US");
    }

    @Test(description = "Navigate to the Terms & Condition Page",priority = 7)
    public void navigateToTermsandCondition(){
        contactUs.exapandMenuScreenContUsScreen();
        contactUs.navigateToTermsandConditionPage();
        Assert.assertEquals(contactUs.getTermsandConditionPageLabel(),"FIREBRAND FRESH WEBSITE TERMS AND CONDITIONS");
    }

    @Test(description = "Naviate to the Create New Order Page",priority = 8)
    public void navigateToCreatenewOrder(){
        termsandCond.expandTheMenuScreeninTermCondScreen();
        termsandCond.navigateToCreateNewOrderPage();
        Assert.assertEquals(termsandCond.getCreateNewOrderPageLabel(),"Order For Later");
    }


//    @Test(description = "Navigate to Login page", priority = 1)
//    public void navigateToLoginPage() {
//        orderDetails.navigateToLoginPage();
//        Assert.assertEquals(orderDetails.getLoginPageHeader(),"LOG IN");
//    }
//
//    @Test(description = "Navigate to Registration page", priority = 2)
//    public void navigateToRegistrationPage() {
//        orderDetails.navigateToLoginPage();
//        Assert.assertEquals(orderDetails.getLoginPageHeader(),"LOG IN");
//    }

}



