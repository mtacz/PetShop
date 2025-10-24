package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class LoginPage {

    Logger logger = LogManager.getRootLogger();

    @FindBy(name = "username")
    private WebElement usernameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(name = "signon")
    private WebElement signOnButton;

    @FindBy(css = "#Sidebar a[href*='FISH']")
    private WebElement menuFish;

    @FindBy(css = "ul.messages li")
    private WebElement signOnWarningMessage;

    public LoginPage(){
        PageFactory.initElements(DriverManager.getDriver(),this);
    }

    public LoginPage typeIntoUsernameField(String username){
        WaitForElement.waitUntilElementIsVisible(usernameField);
        usernameField.sendKeys(username);
        logger.info("Typed username as {}", username);
        return this;
    }

    public LoginPage typeIntoPasswordField(String password){
        WaitForElement.waitUntilElementIsVisible(passwordField);
        passwordField.sendKeys(password);
        logger.info("Typed password as {}", password);
        return this;
    }

    public FooterPageAfterLogin clickOnLoginButton(){
        signOnButton.click();
        logger.info("Clicked on Login button");
        return new FooterPageAfterLogin();
    }

    public FishProductId clickOnMenuWithFishOption(){
        WaitForElement.waitUntilElementIsVisible(menuFish);
        menuFish.click();
        logger.info("Clicked on menu with Fish option");
        return new FishProductId();
    }

    public String checkSignOnWarningMessage() {
        WaitForElement.waitUntilElementIsVisible(signOnWarningMessage);
        String warningMessage = signOnWarningMessage.getText();
        logger.info("Returned warning message was: {}", warningMessage);
        return warningMessage;
    }
}