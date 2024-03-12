package com.nopcomerce.user;

import commons.BaseTest;
import commons.GlobalConstants;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import nopcomerce.pageObjects.user.HomePO;
import nopcomerce.pageObjects.user.PageGeneratorManager;
import nopcomerce.pageObjects.user.RegisterPO;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import utilities.DataHelper;


@Feature("Register Tests")
public class RegisterTest extends BaseTest {

    @Parameters({"browser", "env"})
    @BeforeClass
    public void beforeMethod(String browserName, String envName) {

        dataHelper = DataHelper.getDataHelper();

        invalidEmail = "auto!@##$.com";
        email = dataHelper.getEmail();
        firstName = dataHelper.getFirtName();
        lastName = dataHelper.getLastName();
        password = dataHelper.getPassword();
        invalidConfirmPassword = "123456";
        invalidPassword = "123";

        driver = getBrowserDriver(browserName, envName);

        log.info("Before Class - Get Home Page");
        homePO = PageGeneratorManager.getHomePage(driver);
    }

    @BeforeMethod
    public void beforeMethod() {
        log.info("Before method - Click to register link");
        registerPO = homePO.clickToRegisterLink();
    }

    @Description("Register with empty data")
    @Test
    public void Register_01_Register_With_Empty_Data() {
        log.info("Register 01 - Step 01: Click to 'Register' button ");
        registerPO.clickToRegisterButton();

        log.info("Register 01 - Step 02: Verify error message");
        Assert.assertEquals(registerPO.getErrorMessageAtFirstNameField(), "First name is required.");
        Assert.assertEquals(registerPO.getErrorMessageAtLastNameField(), "Last name is required.");
        Assert.assertEquals(registerPO.getErrorMessageAtEmailField(), "Email is required.");
        Assert.assertEquals(registerPO.getErrorMessageAtPasswordField(), "Password is required.");
        Assert.assertEquals(registerPO.getErrorMessageAtConfirmPasswordField(), "Password is required.");
    }

    @Description("Register with invalid email")
    @Test
    public void Register_02_Register_With_Invalid_Email() {
        log.info("Register 02 - Step 01: Enter invalid data '" + invalidEmail + "'to email textbox ");
        registerPO.enterToTextBoxById("Email", invalidEmail);

        log.info("Register 02 - Step 02: Click to 'Register' button ");
        registerPO.clickToRegisterButton();

        log.info("Register 02 - Step 03: Verify error message");
        Assert.assertEquals(registerPO.getErrorMessageAtEmailField(), "Wrong email");
    }

    @Description("Register with valid information")
    @Test
    public void Register_03_Register_With_Valid_Information() {
        log.info("Register 03 - Step 01: Enter to firstname textbox: '" + firstName + "'");
        registerPO.enterToTextBoxById("FirstName", firstName);

        log.info("Register 03 - Step 02: Enter to lastname textbox: '" + lastName + "'");
        registerPO.enterToTextBoxById("LastName", lastName);

        log.info("Register 03 - Step 03: Enter to email textbox: '" + email + "'");
        registerPO.enterToTextBoxById("Email", email);

        log.info("Register 03 - Step 04: Enter to password textbox: '" + password + "'");
        registerPO.enterToTextBoxById("Password", password);

        log.info("Register 03 - Step 05: Enter to confirm password textbox: '" + password + "'");
        registerPO.enterToTextBoxById("ConfirmPassword", password);

        log.info("Register 03 - Step 06: Click to 'Register' button");
        registerPO.clickToRegisterButton();

        log.info("Register 03 - Step 07: Verify success message");
        Assert.assertEquals(registerPO.getRegisterSuccessMessage(), "Your registration completed");

        log.info("Register 03 - Step 08: Open home page link");
        registerPO.openPageUrl(GlobalConstants.getGlobalConstants().getPortalPageUrl());
        homePO = PageGeneratorManager.getHomePage(driver);
    }

    @Description("Register with registered email")
    @Test
    public void Register_04_Register_With_Existed_Email() {
        log.info("Register 04 - Step 01: Enter to firstname textbox: '" + firstName + "'");
        registerPO.enterToTextBoxById("FirstName", firstName);

        log.info("Register 04 - Step 02: Enter to lastname textbox: '" + lastName + "'");
        registerPO.enterToTextBoxById("LastName", lastName);

        log.info("Register 04 - Step 03: Enter existed email to email textbox: '" + email + "'");
        registerPO.enterToTextBoxById("Email", email);

        log.info("Register 04 - Step 04: Enter to password textbox: '" + password + "'");
        registerPO.enterToTextBoxById("Password", password);

        log.info("Register 04 - Step 05: Enter to confirm password textbox: '" + password + "'");
        registerPO.enterToTextBoxById("ConfirmPassword", password);

        log.info("Register 04 - Step 06: Click to 'Register' button");
        registerPO.clickToRegisterButton();

        log.info("Register 04 - Step 07: Verify error message");
        Assert.assertEquals(registerPO.getErrorMessageAtValidationSummaryField(), "The specified email already exists");
    }

    @Description("Register with password < 6")
    @Test
    public void Register_05_Register_With_Password_Less_Than_6_Charater() {
        log.info("Register 05 - Step 01: Enter invalid password to password textbox: '" + invalidPassword + "'");
        registerPO.enterToTextBoxById("Password", invalidPassword);

        log.info("Register 05 - Step 02: Click to 'Register' button");
        registerPO.clickToRegisterButton();

        log.info("Register 05 - Step 03: Verify error message");
        Assert.assertEquals(registerPO.getErrorMessageAtPasswordField(), "Password must meet the following rules:\n"
                + "must have at least 6 characters");

    }

    @Description("Register with confirm password not match")
    @Test
    public void Register_06_Register_With_Confirm_Password_Not_Match() {
        log.info("Register 06 - Step 01: Enter password to password textbox: '" + password + "'");
        registerPO.enterToTextBoxById("Password", password);

        log.info("Register 06 - Step 02: Enter invalid password to confirm password textbox: '" + invalidConfirmPassword + "'");
        registerPO.enterToTextBoxById("ConfirmPassword", invalidConfirmPassword);

        log.info("Register 06 - Step 03: Click to 'Register' button");
        registerPO.clickToRegisterButton();

        log.info("Register 06 - Step 04: Verify error message");
        Assert.assertEquals(registerPO.getErrorMessageAtConfirmPasswordField(), "The password and confirmation password do not match.");
    }

    @AfterClass(alwaysRun = true)
    public void afterMethod() {
        closeBrowserDriver();
    }


    WebDriver driver;
    HomePO homePO;
    RegisterPO registerPO;
    private String invalidEmail, email, firstName, lastName, password, invalidConfirmPassword, invalidPassword;

    private DataHelper dataHelper;
}
