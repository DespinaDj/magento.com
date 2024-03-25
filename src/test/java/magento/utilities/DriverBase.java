package magento.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverBase {
    private WebDriver driver;
    public WebDriver initiateDriver(String browserName){
        if(browserName.equalsIgnoreCase("chrome")){
            driver =  new ChromeDriver();
        } else if(browserName.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        }else if(browserName.equalsIgnoreCase("edge")){
            driver = new EdgeDriver();
        }else {
            System.out.println("Invalid browser name provided");
        }
        return driver;
    }

}
