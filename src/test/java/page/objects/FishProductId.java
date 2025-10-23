package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class FishProductId {

    Logger logger = LogManager.getRootLogger();

    @FindBy(css = "a[href*='productId=FI-SW-01']")
    private WebElement angelFish;

    public FishProductId() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public AddToCart choseAngelFish() {
        WaitForElement.waitUntilElementIsVisible(angelFish);
        angelFish.click();
        logger.info("Clicked 'Angel Fish'");
        return new AddToCart();
    }

}
