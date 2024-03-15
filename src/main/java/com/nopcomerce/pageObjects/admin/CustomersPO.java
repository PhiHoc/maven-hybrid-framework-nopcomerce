package com.nopcomerce.pageObjects.admin;

import com.nopcomerce.PageUIs.admin.AdminHomePUI;
import commons.BaseComponent;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class CustomersPO extends BaseComponent {
    public CustomersPO(WebDriver driver) {
        super(driver);
    }

    @Step("Click to 'Add new' button at 'Customers' page")
    public void clickToAddNewButton() {
        waitForElementClickable(AdminHomePUI.ADD_NEW_BUTTON);
        clickToElement(AdminHomePUI.ADD_NEW_BUTTON);
    }
}
