package factoryEnvironment;

import factoryBrowser.*;
import org.openqa.selenium.WebDriver;

public class LocalFactory implements EnvironmentFactory {
    private WebDriver driver;
    private String browserName;

    public LocalFactory(String browserName) {
        this.browserName = browserName;
    }

    @Override
    public WebDriver createDriver() {
        BrowserList browser = BrowserList.valueOf(browserName);
        switch (browser){
            case CHROME:
                driver = new ChromeDriverManager().getBrowserDriver();
                break;
            case H_CHROME:
                driver = new HeadlessChromeDriverManager().getBrowserDriver();
                break;
            case FIREFOX:
                driver = new FireFoxDriverManager().getBrowserDriver();
                break;
            case H_FIREFOX:
                driver = new HeadlessFireFoxDriverManager().getBrowserDriver();
                break;
            case OPERA:
                driver = new OperaDriverManager().getBrowserDriver();
                break;
            case EDGE:
                driver = new EdgeDriverManager().getBrowserDriver();
                break;
            default:
                throw new BrowserNotSupportedException(browserName);
        }

        return driver;
    }
}
