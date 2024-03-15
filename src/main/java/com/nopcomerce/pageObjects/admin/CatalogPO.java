package com.nopcomerce.pageObjects.admin;

import com.nopcomerce.PageUIs.admin.CatalogPUI;
import commons.BaseComponent;
import commons.BaseComponentUI;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class CatalogPO extends BaseComponent {
    public CatalogPO(WebDriver driver) {
        super(driver);
    }

    @Step("Click to 'Search' button")
    public void clickToSearchProductButton() {
        waitForElementClickable(CatalogPUI.SEARCH_PRODUCT_BUTTON);
        clickToElement(CatalogPUI.SEARCH_PRODUCT_BUTTON);
    }

    @Step("Check to 'Subcategory' checkbox")
    public void checkToSearchSubcategoryCheckbox() {
        waitForElementVisible(CatalogPUI.SUB_CATEGORY_CHECK_BOX);
        checkToCheckBoxOrRadio(CatalogPUI.SUB_CATEGORY_CHECK_BOX);
    }
    @Step("Uncheck to 'Subcategory' checkbox")
    public void uncheckToSearchSubcategoryCheckbox() {
        waitForElementVisible(CatalogPUI.SUB_CATEGORY_CHECK_BOX);
        uncheckToCheckBox(CatalogPUI.SUB_CATEGORY_CHECK_BOX);
    }

    @Step("Click to 'Go' button at 'SKU' textbox")
    public void clickToSkuGoButon() {
        waitForElementClickable(CatalogPUI.SKU_GO_BUTTON);
        clickToElement(CatalogPUI.SKU_GO_BUTTON);
    }

    @Step("Verify data at row '{0}'")
    public String getRowDataByIndex(String rowIndex) {
        waitForElementVisible(CatalogPUI.DYNAMIC_PRODUCT_ROW_TABLE_INFO_BY_INDEX,rowIndex);
        return getElementText(CatalogPUI.DYNAMIC_PRODUCT_ROW_TABLE_INFO_BY_INDEX,rowIndex);
    }
}
