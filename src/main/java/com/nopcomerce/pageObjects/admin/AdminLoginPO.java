package com.nopcomerce.pageObjects.admin;

import com.nopcomerce.PageUIs.admin.AdminLoginPUI;
import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;

public class AdminLoginPO extends BasePage {
    private WebDriver driver;

    public AdminLoginPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void enterToEmailTextbox(String email) {
        waitForElementVisible(AdminLoginPUI.EMAIL_TEXTBOX);
        sendKeysToElement(AdminLoginPUI.EMAIL_TEXTBOX,email);
    }

    public void enterToPasswordTextbox(String password) {
        waitForElementVisible(AdminLoginPUI.PASSWORD_TEXTBOX);
        sendKeysToElement(AdminLoginPUI.PASSWORD_TEXTBOX,password);
    }

    public AdminDashboardPO clickToLoginButton() {
        waitForElementClickable(AdminLoginPUI.LOGIN_BUTTON);
        clickToElement(AdminLoginPUI.LOGIN_BUTTON);
        return PageGeneratorManager.getAdminDashboardPage(driver);
    }

}
