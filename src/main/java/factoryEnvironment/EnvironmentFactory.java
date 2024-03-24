package factoryEnvironment;

import org.openqa.selenium.WebDriver;

public interface EnvironmentFactory {
    public WebDriver createDriver();
}
