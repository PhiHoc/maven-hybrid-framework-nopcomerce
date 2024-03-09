package nopcomerce.pageObjects;

import commons.BasePage;
import io.qameta.allure.Step;
import nopcomerce.PageUIs.MyAccountPUI;
import org.openqa.selenium.WebDriver;

public class MyAccountPO extends BasePage {
    public MyAccountPO(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    @Step("Click to Customer Info link")
    public CustomerInfoPO clickToCustomerInfoLink() {
        waitForElementClickable(MyAccountPUI.CUSTOMER_INFO_LINK);
        clickToElement(MyAccountPUI.CUSTOMER_INFO_LINK);
        return PageGeneratorManager.getCustomerInfoPage(driver);
    }

    @Step("Click to Addresses link")
    public AddressesPO clickAddressesLink() {
        waitForElementClickable(MyAccountPUI.ADDRESSES_LINK);
        clickToElement(MyAccountPUI.ADDRESSES_LINK);
        return PageGeneratorManager.getAddressesPage(driver);
    }

    @Step("Click to Change Password link")
    public ChangePasswordPO clickToChangePasswordLink() {
        waitForElementClickable(MyAccountPUI.CHANGE_PASSWORD_LINK);
        clickToElement(MyAccountPUI.CHANGE_PASSWORD_LINK);
        return PageGeneratorManager.getChangePasswordPage(driver);
    }

    @Step("Click to My Product Reviews link")
    public MyProductReviewPO clickToMyProductReviewLink() {
        waitForElementClickable(MyAccountPUI.MY_PRODUCT_PREVIEW_LINK);
        clickToElement(MyAccountPUI.MY_PRODUCT_PREVIEW_LINK);
        return PageGeneratorManager.getMyProductReviewPage(driver);
    }

    WebDriver driver;
}
