package page.objects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

public class SignInPage extends BasePage {

    @FindBy(css = "#MenuContent a[href*='signonForm']")
    private WebElement signIn;

    @Step("Clicking on Sign in Link")
    public LoginPage clickOnSignInLink(){
        WaitForElement.waitUntilElementClickable(signIn);
        signIn.click();
        log().info("Clicked on Sign In");
        return new LoginPage();
    }
}