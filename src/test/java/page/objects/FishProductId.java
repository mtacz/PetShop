package objects;

import driver.manager.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class FishProductId {

    @FindBy(css = "a[href*='productId=FI-SW-01']")
    private WebElement angelFish;

    public FishProductId() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public void choseAngelFish() {
        WaitForElement.waitUntilElementIsVisible(angelFish);
        angelFish.click();
    }

}
