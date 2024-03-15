package commons;

import com.nopcomerce.pageObjects.admin.AdminDashboardPO;
import com.nopcomerce.pageObjects.user.*;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BaseComponent extends BasePage{

    public BaseComponent(WebDriver driver) {
        super(driver);
    }

    /**
     * User Component
     */

    @Step("Click to Shopping cart link")
    public ShoppingCartPO clickToShoppingCartLink(){
        waitForElementClickable(BaseComponentUI.SHOPPING_CART_LINK);
        clickToElement(BaseComponentUI.SHOPPING_CART_LINK);
        return PageGeneratorManager.getShoppingCartPage(driver);
    }

    @Step("Click to login link")
    public LoginPO clickToLoginLink() {
        waitForElementClickable(BaseComponentUI.LOGIN_LINK);
        clickToElement(BaseComponentUI.LOGIN_LINK);
        return PageGeneratorManager.getLoginPage(driver);
    }

    @Step("Click to register link")
    public RegisterPO clickToRegisterLink() {
        waitForElementClickable(BaseComponentUI.REGISTER_LINK);
        clickToElement(BaseComponentUI.REGISTER_LINK);
        return PageGeneratorManager.getRegisterPage(driver);
    }

    @Step("Click to logout link")
    public HomePO clickToLogoutLink() {
        waitForElementClickable(BaseComponentUI.LOGOUT_LINK);
        clickToElement(BaseComponentUI.LOGOUT_LINK);
        return PageGeneratorManager.getHomePage(driver);
    }

    @Step("Verify is my account link displayed")
    public boolean isMyAccountLinkDisplayed(){
        waitForElementVisible(BaseComponentUI.MY_ACCOUNT_LINK);
        return isElementDisplayed(BaseComponentUI.MY_ACCOUNT_LINK);
    }

    @Step("Click to My account link")
    public MyAccountPO clickToMyAccountLink() {
        waitForElementClickable(BaseComponentUI.MY_ACCOUNT_LINK);
        clickToElement(BaseComponentUI.MY_ACCOUNT_LINK);
        return PageGeneratorManager.getMyAccountPage(driver);
    }
    @Step("Click to Wishlist link")
    public WishListPO clickToWishListLink() {
        waitForElementClickable(BaseComponentUI.MY_WISHLIST_LINK);
        clickToElement(BaseComponentUI.MY_WISHLIST_LINK);
        return PageGeneratorManager.getWishListPage(driver);
    }

    @Step("Click to home page logo link")
    public HomePO clickToHomePageLogoLink(){
        waitForElementClickable(BaseComponentUI.HOME_PAGE_LOGO_LINK);
        clickToElement(BaseComponentUI.HOME_PAGE_LOGO_LINK);
        return PageGeneratorManager.getHomePage(driver);
    }

    @Step("Click to Footer link: {0}")
    public BasePage clickToFooterLinkByName(String name){
        waitForElementClickable(BaseComponentUI.DYNAMIC_FOOTER_LINK_BY_NAME,name);
        clickToElement(BaseComponentUI.DYNAMIC_FOOTER_LINK_BY_NAME,name);

        switch (name) {
            case "Search":
                return PageGeneratorManager.getSearchPage(driver);
            case "Shopping cart":
                return PageGeneratorManager.getShoppingCartPage(driver);
            case "Compare products list":
                return PageGeneratorManager.getCompareProductPage(driver);
            default:
                return null;
        }
    }

    /**
     * Admin Component
     */

    @Step("Click to '{0}' link at side bar")
    public void clickToSideBarLinkByName(String linkName) {
        waitForElementClickable(BaseComponentUI.DYNAMIC_SIDEBAR_LINK_BY_NAME,linkName);
        clickToElement(BaseComponentUI.DYNAMIC_SIDEBAR_LINK_BY_NAME,linkName);
    }

    @Step("Click to '{0}' sub link at side bar")
    public void clickToSideBarSubLinkByName(String subLinkName) {
        waitForElementClickable(BaseComponentUI.DYNAMIC_SIDEBAR_SUB_LINK_BY_NAME,subLinkName);
        clickToElement(BaseComponentUI.DYNAMIC_SIDEBAR_SUB_LINK_BY_NAME,subLinkName);
    }

    @Step("Verify is 'Logout' link displayed")
    public boolean isLogoutLinkDisplayed() {
        waitForElementVisible(BaseComponentUI.LOG_OUT_LINK);
        return isElementDisplayed(BaseComponentUI.LOG_OUT_LINK);
    }

    @Step("Enter to textbox '{0}' with value {1}")
    public void enterToTextboxByLabel(String labelName, String value) {
        waitForElementVisible(BaseComponentUI.DYNAMIC_TEXTBOX_BY_LABEL,labelName);
        sendKeysToElement(BaseComponentUI.DYNAMIC_TEXTBOX_BY_LABEL,value,labelName);
    }

    @Step("Select to '{0}' dropdown with value {1}")
    public void selectToDropdownByLabel(String labelName, String value) {
        waitForElementVisible(BaseComponentUI.DYNAMIC_DROPDOWN_BY_LABEL,labelName);
        selectItemInDropdown(BaseComponentUI.DYNAMIC_DROPDOWN_BY_LABEL,value,labelName);
    }

    @Step("Wait for 'Ajax loading' icon disappear")
    public void waitForAjaxLoadingIconUndisplayed() {
        waitForElementInvisible(BaseComponentUI.AJAX_BUSY_LOADING);
    }

    /**
     * Get cell data by row index and column name
     * @param rowIndex
     * @param columnName
     * @return
     */
    @Step("Verify data at column '{1}', row number '{0}'")
    public String getTableDataByRowIndexAndColumnName(String rowIndex, String columnName) {
        String columnIndex = String.valueOf(getElementsSize(BaseComponentUI.DYNAMIC_PRECEDING_HEADER_COLUMN_BY_NAME,columnName)+1);
        return getElementText(BaseComponentUI.DYNAMIC_CELL_INFO_BY_ROW_AND_COLUMN_INDEX,rowIndex,columnIndex);
    }

    @Step("Click button at column '{1}', row number '{0}'")
    public void clickTableButtonAtRowIndexAndColumnName(String rowIndex, String columnName) {
        waitForAllElementVisible(BaseComponentUI.DYNAMIC_PRECEDING_HEADER_COLUMN_BY_NAME,columnName);
        String columnIndex = String.valueOf(getElementsSize(BaseComponentUI.DYNAMIC_PRECEDING_HEADER_COLUMN_BY_NAME,columnName)+1);
        clickToElement(BaseComponentUI.DYNAMIC_BUTTON_BY_ROW_AND_COLUMN_INDEX,rowIndex,columnIndex);
    }

    @Step("Verify attribute '{1}' of textbox '{0}'")
    public String getTextboxAttributeValueByLabel(String label, String attributeName) {
        waitForElementVisible(BaseComponentUI.DYNAMIC_TEXTBOX_BY_LABEL,label);
        return getAttributeValue(BaseComponentUI.DYNAMIC_TEXTBOX_BY_LABEL,attributeName,label);
    }

    @Step("Verify page header")
    public String getPageHeader() {
        waitForElementVisible(BaseComponentUI.PAGE_HEADER);
        return getElementText(BaseComponentUI.PAGE_HEADER);
    }

    @Step("Click to 'Dashboard' link")
    public AdminDashboardPO clickToDashboardLink() {
        waitForElementClickable(BaseComponentUI.DASHBOARD_LINK);
        clickToElement(BaseComponentUI.DASHBOARD_LINK);
        return PageGeneratorManager.getAdminDashboardPage(driver);
    }

    @Step("Enter to text area '{0}' with value '{1}'")
    public void enterToTextAreaByLabel(String labelName, String value) {
        waitForElementVisible(BaseComponentUI.DYNAMIC_TEXTAREA_BY_LABEL,labelName);
        sendKeysToElement(BaseComponentUI.DYNAMIC_TEXTAREA_BY_LABEL,value,labelName);
    }

    @Step("Verify text of text area '{0}'")
    public String getTextAreaTextByLabel(String label) {
        waitForElementVisible(BaseComponentUI.DYNAMIC_TEXTAREA_BY_LABEL,label);
        return getElementText(BaseComponentUI.DYNAMIC_TEXTAREA_BY_LABEL,label);
    }

    /**
     * Get all data in a column
     * @param columnName
     * @return
     */
    public String getColumnDataByColumnName(String columnName) {
        String columnTextData = "";
        waitForElementVisible(BaseComponentUI.DYNAMIC_PRECEDING_HEADER_COLUMN_BY_NAME,columnName);
        String columnIndex = String.valueOf(getElementsSize(BaseComponentUI.DYNAMIC_PRECEDING_HEADER_COLUMN_BY_NAME,columnName)+1);
        List<WebElement> columnElements = getElements(BaseComponentUI.DYNAMIC_COLUMN_TABLE_INFO_BY_INDEX,columnIndex);
        for(WebElement element :columnElements){
            columnTextData += " " + element.getText();
        }
        return columnTextData;
    }
}
