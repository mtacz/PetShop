package manager;

import org.openqa.selenium.WebDriver;

public class DriverManager {

    private DriverManager() {
    }

    private static final BrowserType BROWSER_TYPE = BrowserType.FIREFOX;
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = BrowserFactory.getBrowser(BROWSER_TYPE);
        }
        return driver;
    }

    public static void disposeDriver(){
        driver.close();
        if (!BROWSER_TYPE.equals(BrowserType.FIREFOX)){
            driver.quit();
        }
        driver = null;
    }
}
