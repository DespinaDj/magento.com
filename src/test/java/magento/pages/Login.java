package magento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
    WebDriver driver;
    WebDriverWait wait;
    public Login(WebDriver driver, WebDriverWait wait){
        this.driver=driver;
        this.wait = wait;
    }

    private By emailArea = By.id("email");
    private By passwordArea = By.id("pass");
    private By singButton = By.id("send2");

    public void singIn(String email, String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailArea)).sendKeys(email);
        driver.findElement(passwordArea).sendKeys(password);
    }

    public void SingInButton(){
        wait.until(ExpectedConditions.elementToBeClickable(singButton)).click();
    }


}
