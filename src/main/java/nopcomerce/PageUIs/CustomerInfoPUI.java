package nopcomerce.PageUIs;

public class CustomerInfoPUI {
    public static final String DYNAMIC_TEXTBOX_BY_ID = "//input[@id='%s']";
    public static final String DYNAMIC_CHECKBOX_BY_LABEL_NAME = "//label[text()='%s']/preceding-sibling::input";
    public static final String DOB_DAY_DROPDOWN = "//select[@name='DateOfBirthDay']";
    public static final String DOB_MONTH_DROPDOWN = "//select[@name='DateOfBirthMonth']";
    public static final String DOB_YEAR_DROPDOWN = "//select[@name='DateOfBirthYear']";
    public static final String SAVE_BUTTON = "//button[@id='save-info-button']";
    public static final String UPDATE_INFO_SUCCESS_MESSAGE = "//div[@class='bar-notification success']";
}
