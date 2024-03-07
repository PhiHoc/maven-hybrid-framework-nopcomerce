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
}
