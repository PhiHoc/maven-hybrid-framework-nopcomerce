package com.nopcomerce.pageObjects.user;

import com.nopcomerce.PageUIs.user.HomePUI;
import commons.BaseComponent;
import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class HomePO extends BaseComponent {
    public HomePO(WebDriver driver) {
        super(driver);
    }

    @Step("Click to product link: {0}")
    public void clickToProductByName(String name) {
        waitForElementClickable(HomePUI.DYNAMIC_PRODUCT_LINK_BY_NAME, name);
        clickToElement(HomePUI.DYNAMIC_PRODUCT_LINK_BY_NAME, name);
    }

    @Step("Click to 'Add your review' link")
    public void clickToAddYourReviewLink() {
        waitForElementClickable(HomePUI.ADD_YOUR_REVIEW_LINK);
        clickToElement(HomePUI.ADD_YOUR_REVIEW_LINK);
    }

    @Step("Enter to 'Review textbox' with value: '{0}'")
    public void enterToReviewTitleTextbox(String reviewTitle) {
        waitForElementVisible(HomePUI.REVIEW_TITLE_TEXTBOX);
        sendKeysToElement(HomePUI.REVIEW_TITLE_TEXTBOX, reviewTitle);
    }

    @Step("Enter to 'Review textarea' with value: '{0}'")
    public void enterToReviewTextArea(String reviewText) {
        waitForElementVisible(HomePUI.REVIEW_TEXT_AREA);
        sendKeysToElement(HomePUI.REVIEW_TEXT_AREA, reviewText);
    }

    @Step("Click to 'Submit Review' button")
    public void clickToSubmitReviewButton() {
        waitForElementClickable(HomePUI.SUBMIT_REVIEW_BUTTON);
        clickToElement(HomePUI.SUBMIT_REVIEW_BUTTON);
    }

    @Step("Get submit review result")
    public String getSubmitReviewResult() {
        waitForElementVisible(HomePUI.SUBMIT_REVIEW_RESULT_MESSAGE);
        return getElementText(HomePUI.SUBMIT_REVIEW_RESULT_MESSAGE);
    }

    @Step("Click to 'Computers' menu at Home page")
    public void clickToComputersMenu() {
        waitForElementClickable(HomePUI.COMPUTER_MENU_LINK);
        clickToElement(HomePUI.COMPUTER_MENU_LINK);
    }

    @Step("Click to 'Notebook' submenu")
    public void clickToNoteBookSubMenu() {
        waitForElementClickable(HomePUI.NOTEBOOK_SUBMENU_LINK);
        clickToElement(HomePUI.NOTEBOOK_SUBMENU_LINK);
    }

    @Step("Select to 'Sort by' dropdown with value: '{0}'")
    public void selectToSortByDropdownWithValue(String value) {
        waitForElementVisible(HomePUI.SORT_BY_DROPDOWN);
        selectItemInDropdown(HomePUI.SORT_BY_DROPDOWN, value);
    }

    @Step("Verify is product name sorted from A to Z")
    public boolean isProductNameSortedFromAtoZ() {
        waitForAllElementVisible(HomePUI.PRODUCT_TITLE_AT_SEARCH_PAGE);
        List<WebElement> productNameList = getElements(HomePUI.PRODUCT_TITLE_AT_SEARCH_PAGE);
        List<String> productName = productNameList.stream().map(WebElement::getText).collect(Collectors.toList());
        List<String> sortedProductName = new ArrayList<String>(productName);
        Collections.sort(sortedProductName);
        return sortedProductName.equals(productName);
    }

    @Step("Verify is product name sorted from Z to A")
    public boolean isProductNameSortedFromZtoA() {
        waitForAllElementVisible(HomePUI.PRODUCT_TITLE_AT_SEARCH_PAGE);
        List<WebElement> productNameList = getElements(HomePUI.PRODUCT_TITLE_AT_SEARCH_PAGE);
        List<String> productName = productNameList.stream().map(WebElement::getText).collect(Collectors.toList());
        List<String> sortedProductName = new ArrayList<String>(productName);
        Collections.sort(sortedProductName);
        Collections.reverse(sortedProductName);

        return sortedProductName.equals(productName);
    }

    @Step("Verify is product name sorted from low to high")
    public boolean isProductPriceSortedFromLowToHigh() {
        waitForAllElementVisible(HomePUI.PRODUCT_PRICE_AT_SEARCH_PAGE);
        List<WebElement> productPriceList = getElements(HomePUI.PRODUCT_PRICE_AT_SEARCH_PAGE);
        List<Float> productPrice = productPriceList
                .stream()
                .map(p -> Float.parseFloat(p.getText().replace("$", "").replace(",", "").trim()))
                .collect(Collectors.toList());
        List<Float> sortedProductPrice = new ArrayList<Float>(productPrice);
        Collections.sort(sortedProductPrice);
        return sortedProductPrice.equals(productPrice);
    }

    @Step("Verify is product name sorted from high to low")
    public boolean isProductPriceSortedFromHighToLow() {
        waitForAllElementVisible(HomePUI.PRODUCT_PRICE_AT_SEARCH_PAGE);
        List<WebElement> productPriceList = getElements(HomePUI.PRODUCT_PRICE_AT_SEARCH_PAGE);
        List<Float> productPrice = productPriceList
                .stream()
                .map(p -> Float.parseFloat(p.getText().replace("$", "").replace(",", "").trim()))
                .collect(Collectors.toList());
        List<Float> sortedProductPrice = new ArrayList<Float>(productPrice);
        Collections.sort(sortedProductPrice);
        Collections.reverse(sortedProductPrice);
        return sortedProductPrice.equals(productPrice);
    }

    @Step("Select to 'Display per page' dropdown with value: '{0}'")
    public void selectToDisplayPerPageDropdownWithValue(String value) {
        waitForElementVisible(HomePUI.DISPLAY_PER_PAGE_DROPDOWN);
        selectItemInDropdown(HomePUI.DISPLAY_PER_PAGE_DROPDOWN, value);
    }

    @Step("Get number of products displayed")
    public int getNumberOfProductsDisplayed() {
        waitForAllElementVisible(HomePUI.PRODUCT_TITLE_AT_SEARCH_PAGE);
        return getElementsSize(HomePUI.PRODUCT_TITLE_AT_SEARCH_PAGE);
    }

    @Step("Get paging current page")
    public String getPagingCurrentPage() {
        waitForElementVisible(HomePUI.CURRENT_PAGE_TEXT);
        return getElementText(HomePUI.CURRENT_PAGE_TEXT);
    }

    @Step("Verify is Next icon displayed")
    public boolean isPagingNextIconDisplayed() {
        waitForElementVisible(HomePUI.NEXT_ICON_LINK);
        return isElementDisplayed(HomePUI.NEXT_ICON_LINK);
    }

    @Step("Click to paging 'Next' icon")
    public void clickToPagingNextIcon() {
        waitForElementClickable(HomePUI.NEXT_ICON_LINK);
        clickToElement(HomePUI.NEXT_ICON_LINK);
    }

    @Step("Verify is Previous icon displayed")
    public boolean isPagingPreviousIconDisplayed() {
        waitForElementVisible(HomePUI.PREVIOUS_ICON_LINK);
        return isElementDisplayed(HomePUI.PREVIOUS_ICON_LINK);
    }

    @Step("Verify is Next icon undisplayed")
    public boolean isPagingNextIconUnDisplayed() {
        return isElementUndisplayed(HomePUI.NEXT_ICON_LINK);
    }

    @Step("Click to 'Add to wishlist' button")
    public void clickToAddToWishListButton() {
        waitForElementClickable(HomePUI.ADD_TO_WISHLIST_BUTTON);
        clickToElement(HomePUI.ADD_TO_WISHLIST_BUTTON);
    }

    @Step("Verify bar notification message")
    public String getBarNotificationMessage() {
        waitForElementVisible(HomePUI.NOTIFICATION_SUCCESS_MESSAGE);
        return getElementText(HomePUI.NOTIFICATION_SUCCESS_MESSAGE);
    }

    @Step("Click to close notification message")
    public void clickToCloseNotificationMessageButton() {
        waitForElementClickable(HomePUI.CLOSE_NOTIFICATION_BUTTON);
        clickToElement(HomePUI.CLOSE_NOTIFICATION_BUTTON);
    }

    @Step("Click to 'Add to compare' button of product: '{0}'")
    public void clickToCompareButtonByProductName(String productName) {
        waitForElementClickable(HomePUI.DYNAMIC_ADD_TO_COMPARE_BUTTON_BY_PRODUCT_NAME, productName);
        clickToElement(HomePUI.DYNAMIC_ADD_TO_COMPARE_BUTTON_BY_PRODUCT_NAME, productName);
    }

    @Step("Verify product name in 'Recently viewed' page")
    public List<String> getProductNameListInRecentlyViewPage() {
        waitForAllElementVisible(HomePUI.PRODUCT_TITLE_AT_SEARCH_PAGE);
        return getElements(HomePUI.PRODUCT_TITLE_AT_SEARCH_PAGE).stream().map(WebElement::getText).collect(Collectors.toList());
    }

    @Step("Select '{1}' in '{0}' dropdown")
    public void selectProductAttributeDropdownByLabel(String label, String value) {
        waitForElementVisible(HomePUI.DYNAMIC_PRODUCT_ATTRIBUTE_DROPDOWN_BY_LABEL, label);
        selectItemInDropdown(HomePUI.DYNAMIC_PRODUCT_ATTRIBUTE_DROPDOWN_BY_LABEL, value, label);
    }

    @Step("Check to '{0}' radio")
    public void checkToProductAttributeRadioByLabel(String label) {
        waitForElementClickable(HomePUI.DYNAMIC_PRODUCT_ATTRIBUTE_RADIO_BY_LABEL,label);
        checkToCheckBoxOrRadio(HomePUI.DYNAMIC_PRODUCT_ATTRIBUTE_RADIO_BY_LABEL,label);
    }

    @Step("Check to '{0}' checkbox")
    public void checkToProductAttributeCheckboxByLabel(String label) {
        waitForElementClickable(HomePUI.DYNAMIC_PRODUCT_ATTRIBUTE_CHECKBOX_BY_LABEL,label);
        checkToCheckBoxOrRadio(HomePUI.DYNAMIC_PRODUCT_ATTRIBUTE_CHECKBOX_BY_LABEL,label);
    }

    @Step("Uncheck to '{0}' checkbox")
    public void uncheckToProductAttributeCheckboxByLabel(String label) {
        waitForElementClickable(HomePUI.DYNAMIC_PRODUCT_ATTRIBUTE_CHECKBOX_BY_LABEL,label);
        uncheckToCheckBox(HomePUI.DYNAMIC_PRODUCT_ATTRIBUTE_CHECKBOX_BY_LABEL,label);
    }

    @Step("Click to 'Add to cart' button")
    public void clickToAddToCartButton() {
        waitForElementClickable(HomePUI.PRODUCT_ADD_TO_CART_BUTTON);
        clickToElement(HomePUI.PRODUCT_ADD_TO_CART_BUTTON);
    }

    @Step("Enter to product quantity with value'{0}'")
    public void enterToProductQuantity(String value) {
        waitForElementVisible(HomePUI.PRODUCT_QUANTITY);
        sendKeysToElement(HomePUI.PRODUCT_QUANTITY,value);
    }

    @Step("Click to 'Update' button")
    public void clickToUpdateButton() {
        waitForElementClickable(HomePUI.UPDATE_BUTTON);
        clickToElement(HomePUI.UPDATE_BUTTON);
    }
}
