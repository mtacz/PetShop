package page.objects;

import generic.assertions.AssertWebElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

public class LoginPage extends BasePage {

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


    @Step("Type into Username field {username} ")
    public LoginPage typeIntoUsernameField(String username){
        WaitForElement.waitUntilElementIsVisible(usernameField);
        usernameField.sendKeys(username);
        log().info("Typed username as {}", username);
        return this;
    }

    @Step("Type into Password field {password}")
    public LoginPage typeIntoPasswordField(String password){
        passwordField.clear();
        passwordField.sendKeys(password);
        log().info("Typed password as {}", password);
        return this;
    }

    @Step("Clicking on Login button")
    public FooterPageAfterLogin clickOnLoginButton(){
        signOnButton.click();
        log().info("Clicked on Login button");
        return new FooterPageAfterLogin();
    }

    @Step("Clicking on Fish Menu")
    public FishProductId clickOnMenuWithFishOption(){
        WaitForElement.waitUntilElementIsVisible(menuFish);
        menuFish.click();
        log().info("Clicked on menu with Fish option");
        return new FishProductId();
    }

    @Step("Checking warning message")
    public LoginPage assertThatWarningMessageIsDisplayed(String warningMessage) {
        log().info("Checking if warning message was displayed: {}", warningMessage);
        WaitForElement.waitUntilElementIsVisible(signOnWarningMessage);
        AssertWebElement.assertThat(signOnWarningMessage).isDisplayed().hasText(warningMessage);
        return this;
    }
}