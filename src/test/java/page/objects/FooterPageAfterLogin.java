package page.objects;

import driver.DriverManager;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class FooterPageAfterLogin {

    Logger logger = LogManager.getLogger(FooterPageAfterLogin.class);

    @FindBy(css = "#Banner img[src*='dog']")
    private WebElement bannerAfterLogin;

    public FooterPageAfterLogin(){
        PageFactory.initElements(DriverManager.getWebDriver(),this);
    }

   @Step("Checking if banner is displayed on the page")
    public boolean isBannerAfterLoginDisplayed(){
        WaitForElement.waitUntilElementIsVisible(bannerAfterLogin);
        boolean isBannerDisplayed = bannerAfterLogin.isDisplayed();
        logger.info("Banner status after login displayed: {}", isBannerDisplayed);
        return isBannerDisplayed;
    }
}