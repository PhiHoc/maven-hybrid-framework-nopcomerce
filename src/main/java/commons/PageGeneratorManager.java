package commons;

import com.nopcomerce.pageObjects.admin.AdminDashboardPO;
import com.nopcomerce.pageObjects.admin.AdminLoginPO;
import com.nopcomerce.pageObjects.admin.CatalogPO;
import com.nopcomerce.pageObjects.admin.CustomersPO;
import com.nopcomerce.pageObjects.user.*;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
    @Step("Open Home Page")
    public static HomePO getHomePage(WebDriver driver) {
        return new HomePO(driver);
    }

    @Step("Open Register Page")

    public static RegisterPO getRegisterPage(WebDriver driver){
        return new RegisterPO(driver);
    }

    @Step("Open Login Page")
    public static LoginPO getLoginPage(WebDriver driver){
        return new LoginPO(driver);
    }

    @Step("Open My Account Page")
    public static MyAccountPO getMyAccountPage(WebDriver driver) {
        return new MyAccountPO(driver);
    }

    @Step("Open Search Page")
    public static SearchPO getSearchPage(WebDriver driver) {
        return new SearchPO(driver);
    }

    @Step("Open WishList Page")
    public static WishListPO getWishListPage(WebDriver driver) {
        return new WishListPO(driver);
    }

    @Step("Open ShoppingCart Page")
    public static ShoppingCartPO getShoppingCartPage(WebDriver driver) {
        return new ShoppingCartPO(driver);
    }

    @Step("Open Compare Product Page")
    public static CompareProductPO getCompareProductPage(WebDriver driver) {
        return new CompareProductPO(driver);
    }

    @Step("Open Admin Dashboard Page")
    public static AdminDashboardPO getAdminDashboardPage(WebDriver driver) {
        return new AdminDashboardPO(driver);
    }

    @Step("Open Admin Login Page")
    public static AdminLoginPO getAdminLoginPage(WebDriver driver) {
        return new AdminLoginPO(driver);
    }

    @Step("Open Catalog Page")
    public static CatalogPO getCatalogPage(WebDriver driver) {
        return new CatalogPO(driver);
    }

    @Step("Open Admin Customers Page")
    public static CustomersPO getCustomersPage(WebDriver driver) {
        return new CustomersPO(driver);
    }
}
