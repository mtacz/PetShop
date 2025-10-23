package tests;

import org.testng.annotations.Test;
import page.objects.*;

import static org.testng.Assert.assertEquals;

public class AddSmallAngelFishToTheBasketTest extends TestBase {

    @Test
    public void buyingSmallAngelFishWithoutLoginOn() {

        WelcomePage welcomePage = new WelcomePage();
        welcomePage.enterWelcomePage();

        LoginPage loginPage = new LoginPage();
        loginPage.clickOnMenuWithFishOption()
                 .choseAngelFish()
                 .clickOnAddToCartSmallAngelFish()
                 .proceedToCheckOutButton();


        String warningMessage = loginPage.checkSignOnWarningMessage();

        assertEquals(warningMessage, "You must sign on before attempting to check out. Please " +
                "sign on and try checking out again.");
    }
}
