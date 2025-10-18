package objects;

import driver.manager.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class AddToCart {

    @FindBy(css = "a[href*='ItemId=EST-2']")
    private WebElement addToCartSmallAngelFish;

    @FindBy(css = "a[href*='newOrderForm']")
    private WebElement proceedToCheckOut;

    @FindBy(css = "ul.messages li")
    private WebElement signOnWarningMessage;

    public AddToCart() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public void clickOnAddToCartSmallAngelFish() {
        WaitForElement.waitUntilElementIsVisible(addToCartSmallAngelFish);
        addToCartSmallAngelFish.click();
    }

    public void proceedToCheckOutButton() {
        proceedToCheckOut.click();
    }

    public String checkSignOnWarningMessage() {
        WaitForElement.waitUntilElementIsVisible(signOnWarningMessage);
        return signOnWarningMessage.getText();
    }
}
