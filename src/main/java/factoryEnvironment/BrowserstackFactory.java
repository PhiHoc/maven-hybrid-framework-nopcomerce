package factoryEnvironment;

import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackFactory implements EnvironmentFactory {
    private WebDriver driver;
    private String browserName, osName, osVersion;

    public BrowserstackFactory(String browserName, String osName, String osVersion) {
        this.browserName = browserName;
        this.osVersion = osVersion;
        this.osName = osName;
    }

    @Override
    public WebDriver createDriver() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", browserName);
        caps.setCapability("os", osName);
        caps.setCapability("os_version", osVersion);
        caps.setCapability("browser_version", "latest");
        caps.setCapability("name", "Run on " + browserName + " | " + osName + " | " + osVersion);
        caps.setCapability("browserstack.console", "info");
        caps.setCapability("browserstack.debug", "true");

        try {
            driver = new RemoteWebDriver(new URL(GlobalConstants.getGlobalConstants().getBrowserStackUrl()), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return driver;
    }
}
