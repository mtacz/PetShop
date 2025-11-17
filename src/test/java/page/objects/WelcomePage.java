package page.objects;

import driver.DriverManager;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import waits.WaitForElement;

public class WelcomePage {

    private Logger logger = LogManager.getRootLogger();

    @FindBy(css = "#Content a")
    private WebElement welcomeLink;

    public WelcomePage(){
        PageFactory.initElements(DriverManager.getWebDriver(),this);
    }

    @Step("Click on enter story link")
    public SignInPage enterWelcomePage(){
        WaitForElement.waitUntilElementIsVisible(welcomeLink);
        welcomeLink.click();
        logger.info("Entered the Store link");
        return new SignInPage();
    }
}