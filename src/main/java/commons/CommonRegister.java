package commons;

import com.nopcomerce.pageObjects.user.HomePO;
import com.nopcomerce.pageObjects.user.RegisterPO;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import utilities.DataHelper;

public class CommonRegister extends BaseTest {


    @Parameters({"browser", "env"})
    @BeforeTest
    public void beforeTest(String browserName, String envName) {
        dataHelper = DataHelper.getDataHelper();
        firstName = dataHelper.getFirtName();
        lastName = dataHelper.getLastName();
        email = dataHelper.getEmail();
        password = dataHelper.getPassword();

        driver = getBrowserDriver(browserName,envName);
        homePO = PageGeneratorManager.getHomePage(driver);
        registerPO = homePO.clickToRegisterLink();
        registerPO.registerValidAccount(firstName,lastName,email,password);
        Assert.assertEquals(registerPO.getRegisterSuccessMessage(), "Your registration completed");

        closeBrowserDriver();
    }

    private WebDriver driver;
    private HomePO homePO;
    private RegisterPO registerPO;
    private DataHelper dataHelper;

    @Getter
    @Setter
    private static String firstName, lastName, email, password;
}
