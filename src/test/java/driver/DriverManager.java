package driver;

import driver.manager.BrowserFactory;
import driver.manager.BrowserType;
import org.openqa.selenium.WebDriver;

import static configuration.TestRunProperties.getBrowserToRun;
import static configuration.TestRunProperties.getIsRemoteRun;

public class DriverManager {

    private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();
    private static ThreadLocal<BrowserType> browserTypeThreadLocal = new ThreadLocal<>();

    private DriverManager() {
    }

    public static void setWebDriver(BrowserType browserType){

        if (browserType == null) {
            browserType = getBrowserToRun();
        }

        WebDriver browser = new BrowserFactory(browserType,getIsRemoteRun()).getBrowser();

        browserTypeThreadLocal.set(browserType);
        webDriverThreadLocal.set(browser);
    }

    public static WebDriver getWebDriver() {
        if (webDriverThreadLocal.get() == null) {
            throw new IllegalStateException("WebDriver Instance was null! Please create instance of WebDriver using " +
                    "setWebDriver");
        }
        return webDriverThreadLocal.get();
    }

    public static void disposeDriver() {
        if (webDriverThreadLocal.get() != null) {
            webDriverThreadLocal.get().quit();
        }
        webDriverThreadLocal.remove();
        browserTypeThreadLocal.remove();
    }
}