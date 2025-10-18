package objects;

import driver.manager.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class MainPageFish {

    @FindBy(css = "#Sidebar a[href*='FISH']")
    private WebElement menuFish;

    public MainPageFish(){
        PageFactory.initElements(DriverManager.getDriver(),this);
    }

    public void clickOnMenuFish (){
        WaitForElement.waitUntilElementIsVisible(menuFish);
        menuFish.click();
    }

}
