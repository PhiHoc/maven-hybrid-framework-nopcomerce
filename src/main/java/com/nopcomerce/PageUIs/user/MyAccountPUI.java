package com.nopcomerce.PageUIs.user;

public class MyAccountPUI {
    public static final  String CUSTOMER_INFO_LINK = "//div[@class='listbox']//a[text()='Customer info']";
    public static final  String ADDRESSES_LINK = "//div[@class='listbox']//a[text()='Addresses']";
    public static final  String CHANGE_PASSWORD_LINK = "//div[@class='listbox']//a[text()='Change password']";
    public static final  String ORDERS_LINK = "//div[@class='listbox']//a[text()='Orders']";
    public static final  String MY_PRODUCT_PREVIEW_LINK = "//div[@class='listbox']//a[text()='My product reviews']";
    public static final  String DYNAMIC_DETAIL_BUTTON_BY_ORDER_NUMBER = "//strong[contains(text(),'%s')]/parent::div//following-sibling::div/button[text()='Details']";
    public static final String DYNAMIC_TEXTBOX_BY_ID = "//input[@id='%s']";
    public static final String DYNAMIC_CHECKBOX_BY_LABEL_NAME = "//label[text()='%s']/preceding-sibling::input";
    public static final String INFO_DOB_DAY_DROPDOWN = "//select[@name='DateOfBirthDay']";
    public static final String INFO_DOB_MONTH_DROPDOWN = "//select[@name='DateOfBirthMonth']";
    public static final String INFO_DOB_YEAR_DROPDOWN = "//select[@name='DateOfBirthYear']";
    public static final String SAVE_CUSTOMER_INFO_BUTTON = "//button[@id='save-info-button']";
    public static final String UPDATE_INFO_SUCCESS_MESSAGE = "//div[@class='bar-notification success']";
    public static final  String ADD_NEW_ADDRESS_BUTTON = "//button[@class='button-1 add-address-button']";
    public static final  String SAVE_ADDRESS_BUTTON = "//button[@class='button-1 save-address-button']";
    public static final String ADDRESS_COUNTRY_DROPDOWN = "//select[@id='Address_CountryId']";
    public static final String ADDRESS_STATE_DROPDOWN = "//select[@id='Address_StateProvinceId']";
    public static final String ADDRESS_TEXT_VALUE_BY_CLASSNAME = "//li[@class='%s']";
    public static final String ADD_ADDRESS_SUCCESS_MESSAGE = "//div[@class='bar-notification success']/p";
    public static final String DYNAMIC_ADDRESS_TEXT_INFO_BY_CLASSNAME = "//li[@class='%s']";
    public static final String REVIEW_TITLE_TEXT = "//div[@class='review-title']";
    public static final String REVIEW_CONTENT_TEXT = "//div[@class='review-text']";
    public static final String OLD_PASSWORD_TEXTBOX = "//input[@id='OldPassword']";
    public static final String NEW_PASSWORD_TEXTBOX = "//input[@id='NewPassword']";
    public static final String CONFIRM_PASSWORD_TEXTBOX = "//input[@id='ConfirmNewPassword']";
    public static final String CHANGE_PASSWORD_BUTTON = "//button[@class='button-1 change-password-button']";
    public static final String CHANGE_PASSWORD_SUCCESS_MESSAGE = "//div[@class='bar-notification success']";
    public static final String CLOSE_MESSAGE_BUTTON = "//span[@title='Close']";

}
