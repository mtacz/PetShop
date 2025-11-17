package page.objects;

import driver.DriverManager;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class SignInPage {

    Logger logger = LogManager.getRootLogger();


    @FindBy(css = "#MenuContent a[href*='signonForm']")
    private WebElement signIn;

    public SignInPage() {
        PageFactory.initElements(DriverManager.getWebDriver(),this);
    }

    @Step("Clicking on Sign in Link")
    public LoginPage clickOnSignInLink(){
        WaitForElement.waitUntilElementClickable(signIn);
        signIn.click();
        logger.info("Clicked on Sign In");
        return new LoginPage();
    }

}