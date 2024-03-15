package com.nopcomerce.pageObjects.admin;

import com.nopcomerce.PageUIs.admin.CatalogPUI;
import com.nopcomerce.PageUIs.admin.CustomersPUI;
import commons.BaseComponent;
import commons.BaseComponentUI;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CustomersPO extends BaseComponent {
    public CustomersPO(WebDriver driver) {
        super(driver);
    }

    @Step("Click to 'Add new' button at 'Customers' page")
    public void clickToAddNewButton() {
        waitForElementClickable(CustomersPUI.ADD_NEW_BUTTON);
        clickToElement(CustomersPUI.ADD_NEW_BUTTON);
    }

    @Step("Check to 'Male' radio at 'Customers' page")
    public void checkToMaleRadio() {
        waitForElementClickable(CustomersPUI.MALE_RADIO);
        checkToCheckBoxOrRadio(CustomersPUI.MALE_RADIO);
    }

    @Step("Verify is 'Male' radio checked")
    public boolean isMaleGenderRadioChecked() {
        waitForElementVisible(CustomersPUI.MALE_RADIO);
        return isElementSelected(CustomersPUI.MALE_RADIO);
    }

    @Step("Click to 'Search' button")
    public void clickToSearchCustomerButton() {
        waitForElementClickable(CustomersPUI.SEARCH_CUSTOMER_BUTTON);
        clickToElement(CustomersPUI.SEARCH_CUSTOMER_BUTTON);
    }

    @Step("Verify selected value at 'Customer role' dropdown")
    public String getSelectedValueAtCustomerRole() {
        waitForElementVisible(CustomersPUI.CUSTOMER_ROLE_DROPDOWN_SELECTED_ITEM);
        return getElementText(CustomersPUI.CUSTOMER_ROLE_DROPDOWN_SELECTED_ITEM);
    }

    @Step("Verify is 'Active' checkbox checked")
    public boolean isActiveCheckboxChecked() {
        waitForElementVisible(CustomersPUI.ACTIVE_CHECKBOX);
        return isElementSelected(CustomersPUI.ACTIVE_CHECKBOX);
    }

    @Step("Check to 'Active' checkbox")
    public void checkToActiveCheckbox() {
        waitForElementClickable(CustomersPUI.ACTIVE_CHECKBOX);
        checkToCheckBoxOrRadio(CustomersPUI.ACTIVE_CHECKBOX);
    }

    @Step("Delete all role in 'Customer role' dropdown")
    public void deleteAllRoleInCustomerRoleDropdown() {
        waitForAllElementVisible(CustomersPUI.CUSTOMER_ROLE_DELETE_BUTTON);
        getElements(CustomersPUI.CUSTOMER_ROLE_DELETE_BUTTON).forEach(WebElement::click);
    }

    /**
     * Select item in 'Customer Role' dropdown by clicking
     *
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
                sleepInSecond(1);
                item.click();
                sleepInSecond(1);
                break;
            }
        }
    }

    @Step("Select 'Customer role' dropdown with value '{0}'")
    public void selectToCustomerRoleDropdown(String value) {
        waitForElementVisible(CustomersPUI.CUSTOMER_ROLE_DROPDOWN_PARENT_LOCATOR);
        selectItemInCustomerRoleDropdown(CustomersPUI.CUSTOMER_ROLE_DROPDOWN_PARENT_LOCATOR,
                CustomersPUI.CUSTOMER_ROLE_DROPDOWN_CHILDREN_LOCATOR, value);
    }


    @Step("Click to 'Save and Continue' Button")
    public void clickToSaveAndContinueButton() {
        waitForElementClickable(CustomersPUI.CUSTOMER_SAVE_AND_CONTINUE_BUTTON);
        clickToElement(CustomersPUI.CUSTOMER_SAVE_AND_CONTINUE_BUTTON);
    }

    @Step("Verify add customer success message")
    public String getAddCustomerSuccessMessage() {
        waitForElementVisible(CustomersPUI.ADD_CUSTOMER_SUCCESS_MESSAGE);
        return getElementText(CustomersPUI.ADD_CUSTOMER_SUCCESS_MESSAGE);
    }

    @Step("Click to 'Back to customer list' link")
    public void clickToBackToCustomerListLink() {
        waitForElementClickable(CustomersPUI.BACK_TO_CUSTOMER_LIST_LINK);
        clickToElement(CustomersPUI.BACK_TO_CUSTOMER_LIST_LINK);
    }

 @Step("Click to 'Back to customer detail' link")
    public void clickToBackToCustomerDetailLink() {
        waitForElementClickable(CustomersPUI.BACK_TO_CUSTOMER_DETAIL_LINK);
        clickToElement(CustomersPUI.BACK_TO_CUSTOMER_DETAIL_LINK);
    }

    @Step("Verify number of 'Customer info' in table")
    public int getNumberOfCustomerInCustomerTable() {
        waitForAllElementVisible(CustomersPUI.ALL_ROW_TABLE_INFO);
        return getElementsSize(CustomersPUI.ALL_ROW_TABLE_INFO);
    }

    @Step("Enter data to 'Customer' form")
    public void enterDataToCustomerFormTextboxes(String email, String password, String firstName, String lastName,
                                                 String dateOfBirth, String companyName, String adminComment) {
        enterToTextboxByLabel("Email", email);
        enterToTextboxByLabel("Password", password);
        enterToTextboxByLabel("First name", firstName);
        enterToTextboxByLabel("Last name", lastName);
        enterToTextboxByLabel("Date of birth", dateOfBirth);
        enterToTextboxByLabel("Company name", companyName);
        enterToTextAreaByLabel("Admin comment", adminComment);
    }

    @Step("Click to 'Save' Button")
    public void clickToCustomerSaveButton() {
        waitForElementClickable(CustomersPUI.CUSTOMER_SAVE_BUTTON);
        clickToElement(CustomersPUI.CUSTOMER_SAVE_BUTTON);
    }

    @Step("Click to Address 'Save' Button")
    public void clickToAddressSaveButton() {
        waitForElementClickable(CustomersPUI.ADDRESS_SAVE_BUTTON);
        clickToElement(CustomersPUI.ADDRESS_SAVE_BUTTON);
    }

    @Step("Click to Edit Address 'Save' Button")
    public void clickToEditAddressSaveButton() {
        waitForElementClickable(CustomersPUI.EDIT_ADDRESS_SAVE_BUTTON);
        clickToElement(CustomersPUI.EDIT_ADDRESS_SAVE_BUTTON);
    }

    @Step("Click to 'Addresses' card")
    public void clickToAddressesCard() {
        waitForElementClickable(CustomersPUI.ADDRESSES_CARD);
        clickToElement(CustomersPUI.ADDRESSES_CARD);
    }

    @Step("Click to 'Add new address' Button")
    public void clickToAddNewAddressButton() {
        try{
            waitForElementClickable(CustomersPUI.ADD_NEW_ADDRESS_BUTTON);
            clickToElement(CustomersPUI.ADD_NEW_ADDRESS_BUTTON);
        }catch(Exception e){
            clickToAddressesCard();

            waitForElementClickable(CustomersPUI.ADD_NEW_ADDRESS_BUTTON);
            clickToElement(CustomersPUI.ADD_NEW_ADDRESS_BUTTON);
        }

    }

    public void enterDataToAddressFormTextboxes(String firstName, String lastName, String email, String companyName,
                                                String country, String city, String address1, String address2,
                                                String zipCode, String phoneNumber, String faxNumber) {
        enterToTextboxByLabel("Company",companyName);
        enterToTextboxByLabel("First name",firstName);
        enterToTextboxByLabel("Last name",lastName);
        enterToTextboxByLabel("Email",email);
        enterToTextboxByLabel("County / region",country);
        enterToTextboxByLabel("City",city);
        enterToTextboxByLabel("Address 1",address1);
        enterToTextboxByLabel("Address 2",address2);
        enterToTextboxByLabel("Zip / postal code",zipCode);
        enterToTextboxByLabel("Phone number",phoneNumber);
        enterToTextboxByLabel("Fax number",faxNumber);
    }

    @Step("Verify data at row '{0}'")
    public String getAddressRowDataByIndex(String rowIndex) {
        waitForElementVisible(CustomersPUI.DYNAMIC_ADDRESS_ROW_TABLE_INFO_BY_INDEX,rowIndex);
        return getElementText(CustomersPUI.DYNAMIC_ADDRESS_ROW_TABLE_INFO_BY_INDEX,rowIndex);
    }

    @Step("Verify data at column '{1}', row number '{0}'")
    public String getAddressTableDataByRowIndexAndColumnName(String rowIndex, String columnName) {
        String columnIndex;
        if(columnName.equals("First name")){
            columnIndex = "1";
        }
        else{
            columnIndex = String.valueOf(getElementsSize(BaseComponentUI.DYNAMIC_PRECEDING_HEADER_COLUMN_BY_NAME,columnName)+1);
        }
        return getElementText(CustomersPUI.DYNAMIC_ADDRESS_CELL_INFO_BY_ROW_AND_COLUMN_INDEX,rowIndex,columnIndex);
    }

}
