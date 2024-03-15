package com.nopcomerce.pageObjects.user;

import com.nopcomerce.PageUIs.user.ShoppingCartPUI;
import commons.BaseComponent;
import commons.BasePage;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import org.openqa.selenium.*;

import java.util.List;
import java.util.stream.Collectors;

public class ShoppingCartPO extends BaseComponent {
    private WebDriver driver;

    public ShoppingCartPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Verify products name")
    public List<String> getProductsNameList() {
        waitForAllElementVisible(ShoppingCartPUI.PRODUCTS_NAME_LINK);
        return getElements(ShoppingCartPUI.PRODUCTS_NAME_LINK).stream().map(WebElement::getText).collect(Collectors.toList());
    }

    @Step("Verify products attribute of '{0}'")
    public String getProductAttributeByName(String name) {
        waitForElementVisible(ShoppingCartPUI.DYNAMIC_PRODUCTS_ATTRIBUTE_BY_NAME, name);
        return getElementText(ShoppingCartPUI.DYNAMIC_PRODUCTS_ATTRIBUTE_BY_NAME, name);
    }

    @Step("Get price of product '{0}'")
    public String getProductsPriceByProductName(String name) {
        waitForElementVisible(ShoppingCartPUI.DYNAMIC_PRODUCTS_PRICE_BY_NAME, name);
        return getElementText(ShoppingCartPUI.DYNAMIC_PRODUCTS_PRICE_BY_NAME, name);
    }

    @Step("Get total price of product '{0}'")
    public String getProductsTotalPriceByProductName(String name) {
        waitForElementVisible(ShoppingCartPUI.DYNAMIC_PRODUCTS_TOTAL_PRICE_BY_NAME, name);
        return getElementText(ShoppingCartPUI.DYNAMIC_PRODUCTS_TOTAL_PRICE_BY_NAME, name);
    }

    @Step("Click to product '{0}' edit link")
    public HomePO clickToProductEditLinkByName(String pcName) {
        waitForElementClickable(ShoppingCartPUI.DYNAMIC_PRODUCTS_EDIT_LINK_BY_NAME, pcName);
        clickToElement(ShoppingCartPUI.DYNAMIC_PRODUCTS_EDIT_LINK_BY_NAME, pcName);
        return PageGeneratorManager.getHomePage(driver);
    }

    @Step("Click to all remove product button")
    public void clickToRemoveAllProduct() {
        waitForAllElementVisible(ShoppingCartPUI.REMOVE_PRODUCT_BUTTON);
        getElements(ShoppingCartPUI.REMOVE_PRODUCT_BUTTON).forEach(WebElement::click);
    }

    @Step("Verify empty shopping cart message")
    public String getEmptyShoppingCartMessage() {
        waitForElementVisible(ShoppingCartPUI.SHOPPING_CART_EMPTY_MESSAGE);
        return getElementText(ShoppingCartPUI.SHOPPING_CART_EMPTY_MESSAGE);
    }

    @Step("Verify number of product at 'Shopping cart' link")
    public String getProductNumberAtShoppingCartLink() {
        waitForElementVisible(ShoppingCartPUI.QUANTITY_NUMBER_AT_SHOPPING_CART_LINK);
        return getElementText(ShoppingCartPUI.QUANTITY_NUMBER_AT_SHOPPING_CART_LINK);
    }

    @Step("Enter to quantity textbox of product {0}")
    public void enterToQuantityTextBoxByProductName(String name, String number) {
        waitForElementVisible(ShoppingCartPUI.DYNAMIC_PRODUCTS_QUANTITY_TEXTBOX_BY_NAME, name);
        sendKeysToElement(ShoppingCartPUI.DYNAMIC_PRODUCTS_QUANTITY_TEXTBOX_BY_NAME, number, name);
    }

    @Step("Click to 'Update cart' button")
    public void clickToUpdateCartButton() {
        waitForElementClickable(ShoppingCartPUI.UPDATE_CART_BUTTON);
        clickToElement(ShoppingCartPUI.UPDATE_CART_BUTTON);
    }

    @Step("Click to 'Continue' button at Billing form")
    public void clickToBillingContinueButton() {
        waitForElementClickable(ShoppingCartPUI.BILLING_ADDRESS_CONTINUE_BUTTON);
        clickToElement(ShoppingCartPUI.BILLING_ADDRESS_CONTINUE_BUTTON);
    }

    @Step("Click to 'Continue' button at Shipping form")
    public void clickToShippingContinueButton() {
        waitForElementClickable(ShoppingCartPUI.SHIPPING_ADDRESS_CONTINUE_BUTTON);
        clickToElement(ShoppingCartPUI.SHIPPING_ADDRESS_CONTINUE_BUTTON);
    }

    @Step("Click to 'Continue' button at Shipping method form")
    public void clickToShippingMethodContinueButton() {
        waitForElementClickable(ShoppingCartPUI.SHIPPING_METHOD_CONTINUE_BUTTON);
        clickToElement(ShoppingCartPUI.SHIPPING_METHOD_CONTINUE_BUTTON);
    }

    @Step("Click to 'Continue' button at Payment method form")
    public void clickToPaymentMethodContinueButton() {
        waitForElementClickable(ShoppingCartPUI.PAYMENT_METHOD_CONTINUE_BUTTON);
        clickToElement(ShoppingCartPUI.PAYMENT_METHOD_CONTINUE_BUTTON);
    }

    @Step("Click to 'Continue' button at Payment info form")
    public void clickToPaymentInfoContinueButton() {
        waitForElementClickable(ShoppingCartPUI.PAYMENT_INFO_CONTINUE_BUTTON);
        clickToElement(ShoppingCartPUI.PAYMENT_INFO_CONTINUE_BUTTON);
    }

    @Step("Check to 'Agree term of service' checkbox")
    public void checkToAgreeTermOfServiceCheckbox() {
        waitForElementVisible(ShoppingCartPUI.AGREE_TERM_OF_SERVICE_CHECKBOX);
        checkToCheckBoxOrRadio(ShoppingCartPUI.AGREE_TERM_OF_SERVICE_CHECKBOX);
    }

    @Step("Click to 'Checkout' button")
    public void clickToCheckoutButton() {
        waitForElementClickable(ShoppingCartPUI.CHECK_OUT_BUTTON);
        clickToElement(ShoppingCartPUI.CHECK_OUT_BUTTON);
    }

    @Step("Uncheck to 'Shipping to the same address' checkbox")
    public void uncheckToShippingSameAddressCheckbox() {
        waitForElementVisible(ShoppingCartPUI.SHIPPING_TO_SAME_ADDRESS_CHECKBOX);
        uncheckToCheckBox(ShoppingCartPUI.SHIPPING_TO_SAME_ADDRESS_CHECKBOX);
    }

    @Step("Enter to '{0}' checkbox with value {1}")
    public void enterToBillingAddressTextboxByLabel(String label, String value) {
        waitForElementVisible(ShoppingCartPUI.DYNAMIC_BILLING_ADDRESS_TEXTBOX_BY_LABEL, label);
        sendKeysToElement(ShoppingCartPUI.DYNAMIC_BILLING_ADDRESS_TEXTBOX_BY_LABEL, value, label);
    }

    public void enterDataToBillingAddressForm(String firstName, String lastName, String email, String country, String city, String address1, String zipCode, String phoneNumber) {
        enterToBillingAddressTextboxByLabel("First name:", firstName);
        enterToBillingAddressTextboxByLabel("Last name:", lastName);
        enterToBillingAddressTextboxByLabel("Email:", email);
        selectToBillingAddressCountryDropdown(country);
        enterToBillingAddressTextboxByLabel("City:", city);
        enterToBillingAddressTextboxByLabel("Address 1:", address1);
        enterToBillingAddressTextboxByLabel("Zip / postal code:", zipCode);
        enterToBillingAddressTextboxByLabel("Phone number:", phoneNumber);
    }

    public void enterDataToShippingAddressForm(String firstName, String lastName, String email, String country, String city, String address1, String zipCode, String phoneNumber) {
        enterToShippingAddressTextboxByLabel("First name:", firstName);
        enterToShippingAddressTextboxByLabel("Last name:", lastName);
        enterToShippingAddressTextboxByLabel("Email:", email);
        selectToShippingAddressCountryDropdown(country);
        enterToShippingAddressTextboxByLabel("City:", city);
        enterToShippingAddressTextboxByLabel("Address 1:", address1);
        enterToShippingAddressTextboxByLabel("Zip / postal code:", zipCode);
        enterToShippingAddressTextboxByLabel("Phone number:", phoneNumber);
    }

    @Step("Select value '{0}' in Shipping Address dropdown")
    public void selectToShippingAddressDropdown(String value) {
        waitForElementVisible(ShoppingCartPUI.SHIPPING_ADDRESS_DROPDOWN);
        selectItemInDropdown(ShoppingCartPUI.SHIPPING_ADDRESS_DROPDOWN, value);
    }

    @Step("Select value '{0}' in Shipping Address dropdown")
    public void selectToBillingAddressDropdown(String value) {
        waitForElementVisible(ShoppingCartPUI.BILLING_ADDRESS_DROPDOWN);
        selectItemInDropdown(ShoppingCartPUI.BILLING_ADDRESS_DROPDOWN, value);
    }

    @Step("Enter to '{0}' checkbox with value {1}")
    public void enterToShippingAddressTextboxByLabel(String label, String value) {
        waitForElementVisible(ShoppingCartPUI.DYNAMIC_SHIPPING_ADDRESS_TEXTBOX_BY_LABEL, label);
        sendKeysToElement(ShoppingCartPUI.DYNAMIC_SHIPPING_ADDRESS_TEXTBOX_BY_LABEL, value, label);
    }

    @Step("Check to '{0}' radio at payment method")
    public void checkToPaymentMethodRadioByLabel(String label) {
        waitForElementVisible(ShoppingCartPUI.DYNAMIC_PAYMENT_METHOD_RADIO_BY_LABEL,label);
        checkToCheckBoxOrRadio(ShoppingCartPUI.DYNAMIC_PAYMENT_METHOD_RADIO_BY_LABEL,label);
    }

    @Step("Verify billing address info")
    public String getBillingAddressInfo() {
        waitForElementVisible(ShoppingCartPUI.BILLING_ADDRESS_INFO);
        return getElementText(ShoppingCartPUI.BILLING_ADDRESS_INFO);
    }

    @Step("Verify shipping address info")
    public String getShippingAddressInfo() {
        waitForElementVisible(ShoppingCartPUI.SHIPPING_ADDRESS_INFO);
        return getElementText(ShoppingCartPUI.SHIPPING_ADDRESS_INFO);
    }

    @Step("Verify Wrapping Cart info")
    public String getWrappingCartInfo() {
        waitForElementVisible(ShoppingCartPUI.WRAPPING_CART_INFO);
        return getElementText(ShoppingCartPUI.WRAPPING_CART_INFO);
    }

    @Step("Verify '{0}' info")
    public String getSummaryTotalInfoByLabel(String label) {
        waitForElementVisible(ShoppingCartPUI.DYNAMIC_SUMMARY_TOTAL_INFO_BY_LABEL,label);
        return getElementText(ShoppingCartPUI.DYNAMIC_SUMMARY_TOTAL_INFO_BY_LABEL,label);
    }

    @Step("Click to 'Confirm' button")
    public void clickToCheckoutConfirmButton() {
        waitForElementClickable(ShoppingCartPUI.CONFIRM_CHECKOUT_BUTTON);
        clickToElement(ShoppingCartPUI.CONFIRM_CHECKOUT_BUTTON);
    }

    @Step("Verify order success message")
    public String getOrderSuccessMessage() {
        waitForElementVisible(ShoppingCartPUI.ORDER_SUCCESS_MESSAGE);
        return getElementText(ShoppingCartPUI.ORDER_SUCCESS_MESSAGE);
    }

    @Step("Get order number")
    public String getOrderNumber() {
        waitForElementVisible(ShoppingCartPUI.ORDER_NUMBER);
        return getElementText(ShoppingCartPUI.ORDER_NUMBER).replace("ORDER NUMBER: ","");
    }

    @Step("Select to Billing address country dropdown with value: '{0}'")
    public void selectToBillingAddressCountryDropdown(String countryName) {
        waitForElementVisible(ShoppingCartPUI.BILLING_ADDRESS_COUNTRY_DROPDOWN);
        selectItemInDropdown(ShoppingCartPUI.BILLING_ADDRESS_COUNTRY_DROPDOWN,countryName);
    }

    @Step("Select to Shipping address country dropdown with value: '{0}'")
    public void selectToShippingAddressCountryDropdown(String countryName) {
        waitForElementVisible(ShoppingCartPUI.SHIPPING_ADDRESS_COUNTRY_DROPDOWN);
        selectItemInDropdown(ShoppingCartPUI.SHIPPING_ADDRESS_COUNTRY_DROPDOWN,countryName);
    }

    @Step("Enter to 'Card holder name' textbox with value: {0}")
    public void enterToCardHolderNameTextbox(String cardHolderName) {
        waitForElementVisible(ShoppingCartPUI.CARD_HOLDER_NAME_TEXTBOX);
        sendKeysToElement(ShoppingCartPUI.CARD_HOLDER_NAME_TEXTBOX,cardHolderName);
    }

    @Step("Enter to 'Card number' textbox with value: {0}")
    public void enterToCardNumberTextbox(String cardNumber) {
        waitForElementVisible(ShoppingCartPUI.CARD_NUMBER_TEXTBOX);
        sendKeysToElement(ShoppingCartPUI.CARD_NUMBER_TEXTBOX,cardNumber);
    }

    @Step("Enter to 'Card code' textbox with value: {0}")
    public void enterToCardCodeTextbox(String cardCode) {
        waitForElementVisible(ShoppingCartPUI.CARD_CODE_TEXTBOX);
        sendKeysToElement(ShoppingCartPUI.CARD_CODE_TEXTBOX,cardCode);
    }

    @Step("Select to Card Expiration month: '{0}'")
    public void selectToCardExpirationMonthDropdown(String expirationMonth) {
        waitForElementVisible(ShoppingCartPUI.EXPIRE_MONTH_DROPDOWN);
        selectItemInDropdown(ShoppingCartPUI.EXPIRE_MONTH_DROPDOWN,expirationMonth);
    }

    @Step("Select to Card Expiration year: '{0}'")
    public void selectToCardExpirationYearDropdown(String expirationYear) {
        waitForElementVisible(ShoppingCartPUI.EXPIRE_YEAR_DROPDOWN);
        selectItemInDropdown(ShoppingCartPUI.EXPIRE_YEAR_DROPDOWN,expirationYear);
    }

    @Step("Click to 'Re Order' button")
    public void clickToReOrderButton() {
        waitForElementClickable(ShoppingCartPUI.RE_ORDER_BUTTON);
        clickToElement(ShoppingCartPUI.RE_ORDER_BUTTON);
    }
}
