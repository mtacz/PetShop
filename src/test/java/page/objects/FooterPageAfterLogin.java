package page.objects;

import driver.DriverManager;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

import static generic.assertions.AssertWebElement.assertThat;

public class FooterPageAfterLogin {

    Logger logger = LogManager.getLogger(FooterPageAfterLogin.class);

    @FindBy(css = "#Banner img[src*='dog']")
    private WebElement bannerAfterLogin;

    public FooterPageAfterLogin(){
        PageFactory.initElements(DriverManager.getWebDriver(),this);
    }

   @Step("Checking if banner is displayed on the page")
    public FooterPageAfterLogin assertThatBannerAfterLoginDisplayed(){
       logger.info("Banner status after login displayed");
        WaitForElement.waitUntilElementIsVisible(bannerAfterLogin);
        assertThat(bannerAfterLogin).isDisplayed();
        return this;
    }
}