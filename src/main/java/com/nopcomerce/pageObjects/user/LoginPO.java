package com.nopcomerce.pageObjects.user;

import commons.BaseComponent;
import commons.BasePage;
import io.qameta.allure.Step;
import com.nopcomerce.PageUIs.user.LoginPUI;
import org.openqa.selenium.WebDriver;

public class LoginPO extends BaseComponent {
    public LoginPO(WebDriver driver){
        super(driver);
    }

    @Step("Click to Login button")
    public void clickToLoginButton() {
        waitForElementClickable(LoginPUI.LOGIN_BUTTON);
        clickToElement(LoginPUI.LOGIN_BUTTON);
    }

    @Step("Get email error message")
    public String getErrorMessageAtEmailField() {
        waitForElementVisible(LoginPUI.EMAIL_ERROR_MESSAGE);
        return getElementText(LoginPUI.EMAIL_ERROR_MESSAGE);
    }

    @Step("Enter to email textbox with value: {0}")
    public void enterToEmailTextBox(String value) {
        waitForElementVisible(LoginPUI.EMAIL_TEXTBOX);
        sendKeysToElement(LoginPUI.EMAIL_TEXTBOX,value);
    }

    @Step("Get error message at validation summary field")
    public String getErrorMessageAtValidationSummaryField() {
        waitForElementVisible(LoginPUI.VALIDATION_SUMMARY_ERROR_MESSAGE);
        return getElementText(LoginPUI.VALIDATION_SUMMARY_ERROR_MESSAGE);
    }

    @Step("Enter to password textbox with value: {0}")
    public void enterToPasswordTextBox(String value) {
        waitForElementVisible(LoginPUI.PASSWORD_TEXTBOT);
        sendKeysToElement(LoginPUI.PASSWORD_TEXTBOT,value);
    }

    @Step("Login with email: '{0}' - password: '{1}'")
    public void loginToAccount(String email, String password){
        enterToEmailTextBox(email);
        enterToPasswordTextBox(password);
        clickToLoginButton();
    }

}
