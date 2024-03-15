package com.nopcomerce.pageObjects.user;

import commons.BasePage;
import io.qameta.allure.Step;
import com.nopcomerce.PageUIs.user.SearchPUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class SearchPO extends BasePage {
    public SearchPO(WebDriver driver) {
        super(driver);
    }

    @Step("Click to search button")
    public void clickToSearchButton() {
        waitForElementClickable(SearchPUI.SEARCH_BUTTON);
        clickToElement(SearchPUI.SEARCH_BUTTON);
    }

    @Step("Verify search result message")
    public String getSearchResultMessage() {
        waitForElementVisible(SearchPUI.SEARCH_RESULT_MESSAGE);
        return getElementText(SearchPUI.SEARCH_RESULT_MESSAGE);
    }

    @Step("Enter to search textbox with value: '{0}'")
    public void enterToSearchTextBox(String value) {
        waitForElementVisible(SearchPUI.SEARCH_TEXTBOX);
        sendKeysToElement(SearchPUI.SEARCH_TEXTBOX,value);
    }

    @Step("Verify number of searched products")
    public int getNumberOfProductsAppear() {
        waitForAllElementVisible(SearchPUI.SEARCHED_PRODUCT_ITEM);
        return getElementsSize(SearchPUI.SEARCHED_PRODUCT_ITEM);
    }

    @Step("Verify products name")
    public List<String> getProductsNameList() {
        waitForAllElementVisible(SearchPUI.SEARCHED_PRODUCT_NAME);
        List<WebElement> productElement = getElements(SearchPUI.SEARCHED_PRODUCT_NAME);
        return productElement.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    @Step("Check to 'Advanced Search' checkbox")
    public void checkToAdvancedSearchCheckBox() {
        waitForElementClickable(SearchPUI.ADVANCED_SEARCH_CHECKBOX);
        checkToCheckBoxOrRadio(SearchPUI.ADVANCED_SEARCH_CHECKBOX);
    }

    @Step("Select '{0}' in Category dropdown")
    public void selectCategoryDropdownWithValue(String value) {
        waitForElementVisible(SearchPUI.CATEGORY_DROPDOWN);
        selectItemInDropdown(SearchPUI.CATEGORY_DROPDOWN,value);
    }

    @Step("Select '{0}' in Manufacturer dropdown")
    public void selectManufacturerDropdownWithValue(String value) {
        waitForElementVisible(SearchPUI.MANUFACTURER_DROPDOWN);
        selectItemInDropdown(SearchPUI.MANUFACTURER_DROPDOWN,value);
    }

    @Step("Uncheck to 'Automatically search sub categories' checkbox")
    public void unCheckToAutoSearchSubCategoryCheckBox() {
        waitForElementClickable(SearchPUI.AUTO_SEARCH_SUB_CATEGORY_CHECKBOX);
        uncheckToCheckBox(SearchPUI.AUTO_SEARCH_SUB_CATEGORY_CHECKBOX);
    }

    @Step("Check to 'Automatically search sub categories' checkbox")
    public void checkToAutoSearchSubCategoryCheckBox() {
        waitForElementClickable(SearchPUI.AUTO_SEARCH_SUB_CATEGORY_CHECKBOX);
        checkToCheckBoxOrRadio(SearchPUI.AUTO_SEARCH_SUB_CATEGORY_CHECKBOX);
    }
}