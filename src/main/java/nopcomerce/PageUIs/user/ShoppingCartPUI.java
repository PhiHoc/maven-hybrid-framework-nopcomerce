package nopcomerce.PageUIs.user;

public class ShoppingCartPUI {
    public static final String SHOPPING_CART_PAGE_TITILE = "//div[@class='page-title']";
    public static final String PRODUCTS_NAME_LINK = "//td[@class='product']//a";
    public static final String DYNAMIC_PRODUCTS_ATTRIBUTE_BY_NAME = "//a[text()='%s']/following-sibling::div[@class='attributes']";
    public static final String DYNAMIC_PRODUCTS_PRICE_BY_NAME = "//a[text()='%s']/parent::td//following-sibling::td[@class='unit-price']";
    public static final String DYNAMIC_PRODUCTS_TOTAL_PRICE_BY_NAME = "//a[text()='%s']/parent::td//following-sibling::td[@class='subtotal']/span";
    public static final String DYNAMIC_PRODUCTS_QUANTITY_TEXTBOX_BY_NAME = "//a[text()='%s']/parent::td//following-sibling::td[@class='quantity']/input";
    public static final String DYNAMIC_PRODUCTS_EDIT_LINK_BY_NAME = "//a[text()='%s']//following-sibling::div[@class='edit-item']/a";
    public static final String REMOVE_PRODUCT_BUTTON = "//button[@class='remove-btn']";
    public static final String SHOPPING_CART_EMPTY_MESSAGE = "//div[@class='no-data']";
    public static final String QUANTITY_NUMBER_AT_SHOPPING_CART_LINK = "//span[@class='cart-qty']";
    public static final String UPDATE_CART_BUTTON = "//button[@id='updatecart']";
    public static final String AGREE_TERM_OF_SERVICE_CHECKBOX = "//input[@id='termsofservice']";
    public static final String CHECK_OUT_BUTTON = "//button[@id='checkout']";
    public static final String SHIPPING_TO_SAME_ADDRESS_CHECKBOX = "//input[@id='ShipToSameAddress']";
    public static final String DYNAMIC_BILLING_ADDRESS_TEXTBOX_BY_LABEL = "//label[text()='%s']/following-sibling::input[starts-with(@id,'Billing')]";
    public static final String DYNAMIC_SHIPPING_ADDRESS_TEXTBOX_BY_LABEL = "//label[text()='%s']/following-sibling::input[starts-with(@id,'Shipping')]";
    public static final String BILLING_ADDRESS_COUNTRY_DROPDOWN = "//select[@id='BillingNewAddress_CountryId']";
    public static final String SHIPPING_ADDRESS_COUNTRY_DROPDOWN = "//select[@id='ShippingNewAddress_CountryId']";
    public static final String BILLING_ADDRESS_STATE_PROVINCE_DROPDOWN = "//select[@id='BillingNewAddress_StateProvinceId']";
    public static final String BILLING_ADDRESS_CONTINUE_BUTTON = "//div[@id='billing-buttons-container']//button[text()='Continue']";
    public static final String SHIPPING_ADDRESS_CONTINUE_BUTTON = "//div[@id='shipping-buttons-container']//button[text()='Continue']";
    public static final String SHIPPING_METHOD_CONTINUE_BUTTON = "//div[@id='shipping-method-buttons-container']//button[text()='Continue']";
    public static final String PAYMENT_METHOD_CONTINUE_BUTTON = "//div[@id='payment-method-buttons-container']//button[text()='Continue']";
    public static final String PAYMENT_INFO_CONTINUE_BUTTON = "//div[@id='payment-info-buttons-container']//button[text()='Continue']";
    public static final String DYNAMIC_PAYMENT_METHOD_RADIO_BY_LABEL = "//label[text()='%s']/preceding-sibling::input";
    public static final String SHIPPING_ADDRESS_DROPDOWN = "//select[@id='shipping-address-select']";
    public static final String BILLING_ADDRESS_DROPDOWN = "//select[@id='billing-address-select']";
    public static final String BILLING_ADDRESS_INFO = "//div[@class='billing-info']";
    public static final String SHIPPING_ADDRESS_INFO = "//div[@class='shipping-info']";
    public static final String WRAPPING_CART_INFO = "//div[@class='cart-options']/div";
    public static final String DYNAMIC_SUMMARY_TOTAL_INFO_BY_LABEL = "//label[text()='%s']//parent::td/following-sibling::td[@class='cart-total-right']";
    public static final String CONFIRM_CHECKOUT_BUTTON = "//button[text()='Confirm']";
    public static final String ORDER_SUCCESS_MESSAGE = "//div[@class='section order-completed']//div[@class='title']";
    public static final String ORDER_NUMBER = "//div[@class='order-number']";
    public static final String CARD_HOLDER_NAME_TEXTBOX = "//input[@id='CardholderName']";
    public static final String CARD_NUMBER_TEXTBOX = "//input[@id='CardNumber']";
    public static final String CARD_CODE_TEXTBOX = "//input[@id='CardCode']";
    public static final String EXPIRE_MONTH_DROPDOWN = "//select[@id='ExpireMonth']";
    public static final String EXPIRE_YEAR_DROPDOWN = "//select[@id='ExpireYear']";
    public static final String RE_ORDER_BUTTON = "//button[text()='Re-order']";

}
