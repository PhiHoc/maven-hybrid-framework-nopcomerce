package nopcomerce.PageUIs.user;

public class MyAccountPUI {
    public static final  String CUSTOMER_INFO_LINK = "//div[@class='listbox']//a[text()='Customer info']";
    public static final  String ADDRESSES_LINK = "//div[@class='listbox']//a[text()='Addresses']";
    public static final  String CHANGE_PASSWORD_LINK = "//div[@class='listbox']//a[text()='Change password']";
    public static final  String ORDERS_LINK = "//div[@class='listbox']//a[text()='Orders']";
    public static final  String MY_PRODUCT_PREVIEW_LINK = "//div[@class='listbox']//a[text()='My product reviews']";
    public static final  String DYNAMIC_DETAIL_BUTTON_BY_ORDER_NUMBER = "//strong[contains(text(),'%s')]/parent::div//following-sibling::div/button[text()='Details']";
}
