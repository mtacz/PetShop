package page.objects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

public class FishProductId extends BasePage {

    @FindBy(css = "a[href*='productId=FI-SW-01']")
    private WebElement angelFish;

    @Step("Choosing Angel Fish")
    public AddToCart choseAngelFish() {
        WaitForElement.waitUntilElementIsVisible(angelFish);
        angelFish.click();
        log().info("Clicked 'Angel Fish'");
        return new AddToCart();
    }
}