package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class AddToCart {

    Logger logger = LogManager.getRootLogger();

    @FindBy(css = "a[href*='ItemId=EST-2']")
    private WebElement addToCartSmallAngelFish;

    @FindBy(css = "a[href*='newOrderForm']")
    private WebElement proceedToCheckOut;



    public AddToCart() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public AddToCart clickOnAddToCartSmallAngelFish() {
        WaitForElement.waitUntilElementIsVisible(addToCartSmallAngelFish);
        addToCartSmallAngelFish.click();
        logger.info("Clicked 'add to cart'");
        return this;
    }

    public AddToCart proceedToCheckOutButton() {
        proceedToCheckOut.click();
        logger.info("Clicked proceed to check out");
        return this;
    }

}
