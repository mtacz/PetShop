package driver.manager;

import configuration.LocalWebDriverProperties;
import org.openqa.selenium.WebDriver;

public class DriverManager {

    private DriverManager() {
    }

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = BrowserFactory.getBrowser(LocalWebDriverProperties.getLocalBrowser());
        }
        return driver;
    }

    public static void disposeDriver() {
        driver.close();
        if (!LocalWebDriverProperties.getLocalBrowser().equals(BrowserType.FIREFOX)) {
            driver.quit();
        }
        driver = null;
    }
}