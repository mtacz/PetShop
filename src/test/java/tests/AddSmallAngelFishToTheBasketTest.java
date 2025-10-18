package tests;

import org.testng.annotations.Test;
import page.objects.*;

import static org.testng.Assert.assertEquals;

public class AddAngelFishToTheBasketTest extends TestBase {

    @Test
    public void buyingSmallAngelFishWithoutLoginOn() {

        WelcomePage welcomePage = new WelcomePage();
        welcomePage.enterWelcomePage();

        MainPageFish mainPageFish = new MainPageFish();
        mainPageFish.clickOnMenuFish();

        FishProductId fishProductId = new FishProductId();
        fishProductId.choseAngelFish();

        AddToCart addToCart = new AddToCart();
        addToCart.clickOnAddToCartSmallAngelFish();
        addToCart.proceedToCheckOutButton();
        String warningMessage = addToCart.checkSignOnWarningMessage();

        assertEquals(warningMessage, "You must sign on before attempting to check out. Please " +
                "sign on and try checking out again.");
    }

}
