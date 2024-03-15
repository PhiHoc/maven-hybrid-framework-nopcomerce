package com.nopcomerce.pageObjects.user;

import commons.BaseComponent;
import commons.BasePage;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import com.nopcomerce.PageUIs.user.MyAccountPUI;
import org.openqa.selenium.WebDriver;

public class MyAccountPO extends BaseComponent {
    public MyAccountPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Click to Customer Info link")
    public void clickToCustomerInfoLink() {
        waitForElementClickable(MyAccountPUI.CUSTOMER_INFO_LINK);
        clickToElement(MyAccountPUI.CUSTOMER_INFO_LINK);
    }

    @Step("Click to Addresses link")
    public void clickAddressesLink() {
        waitForElementClickable(MyAccountPUI.ADDRESSES_LINK);
        clickToElement(MyAccountPUI.ADDRESSES_LINK);
    }

    @Step("Click to Change Password link")
    public void clickToChangePasswordLink() {
        waitForElementClickable(MyAccountPUI.CHANGE_PASSWORD_LINK);
        clickToElement(MyAccountPUI.CHANGE_PASSWORD_LINK);
    }

    @Step("Click to My Product Reviews link")
    public void clickToMyProductReviewLink() {
        waitForElementClickable(MyAccountPUI.MY_PRODUCT_PREVIEW_LINK);
        clickToElement(MyAccountPUI.MY_PRODUCT_PREVIEW_LINK);
    }

    @Step("Click to 'Orders' link")
    public void clickToOrdersLink() {
        waitForElementClickable(MyAccountPUI.ORDERS_LINK);
        clickToElement(MyAccountPUI.ORDERS_LINK);
    }

    @Step("Click to 'Detail' of order number: {0}")
    public ShoppingCartPO clickToOrderDetailByOrderNumber(String orderNumber) {
        waitForElementClickable(MyAccountPUI.DYNAMIC_DETAIL_BUTTON_BY_ORDER_NUMBER, orderNumber);
        clickToElement(MyAccountPUI.DYNAMIC_DETAIL_BUTTON_BY_ORDER_NUMBER, orderNumber);
        return PageGeneratorManager.getShoppingCartPage(driver);
    }

    @Step("Check to '{0}' checkbox")
    public void checkToCheckBoxByLabel(String label) {
        waitForElementVisible(MyAccountPUI.DYNAMIC_CHECKBOX_BY_LABEL_NAME, label);
        checkToCheckBoxOrRadio(MyAccountPUI.DYNAMIC_CHECKBOX_BY_LABEL_NAME, label);
    }

    @Step("Enter to '{0}' textbox with value: {1}")
    public void enterToTextboxById(String id, String value) {
        waitForElementVisible(MyAccountPUI.DYNAMIC_TEXTBOX_BY_ID, id);
        sendKeysToElement(MyAccountPUI.DYNAMIC_TEXTBOX_BY_ID, value, id);
    }

    public void selectToDateOfBirthDropdown(String dateOfBirth) {
        String[] dob = dateOfBirth.split("/");
        String day = dob[0];
        String month = dob[1];
        String year = dob[2];

        selectToDOBDayDropdown(day);
        selectToDOBMonthDropdown(month);
        selectToDOBYearDropdown(year);

    }

    @Step("Select year dropdown with value: {0}")
    private void selectToDOBYearDropdown(String year) {
        waitForElementVisible(MyAccountPUI.INFO_DOB_YEAR_DROPDOWN);
        selectItemInDropdown(MyAccountPUI.INFO_DOB_YEAR_DROPDOWN, year);
    }

    /**
     * Select month in DOB dropdown by convert month number to month name
     * @param monthNumber
     */
    @Step("Select month dropdown with value: {0}")
    private void selectToDOBMonthDropdown(String monthNumber) {
        String[] monthNames = {
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
        };
        String monthname = monthNames[Integer.parseInt(monthNumber) - 1];

        waitForElementVisible(MyAccountPUI.INFO_DOB_MONTH_DROPDOWN);
        selectItemInDropdown(MyAccountPUI.INFO_DOB_MONTH_DROPDOWN, monthname);
    }

    @Step("Select day dropdown with value: {0}")
    private void selectToDOBDayDropdown(String day) {
        waitForElementVisible(MyAccountPUI.INFO_DOB_DAY_DROPDOWN);
        selectItemInDropdown(MyAccountPUI.INFO_DOB_DAY_DROPDOWN, day);
    }

    @Step("Click to save button")
    public void clickToSaveCustomerButton() {
        waitForElementClickable(MyAccountPUI.SAVE_CUSTOMER_INFO_BUTTON);
        clickToElement(MyAccountPUI.SAVE_CUSTOMER_INFO_BUTTON);
    }

    @Step("Get update success message")
    public String getUpdateSuccessMessage() {
        waitForElementVisible(MyAccountPUI.UPDATE_INFO_SUCCESS_MESSAGE);
        return getElementText(MyAccountPUI.UPDATE_INFO_SUCCESS_MESSAGE);
    }

    @Step("Click to add new button")
    public void clickToAddNewButton() {
        waitForElementClickable(MyAccountPUI.ADD_NEW_ADDRESS_BUTTON);
        clickToElement(MyAccountPUI.ADD_NEW_ADDRESS_BUTTON);
    }

    @Step("Click to save button")
    public void clickToSaveAddressButton() {
        waitForElementClickable(MyAccountPUI.SAVE_ADDRESS_BUTTON);
        clickToElement(MyAccountPUI.SAVE_ADDRESS_BUTTON);
    }

    @Step("Get '{0}' text info")
    public String getAddressTextInfoByClassName(String className) {
        waitForElementVisible(MyAccountPUI.DYNAMIC_ADDRESS_TEXT_INFO_BY_CLASSNAME, className);
        return getElementText(MyAccountPUI.DYNAMIC_ADDRESS_TEXT_INFO_BY_CLASSNAME, className);
    }

    @Step("Verify 'Add address success' message")
    public String getAddAddressSuccessMessage() {
        waitForElementVisible(MyAccountPUI.ADD_ADDRESS_SUCCESS_MESSAGE);
        return getElementText(MyAccountPUI.ADD_ADDRESS_SUCCESS_MESSAGE);
    }

    @Step("Select 'Country' dropdown with value: '{0}'")
    public void selectCountryDropDown(String country) {
        waitForElementVisible(MyAccountPUI.ADDRESS_COUNTRY_DROPDOWN);
        selectItemInDropdown(MyAccountPUI.ADDRESS_COUNTRY_DROPDOWN, country);
    }

    @Step("Select 'State' dropdown with value: '{0}'")
    public void selectStateDropDown(String state) {
        waitForElementVisible(MyAccountPUI.ADDRESS_STATE_DROPDOWN);
        selectItemInDropdown(MyAccountPUI.ADDRESS_STATE_DROPDOWN, state);
    }

    @Step("Verify 'Review Title' text")
    public String getReviewTitleText() {
        waitForElementVisible(MyAccountPUI.REVIEW_TITLE_TEXT);
        return getElementText(MyAccountPUI.REVIEW_TITLE_TEXT);
    }

    @Step("Verify 'Review Content' text")
    public String getReviewContentText() {
        waitForElementVisible(MyAccountPUI.REVIEW_CONTENT_TEXT);
        return getElementText(MyAccountPUI.REVIEW_CONTENT_TEXT);
    }

    @Step("Enter to old password textbox with value: {0}")
    public void enterToOldPasswordTextBox(String oldPassword) {
        waitForElementVisible(MyAccountPUI.OLD_PASSWORD_TEXTBOX);
        sendKeysToElement(MyAccountPUI.OLD_PASSWORD_TEXTBOX, oldPassword);
    }

    @Step("Enter to new password textbox with value: {0}")
    public void enterToNewPasswordTextbox(String newPassword) {
        waitForElementVisible(MyAccountPUI.NEW_PASSWORD_TEXTBOX);
        sendKeysToElement(MyAccountPUI.NEW_PASSWORD_TEXTBOX, newPassword);
    }

    @Step("Enter to confirm password textbox with value: {0}")
    public void enterToConfirmPasswordTextbox(String newPassword) {
        waitForElementVisible(MyAccountPUI.CONFIRM_PASSWORD_TEXTBOX);
        sendKeysToElement(MyAccountPUI.CONFIRM_PASSWORD_TEXTBOX, newPassword);
    }

    @Step("Click to Change Password button")
    public void clickToChangePasswordButton() {
        waitForElementClickable(MyAccountPUI.CHANGE_PASSWORD_BUTTON);
        clickToElement(MyAccountPUI.CHANGE_PASSWORD_BUTTON);
    }

    @Step("Get change password success message")
    public String getChangePasswordSuccessMessage() {
        waitForElementVisible(MyAccountPUI.CHANGE_PASSWORD_SUCCESS_MESSAGE);
        return getElementText(MyAccountPUI.CHANGE_PASSWORD_SUCCESS_MESSAGE);
    }

    @Step("Click to close success message button")
    public void clickToCloseSuccessMessageButton() {
        waitForElementClickable(MyAccountPUI.CLOSE_MESSAGE_BUTTON);
        clickToElement(MyAccountPUI.CLOSE_MESSAGE_BUTTON);
    }

    WebDriver driver;
}
