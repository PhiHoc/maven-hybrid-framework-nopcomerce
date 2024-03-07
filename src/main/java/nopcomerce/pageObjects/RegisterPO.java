package nopcomerce.pageObjects;

import commons.BasePage;
import net.bytebuddy.asm.Advice;
import nopcomerce.PageUIs.RegisterPUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverInfo;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPO extends BasePage {
    public RegisterPO(WebDriver driver){
        super(driver);
    }

    WebDriver driver;

    public void clickToRegisterButton() {
        waitForElementClickable(RegisterPUI.REGISTER_BUTTON);
        clickToElement(RegisterPUI.REGISTER_BUTTON);
    }

    public String getErrorMessageAtFirstNameField() {
        waitForElementVisible(RegisterPUI.FIRSTNAME_ERROR_MESSAGE);
        return getElementText(RegisterPUI.FIRSTNAME_ERROR_MESSAGE);
    }

    public String getErrorMessageAtLastNameField() {
        waitForElementVisible(RegisterPUI.LASTNAME_ERROR_MESSAGE);
        return getElementText(RegisterPUI.LASTNAME_ERROR_MESSAGE);
    }

    public String getErrorMessageAtEmailField() {
        waitForElementVisible(RegisterPUI.EMAIL_ERROR_MESSAGE);
        return getElementText(RegisterPUI.EMAIL_ERROR_MESSAGE);
    }

    public String getErrorMessageAtPasswordField() {
        waitForElementVisible(RegisterPUI.PASSWORD_ERROR_MESSAGE);
        return getElementText(RegisterPUI.PASSWORD_ERROR_MESSAGE);
    }

    public String getErrorMessageAtConfirmPasswordField() {
        waitForElementVisible(RegisterPUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
        return getElementText(RegisterPUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
    }

    public void enterToTextBoxById(String id, String value) {
        waitForElementVisible(RegisterPUI.DYNAMIC_TEXTBOX_BY_ID,id);
        sendKeysToElement(RegisterPUI.DYNAMIC_TEXTBOX_BY_ID,value,id);
    }

    public String getRegisterSuccessMessage() {
        waitForElementVisible(RegisterPUI.REGISTER_SUCCESS_MESSAGE);
        return getElementText(RegisterPUI.REGISTER_SUCCESS_MESSAGE);
    }

    public String getErrorMessageAtValidationSummaryField() {
        waitForElementVisible(RegisterPUI.VALIDATION_SUMMARY_MESSAGE);
        return getElementText(RegisterPUI.VALIDATION_SUMMARY_MESSAGE);
    }

}
