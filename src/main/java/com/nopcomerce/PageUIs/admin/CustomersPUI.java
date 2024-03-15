package com.nopcomerce.PageUIs.admin;

public class CustomersPUI {
    public static final String ADD_NEW_BUTTON = "//a[contains(@href,'Create')]";
    public static final String MALE_RADIO = "//input[@id='Gender_Male']";
    public static final String SEARCH_CUSTOMER_BUTTON = "//button[@id='search-customers']";
    public static final String ALL_ROW_TABLE_INFO = "//tr[@class='odd' or @class = 'even']";
    public static final String ACTIVE_CHECKBOX = "//input[@id='Active']";
    public static final String CUSTOMER_ROLE_DELETE_BUTTON = "//ul[@id='SelectedCustomerRoleIds_taglist']//span[@title='delete']";
    public static final String CUSTOMER_ROLE_DROPDOWN_PARENT_LOCATOR = "//ul[@id='SelectedCustomerRoleIds_taglist']//parent::div[@role='listbox']";
    public static final String CUSTOMER_ROLE_DROPDOWN_CHILDREN_LOCATOR = "//ul[@id='SelectedCustomerRoleIds_listbox']//li";
    public static final String CUSTOMER_ROLE_DROPDOWN_SELECTED_ITEM = "//ul[@id='SelectedCustomerRoleIds_taglist']//li[@aria-selected='true']";
    public static final String CUSTOMER_SAVE_AND_CONTINUE_BUTTON = "//button[@name='save-continue']";
    public static final String CUSTOMER_SAVE_BUTTON = "//button[@name='save']";
    public static final String ADDRESS_SAVE_BUTTON = "//button[contains(text(),'Save')]";
    public static final String EDIT_ADDRESS_SAVE_BUTTON = "//button[@name='save']";
    public static final String ADD_CUSTOMER_SUCCESS_MESSAGE = "//div[contains(@class,'alert-success')]";
    public static final String BACK_TO_CUSTOMER_LIST_LINK = "//a[text()='back to customer list']";
    public static final String BACK_TO_CUSTOMER_DETAIL_LINK = "//a[text()='back to customer details']";
    public static final String ADDRESSES_CARD = "//div[text()='Addresses']";
    public static final String ADD_NEW_ADDRESS_BUTTON = "//button[contains(text(),'Add new address')]";
    public static final String DYNAMIC_ADDRESS_ROW_TABLE_INFO_BY_INDEX = "//div[starts-with(@id,'customer-addresses')]//tr[@class='odd' or @class = 'even'][%s]";
    public static final String DYNAMIC_ADDRESS_CELL_INFO_BY_ROW_AND_COLUMN_INDEX = "//div[@id='customer-addresses-grid_wrapper']//tbody//tr[%s]//td[%s]";


}
