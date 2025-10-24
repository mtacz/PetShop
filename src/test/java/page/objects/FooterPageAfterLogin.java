package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class FooterPageAfterLogin {

    Logger logger = LogManager.getRootLogger();

    @FindBy(css = "#Banner img[src*='dog']")
    private WebElement bannerAfterLogin;

    public FooterPageAfterLogin(){
        PageFactory.initElements(DriverManager.getDriver(),this);
    }

    public boolean isBannerAfterLoginDisplayed(){
        WaitForElement.waitUntilElementIsVisible(bannerAfterLogin);
        boolean isBannerDisplayed = bannerAfterLogin.isDisplayed();
        logger.info("Banner status after login displayed: {}", isBannerDisplayed);
        return isBannerDisplayed;
    }
}