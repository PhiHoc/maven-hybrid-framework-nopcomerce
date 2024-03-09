package nopcomerce.pageObjects;

import io.qameta.allure.Step;
import nopcomerce.PageUIs.CustomerInfoPUI;
import org.openqa.selenium.WebDriver;

public class CustomerInfoPO extends MyAccountPO{
    public CustomerInfoPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Check to '{0}' checkbox")
    public void checkToCheckBoxByLabel(String label) {
        waitForElementVisible(CustomerInfoPUI.DYNAMIC_CHECKBOX_BY_LABEL_NAME,label);
        checkToCheckBoxOrRadio(CustomerInfoPUI.DYNAMIC_CHECKBOX_BY_LABEL_NAME,label);
    }

    @Step("Enter to '{0}' textbox with value: {1}")
    public void enterToTextboxById(String id, String value) {
        waitForElementVisible(CustomerInfoPUI.DYNAMIC_TEXTBOX_BY_ID,id);
        sendKeysToElement(CustomerInfoPUI.DYNAMIC_TEXTBOX_BY_ID,value,id);
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
        waitForElementVisible(CustomerInfoPUI.DOB_YEAR_DROPDOWN);
        selectItemInDropdown(CustomerInfoPUI.DOB_YEAR_DROPDOWN,year);
    }

    @Step("Select month dropdown with value: {0}")
    private void selectToDOBMonthDropdown(String month) {
        waitForElementVisible(CustomerInfoPUI.DOB_MONTH_DROPDOWN);
        selectItemInDropdown(CustomerInfoPUI.DOB_MONTH_DROPDOWN,month);
    }

    @Step("Select day dropdown with value: {0}")
    private void selectToDOBDayDropdown(String day) {
        waitForElementVisible(CustomerInfoPUI.DOB_DAY_DROPDOWN);
        selectItemInDropdown(CustomerInfoPUI.DOB_DAY_DROPDOWN,day);
    }

    @Step("Click to save button")
    public void clickToSaveButton() {
        waitForElementClickable(CustomerInfoPUI.SAVE_BUTTON);
        clickToElement(CustomerInfoPUI.SAVE_BUTTON);
    }

    @Step("Get update success message")
    public String getUpdateSuccessMessage() {
        waitForElementVisible(CustomerInfoPUI.UPDATE_INFO_SUCCESS_MESSAGE);
        return getElementText(CustomerInfoPUI.UPDATE_INFO_SUCCESS_MESSAGE);
    }

    WebDriver driver;
}
