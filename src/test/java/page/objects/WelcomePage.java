package page.objects;

import driver.manager.DriverManager;
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
        PageFactory.initElements(DriverManager.getDriver(),this);
    }

    public SignInPage enterWelcomePage(){
        WaitForElement.waitUntilElementIsVisible(welcomeLink);
        welcomeLink.click();
        logger.info("Entered the Store link");
        return new SignInPage();
    }

}
