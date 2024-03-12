package nopcomerce.pageObjects.user;

import io.qameta.allure.Step;
import nopcomerce.PageUIs.user.ChangePasswordPUI;
import org.openqa.selenium.WebDriver;

public class ChangePasswordPO extends MyAccountPO {
    public ChangePasswordPO(WebDriver driver) {
        super(driver);
    }

    @Step("Enter to old password textbox with value: {0}")
    public void enterToOldPasswordTextBox(String oldPassword) {
        waitForElementVisible(ChangePasswordPUI.OLD_PASSWORD_TEXTBOX);
        sendKeysToElement(ChangePasswordPUI.OLD_PASSWORD_TEXTBOX,oldPassword);
    }

    @Step("Enter to new password textbox with value: {0}")
    public void enterToNewPasswordTextbox(String newPassword) {
        waitForElementVisible(ChangePasswordPUI.NEW_PASSWORD_TEXTBOX);
        sendKeysToElement(ChangePasswordPUI.NEW_PASSWORD_TEXTBOX,newPassword);
    }

    @Step("Enter to confirm password textbox with value: {0}")
    public void enterToConfirmPasswordTextbox(String newPassword) {
        waitForElementVisible(ChangePasswordPUI.CONFIRM_PASSWORD_TEXTBOX);
        sendKeysToElement(ChangePasswordPUI.CONFIRM_PASSWORD_TEXTBOX,newPassword);
    }

    @Step("Click to Change Password button")
    public void clickToChangePasswordButton() {
        waitForElementClickable(ChangePasswordPUI.CHANGE_PASSWORD_BUTTON);
        clickToElement(ChangePasswordPUI.CHANGE_PASSWORD_BUTTON);
    }

    @Step("Get change password success message")
    public String getChangePasswordSuccessMessage() {
        waitForElementVisible(ChangePasswordPUI.CHANGE_PASSWORD_SUCCESS_MESSAGE);
        return getElementText(ChangePasswordPUI.CHANGE_PASSWORD_SUCCESS_MESSAGE);
    }

    @Step("Click to close success message button")
    public void clickToCloseSuccessMessageButton() {
        waitForElementClickable(ChangePasswordPUI.CLOSE_MESSAGE_BUTTON);
        clickToElement(ChangePasswordPUI.CLOSE_MESSAGE_BUTTON);
    }
}
