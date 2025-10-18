package objects;

import driver.manager.DriverManager;
import driver.manager.DriverUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    @BeforeMethod
    public void beforeTest(){
        DriverManager.getDriver();
        DriverUtils.setInitialConfiguration();
        DriverUtils.navigateToPage("https://przyklady.javastart.pl/jpetstore/");
    }

    @AfterMethod
    public void afterTest(){
        DriverManager.disposeDriver();
    }
}
