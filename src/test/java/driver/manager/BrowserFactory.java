package driver.manager;

import configuration.TestRunProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;


public class BrowserFactory {

    private BrowserType browserType;
    private boolean isRemoteRun;

    public BrowserFactory(BrowserType browserType, boolean isRemoteRun) {
        this.browserType = browserType;
        this.isRemoteRun = isRemoteRun;
    }

    private static final String MESSAGE_UNKNOWN_BROWSER = "Unknown browser type! Please check your configuration";

    public WebDriver getBrowser() {
        if (isRemoteRun) {
            switch (browserType) {
                case CHROME:
                    return new RemoteWebDriver(getGridUrl(), getChromeOptions());
                case FIREFOX:
                    return new RemoteWebDriver(getGridUrl(), getFirefoxOptions());
                case EDGE:
                    return new RemoteWebDriver(getGridUrl(), getEdgeOptions());
                default:
                    throw new IllegalStateException(MESSAGE_UNKNOWN_BROWSER);
            }
        } else {
            switch (browserType) {
                case CHROME:
                    return new ChromeDriver();
                case FIREFOX:
                    return new FirefoxDriver();
                case EDGE:
                    return new EdgeDriver();
                default:
                    throw new IllegalStateException(MESSAGE_UNKNOWN_BROWSER);
            }
        }
    }

    private URL getGridUrl() {
        try {
            String gridAddress = TestRunProperties.getGridUrl();
            return URI.create(gridAddress).toURL();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to create RemoteWebDriver due to: " + e.getMessage());
        }
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
       // options.setPlatformName("Windows 10");
        return options;
    }

    private FirefoxOptions getFirefoxOptions() {
        FirefoxOptions options = new FirefoxOptions();
      //  options.setPlatformName("Windows 10");
        return options;
    }

    private EdgeOptions getEdgeOptions() {
        EdgeOptions options = new EdgeOptions();
       // options.setPlatformName("Windows 10");
        return options;
    }
}