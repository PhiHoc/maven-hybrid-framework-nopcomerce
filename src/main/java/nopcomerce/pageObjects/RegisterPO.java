package nopcomerce.pageObjects;

import commons.BasePage;
import io.qameta.allure.Step;
import net.bytebuddy.asm.Advice;
import nopcomerce.PageUIs.RegisterPUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverInfo;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class RegisterPO extends BasePage {
    public RegisterPO(WebDriver driver){
        super(driver);
    }

    WebDriver driver;
    @Step("Click to 'Register' button")
    public void clickToRegisterButton() {
        waitForElementClickable(RegisterPUI.REGISTER_BUTTON);
        clickToElement(RegisterPUI.REGISTER_BUTTON);
    }

    @Step("Get error massage at 'First name' field")
    public String getErrorMessageAtFirstNameField() {
        waitForElementVisible(RegisterPUI.FIRSTNAME_ERROR_MESSAGE);
        return getElementText(RegisterPUI.FIRSTNAME_ERROR_MESSAGE);
    }

    @Step("Get error massage at 'Last name' field")
    public String getErrorMessageAtLastNameField() {
        waitForElementVisible(RegisterPUI.LASTNAME_ERROR_MESSAGE);
        return getElementText(RegisterPUI.LASTNAME_ERROR_MESSAGE);
    }

    @Step("Get error massage at 'Email' field")
    public String getErrorMessageAtEmailField() {
        waitForElementVisible(RegisterPUI.EMAIL_ERROR_MESSAGE);
        return getElementText(RegisterPUI.EMAIL_ERROR_MESSAGE);
    }

    @Step("Get error massage at 'Password' field")
    public String getErrorMessageAtPasswordField() {
        waitForElementVisible(RegisterPUI.PASSWORD_ERROR_MESSAGE);
        return getElementText(RegisterPUI.PASSWORD_ERROR_MESSAGE);
    }

    @Step("Get error massage at 'Confirm Password' field")
    public String getErrorMessageAtConfirmPasswordField() {
        waitForElementVisible(RegisterPUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
        return getElementText(RegisterPUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
    }

    @Step("Enter to '{0}' textbox with value: '{1}'")
    public void enterToTextBoxById(String id, String value) {
        waitForElementVisible(RegisterPUI.DYNAMIC_TEXTBOX_BY_ID,id);
        sendKeysToElement(RegisterPUI.DYNAMIC_TEXTBOX_BY_ID,value,id);
    }

    @Step("Get register success message")
    public String getRegisterSuccessMessage() {
        waitForElementVisible(RegisterPUI.REGISTER_SUCCESS_MESSAGE);
        return getElementText(RegisterPUI.REGISTER_SUCCESS_MESSAGE);
    }

    @Step("Get error massage at validation summary field")
    public String getErrorMessageAtValidationSummaryField() {
        waitForElementVisible(RegisterPUI.VALIDATION_SUMMARY_MESSAGE);
        return getElementText(RegisterPUI.VALIDATION_SUMMARY_MESSAGE);
    }

    public void registerValidAccount(String firstName, String lastName, String email, String password) {
        enterToTextBoxById("FirstName", firstName);
        enterToTextBoxById("LastName", lastName);
        enterToTextBoxById("Email", email);
        enterToTextBoxById("Password", password);
        enterToTextBoxById("ConfirmPassword", password);
        clickToRegisterButton();
    }
}
