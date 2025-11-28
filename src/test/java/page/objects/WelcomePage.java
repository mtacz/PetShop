package page.objects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import waits.WaitForElement;

public class WelcomePage extends BasePage {

    @FindBy(css = "#Content a")
    private WebElement welcomeLink;

    @Step("Click on enter story link")
    public SignInPage enterWelcomePage(){
        WaitForElement.waitUntilElementIsVisible(welcomeLink);
        welcomeLink.click();
        log().info("Entered the Store link");
        return new SignInPage();
    }
}