package page.objects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

import static generic.assertions.AssertWebElement.assertThat;

public class FooterPageAfterLogin extends BasePage {

    @FindBy(css = "#Banner img[src*='dog']")
    private WebElement bannerAfterLogin;

   @Step("Checking if banner is displayed on the page")
    public FooterPageAfterLogin assertThatBannerAfterLoginDisplayed(){
       log().info("Banner status after login displayed");
        WaitForElement.waitUntilElementIsVisible(bannerAfterLogin);
        assertThat(bannerAfterLogin).isDisplayed();
        return this;
    }
}