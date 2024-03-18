package com.nopcomerce.user;

import com.nopcomerce.pageObjects.user.*;
import commons.BaseTest;
import commons.CommonRegister;
import commons.PageGeneratorManager;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nopcomerce.data.UserData;
import utilities.DataHelper;

@Feature("My account tests")
public class MyAccountTest extends BaseTest {
    @Parameters({"browser", "env"})
    @BeforeClass
    public void beforeClass(String browserName, String envName) {
        dataHelper = DataHelper.getDataHelper();
        firstName = dataHelper.getFirtName();
        lastName = dataHelper.getLastName();
        email = CommonRegister.getEmail();
        oldPassword = password = CommonRegister.getPassword();
        newPassword = dataHelper.getPassword();
        newEmail = dataHelper.getEmail();

        reviewTitle = "Review title";
        reviewText = "Review Text";

        driver = getBrowserDriver(browserName, envName);
        homePO = PageGeneratorManager.getHomePage(driver);

        log.info("Precodition Step 01 - Click to login link");
        loginPO = homePO.clickToLoginLink();

        log.info("Precodition Step 02 - Login with a valid account");
        loginPO.loginToAccount(email, password);

        log.info("Precodition Step 03 - Verify 'My account' link displayed");
        Assert.assertTrue(homePO.isMyAccountLinkDisplayed());
        homePO = PageGeneratorManager.getHomePage(driver);
    }

    @Description("Update customer info and verify")
    @Test
    public void MyAccount_01_Update_Customer_Info() {
        myAccountPO = homePO.clickToMyAccountLink();

        log.info("MyAccount 01 - Step 01: Click to Customer Info link");
        myAccountPO.clickToCustomerInfoLink();

        log.info("MyAccount 01 - Step 02: Click to Gender checkbox: '" + UserData.GENDER + "'");
        myAccountPO.checkToCheckBoxByLabel(UserData.GENDER);

        log.info("MyAccount 01 - Step 03: Enter to first name textbox: '" + UserData.FIRST_NAME + "'");
        myAccountPO.enterToTextboxById("FirstName", UserData.FIRST_NAME);

        log.info("MyAccount 01 - Step 04: Enter to last name textbox: '" + UserData.LAST_NAME + "'");
        myAccountPO.enterToTextboxById("LastName", UserData.LAST_NAME);

        log.info("MyAccount 01 - Step 05: Select date of birth dropdown: '" + UserData.DATE_OF_BIRTH + "'");
        myAccountPO.selectToDateOfBirthDropdown(UserData.DATE_OF_BIRTH);

        log.info("MyAccount 01 - Step 06: Enter to email textbox: '" + newEmail + "'");
        myAccountPO.enterToTextboxById("Email", newEmail);

        log.info("MyAccount 01 - Step 07: Enter to company name textbox: '" + UserData.COMPANY_NAME + "'");
        myAccountPO.enterToTextboxById("Company", UserData.COMPANY_NAME);

        log.info("MyAccount 01 - Step 08: Click save button");
        myAccountPO.clickToSaveCustomerButton();

        log.info("MyAccount 01 - Step 09: Verify Update success message");
        Assert.assertEquals(myAccountPO.getUpdateSuccessMessage(), "The customer info has been updated successfully.");

        log.info("MyAccount 01 - Step 10: Click 'Home page' logo");
        homePO = myAccountPO.clickToHomePageLogoLink();

    }

    @Description("Add address info and verify")
    @Test
    public void MyAccount_02_Add_Address() {
        log.info("MyAccount 02 - Step 01: Click to My account link");
        myAccountPO = homePO.clickToMyAccountLink();

        log.info("MyAccount 02 - Step 02: Click to address link");
        myAccountPO.clickAddressesLink();

        log.info("MyAccount 02 - Step 03: Click to 'Add new' button");
        myAccountPO.clickToAddNewButton();

        log.info("MyAccount 02 - Step 04: Enter to first name textbox: '" + UserData.FIRST_NAME + "'");
        myAccountPO.enterToTextboxById("Address_FirstName", UserData.FIRST_NAME);

        log.info("MyAccount 02 - Step 05: Enter to last name textbox: '" + UserData.LAST_NAME + "'");
        myAccountPO.enterToTextboxById("Address_LastName", UserData.LAST_NAME);

        log.info("MyAccount 02 - Step 06: Enter to email textbox: '" + UserData.EMAIL + "'");
        myAccountPO.enterToTextboxById("Address_Email", UserData.EMAIL);

        log.info("MyAccount 02 - Step 07: Enter to company textbox: '" + UserData.COMPANY_NAME + "'");
        myAccountPO.enterToTextboxById("Address_Company", UserData.COMPANY_NAME);

        log.info("MyAccount 02 - Step 08: Enter to city textbox: '" + UserData.CITY + "'");
        myAccountPO.enterToTextboxById("Address_City", UserData.CITY);

        log.info("MyAccount 02 - Step 08: Enter to Address 1 textbox: '" + UserData.ADDRESS1 + "'");
        myAccountPO.enterToTextboxById("Address_Address1", UserData.ADDRESS1);

        log.info("MyAccount 02 - Step 09: Enter to Address 2 textbox: '" + UserData.ADDRESS2 + "'");
        myAccountPO.enterToTextboxById("Address_Address2", UserData.ADDRESS2);

        log.info("MyAccount 02 - Step 10: Enter to Zip postal textbox: '" + UserData.ZIP_CODE + "'");
        myAccountPO.enterToTextboxById("Address_ZipPostalCode", UserData.ZIP_CODE);

        log.info("MyAccount 02 - Step 11: Enter to phone number textbox: '" + UserData.PHONE_NUMBER + "'");
        myAccountPO.enterToTextboxById("Address_PhoneNumber", UserData.PHONE_NUMBER);

        log.info("MyAccount 02 - Step 12: Enter to fax number textbox: '" + UserData.FAX_NUMBER + "'");
        myAccountPO.enterToTextboxById("Address_FaxNumber", UserData.FAX_NUMBER);

        log.info("MyAccount 02 - Step 13: Select country dropdown: '" + UserData.PHONE_NUMBER + "'");
        myAccountPO.selectCountryDropDown(UserData.COUNTRY);

        log.info("MyAccount 02 - Step 14: Select State dropdown: '" + UserData.PHONE_NUMBER + "'");
        myAccountPO.selectStateDropDown(UserData.STATE);

        log.info("MyAccount 02 - Step 15: Click to save button");
        myAccountPO.clickToSaveAddressButton();

        log.info("MyAccount 02 - Step 16: Verify add address success message displayed");
        Assert.assertEquals(myAccountPO.getAddAddressSuccessMessage(), "The new address has been added successfully.");

        log.info("MyAccount 02 - Step 17: Verify added data");
        Assert.assertEquals(myAccountPO.getAddressTextInfoByClassName("name"), UserData.FULL_NAME);
        Assert.assertEquals(myAccountPO.getAddressTextInfoByClassName("email"), "Email: " + UserData.EMAIL);
        Assert.assertEquals(myAccountPO.getAddressTextInfoByClassName("phone"), "Phone number: " + UserData.PHONE_NUMBER);
        Assert.assertEquals(myAccountPO.getAddressTextInfoByClassName("fax"), "Fax number: " + UserData.FAX_NUMBER);
        Assert.assertEquals(myAccountPO.getAddressTextInfoByClassName("company"), UserData.COMPANY_NAME);
        Assert.assertEquals(myAccountPO.getAddressTextInfoByClassName("address1"), UserData.ADDRESS1);
        Assert.assertEquals(myAccountPO.getAddressTextInfoByClassName("address2"), UserData.ADDRESS2);
        Assert.assertEquals(myAccountPO.getAddressTextInfoByClassName("city-state-zip"), UserData.CITY + ", " + UserData.ZIP_CODE);
        Assert.assertEquals(myAccountPO.getAddressTextInfoByClassName("country"), UserData.COUNTRY);

        log.info("MyAccount 02 - Step 18: Click to 'Home Page' logo link");
        homePO = myAccountPO.clickToHomePageLogoLink();
    }

    @Description("Change Password")
    @Test
    public void MyAccount_03_Change_Password() {
        log.info("MyAccount 03 - Step 01: Click to My account link");
        myAccountPO = homePO.clickToMyAccountLink();

        log.info("MyAccount 03 - Step 02: Click to Change password link");
        myAccountPO.clickToChangePasswordLink();

        log.info("MyAccount 03 - Step 03: Enter to old password textbox: '" + password + "'");
        myAccountPO.enterToOldPasswordTextBox(password);

        log.info("MyAccount 03 - Step 04: Enter to new password textbox: '" + newPassword + "'");
        myAccountPO.enterToNewPasswordTextbox(newPassword);

        log.info("MyAccount 03 - Step 05: Enter to confirm password textbox: '" + newPassword + "'");
        myAccountPO.enterToConfirmPasswordTextbox(newPassword);

        log.info("MyAccount 03 - Step 06: Click to Change password button");
        myAccountPO.clickToChangePasswordButton();

        log.info("MyAccount 03 - Step 07: Verify change message success displayed");
        Assert.assertEquals(myAccountPO.getChangePasswordSuccessMessage(), "Password was changed");

        log.info("MyAccount 03 - Step 08: Click close message");
        myAccountPO.clickToCloseSuccessMessageButton();

        log.info("MyAccount 03 - Step 09: Click logout link");
        homePO = myAccountPO.clickToLogoutLink();

        log.info("MyAccount 03 - Step 10: Click login link");
        loginPO = homePO.clickToLoginLink();

        log.info("MyAccount 03 - Step 11: Login with old password");
        loginPO.enterToEmailTextBox(newEmail);
        loginPO.enterToPasswordTextBox(oldPassword);
        loginPO.clickToLoginButton();

        log.info("MyAccount 03 - Step 12: Verify error message displayed");
        Assert.assertEquals(loginPO.getErrorMessageAtValidationSummaryField(),
                "Login was unsuccessful. " +
                        "Please correct the errors and try again.\n" +
                        "The credentials provided are incorrect");

        log.info("MyAccount 03 - Step 13: Login with new password");
        loginPO.enterToEmailTextBox(newEmail);
        loginPO.enterToPasswordTextBox(newPassword);
        loginPO.clickToLoginButton();

        log.info("MyAccount 03 - Step 14: Verify login success");
        Assert.assertTrue(loginPO.isMyAccountLinkDisplayed());
        homePO = PageGeneratorManager.getHomePage(driver);
    }

    @Description("Add product to My product preview")
    @Test
    public void MyAccount_04_My_Product_Preview() {
        log.info("MyAccount 04 - Step 01: Click to product link");
        homePO.clickToProductByName("Build your own computer");

        log.info("MyAccount 04 - Step 02: Click to add your review link");
        homePO.clickToAddYourReviewLink();

        log.info("MyAccount 04 - Step 03: Enter to review title textbox: '" + reviewTitle + "'");
        homePO.enterToReviewTitleTextbox(reviewTitle);

        log.info("MyAccount 04 - Step 04: Enter to review textarea: '" + reviewText + "'");
        homePO.enterToReviewTextArea(reviewText);

        log.info("MyAccount 04 - Step 05: Click 'Submit review' button");
        homePO.clickToSubmitReviewButton();

        log.info("MyAccount 04 - Step 06: Verify submit success message displayed");
        Assert.assertEquals(homePO.getSubmitReviewResult(), "Product review is successfully added.");

        log.info("MyAccount 04 - Step 07: Click to my account link");
        myAccountPO = homePO.clickToMyAccountLink();

        log.info("MyAccount 04 - Step 08: Click to my product review link");
        myAccountPO.clickToMyProductReviewLink();

        log.info("MyAccount 04 - Step 09: Verify review text");
        Assert.assertEquals(myAccountPO.getReviewTitleText(), reviewTitle);
        Assert.assertEquals(myAccountPO.getReviewContentText(), reviewText);
    }

    @AfterClass(alwaysRun = true)
    public void afterClas() {
        log.info("Update Common User info");
        CommonRegister.firstName = firstName;
        CommonRegister.lastName = lastName;
        CommonRegister.email = newEmail;
        CommonRegister.password = password;
        closeBrowserDriver();
    }

    private WebDriver driver;
    private HomePO homePO;
    private RegisterPO registerPO;
    private LoginPO loginPO;
    private String firstName, lastName, email, password, newPassword, oldPassword, reviewTitle, reviewText, newEmail;
    private DataHelper dataHelper;
    private MyAccountPO myAccountPO;
}
