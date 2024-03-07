package nopcomerce.pageObjects;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
    public static HomePO getHomePage(WebDriver driver) {
        return new HomePO(driver);
    }

    public static RegisterPO getRegisterPage(WebDriver driver){
        return new RegisterPO(driver);
    }
}
