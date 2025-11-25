package tests;

import driver.DriverUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import page.objects.LoginPage;
import page.objects.TestBase;

import static navigation.ApplicationURLs.LOGIN_URL;
import static org.testng.Assert.assertTrue;

public class PositiveLoginTests extends TestBase {

    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Description ("Test for login with valid credential - happy path")
    public void logInWithValidCredential() {
        DriverUtils.navigateToPage(LOGIN_URL);

        LoginPage loginPage = new LoginPage();
        loginPage
                .typeIntoUsernameField("j2ee")
//               .typeIntoPasswordField("j2ee")
                .clickOnLoginButton()
                .assertThatBannerAfterLoginDisplayed();

    }
}