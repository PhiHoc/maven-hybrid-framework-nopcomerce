package com.nopcomerce.user;

import commons.BaseTest;
import commons.CommonRegister;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import com.nopcomerce.pageObjects.user.HomePO;
import com.nopcomerce.pageObjects.user.LoginPO;
import commons.PageGeneratorManager;
import com.nopcomerce.pageObjects.user.RegisterPO;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import utilities.DataHelper;

@Feature("Login Tests")
public class LoginTest extends BaseTest {

    @Parameters({"browser", "role"})
    @BeforeClass
    public void beforeClass(String browserName, String role) {
        dataHelper = DataHelper.getDataHelper();
        unRegisteredEmail = dataHelper.getEmail();
        invalidEmail = "auto!@#$%.com";
        invalidPassword = "123456";

        registeredEmail = CommonRegister.getEmail();
        validPassword = CommonRegister.getPassword();

        driver = getBrowserDriver(browserName, role);
        homePO = PageGeneratorManager.getHomePage(driver);

        log.info("Pre-condition - Open Login page");
        loginPO = homePO.clickToLoginLink();
    }

    @BeforeMethod
    public void beforeMethod() {
        log.info("Before method - Refresh Page");
        loginPO.refreshPage();
    }

    @Description("Login with empty data")
    @Test
    public void Login_01_Login_With_Empty_Data() {
        log.info("Login 01 - Step 01: Click to Login button");
        loginPO.clickToLoginButton();

        log.info("Login 01 - Step 02: Verify error message");
        Assert.assertEquals(loginPO.getErrorMessageAtEmailField(), "Please enter your email");
    }

    @Description("Login with invalid email")
    @Test
    public void Login_02_Login_With_Invalid_Email() {
        log.info("Login 02 - Step 01: Enter invalid email to email textbox: '" + invalidEmail + "'");
        loginPO.enterToEmailTextBox(invalidEmail);

        log.info("Login 02 - Step 02: Click to Login button");
        loginPO.clickToLoginButton();

        log.info("Login 02 - Step 03: Verify error message");
        Assert.assertEquals(loginPO.getErrorMessageAtEmailField(), "Wrong email");

    }

    @Description("Login with unregistered email")
    @Test
    public void Login_03_Login_With_Unregistered_Email() {
        log.info("Login 03 - Step 01: Enter unregistered email to email textbox: '" + unRegisteredEmail + "'");
        loginPO.enterToEmailTextBox(unRegisteredEmail);

        log.info("Login 03 - Step 02: Click to Login button");
        loginPO.clickToLoginButton();

        log.info("Login 03 - Step 03: Verify error message");
        Assert.assertEquals(loginPO.getErrorMessageAtValidationSummaryField(), "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found");
    }

    @Description("Login with registered email and empty password")
    @Test
    public void Login_04_Login_With_Registered_Email_And_Empty_Password() {
        log.info("Login 04 - Step 01: Enter registered email to email textbox: '" + registeredEmail + "'");
        loginPO.enterToEmailTextBox(registeredEmail);

        log.info("Login 04 - Step 02: Click to Login button");
        loginPO.clickToLoginButton();

        log.info("Login 04 - Step 03: Verify error message");
        Assert.assertEquals(loginPO.getErrorMessageAtValidationSummaryField(), "Login was unsuccessful. Please correct the errors and try again.\n" +
                "The credentials provided are incorrect");
    }

    @Description("Login with registered email and invalid password")
    @Test
    public void Login_05_Login_With_Registered_Email_And_Invalid_Password() {
        log.info("Login 05 - Step 01: Enter registered email to email textbox: '" + registeredEmail + "'");
        loginPO.enterToEmailTextBox(registeredEmail);

        log.info("Login 05 - Step 02: Enter invalid password to password textbox: '" + invalidPassword + "'");
        loginPO.enterToPasswordTextBox(invalidPassword);

        log.info("Login 05 - Step 03: Click to Login button");
        loginPO.clickToLoginButton();

        log.info("Login 05 - Step 04: Verify error message");
        Assert.assertEquals(loginPO.getErrorMessageAtValidationSummaryField(), "Login was unsuccessful. Please correct the errors and try again.\n" +
                "The credentials provided are incorrect");
    }

    @Description("Login with registered email and valid password")
    @Test
    public void Login_06_Login_With_Valid_Email_And_Valid_Password() {
        log.info("Login 06 - Step 01: Enter registered email to email textbox: '" + registeredEmail + "'");
        loginPO.enterToEmailTextBox(registeredEmail);

        log.info("Login 06 - Step 02: Enter valid password to password textbox: '" + validPassword + "'");
        loginPO.enterToPasswordTextBox(validPassword);

        log.info("Login 06 - Step 03: Click to Login button");
        loginPO.clickToLoginButton();

        log.info("Login 06 - Step 04: Verify is 'My Account' link displayed");
        Assert.assertTrue(loginPO.isMyAccountLinkDisplayed());
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserDriver();
    }

    private WebDriver driver;
    private HomePO homePO;
    private RegisterPO registerPO;
    private LoginPO loginPO;
    private String firstName, lastName, unRegisteredEmail, invalidEmail, registeredEmail, validPassword, invalidPassword;
    private DataHelper dataHelper;

}
