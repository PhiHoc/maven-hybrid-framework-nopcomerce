package nopcomerce.pageObjects.user;

import io.qameta.allure.Step;
import nopcomerce.PageUIs.user.AddressesPUI;
import org.openqa.selenium.WebDriver;

public class AddressesPO extends MyAccountPO {

    public AddressesPO(WebDriver driver) {
        super(driver);
    }

    @Step("Click to add new button")
    public void clickToAddNewButton() {
        waitForElementClickable(AddressesPUI.ADD_NEW_ADDRESS_BUTTON);
        clickToElement(AddressesPUI.ADD_NEW_ADDRESS_BUTTON);
    }

    @Step("Enter to '{0}' textbox with value: {1}")
    public void enterToTextboxById(String id, String value) {
        waitForElementVisible(AddressesPUI.DYNAMIC_TEXTBOX_BY_ID, id);
        sendKeysToElement(AddressesPUI.DYNAMIC_TEXTBOX_BY_ID, value, id);
    }

    @Step("Click to save button")
    public void clickToSaveButton() {
        waitForElementClickable(AddressesPUI.SAVE_ADDRESS_BUTTON);
        clickToElement(AddressesPUI.SAVE_ADDRESS_BUTTON);
    }

    @Step("Get '{0}' text info")
    public String getAddressTextInfoByClassName(String className) {
        waitForElementVisible(AddressesPUI.DYNAMIC_ADDRESS_TEXT_INFO_BY_CLASSNAME, className);
        return getElementText(AddressesPUI.DYNAMIC_ADDRESS_TEXT_INFO_BY_CLASSNAME, className);
    }

    public String getAddAddressSuccessMessage() {
        waitForElementVisible(AddressesPUI.ADD_ADDRESS_SUCCESS_MESSAGE);
        return getElementText(AddressesPUI.ADD_ADDRESS_SUCCESS_MESSAGE);
    }

    public void selectCountryDropDown(String country) {
        waitForElementVisible(AddressesPUI.COUNTRY_DROPDOWN);
        selectItemInDropdown(AddressesPUI.COUNTRY_DROPDOWN,country);
    }

    public void selectStateDropDown(String state) {
        waitForElementVisible(AddressesPUI.STATE_DROPDOWN);
        selectItemInDropdown(AddressesPUI.STATE_DROPDOWN,state);
    }
}
