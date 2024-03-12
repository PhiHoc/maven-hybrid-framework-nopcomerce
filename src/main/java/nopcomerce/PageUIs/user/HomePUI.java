package nopcomerce.PageUIs.user;

public class HomePUI {
    public static final String DYNAMIC_PRODUCT_LINK_BY_NAME = "//div[@class='page-body']//a[text()='%s']";
    public static final String ADD_YOUR_REVIEW_LINK = "//a[text()='Add your review']";
    public static final String REVIEW_TITLE_TEXTBOX = "//input[@id='AddProductReview_Title']";
    public static final String REVIEW_TEXT_AREA = "//textarea[@id='AddProductReview_ReviewText']";
    public static final String SUBMIT_REVIEW_BUTTON = "//button[text()='Submit review']";
    public static final String SUBMIT_REVIEW_RESULT_MESSAGE = "//div[@class='result']";
    public static final String COMPUTER_MENU_LINK = "//ul[@class='top-menu notmobile']//a[text()='Computers ']";
    public static final String NOTEBOOK_SUBMENU_LINK = "//a[text()=' Notebooks ']";
    public static final String SORT_BY_DROPDOWN = "//select[@id='products-orderby']";
    public static final String DISPLAY_PER_PAGE_DROPDOWN = "//select[@id='products-pagesize']";
    public static final String NEXT_ICON_LINK = "//a[text()='Next']";
    public static final String PREVIOUS_ICON_LINK = "//a[text()='Previous']";
    public static final String CURRENT_PAGE_TEXT = "//li[@class='current-page']/span";
    public static final String PRODUCT_TITLE_AT_SEARCH_PAGE = "//h2[@class='product-title']/a";
    public static final String PRODUCT_PRICE_AT_SEARCH_PAGE = "//span[@class='price actual-price']";
    public static final String PRODUCT_QUANTITY = "//label[text()='Qty:']//following-sibling::input";
    public static final String UPDATE_BUTTON = "//button[text()='Update']";
    public static final String DYNAMIC_PRODUCT_ATTRIBUTE_DROPDOWN_BY_LABEL = "//label[text()='%s']/parent::dt/following-sibling::dd[1]/select";
    public static final String DYNAMIC_PRODUCT_ATTRIBUTE_RADIO_BY_LABEL = "//label[text()='%s']/preceding-sibling::input[@type='radio']";
    public static final String DYNAMIC_PRODUCT_ATTRIBUTE_CHECKBOX_BY_LABEL = "//label[text()='%s']/preceding-sibling::input[@type='checkbox']";
    public static final String PRODUCT_ADD_TO_CART_BUTTON = "//div[@class='overview']//button[text()='Add to cart']";
    public static final String ADD_TO_WISHLIST_BUTTON = "//div[@class='overview']//button[text()='Add to wishlist']";
    public static final String NOTIFICATION_SUCCESS_MESSAGE = "//div[@class='bar-notification success']/p";
    public static final String CLOSE_NOTIFICATION_BUTTON = "//span[@class='close']";
    public static final String DYNAMIC_ADD_TO_COMPARE_BUTTON_BY_PRODUCT_NAME = "//a[text()='%s']/parent::h2//following-sibling::div[@class='add-info']//button[text()='Add to compare list']";
}
