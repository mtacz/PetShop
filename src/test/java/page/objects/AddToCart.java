package page.objects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

public class AddToCart extends BasePage {


    @FindBy(css = "a[href*='ItemId=EST-2']")
    private WebElement addToCartSmallAngelFish;

    @FindBy(css = "a[href*='newOrderForm']")
    private WebElement proceedToCheckOut;


    @Step("Clicking add to cart button")
    public AddToCart clickOnAddToCartSmallAngelFish() {
        WaitForElement.waitUntilElementIsVisible(addToCartSmallAngelFish);
        addToCartSmallAngelFish.click();
        log().info("Clicked 'add to cart'");
        return this;
    }

    @Step("Clicking proceed to check out")
    public AddToCart proceedToCheckOutButton() {
        proceedToCheckOut.click();
        log().info("Clicked proceed to check out");
        return this;
    }

}
