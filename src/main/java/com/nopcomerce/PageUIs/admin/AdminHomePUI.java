package com.nopcomerce.PageUIs.admin;

public class AdminHomePUI {
    public static final String DYNAMIC_TEXTAREA_BY_LABEL = "//label[text()='%s']//ancestor::div[@class='form-group row']//textarea";
    public static final String SEARCH_CUSTOMER_BUTTON = "//button[@id='search-customers']";
    public static final String ALL_ROW_TABLE_INFO = "//tr[@class='odd' or @class = 'even']";
    public static final String DYNAMIC_COLUMN_TABLE_INFO_BY_INDEX = "//tbody//td[%s]";
    public static final String MALE_RADIO = "//input[@id='Gender_Male']";
    public static final String ACTIVE_CHECKBOX = "//input[@id='Active']";
    public static final String CUSTOMER_ROLE_DELETE_BUTTON = "//ul[@id='SelectedCustomerRoleIds_taglist']//span[@title='delete']";
    public static final String CUSTOMER_ROLE_DROPDOWN_PARENT_LOCATOR = "//ul[@id='SelectedCustomerRoleIds_taglist']//parent::div[@role='listbox']";
    public static final String CUSTOMER_ROLE_DROPDOWN_CHILDREN_LOCATOR = "//ul[@id='SelectedCustomerRoleIds_listbox']//li";
    public static final String CUSTOMER_ROLE_DROPDOWN_SELECTED_ITEM = "//ul[@id='SelectedCustomerRoleIds_taglist']//li[@aria-selected='true']";
    public static final String CUSTOMER_SAVE_AND_CONTINUE_BUTTON = "//button[@name='save-continue']";
    public static final String ADD_CUSTOMER_SUCCESS_MESSAGE = "//div[contains(@class,'alert-success')]";
    public static final String BACK_TO_CUSTOMER_LIST_LINK = "//a[text()='back to customer list']";
}
