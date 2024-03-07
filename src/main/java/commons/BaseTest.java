package commons;

import factoryBrowser.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    // Constructor
    protected BaseTest() {
        log = LogFactory.getLog(getClass());
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    @BeforeSuite
    public void initBeforeSuite() {
//         Remove all file in ReportNG screenshot (image)
//		deleteAllFileInFolder("reportNGImage");

//         Remove all file in Allure attachment (json file)
//        deleteAllFileInFolder("allure-json");
    }

    protected WebDriver getBrowserDriver(String browserName,String env) {
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

        driver.get(getEnvironment(env));
        driver.manage().timeouts().implicitlyWait(longTimeout, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    protected String getEnvironment(String env) {
        String url = "";
        if (env.equals("admin")) {
            url = GlobalConstants.getGlobalConstants().getAdminPageUrl();
        } else if (env.equals("user")) {
            url = GlobalConstants.getGlobalConstants().getPortalPageUrl();
        } else {
            throw new RuntimeException("Please input correct environment name");
        }
        return url;
    }

    public int getRandomNumber() {
        Random rand = new Random();
        return rand.nextInt(99999);
    }

    protected boolean verifyTrue(boolean condition) {
        boolean pass = true;
        try {
            Assert.assertTrue(condition);
            log.info("------------------PASSED------------------");
        } catch (Throwable e) {
            log.info("------------------FAILED------------------");
            pass = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    protected boolean verifyFalse(boolean condition) {
        boolean pass = true;
        try {
            Assert.assertFalse(condition);
            log.info("------------------PASSED------------------");
        } catch (Throwable e) {
            log.info("------------------FAILED------------------");
            pass = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    protected boolean verifyEquals(Object actual, Object expected) {
        boolean pass = true;
        try {
            Assert.assertEquals(actual, expected);
            log.info("------------------PASSED------------------");
        } catch (Throwable e) {
            log.info("------------------FAILED------------------");
            pass = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    public void deleteAllFileInFolder(String folderName) {
        try {
            String pathFolderDownload = GlobalConstants.getGlobalConstants().getProjectPath() + File.separator + folderName;
            File file = new File(pathFolderDownload);
            File[] listOfFiles = file.listFiles();
            if (listOfFiles.length != 0) {
                for (int i = 0; i < listOfFiles.length; i++) {
                    if (listOfFiles[i].isFile() && !listOfFiles[i].getName().equals("environment.properties")) {
                        new File(listOfFiles[i].toString()).delete();
                    }
                }
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    protected void closeBrowserDriver() {
        String cmd = null;
        try {
            String osName = System.getProperty("os.name").toLowerCase();
            log.info("OS name = " + osName);

            String driverInstanceName = driver.toString().toLowerCase();
            log.info("Driver instance name = " + driverInstanceName);

            String browserDriverName = null;

            if (driverInstanceName.contains("chrome")) {
                browserDriverName = "chromedriver";
            } else if (driverInstanceName.contains("internetexplorer")) {
                browserDriverName = "IEDriverServer";
            } else if (driverInstanceName.contains("firefox")) {
                browserDriverName = "geckodriver";
            } else if (driverInstanceName.contains("edge")) {
                browserDriverName = "msedgedriver";
            } else if (driverInstanceName.contains("opera")) {
                browserDriverName = "operadriver";
            } else {
                browserDriverName = "safaridriver";
            }

            if (osName.contains("window")) {
                cmd = "taskkill /F /FI \"IMAGENAME eq " + browserDriverName + "*\"";
            } else {
                cmd = "pkill " + browserDriverName;
            }

            if (driver != null) {
                driver.manage().deleteAllCookies();
                driver.quit();
            }
        } catch (Exception e) {
            log.info(e.getMessage());
        } finally {
            try {
                Process process = Runtime.getRuntime().exec(cmd);
                process.waitFor();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private WebDriver driver;
    protected final Log log;
    long longTimeout = GlobalConstants.getGlobalConstants().getLongTimeout();
}
