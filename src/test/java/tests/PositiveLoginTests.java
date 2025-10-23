package tests;

import org.testng.annotations.Test;
import page.objects.TestBase;
import page.objects.WelcomePage;

import static org.testng.Assert.assertTrue;

public class PositiveLoginTests extends TestBase {

    @Test
    public void logInWithValidCredential() {
        WelcomePage welcomePage = new WelcomePage();
        boolean isBannerAfterLoginDisplayed = welcomePage
                .enterWelcomePage()
                .clickOnSignInLink()
                .typeIntoUsernameField("j2ee")
//                .typeIntoPasswordField("j2ee")
                .clickOnLoginButton()
                .isBannerAfterLoginDisplayed();

        assertTrue(isBannerAfterLoginDisplayed);

    }
}
