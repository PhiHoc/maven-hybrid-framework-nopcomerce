package com.nopcomerce.pageObjects.user;

import commons.BasePage;
import io.qameta.allure.Step;
import com.nopcomerce.PageUIs.user.CompareProductPUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class CompareProductPO extends BasePage {
    public CompareProductPO(WebDriver driver) {
        super(driver);
    }

    @Step("Verify compare product name")
    public List<String> getCompareProductNameList() {
        waitForAllElementVisible(CompareProductPUI.COMPARE_PRODUCTS_NAME);
        return getElements(CompareProductPUI.COMPARE_PRODUCTS_NAME)
                .stream().map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public void clickToClearListButton() {
        waitForElementClickable(CompareProductPUI.CLEAR_LIST_BUTTON);
        clickToElement(CompareProductPUI.CLEAR_LIST_BUTTON);
    }

    public String getNoCompareProductMessage() {
        waitForElementVisible(CompareProductPUI.COMPARE_NO_DATA_MESSAGE);
        return getElementText(CompareProductPUI.COMPARE_NO_DATA_MESSAGE);
    }
}
