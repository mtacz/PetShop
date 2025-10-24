package driver.manager;

public class DriverUtils {

    public static void setInitialConfiguration(){
        DriverManager.getDriver().manage().window().maximize();
    }

    public static void navigateToPage(String pageUrl){
        DriverManager.getDriver().navigate().to(pageUrl);
    }
}