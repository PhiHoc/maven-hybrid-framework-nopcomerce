package nopcomerce.pageObjects;

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

    @Step("Open Customer Info Page")
    public static CustomerInfoPO getCustomerInfoPage(WebDriver driver) {
        return new CustomerInfoPO(driver);
    }

    @Step("Open Addresses Page")
    public static AddressesPO getAddressesPage(WebDriver driver) {
        return new AddressesPO(driver);

    }

    @Step("Open ChangePassword Page")
    public static ChangePasswordPO getChangePasswordPage(WebDriver driver) {
        return new ChangePasswordPO(driver);
    }

    @Step("Open My Product Preview Page")
    public static MyProductReviewPO getMyProductReviewPage(WebDriver driver) {
        return new MyProductReviewPO(driver);
    }
}
