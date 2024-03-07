package com.nopcomerce.login;

import commons.BaseTest;
import nopcomerce.pageObjects.HomePO;
import nopcomerce.pageObjects.RegisterPO;
import nopcomerce.pageObjects.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class RegisterTabTest extends BaseTest {

    @Parameters({"browser", "env"})
    @BeforeClass
    public void beforeMethod(String browserName, String envName) {
        driver = getBrowserDriver(browserName, envName);

        log.info("Pre-condition 01 - Get Home Page");
        homePO = PageGeneratorManager.getHomePage(driver);

        log.info("Pre-condition 02 - Click to register link");
        registerPO = homePO.clickToRegisterLink();
    }

    @Test
    public void Register_01_Register_With_Empty_Data() {
        registerPO.clickToRegisterButton();

        Assert.assertEquals(registerPO.getErrorMessageAtFirstNameField(), "First name is required.");
        Assert.assertEquals(registerPO.getErrorMessageAtLastNameField(), "Last name is required.");
        Assert.assertEquals(registerPO.getErrorMessageAtEmailField(), "Email is required.");
        Assert.assertEquals(registerPO.getErrorMessageAtPasswordField(), "Password is required.");
        Assert.assertEquals(registerPO.getErrorMessageAtConfirmPasswordField(), "Password is required.");
    }

    @Test
    public void Register_02_Register_With_Invalid_Email() {

    }

    @Test
    public void Register_03_Register_With_Valid_Information() {

    }

    @Test
    public void Register_04_Register_With_Existed_Email() {

    }

    @Test
    public void Register_05_Register_With_Email_Less_Than_6_Charater() {

    }

    @Test
    public void Register_06_Register_With_Confirm_Password_Not_Match() {

    }

    @AfterClass
    public void afterMethod() {
        closeBrowserDriver();
    }


    WebDriver driver;
    HomePO homePO;
    RegisterPO registerPO;
}
