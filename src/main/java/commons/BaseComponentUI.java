package commons;

public class BaseComponentUI {
    /**
     * User page UI
     */
    public static final String LOGIN_LINK = "//a[@class='ico-login']";
    public static final String REGISTER_LINK = "//a[@class='ico-register']";
    public static final String LOGOUT_LINK = "//a[@class='ico-logout']";
    public static final String MY_ACCOUNT_LINK = "//a[@class='ico-account']";
    public static final String MY_WISHLIST_LINK = "//a[@class='ico-wishlist']";
    public static final String SHOPPING_CART_LINK = "//a[@class='ico-cart']";
    public static final String DYNAMIC_FOOTER_LINK_BY_NAME = "//div[@class='footer']//a[text()='%s']";
    public static final String HOME_PAGE_LOGO_LINK = "//div[@class='header-logo']/a";

    /**
     * Admin page UI
     */
    public static final String DYNAMIC_SIDEBAR_LINK_BY_NAME = "//i[starts-with(@class,'right')]/parent::p[contains(text(),'%s')]";
    public static final String DYNAMIC_SIDEBAR_SUB_LINK_BY_NAME = "//i[contains(@class,'fa-dot-circle')]/following-sibling::p[text()='%s']";
    public static final String DYNAMIC_TEXTBOX_BY_LABEL = "//label[text()='%s']//ancestor::div[@class='form-group row']//input";
    public static final String DYNAMIC_DROPDOWN_BY_LABEL = "//label[text()='%s']//ancestor::div[@class='form-group row']//select";
    public static final String LOG_OUT_LINK = "//a[text()='Logout']";
    public static final String AJAX_BUSY_LOADING = "//div[@id='ajaxBusy']";
    public static final String DYNAMIC_PRECEDING_HEADER_COLUMN_BY_NAME = "//thead//th[text()='%s']//preceding-sibling::th";
    public static final String DYNAMIC_CELL_INFO_BY_ROW_AND_COLUMN_INDEX = "//tbody//tr[%s]//td[%s]";
    public static final String DYNAMIC_BUTTON_BY_ROW_AND_COLUMN_INDEX = "//tbody//tr[%s]//td[%s]//a";
    public static final String PAGE_HEADER = "//div[@class='content-header clearfix']//h1";
    public static final String DASHBOARD_LINK = "//a[@class='nav-link']//p[contains(text(),'Dashboard')]";
    public static final String DYNAMIC_TEXTAREA_BY_LABEL = "//label[text()='%s']//ancestor::div[@class='form-group row']//textarea";
    public static final String DYNAMIC_COLUMN_TABLE_INFO_BY_INDEX = "//tbody//td[%s]";

}
