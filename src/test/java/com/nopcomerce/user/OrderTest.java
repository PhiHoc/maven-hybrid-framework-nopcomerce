package com.nopcomerce.user;

import com.nopcomerce.data.UserData;
import com.nopcomerce.pageObjects.user.*;
import commons.BaseTest;
import commons.CommonRegister;
import commons.PageGeneratorManager;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OrderTest extends BaseTest {
    @Parameters({"browser", "role"})
    @BeforeClass
    public void beforeClass(String browserName, String role) {
        email = CommonRegister.getEmail();
        password = CommonRegister.getPassword();
        macbookName = "Apple MacBook Pro 13-inch";

        driver = getBrowserDriver(browserName, role);
        homePO = PageGeneratorManager.getHomePage(driver);

        log.info("Pre-condition Step 01 - Click to Login link");
        loginPO = homePO.clickToLoginLink();

        log.info("Pre-condition Step 02 - Login with a valid account");
        loginPO.loginToAccount(email, password);

        log.info("Pre-condition Step 03 - Verify login success");
        Assert.assertTrue(loginPO.isMyAccountLinkDisplayed());
        homePO = PageGeneratorManager.getHomePage(driver);
    }

    @Description("Checkout with payment method by cheque")
    @Test
    public void Order_01_Checkout_Payment_Method_By_Cheque() {
        log.info("Order 01 - Step 01: Add product '" + macbookName + "' to cart");
        homePO.clickToProductByName(macbookName);

        log.info("Order 01 - Step 02: Click 'Add to cart' button");
        homePO.clickToAddToCartButton();

        log.info("Order 01 - Step 03: Verify add to cart success message");
        Assert.assertEquals(homePO.getBarNotificationMessage(), "The product has been added to your shopping cart");
        homePO.clickToCloseNotificationMessageButton();

        log.info("Order 01 - Step 04: Click to 'Shopping cart' link");
        shoppingCartPO = homePO.clickToShoppingCartLink();

        log.info("Order 01 - Step 04: Update product quantity to 2");
        shoppingCartPO.enterToQuantityTextBoxByProductName(macbookName,"2");
        shoppingCartPO.clickToUpdateCartButton();

        log.info("Order 01 - Step 05: Click to 'Term of service' checkbox");
        shoppingCartPO.checkToAgreeTermOfServiceCheckbox();

        log.info("Order 01 - Step 06: Click to 'Check out' button");
        shoppingCartPO.clickToCheckoutButton();

        log.info("Order 01 - Step 07: Uncheck to 'Shipping to the same address' checkbox");
        shoppingCartPO.uncheckToShippingSameAddressCheckbox();

        log.info("Order 01 - Step 08: Enter address value to 'Billing address' textboxes");
        shoppingCartPO.enterDataToBillingAddressForm(UserData.ShippingAdrress.FIRST_NAME,
                UserData.LAST_NAME, UserData.EMAIL, UserData.COUNTRY, UserData.CITY,
                UserData.ADDRESS1, UserData.ZIP_CODE, UserData.PHONE_NUMBER);

        log.info("Order 01 - Step 09: Click to 'Continue' button at Billing form");
        shoppingCartPO.clickToBillingContinueButton();

        log.info("Order 01 - Step 10: Select 'New Address' on Shipping Address dropdown");
        shoppingCartPO.selectToShippingAddressDropdown("New Address");

        log.info("Order 01 - Step 11: Enter address value to 'Shipping address' textboxes");
        shoppingCartPO.enterDataToShippingAddressForm(UserData.ShippingAdrress.FIRST_NAME,
                UserData.ShippingAdrress.LAST_NAME, UserData.ShippingAdrress.EMAIL,
                UserData.ShippingAdrress.COUNTRY, UserData.ShippingAdrress.CITY,
                UserData.ShippingAdrress.ADDRESS1, UserData.ShippingAdrress.ZIP_CODE,
                UserData.ShippingAdrress.PHONE_NUMBER);

        log.info("Order 01 - Step 12: Click to 'Continue' button at Shipping form");
        shoppingCartPO.clickToShippingContinueButton();

        log.info("Order 01 - Step 13: Click to 'Continue' button at Shipping method form");
        shoppingCartPO.clickToShippingMethodContinueButton();

        log.info("Order 01 - Step 14: Check to 'Check / Money Order' payment method");
        shoppingCartPO.checkToPaymentMethodRadioByLabel("Check / Money Order");

        log.info("Order 01 - Step 15: Click to 'Continue' button at Payment method form");
        shoppingCartPO.clickToPaymentMethodContinueButton();

        log.info("Order 01 - Step 16: Click to 'Continue' button at Payment info form");
        shoppingCartPO.clickToPaymentInfoContinueButton();

        log.info("Order 01 - Step 17: Verify billing address info");
        Assert.assertTrue(shoppingCartPO.getBillingAddressInfo().contains(UserData.FIRST_NAME));
        Assert.assertTrue(shoppingCartPO.getBillingAddressInfo().contains(UserData.LAST_NAME));
        Assert.assertTrue(shoppingCartPO.getBillingAddressInfo().contains(UserData.EMAIL));
        Assert.assertTrue(shoppingCartPO.getBillingAddressInfo().contains(UserData.COUNTRY));
        Assert.assertTrue(shoppingCartPO.getBillingAddressInfo().contains(UserData.CITY));
        Assert.assertTrue(shoppingCartPO.getBillingAddressInfo().contains(UserData.ADDRESS1));
        Assert.assertTrue(shoppingCartPO.getBillingAddressInfo().contains(UserData.ZIP_CODE));
        Assert.assertTrue(shoppingCartPO.getBillingAddressInfo().contains(UserData.PHONE_NUMBER));

        log.info("Order 01 - Step 18: Verify shipping address info");
        Assert.assertTrue(shoppingCartPO.getShippingAddressInfo().contains(UserData.ShippingAdrress.FIRST_NAME));
        Assert.assertTrue(shoppingCartPO.getShippingAddressInfo().contains(UserData.ShippingAdrress.LAST_NAME));
        Assert.assertTrue(shoppingCartPO.getShippingAddressInfo().contains(UserData.ShippingAdrress.EMAIL));
        Assert.assertTrue(shoppingCartPO.getShippingAddressInfo().contains(UserData.ShippingAdrress.COUNTRY));
        Assert.assertTrue(shoppingCartPO.getShippingAddressInfo().contains(UserData.ShippingAdrress.CITY));
        Assert.assertTrue(shoppingCartPO.getShippingAddressInfo().contains(UserData.ShippingAdrress.ADDRESS1));
        Assert.assertTrue(shoppingCartPO.getShippingAddressInfo().contains(UserData.ShippingAdrress.ZIP_CODE));
        Assert.assertTrue(shoppingCartPO.getShippingAddressInfo().contains(UserData.ShippingAdrress.PHONE_NUMBER));

        log.info("Order 01 - Step 19: Verify product name");
        Assert.assertEquals(shoppingCartPO.getProductsNameList().get(0), macbookName);

        log.info("Order 01 - Step 20: Verify Wrapping info");
        Assert.assertEquals(shoppingCartPO.getWrappingCartInfo(), "Gift wrapping: No");

        log.info("Order 01 - Step 21: Verify total price info");
        Assert.assertEquals(shoppingCartPO.getSummaryTotalInfoByLabel("Total:"), "$3,600.00");

        log.info("Order 01 - Step 22: Click to 'Confirm' button");
        shoppingCartPO.clickToCheckoutConfirmButton();

        log.info("Order 01 - Step 23: Verify order success message");
        Assert.assertEquals(shoppingCartPO.getOrderSuccessMessage(), "Your order has been successfully processed!");

        orderNumber = shoppingCartPO.getOrderNumber();
        log.info("Order 01 - Step 24: Get order number: " + orderNumber);

        log.info("Order 01 - Step 25: Click to 'My account' button");
        myAccountPO = shoppingCartPO.clickToMyAccountLink();

        log.info("Order 01 - Step 26: Click to 'Orders' link");
        myAccountPO.clickToOrdersLink();

        log.info("Order 01 - Step 27: Click to 'Detail' button of order: " + orderNumber);
        shoppingCartPO = myAccountPO.clickToOrderDetailByOrderNumber(orderNumber);

        log.info("Order 01 - Step 28: Verify billing address info");
        Assert.assertTrue(shoppingCartPO.getBillingAddressInfo().contains(UserData.FIRST_NAME));
        Assert.assertTrue(shoppingCartPO.getBillingAddressInfo().contains(UserData.LAST_NAME));
        Assert.assertTrue(shoppingCartPO.getBillingAddressInfo().contains(UserData.EMAIL));
        Assert.assertTrue(shoppingCartPO.getBillingAddressInfo().contains(UserData.COUNTRY));
        Assert.assertTrue(shoppingCartPO.getBillingAddressInfo().contains(UserData.CITY));
        Assert.assertTrue(shoppingCartPO.getBillingAddressInfo().contains(UserData.ADDRESS1));
        Assert.assertTrue(shoppingCartPO.getBillingAddressInfo().contains(UserData.ZIP_CODE));
        Assert.assertTrue(shoppingCartPO.getBillingAddressInfo().contains(UserData.PHONE_NUMBER));

        log.info("Order 01 - Step 29: Verify shipping address info");
        Assert.assertTrue(shoppingCartPO.getShippingAddressInfo().contains(UserData.ShippingAdrress.FIRST_NAME));
        Assert.assertTrue(shoppingCartPO.getShippingAddressInfo().contains(UserData.ShippingAdrress.LAST_NAME));
        Assert.assertTrue(shoppingCartPO.getShippingAddressInfo().contains(UserData.ShippingAdrress.EMAIL));
        Assert.assertTrue(shoppingCartPO.getShippingAddressInfo().contains(UserData.ShippingAdrress.COUNTRY));
        Assert.assertTrue(shoppingCartPO.getShippingAddressInfo().contains(UserData.ShippingAdrress.CITY));
        Assert.assertTrue(shoppingCartPO.getShippingAddressInfo().contains(UserData.ShippingAdrress.ADDRESS1));
        Assert.assertTrue(shoppingCartPO.getShippingAddressInfo().contains(UserData.ShippingAdrress.ZIP_CODE));
        Assert.assertTrue(shoppingCartPO.getShippingAddressInfo().contains(UserData.ShippingAdrress.PHONE_NUMBER));

        log.info("Order 01 - Step 30: Verify product name");
        Assert.assertEquals(shoppingCartPO.getProductsNameList().get(0), macbookName);

        log.info("Order 01 - Step 31: Verify total price info");
        Assert.assertEquals(shoppingCartPO.getSummaryTotalInfoByLabel("Order Total:"), "$3,600.00");

        homePO = shoppingCartPO.clickToHomePageLogoLink();

        sleepInSecond(20);
    }

    @Description("Checkout with payment method by Credit Card")
    @Test
    public void Order_02_Checkout_Payment_Method_By_Credit_Card() {
        log.info("Order 02 - Step 01: Add product '" + macbookName + "' to cart");
        homePO.clickToProductByName(macbookName);

        log.info("Order 02 - Step 02: Click 'Add to cart' button");
        homePO.clickToAddToCartButton();

        log.info("Order 02 - Step 03: Verify add to cart success message");
        Assert.assertEquals(homePO.getBarNotificationMessage(), "The product has been added to your shopping cart");
        homePO.clickToCloseNotificationMessageButton();

        log.info("Order 02 - Step 04: Click to 'Shopping cart' link");
        shoppingCartPO = homePO.clickToShoppingCartLink();

        log.info("Order 02 - Step 05: Click to 'Term of service' checkbox");
        shoppingCartPO.checkToAgreeTermOfServiceCheckbox();

        log.info("Order 02 - Step 06: Click to 'Check out' button");
        shoppingCartPO.clickToCheckoutButton();

        log.info("Order 02 - Step 07: Uncheck to 'Shipping to the same address' checkbox");
        shoppingCartPO.uncheckToShippingSameAddressCheckbox();

        shoppingCartPO.selectToBillingAddressDropdown("New Address");

        log.info("Order 02 - Step 08: Enter address value to 'Billing address' textboxes");
        shoppingCartPO.enterDataToBillingAddressForm(UserData.ShippingAdrress.FIRST_NAME,
                UserData.LAST_NAME, UserData.EMAIL, UserData.COUNTRY, UserData.CITY,
                UserData.ADDRESS1, UserData.ZIP_CODE, UserData.PHONE_NUMBER);

        log.info("Order 02 - Step 09: Click to 'Continue' button at Billing form");
        shoppingCartPO.clickToBillingContinueButton();

        log.info("Order 02 - Step 10: Select 'New Address' on Shipping Address dropdown");
        shoppingCartPO.selectToShippingAddressDropdown("New Address");

        log.info("Order 02 - Step 11: Enter address value to 'Shipping address' textboxes");
        shoppingCartPO.enterDataToShippingAddressForm(UserData.ShippingAdrress.FIRST_NAME,
                UserData.ShippingAdrress.LAST_NAME, UserData.ShippingAdrress.EMAIL,
                UserData.ShippingAdrress.COUNTRY, UserData.ShippingAdrress.CITY,
                UserData.ShippingAdrress.ADDRESS1, UserData.ShippingAdrress.ZIP_CODE,
                UserData.ShippingAdrress.PHONE_NUMBER);

        log.info("Order 02 - Step 12: Click to 'Continue' button at Shipping form");
        shoppingCartPO.clickToShippingContinueButton();

        log.info("Order 02 - Step 13: Click to 'Continue' button at Shipping method form");
        shoppingCartPO.clickToShippingMethodContinueButton();

        log.info("Order 02 - Step 14: Check to 'Credit Card' payment method");
        shoppingCartPO.checkToPaymentMethodRadioByLabel("Credit Card");

        log.info("Order 02 - Step 15: Click to 'Continue' button at Payment method form");
        shoppingCartPO.clickToPaymentMethodContinueButton();

        log.info("Order 02 - Step 16: Enter card info to textbox");
        shoppingCartPO.enterToCardHolderNameTextbox(UserData.VisaCard.CARD_HOLDER_NAME);
        shoppingCartPO.enterToCardNumberTextbox(UserData.VisaCard.CARD_NUMBER);
        shoppingCartPO.enterToCardCodeTextbox(UserData.VisaCard.CARD_CODE);
        shoppingCartPO.selectToCardExpirationMonthDropdown(UserData.VisaCard.EXPIRATION_MONTH);
        shoppingCartPO.selectToCardExpirationYearDropdown(UserData.VisaCard.EXPIRATION_YEAR);


        log.info("Order 02 - Step 17: Click to 'Continue' button at Payment info form");
        shoppingCartPO.clickToPaymentInfoContinueButton();

        log.info("Order 02 - Step 18: Verify billing address info");
        Assert.assertTrue(shoppingCartPO.getBillingAddressInfo().contains(UserData.FIRST_NAME));
        Assert.assertTrue(shoppingCartPO.getBillingAddressInfo().contains(UserData.LAST_NAME));
        Assert.assertTrue(shoppingCartPO.getBillingAddressInfo().contains(UserData.EMAIL));
        Assert.assertTrue(shoppingCartPO.getBillingAddressInfo().contains(UserData.COUNTRY));
        Assert.assertTrue(shoppingCartPO.getBillingAddressInfo().contains(UserData.CITY));
        Assert.assertTrue(shoppingCartPO.getBillingAddressInfo().contains(UserData.ADDRESS1));
        Assert.assertTrue(shoppingCartPO.getBillingAddressInfo().contains(UserData.ZIP_CODE));
        Assert.assertTrue(shoppingCartPO.getBillingAddressInfo().contains(UserData.PHONE_NUMBER));

        log.info("Order 02 - Step 19:Verify shipping address info");
        Assert.assertTrue(shoppingCartPO.getShippingAddressInfo().contains(UserData.ShippingAdrress.FIRST_NAME));
        Assert.assertTrue(shoppingCartPO.getShippingAddressInfo().contains(UserData.ShippingAdrress.LAST_NAME));
        Assert.assertTrue(shoppingCartPO.getShippingAddressInfo().contains(UserData.ShippingAdrress.EMAIL));
        Assert.assertTrue(shoppingCartPO.getShippingAddressInfo().contains(UserData.ShippingAdrress.COUNTRY));
        Assert.assertTrue(shoppingCartPO.getShippingAddressInfo().contains(UserData.ShippingAdrress.CITY));
        Assert.assertTrue(shoppingCartPO.getShippingAddressInfo().contains(UserData.ShippingAdrress.ADDRESS1));
        Assert.assertTrue(shoppingCartPO.getShippingAddressInfo().contains(UserData.ShippingAdrress.ZIP_CODE));
        Assert.assertTrue(shoppingCartPO.getShippingAddressInfo().contains(UserData.ShippingAdrress.PHONE_NUMBER));

        log.info("Order 02 - Step 20: Verify product name");
        Assert.assertEquals(shoppingCartPO.getProductsNameList().get(0), macbookName);

        log.info("Order 02 - Step 21: Verify Wrapping info");
        Assert.assertEquals(shoppingCartPO.getWrappingCartInfo(), "Gift wrapping: No");

        log.info("Order 02 - Step 22: Verify total price info");
        Assert.assertEquals(shoppingCartPO.getSummaryTotalInfoByLabel("Total:"), "$3,600.00");

        log.info("Order 02 - Step 23: Click to 'Confirm' button");
        shoppingCartPO.clickToCheckoutConfirmButton();

        log.info("Order 02 - Step 24: Verify order success message");
        Assert.assertEquals(shoppingCartPO.getOrderSuccessMessage(), "Your order has been successfully processed!");

        orderNumber = shoppingCartPO.getOrderNumber();
        log.info("Order 02 - Step 25: Get order number: " + orderNumber);

        log.info("Order 02 - Step 26: Click to 'My account' button");
        myAccountPO = shoppingCartPO.clickToMyAccountLink();

        log.info("Order 02 - Step 27: Click to 'Orders' link");
        myAccountPO.clickToOrdersLink();

        log.info("Order 02 - Step 28: Click to 'Detail' button of order: " + orderNumber);
        shoppingCartPO = myAccountPO.clickToOrderDetailByOrderNumber(orderNumber);

        log.info("Order 02 - Step 29: Verify billing address info");
        Assert.assertTrue(shoppingCartPO.getBillingAddressInfo().contains(UserData.FIRST_NAME));
        Assert.assertTrue(shoppingCartPO.getBillingAddressInfo().contains(UserData.LAST_NAME));
        Assert.assertTrue(shoppingCartPO.getBillingAddressInfo().contains(UserData.EMAIL));
        Assert.assertTrue(shoppingCartPO.getBillingAddressInfo().contains(UserData.COUNTRY));
        Assert.assertTrue(shoppingCartPO.getBillingAddressInfo().contains(UserData.CITY));
        Assert.assertTrue(shoppingCartPO.getBillingAddressInfo().contains(UserData.ADDRESS1));
        Assert.assertTrue(shoppingCartPO.getBillingAddressInfo().contains(UserData.ZIP_CODE));
        Assert.assertTrue(shoppingCartPO.getBillingAddressInfo().contains(UserData.PHONE_NUMBER));

        log.info("Order 02 - Step 30: Verify shipping address info");
        Assert.assertTrue(shoppingCartPO.getShippingAddressInfo().contains(UserData.ShippingAdrress.FIRST_NAME));
        Assert.assertTrue(shoppingCartPO.getShippingAddressInfo().contains(UserData.ShippingAdrress.LAST_NAME));
        Assert.assertTrue(shoppingCartPO.getShippingAddressInfo().contains(UserData.ShippingAdrress.EMAIL));
        Assert.assertTrue(shoppingCartPO.getShippingAddressInfo().contains(UserData.ShippingAdrress.COUNTRY));
        Assert.assertTrue(shoppingCartPO.getShippingAddressInfo().contains(UserData.ShippingAdrress.CITY));
        Assert.assertTrue(shoppingCartPO.getShippingAddressInfo().contains(UserData.ShippingAdrress.ADDRESS1));
        Assert.assertTrue(shoppingCartPO.getShippingAddressInfo().contains(UserData.ShippingAdrress.ZIP_CODE));
        Assert.assertTrue(shoppingCartPO.getShippingAddressInfo().contains(UserData.ShippingAdrress.PHONE_NUMBER));

        log.info("Order 02 - Step 31: Verify product name");
        Assert.assertEquals(shoppingCartPO.getProductsNameList().get(0), macbookName);

        log.info("Order 02 - Step 32: Verify total price info");
        Assert.assertEquals(shoppingCartPO.getSummaryTotalInfoByLabel("Order Total:"), "$3,600.00");

        homePO = shoppingCartPO.clickToHomePageLogoLink();

        sleepInSecond(20);
    }

    @Description("Re order")
    @Test
    public void Order_03_Re_Order() {
        log.info("Order 03 - Step 01: Click to 'My account' link");
        myAccountPO = homePO.clickToMyAccountLink();

        log.info("Order 03 - Step 02: Click to 'Orders' link");
        myAccountPO.clickToOrdersLink();

        log.info("Order 03 - Step 03: Click to Detail button of product" + orderNumber);
        shoppingCartPO = myAccountPO.clickToOrderDetailByOrderNumber(orderNumber);

        log.info("Order 03 - Step 04: Click to 'Re Order' checkbox");
        shoppingCartPO.clickToReOrderButton();

        log.info("Order 03 - Step 05: Update product quantity to 10");
        shoppingCartPO.enterToQuantityTextBoxByProductName(macbookName, "10");

        log.info("Order 03 - Step 06: Click to 'Upadate cart' button");
        shoppingCartPO.clickToUpdateCartButton();

        log.info("Order 03 - Step 07: Check to 'Agree term of service' checkbox");
        shoppingCartPO.checkToAgreeTermOfServiceCheckbox();

        log.info("Order 03 - Step 08: Click to 'Check out' button");
        shoppingCartPO.clickToCheckoutButton();

        log.info("Order 03 - Step 09: Uncheck to 'Shipping to the same address' checkbox");
        shoppingCartPO.uncheckToShippingSameAddressCheckbox();

        log.info("Order 03 - Step 10: Select 'New Address' in Billing Addres Dropdown");
        shoppingCartPO.selectToBillingAddressDropdown("New Address");

        log.info("Order 03 - Step 11: Enter address value to 'Billing address' textboxes");
        shoppingCartPO.enterDataToBillingAddressForm(UserData.ShippingAdrress.FIRST_NAME,
                UserData.LAST_NAME, UserData.EMAIL, UserData.COUNTRY, UserData.CITY,
                UserData.ADDRESS1, UserData.ZIP_CODE, UserData.PHONE_NUMBER);

        log.info("Order 03 - Step 12: Click to 'Continue' button at Billing form");
        shoppingCartPO.clickToBillingContinueButton();

        log.info("Order 03 - Step 13: Select 'New Address' on Shipping Address dropdown");
        shoppingCartPO.selectToShippingAddressDropdown("New Address");

        log.info("Order 03 - Step 14: Enter address value to 'Shipping address' textboxes");
        shoppingCartPO.enterDataToShippingAddressForm(UserData.ShippingAdrress.FIRST_NAME,
                UserData.ShippingAdrress.LAST_NAME, UserData.ShippingAdrress.EMAIL,
                UserData.ShippingAdrress.COUNTRY, UserData.ShippingAdrress.CITY,
                UserData.ShippingAdrress.ADDRESS1, UserData.ShippingAdrress.ZIP_CODE,
                UserData.ShippingAdrress.PHONE_NUMBER);

        log.info("Order 03 - Step 15: Click to 'Continue' button at Shipping form");
        shoppingCartPO.clickToShippingContinueButton();

        log.info("Order 03 - Step 16: Click to 'Continue' button at Shipping method form");
        shoppingCartPO.clickToShippingMethodContinueButton();

        log.info("Order 03 - Step 17: Check to 'Check / Money Order' payment method");
        shoppingCartPO.checkToPaymentMethodRadioByLabel("Check / Money Order");

        log.info("Order 03 - Step 18: Click to 'Continue' button at Payment method form");
        shoppingCartPO.clickToPaymentMethodContinueButton();

        log.info("Order 03 - Step 19: Click to 'Continue' button at Payment info form");
        shoppingCartPO.clickToPaymentInfoContinueButton();

        log.info("Order 03 - Step 20: Verify billing address info");
        Assert.assertTrue(shoppingCartPO.getBillingAddressInfo().contains(UserData.FIRST_NAME));
        Assert.assertTrue(shoppingCartPO.getBillingAddressInfo().contains(UserData.LAST_NAME));
        Assert.assertTrue(shoppingCartPO.getBillingAddressInfo().contains(UserData.EMAIL));
        Assert.assertTrue(shoppingCartPO.getBillingAddressInfo().contains(UserData.COUNTRY));
        Assert.assertTrue(shoppingCartPO.getBillingAddressInfo().contains(UserData.CITY));
        Assert.assertTrue(shoppingCartPO.getBillingAddressInfo().contains(UserData.ADDRESS1));
        Assert.assertTrue(shoppingCartPO.getBillingAddressInfo().contains(UserData.ZIP_CODE));
        Assert.assertTrue(shoppingCartPO.getBillingAddressInfo().contains(UserData.PHONE_NUMBER));

        log.info("Order 03 - Step 21: Verify shipping address info");
        Assert.assertTrue(shoppingCartPO.getShippingAddressInfo().contains(UserData.ShippingAdrress.FIRST_NAME));
        Assert.assertTrue(shoppingCartPO.getShippingAddressInfo().contains(UserData.ShippingAdrress.LAST_NAME));
        Assert.assertTrue(shoppingCartPO.getShippingAddressInfo().contains(UserData.ShippingAdrress.EMAIL));
        Assert.assertTrue(shoppingCartPO.getShippingAddressInfo().contains(UserData.ShippingAdrress.COUNTRY));
        Assert.assertTrue(shoppingCartPO.getShippingAddressInfo().contains(UserData.ShippingAdrress.CITY));
        Assert.assertTrue(shoppingCartPO.getShippingAddressInfo().contains(UserData.ShippingAdrress.ADDRESS1));
        Assert.assertTrue(shoppingCartPO.getShippingAddressInfo().contains(UserData.ShippingAdrress.ZIP_CODE));
        Assert.assertTrue(shoppingCartPO.getShippingAddressInfo().contains(UserData.ShippingAdrress.PHONE_NUMBER));

        log.info("Order 03 - Step 22: Verify product name");
        Assert.assertEquals(shoppingCartPO.getProductsNameList().get(0), macbookName);

        log.info("Order 03 - Step 23: Verify Wrapping info");
        Assert.assertEquals(shoppingCartPO.getWrappingCartInfo(), "Gift wrapping: No");

        log.info("Order 03 - Step 24: Verify total price info");
        Assert.assertEquals(shoppingCartPO.getSummaryTotalInfoByLabel("Total:"), "$18,000.00");

        log.info("Order 03 - Step 25: Click to 'Confirm' button");
        shoppingCartPO.clickToCheckoutConfirmButton();

        log.info("Order 03 - Step 26: Verify order success message");
        Assert.assertEquals(shoppingCartPO.getOrderSuccessMessage(), "Your order has been successfully processed!");

        log.info("Order 03 - Step 27: Get order number");
        orderNumber = shoppingCartPO.getOrderNumber();

        log.info("Order 03 - Step 28: Click to 'My account' button");
        myAccountPO = shoppingCartPO.clickToMyAccountLink();

        log.info("Order 03 - Step 29: Click to 'Orders' link");
        myAccountPO.clickToOrdersLink();

        log.info("Order 03 - Step 30: Click to 'Detail' button of order: " + orderNumber);
        shoppingCartPO = myAccountPO.clickToOrderDetailByOrderNumber(orderNumber);

        log.info("Order 03 - Step 31: Verify billing address info");
        Assert.assertTrue(shoppingCartPO.getBillingAddressInfo().contains(UserData.FIRST_NAME));
        Assert.assertTrue(shoppingCartPO.getBillingAddressInfo().contains(UserData.LAST_NAME));
        Assert.assertTrue(shoppingCartPO.getBillingAddressInfo().contains(UserData.EMAIL));
        Assert.assertTrue(shoppingCartPO.getBillingAddressInfo().contains(UserData.COUNTRY));
        Assert.assertTrue(shoppingCartPO.getBillingAddressInfo().contains(UserData.CITY));
        Assert.assertTrue(shoppingCartPO.getBillingAddressInfo().contains(UserData.ADDRESS1));
        Assert.assertTrue(shoppingCartPO.getBillingAddressInfo().contains(UserData.ZIP_CODE));
        Assert.assertTrue(shoppingCartPO.getBillingAddressInfo().contains(UserData.PHONE_NUMBER));

        log.info("Order 03 - Step 32: Verify shipping address info");
        Assert.assertTrue(shoppingCartPO.getShippingAddressInfo().contains(UserData.ShippingAdrress.FIRST_NAME));
        Assert.assertTrue(shoppingCartPO.getShippingAddressInfo().contains(UserData.ShippingAdrress.LAST_NAME));
        Assert.assertTrue(shoppingCartPO.getShippingAddressInfo().contains(UserData.ShippingAdrress.EMAIL));
        Assert.assertTrue(shoppingCartPO.getShippingAddressInfo().contains(UserData.ShippingAdrress.COUNTRY));
        Assert.assertTrue(shoppingCartPO.getShippingAddressInfo().contains(UserData.ShippingAdrress.CITY));
        Assert.assertTrue(shoppingCartPO.getShippingAddressInfo().contains(UserData.ShippingAdrress.ADDRESS1));
        Assert.assertTrue(shoppingCartPO.getShippingAddressInfo().contains(UserData.ShippingAdrress.ZIP_CODE));
        Assert.assertTrue(shoppingCartPO.getShippingAddressInfo().contains(UserData.ShippingAdrress.PHONE_NUMBER));

        log.info("Order 03 - Step 33: Verify product name");
        Assert.assertEquals(shoppingCartPO.getProductsNameList().get(0), macbookName);

        log.info("Order 03 - Step 34: Verify total price info");
        Assert.assertEquals(shoppingCartPO.getSummaryTotalInfoByLabel("Order Total:"), "$18,000.00");

        log.info("Order 03 - Step 35: Verify total price info");
        homePO = shoppingCartPO.clickToHomePageLogoLink();
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserDriver();
    }

    private WebDriver driver;
    private HomePO homePO;
    String email, password, macbookName, orderNumber;
    private LoginPO loginPO;
    private ShoppingCartPO shoppingCartPO;
    private MyAccountPO myAccountPO;
}
