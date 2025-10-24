package configuration;

import driver.manager.BrowserType;

public class LocalWebDriverProperties {

    public static BrowserType getLocalBrowser(){
        return BrowserType.valueOf(ConfigurationProperties.getProperties().getProperty("local.browser"));
    }
}