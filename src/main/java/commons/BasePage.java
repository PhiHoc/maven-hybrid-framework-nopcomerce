package commons;

import com.nopcomerce.pageObjects.user.*;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BasePage {
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPageUrl(String pageUrl) {
        driver.get(pageUrl);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getPageSource() {
        return driver.getPageSource();
    }

    public void backToPage() {
        driver.navigate().back();
    }

    public void forwardToPage() {
        driver.navigate().forward();
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public Alert waitForAlertPresence() {
        WebDriverWait explitcitWait = new WebDriverWait(driver, longTimeOut);
        return explitcitWait.until(ExpectedConditions.alertIsPresent());
    }

    public void acceptAlert() {
        waitForAlertPresence().accept();
    }

    public void cancelAlert() {
        waitForAlertPresence().dismiss();
    }

    public String getAlertText() {
        return waitForAlertPresence().getText();
    }

    public void sendKeysToAlert(String textValue) {
        waitForAlertPresence().sendKeys(textValue);
    }

    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    public String getWindowHandle() {
        return driver.getWindowHandle();
    }

    public void switchWindowById(String Id) {
        Set<String> allWindowId = getWindowHandles();
        for (String windowId : allWindowId) {
            if (!windowId.equals(Id)) {
                driver.switchTo().window(windowId);
                break;
            }
        }
    }

    public void switchWindowByTitle(String targetTitle) {
        Set<String> allWindowId = getWindowHandles();
        for (String windowId : allWindowId) {
            driver.switchTo().window(windowId);
            String currentTitle = driver.getTitle();
            if (currentTitle.equals(targetTitle)) {
                break;
            }
        }
    }

    public void closeAllWindowsWithoutParent(String parentId) {
        Set<String> allWindowId = getWindowHandles();
        for (String windowId : allWindowId) {
            if (!windowId.equals(parentId)) {
                driver.switchTo().window(windowId).close();
            }
            driver.switchTo().window(parentId);
        }
    }

    public By getByXpath(String xpathLocator) {
        return By.xpath(xpathLocator);
    }

    public By getByXpath(String locator, String... dynamicValues) {
        locator = String.format(locator, (Object[]) dynamicValues);
        return By.xpath(locator);
    }

    public By getByLocator(String locator) {
        By by = null;
        if (locator.startsWith("id=") || locator.startsWith("Id=") || locator.startsWith("ID=")) {
            by = By.id(locator.substring(3));
        } else if (locator.startsWith("class=") || locator.startsWith("Class=") || locator.startsWith("CLASS=")) {
            by = By.className(locator.substring(6));
        } else if (locator.startsWith("name=") || locator.startsWith("Name=") || locator.startsWith("NAME=")) {
            by = By.name(locator.substring(5));
        } else if (locator.startsWith("css=") || locator.startsWith("Css=") || locator.startsWith("CSS=")) {
            by = By.cssSelector(locator.substring(4));
        } else if (locator.startsWith("xpath=") || locator.startsWith("Xpath=") || locator.startsWith("XPATH=")) {
            by = By.xpath(locator.substring(6));
        } else {
            throw new RuntimeException("Locator type is not supported");
        }

        return by;
    }

    public WebElement getElement(String xpathLocator) {
        return driver.findElement(getByXpath(xpathLocator));
    }

    public WebElement getElement(String xpathLocator, String... dynamicValues) {
        return driver.findElement(getByXpath(xpathLocator, dynamicValues));
    }

    public List<WebElement> getElements(String xpathLocator) {
        return driver.findElements(getByXpath(xpathLocator));
    }

    public List<WebElement> getElements(String xpathLocator, String... dynamicValues) {
        return driver.findElements(getByXpath(xpathLocator, dynamicValues));
    }

    public void clickToElement(String xpathLocator) {
        getElement(xpathLocator).click();
    }

    public void clickToElement(String xpathLocator, String... dynamicValues) {
        getElement(xpathLocator, dynamicValues).click();
    }

    public void sendKeysToElement(String xpathLocator, String textValue) {
        getElement(xpathLocator).clear();
        getElement(xpathLocator).sendKeys(textValue);
    }

    public void sendKeysToElement(String xpathLocator, String textValue, String... dynamicValues) {
        getElement(xpathLocator, dynamicValues).clear();
        getElement(xpathLocator, dynamicValues).sendKeys(textValue);
    }

    public void selectItemInDropdown(String xpathLocator, String textValue) {
        Select select = new Select(getElement(xpathLocator));
        select.selectByVisibleText(textValue);
    }

    public void selectItemInDropdown(String xpathLocator, String textValue, String... dynamicValues) {
        Select select = new Select(getElement(xpathLocator, dynamicValues));
        select.selectByVisibleText(textValue);
    }

    public String getSelectedItemInDropdown(String xpathLocator) {
        Select select = new Select(getElement(xpathLocator));
        return select.getFirstSelectedOption().getText();
    }

    public String getSelectedItemInDropdown(String xpathLocator, String... dynamicValues) {
        Select select = new Select(getElement(xpathLocator, dynamicValues));
        return select.getFirstSelectedOption().getText();
    }

    public boolean isDropdownMultiple(String xpathLocator) {
        return new Select(getElement(xpathLocator)).isMultiple();
    }

    public boolean isDropdownMultiple(String xpathLocator, String... dynamicValues) {
        return new Select(getElement(xpathLocator, dynamicValues)).isMultiple();
    }

    public void selectItemInCustomDropdown(String parentLocator, String childrenLocator,
                                           String textValue) {
        getElement(parentLocator).click();
        sleepInSecond(1);
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
        List<WebElement> allItems = explicitWait
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childrenLocator)));
        for (WebElement item : allItems) {
            if (item.getText().equals(textValue)) {
                JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
                jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
                sleepInSecond(1);
                item.click();
                sleepInSecond(1);
                break;
            }
        }
    }

    public String getAttributeValue(String xpathLocator, String attributeName) {
        return getElement(xpathLocator).getAttribute(attributeName);
    }

    public String getAttributeValue(String xpathLocator, String attributeName,
                                    String... dynamicValues) {
        return getElement(xpathLocator, dynamicValues).getAttribute(attributeName);
    }

    public void sleepInSecond(long second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public String getElementText(String xpathLocator) {
        return getElement(xpathLocator).getText().trim();
    }

    public String getElementText(String xpathLocator, String... dynamicValues) {
        return getElement(xpathLocator, dynamicValues).getText().trim();
    }

    public String getCssValue(String xpathLocator, String property) {
        return getElement(xpathLocator).getCssValue(property);
    }

    public String getCssValue(String xpathLocator, String property, String... dynamicValues) {
        return getElement(xpathLocator, dynamicValues).getCssValue(property);
    }

    public String getHexaColorFromRGBA(String rbgaValue) {
        return Color.fromString(rbgaValue).asHex();
    }

    public int getElementsSize(String xpathLocator) {
        return getElements(xpathLocator).size();
    }

    public int getElementsSize(String xpathLocator, String... dynamicValues) {
        return getElements(xpathLocator, dynamicValues).size();
    }

    public void checkToCheckBoxOrRadio(String xpathLocator) {
        WebElement element = getElement(xpathLocator);
        if (!element.isSelected()) {
            element.click();
        }
    }

    public void checkToCheckBoxOrRadio(String xpathLocator, String... dynamicValues) {
        WebElement element = getElement(xpathLocator, dynamicValues);
        if (!element.isSelected()) {
            element.click();
        }
    }

    public void uncheckToCheckBox(String xpathLocator) {
        WebElement element = getElement(xpathLocator);
        if (element.isSelected()) {
            element.click();
        }
    }

    public void uncheckToCheckBox(String xpathLocator, String... dynamicValues) {
        WebElement element = getElement(xpathLocator, dynamicValues);
        if (element.isSelected()) {
            element.click();
        }
    }

    public boolean isElementDisplayed(String xpathLocator) {
        return getElement(xpathLocator).isDisplayed();
    }

    public boolean isElementDisplayed(String xpathLocator, String... dynamicValues) {
        return getElement(xpathLocator, dynamicValues).isDisplayed();
    }

    public void overrideGlobalImplicitTimeout(long timeOut) {
        driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
    }

    public boolean isElementUndisplayed(String xpathLocator) {
        overrideGlobalImplicitTimeout(shortTimeOut);
        List<WebElement> elementList = getElements(xpathLocator);
        overrideGlobalImplicitTimeout(longTimeOut);

        if (elementList.size() == 0) {
            return true;
        } else if (elementList.size() > 0 && !elementList.get(0).isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isElementUndisplayed(String xpathLocator, String... dynamicValues) {
        overrideGlobalImplicitTimeout(shortTimeOut);
        List<WebElement> elementList = getElements(xpathLocator, dynamicValues);
        overrideGlobalImplicitTimeout(longTimeOut);

        if (elementList.size() == 0) {
            return true;
        } else if (elementList.size() > 0 && !elementList.get(0).isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isElementSelected(String xpathLocator) {
        return getElement(xpathLocator).isSelected();
    }

    public boolean isElementSelected(String xpathLocator, String... dynamicValues) {
        return getElement(xpathLocator, dynamicValues).isSelected();
    }

    public boolean isElementEnabled(String xpathLocator) {
        return getElement(xpathLocator).isEnabled();
    }

    public boolean isElementEnabled(String xpathLocator, String... dynamicValues) {
        return getElement(xpathLocator, dynamicValues).isEnabled();
    }

    public void switchToFrameIframe(String xpathLocator) {
        driver.switchTo().frame(getElement(xpathLocator));
    }

    public void switchToFrameIframe(String xpathLocator, String... dynamicValues) {
        driver.switchTo().frame(getElement(xpathLocator, dynamicValues));
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    public void hoverMouseToElement(String xpathLocator) {
        new Actions(driver).moveToElement(getElement(xpathLocator)).perform();
    }

    public void hoverMouseToElement(String xpathLocator, String... dynamicValues) {
        new Actions(driver).moveToElement(getElement(xpathLocator, dynamicValues)).perform();
    }

    public void pressKeyToElement(String xpathLocator, Keys key) {
        new Actions(driver).sendKeys(getElement(xpathLocator), key).perform();
    }

    public void pressKeyToElement(String xpathLocator, Keys key, String... dynamicValues) {
        new Actions(driver).sendKeys(getElement(xpathLocator, dynamicValues), key).perform();
    }

    public void scrollToBottomPage() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void hightlightElement(String xpathLocator) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        WebElement element = getElement(xpathLocator);
        String originalStyle = element.getAttribute("style");
        jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element,
                "border: 2px solid red; border-style: dashed;");
        sleepInSecond(2);
        jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
    }

    public void clickToElementByJS(String xpathLocator) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", getElement(xpathLocator));
        sleepInSecond(3);
    }

    public void scrollToElementOnTop(String xpathLocator) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(xpathLocator));
    }

    public void scrollToElementOnDown(String xpathLocator) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(false);", getElement(xpathLocator));
    }

    public void setAttributeInDOM(String xpathLocator, String attributeName, String attributeValue) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].setAttribute('" + attributeName + "', '" + attributeValue + "');",
                getElement(xpathLocator));
    }

    public void removeAttributeInDOM(String xpathLocator, String attributeRemove) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');",
                getElement(xpathLocator));
    }

    public String getElementValidationMessage(String xpathLocator) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        return (String) jsExecutor.executeScript("return arguments[0].validationMessage;",
                getElement(xpathLocator));
    }

    public boolean isImageLoaded(String xpathLocator) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        boolean status = (boolean) jsExecutor.executeScript(
                "return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",
                getElement(xpathLocator));
        return status;
    }

    public void waitForElementPresence(String xpathLocator) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(getByXpath(xpathLocator)));
    }

    public void waitForElementVisible(String xpathLocator) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(xpathLocator)));
    }

    public void waitForElementVisible(String xpathLocator, String... dynamicValues) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(xpathLocator, dynamicValues)));
    }

    public void waitForElementInvisible(String xpathLocator) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(xpathLocator)));
    }

    public void waitForElementInvisible(String xpathLocator, String... dynamicValues) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(xpathLocator, dynamicValues)));
    }

    public void waitForAllElementVisible(String xpathLocator) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
        explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(xpathLocator)));
    }

    public void waitForAllElementVisible(String xpathLocator, String... dynamicValues) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
        explicitWait
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(xpathLocator, dynamicValues)));
    }

    public void waitForAllElementInvisible(String xpathLocator) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
        explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getElements(xpathLocator)));
    }

    public void waitForAllElementInvisible(String xpathLocator, String... dynamicValues) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
        explicitWait
                .until(ExpectedConditions.invisibilityOfAllElements(getElements(xpathLocator, dynamicValues)));
    }

    public void waitForElementClickable(String xpathLocator) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
        explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(xpathLocator)));
    }

    public void waitForElementClickable(String xpathLocator, String... dynamicValues) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
        explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(xpathLocator, dynamicValues)));
    }
    public void setCookie(Set<Cookie> cookies) {
        for (Cookie cookie : cookies) {
            driver.manage().addCookie(cookie);
        }
    }

    public Set<Cookie> getAllCookies() {
        return driver.manage().getCookies();
    }

    public final long longTimeOut = GlobalConstants.getGlobalConstants().getLongTimeout();
    public final long shortTimeOut = GlobalConstants.getGlobalConstants().getShortTimeout();

    public WebDriver driver;
}
