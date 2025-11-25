package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import page.objects.*;

import static org.testng.Assert.assertEquals;

public class BuyingFishWithoutLoginTests extends TestBase {

    @Severity(SeverityLevel.NORMAL)
    @Test
    @Description("The goal of this test is to add small Angel Fish to the basket without log in to the system and try" +
            " buying it")
    public void buyingSmallAngelFishWithoutLoginOn() {

        WelcomePage welcomePage = new WelcomePage();
        welcomePage.enterWelcomePage();

        LoginPage loginPage = new LoginPage();
        loginPage
                .clickOnMenuWithFishOption()
                 .choseAngelFish()
                 .clickOnAddToCartSmallAngelFish()
                 .proceedToCheckOutButton();
        loginPage
                .assertThatWarningMessageIsDisplayed("You must sign on before attempting to check out. Please " +
                "sign on and try checking out again.");

    }
}