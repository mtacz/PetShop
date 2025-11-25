package page.objects;

import driver.DriverManager;
import generic.assertions.AssertWebElement;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class LoginPage {

    Logger logger = LogManager.getLogger(LoginPage.class);

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
        PageFactory.initElements(DriverManager.getWebDriver(),this);
    }

    @Step("Type into Username field {username} ")
    public LoginPage typeIntoUsernameField(String username){
        WaitForElement.waitUntilElementIsVisible(usernameField);
        usernameField.sendKeys(username);
        logger.info("Typed username as {}", username);
        return this;
    }

    @Step("Type into Password field {password}")
    public LoginPage typeIntoPasswordField(String password){
        WaitForElement.waitUntilElementIsVisible(passwordField);
        passwordField.sendKeys(password);
        logger.info("Typed password as {}", password);
        return this;
    }

    @Step("Clocking on Login button")
    public FooterPageAfterLogin clickOnLoginButton(){
        signOnButton.click();
        logger.info("Clicked on Login button");
        return new FooterPageAfterLogin();
    }

    @Step("Clicking on Fish Menu")
    public FishProductId clickOnMenuWithFishOption(){
        WaitForElement.waitUntilElementIsVisible(menuFish);
        menuFish.click();
        logger.info("Clicked on menu with Fish option");
        return new FishProductId();
    }

    @Step("Checking warning message")
    public LoginPage assertThatWarningMessageIsDisplayed(String warningMessage) {
        logger.info("Checking if warning message was displayed: {}", warningMessage);
        WaitForElement.waitUntilElementIsVisible(signOnWarningMessage);
        AssertWebElement.assertThat(signOnWarningMessage).isDisplayed().hasText(warningMessage);
        return this;
    }
}