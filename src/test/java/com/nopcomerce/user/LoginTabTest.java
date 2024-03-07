package com.nopcomerce.user;

import commons.BaseTest;
import commons.GlobalConstants;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import nopcomerce.pageObjects.HomePO;
import nopcomerce.pageObjects.LoginPO;
import nopcomerce.pageObjects.PageGeneratorManager;
import nopcomerce.pageObjects.RegisterPO;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import utilities.DataHelper;

@Feature("Login Tests")
public class LoginTabTest extends BaseTest {

    @Parameters({"browser", "env"})
    @BeforeClass
    public void beforeClass(String browserName, String envName) {
        dataHelper = DataHelper.getDataHelper();
        firstName = dataHelper.getFirtName();
        lastName = dataHelper.getLastName();
        unRegisteredEmail = dataHelper.getEmail();
        invalidEmail = "auto!@#$%.com";
        registeredEmail = dataHelper.getEmail();
        validPassword = dataHelper.getPassword();
        invalidPassword = "123456";

        driver = getBrowserDriver(browserName, envName);
        homePO = PageGeneratorManager.getHomePage(driver);

        log.info("Pre-condition 01 - Click to register link");
        registerPO = homePO.clickToRegisterLink();

        log.info("Pre-condition 02 - Register a valid account");
        registerPO.registerValidAccount(firstName,lastName,registeredEmail,validPassword);

        log.info("Pre-condition 03 - Open HomePage");
        registerPO.openPageUrl(GlobalConstants.getGlobalConstants().getPortalPageUrl());
        homePO = PageGeneratorManager.getHomePage(driver);

        log.info("Pre-condition 04 - Open Login page");
        loginPO = homePO.clickToLoginLink();
    }

    @BeforeMethod
    public void beforeMethod(){
        log.info("Before method - Refresh Page");
        loginPO.refreshPage();
    }

    @Description("Login with empty data")
    @Test
    public void Login_01_Login_With_Empty_Data(){
        log.info("Login 01 - Step 01: Click to Login button");
        loginPO.clickToLoginButton();

        log.info("Login 01 - Step 02: Verify error message");
        Assert.assertEquals(loginPO.getErrorMessageAtEmailField(),"Please enter your email");
    }

    @Description("Login with invalid email")
    @Test
    public void Login_02_Login_With_Invalid_Email(){
        log.info("Login 02 - Step 01: Enter invalid email to email textbox: '"+invalidEmail+"'");
        loginPO.enterToEmailTextBox(invalidEmail);

        log.info("Login 02 - Step 02: Click to Login button");
        loginPO.clickToLoginButton();

        log.info("Login 02 - Step 03: Verify error message");
        Assert.assertEquals(loginPO.getErrorMessageAtEmailField(),"Wrong email");

    }

    @Description("Login with unregistered email")
    @Test
    public void Login_03_Login_With_Unregistered_Email(){
        log.info("Login 03 - Step 01: Enter unregistered email to email textbox: '"+unRegisteredEmail+"'");
        loginPO.enterToEmailTextBox(unRegisteredEmail);

        log.info("Login 03 - Step 02: Click to Login button");
        loginPO.clickToLoginButton();

        log.info("Login 03 - Step 03: Verify error message");
        Assert.assertEquals(loginPO.getErrorMessageAtValidationSummaryField(),"Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found");
    }

    @Description("Login with registered email and empty password")
    @Test
    public void Login_04_Login_With_Registered_Email_And_Empty_Password(){
        log.info("Login 04 - Step 01: Enter registered email to email textbox: '"+registeredEmail+"'");
        loginPO.enterToEmailTextBox(registeredEmail);

        log.info("Login 04 - Step 02: Click to Login button");
        loginPO.clickToLoginButton();

        log.info("Login 04 - Step 03: Verify error message");
        Assert.assertEquals(loginPO.getErrorMessageAtValidationSummaryField(),"Login was unsuccessful. Please correct the errors and try again.\n" +
                "The credentials provided are incorrect");
    }

    @Description("Login with registered email and invalid password")
    @Test
    public void Login_05_Login_With_Registered_Email_And_Invalid_Password(){
        log.info("Login 05 - Step 01: Enter registered email to email textbox: '"+registeredEmail+"'");
        loginPO.enterToEmailTextBox(registeredEmail);

        log.info("Login 05 - Step 02: Enter invalid password to password textbox: '"+invalidPassword+"'");
        loginPO.enterToPasswordTextBox(invalidPassword);

        log.info("Login 05 - Step 03: Click to Login button");
        loginPO.clickToLoginButton();

        log.info("Login 05 - Step 04: Verify error message");
        Assert.assertEquals(loginPO.getErrorMessageAtValidationSummaryField(),"Login was unsuccessful. Please correct the errors and try again.\n" +
                "The credentials provided are incorrect");
    }

    @Description("Login with registered email and valid password")
    @Test
    public void Login_06_Login_With_Valid_Email_And_Valid_Password(){
        log.info("Login 06 - Step 01: Enter registered email to email textbox: '"+registeredEmail+"'");
        loginPO.enterToEmailTextBox(registeredEmail);

        log.info("Login 06 - Step 02: Enter valid password to password textbox: '"+validPassword+"'");
        loginPO.enterToPasswordTextBox(validPassword);

        log.info("Login 06 - Step 03: Click to Login button");
        loginPO.clickToLoginButton();

        log.info("Login 06 - Step 04: Verify is 'My Account' link displayed");
        Assert.assertTrue(loginPO.isMyAccountLinkDisplayed());
    }

    @AfterClass(alwaysRun = true)
    public void afterClass(){
        closeBrowserDriver();
    }

    private WebDriver driver;
    private HomePO homePO;
    private RegisterPO registerPO;
    private LoginPO loginPO;
    private String firstName,lastName,unRegisteredEmail, invalidEmail, registeredEmail, validPassword, invalidPassword;
    private DataHelper dataHelper;

}