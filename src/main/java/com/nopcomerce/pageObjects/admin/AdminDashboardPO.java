package com.nopcomerce.pageObjects.admin;

import com.nopcomerce.PageUIs.admin.AdminHomePUI;
import commons.BaseComponent;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AdminDashboardPO extends BaseComponent {
    private WebDriver driver;
    public AdminDashboardPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

 @Step("Click to 'Search' button")
    public void clickToSearchCustomerButton() {
        waitForElementClickable(AdminHomePUI.SEARCH_CUSTOMER_BUTTON);
        clickToElement(AdminHomePUI.SEARCH_CUSTOMER_BUTTON);
    }

    @Step("Check to 'Male' radio at 'Customers' page")
    public void checkToMaleRadio() {
        waitForElementClickable(AdminHomePUI.MALE_RADIO);
        checkToCheckBoxOrRadio(AdminHomePUI.MALE_RADIO);
    }

    @Step("Verify is 'Male' radio checked")
    public boolean isMaleGenderRadioChecked() {
        waitForElementVisible(AdminHomePUI.MALE_RADIO);
        return isElementSelected(AdminHomePUI.MALE_RADIO);
    }

    @Step("Verify selected value at 'Customer role' dropdown")
    public String getSelectedValueAtCustomerRole() {
        waitForElementVisible(AdminHomePUI.CUSTOMER_ROLE_DROPDOWN_SELECTED_ITEM);
        return getElementText(AdminHomePUI.CUSTOMER_ROLE_DROPDOWN_SELECTED_ITEM);
    }

    @Step("Verify is 'Active' checkbox checked")
    public boolean isActiveCheckboxChecked() {
        waitForElementVisible(AdminHomePUI.ACTIVE_CHECKBOX);
        return isElementSelected(AdminHomePUI.ACTIVE_CHECKBOX);
    }

    @Step("Check to 'Active' checkbox")
    public void checkToActiveCheckbox() {
        waitForElementClickable(AdminHomePUI.ACTIVE_CHECKBOX);
        checkToCheckBoxOrRadio(AdminHomePUI.ACTIVE_CHECKBOX);
    }

    @Step("Enter to text area '{0}' with value '{1}'")
    public void enterToTextAreaByLabel(String labelName, String value) {
        waitForElementVisible(AdminHomePUI.DYNAMIC_TEXTAREA_BY_LABEL,labelName);
        sendKeysToElement(AdminHomePUI.DYNAMIC_TEXTAREA_BY_LABEL,value,labelName);
    }

    @Step("Verify text of text area '{0}'")
    public String getTextAreaTextByLabel(String label) {
        waitForElementVisible(AdminHomePUI.DYNAMIC_TEXTAREA_BY_LABEL,label);
        return getElementText(AdminHomePUI.DYNAMIC_TEXTAREA_BY_LABEL,label);
    }

    @Step("Delete all role in 'Customer role' dropdown")
    public void deleteAllRoleInCustomerRoleDropdown() {
        waitForAllElementVisible(AdminHomePUI.CUSTOMER_ROLE_DELETE_BUTTON);
        getElements(AdminHomePUI.CUSTOMER_ROLE_DELETE_BUTTON).forEach(WebElement::click);
    }

    /**
     * Select item in 'Customer Role' dropdown by clicking
     * @param parentLocator
     * @param childrenLocator
     * @param textValue
     */
    private void selectItemInCustomerRoleDropdown(String parentLocator, String childrenLocator,
                                           String textValue) {
        clickToElement(parentLocator);
        sleepInSecond(1);
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
        List<WebElement> allItems = explicitWait
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childrenLocator)));
        for (WebElement item : allItems) {
            if (item.getText().equals(textValue)) {
                JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
                sleepInSecond(1);
                item.click();
                sleepInSecond(1);
                break;
            }
        }
    }

    @Step("Select 'Customer role' dropdown with value '{0}'")
    public void selectToCustomerRoleDropdown(String value) {
        waitForElementVisible(AdminHomePUI.CUSTOMER_ROLE_DROPDOWN_PARENT_LOCATOR);
        selectItemInCustomerRoleDropdown(AdminHomePUI.CUSTOMER_ROLE_DROPDOWN_PARENT_LOCATOR,
                AdminHomePUI.CUSTOMER_ROLE_DROPDOWN_CHILDREN_LOCATOR,value);
    }


    @Step("Click to 'Save and Continue' Button")
    public void clickToSaveAndContinueButton() {
        waitForElementClickable(AdminHomePUI.CUSTOMER_SAVE_AND_CONTINUE_BUTTON);
        clickToElement(AdminHomePUI.CUSTOMER_SAVE_AND_CONTINUE_BUTTON);
    }

    @Step("Verify add customer success message")
    public String getAddCustomerSuccessMessage() {
        waitForElementVisible(AdminHomePUI.ADD_CUSTOMER_SUCCESS_MESSAGE);
        return getElementText(AdminHomePUI.ADD_CUSTOMER_SUCCESS_MESSAGE);
    }

    @Step("Click to 'Back to customer list' link")
    public void clickToBackToCustomerListLink() {
        waitForElementClickable(AdminHomePUI.BACK_TO_CUSTOMER_LIST_LINK);
        clickToElement(AdminHomePUI.BACK_TO_CUSTOMER_LIST_LINK);
    }

    /**
     * Get all data in a column
     * @param columnName
     * @return
     */
    public String getColumnDataByColumnName(String columnName) {
        String columnTextData = "";
        waitForElementVisible(AdminHomePUI.DYNAMIC_PRECEDING_HEADER_COLUMN_BY_NAME,columnName);
        String columnIndex = String.valueOf(getElementsSize(AdminHomePUI.DYNAMIC_PRECEDING_HEADER_COLUMN_BY_NAME,columnName)+1);
        List<WebElement> columnElements = getElements(AdminHomePUI.DYNAMIC_COLUMN_TABLE_INFO_BY_INDEX,columnIndex);
        for(WebElement element :columnElements){
            columnTextData += " " + element.getText();
        }
        return columnTextData;
    }

    public int getNumberOfCustomerInCustomerTable() {
        waitForAllElementVisible(AdminHomePUI.ALL_ROW_TABLE_INFO);
        return getElementsSize(AdminHomePUI.ALL_ROW_TABLE_INFO);
    }
}
