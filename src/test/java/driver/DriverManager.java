package driver;

import driver.manager.BrowserFactory;
import org.openqa.selenium.WebDriver;

import static configuration.TestRunProperties.getBrowserToRun;
import static configuration.TestRunProperties.getIsRemoteRun;

public class DriverManager {

    private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

    private DriverManager() {
    }

    public static WebDriver getWebDriver() {
        if (webDriverThreadLocal.get() == null) {
            webDriverThreadLocal.set(new BrowserFactory(getBrowserToRun(),getIsRemoteRun()).getBrowser());
        }
        return webDriverThreadLocal.get();
    }

    public static void disposeDriver() {
        webDriverThreadLocal.get().close();
        if (webDriverThreadLocal != null) {
            webDriverThreadLocal.get().quit();
        }
        webDriverThreadLocal.remove();
    }
}