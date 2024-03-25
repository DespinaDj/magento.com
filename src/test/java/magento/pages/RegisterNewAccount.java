package magento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterNewAccount {
    private WebDriver driver;
    private WebDriverWait wait;
    public RegisterNewAccount(WebDriver driver, WebDriverWait wait){
        this.driver=driver;
        this.wait=wait;
    }
    // region 1. Locators of the elements on the page

    private By firstNameAria = By.id("firstname");
    private By lastNameAria = By.id("lastname");
    private By emailAria = By.id("email_address");
    private By passwordAria = By.id("password");
    private By confirmPasswordAria = By.id("password-confirmation");
    private By createAnAccountButton = By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button/span");

    private By passwordStrength = By.id("password-strength-meter-label");
    private By confirmation = By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div");
    //endregion

    public void populateFirstName(String firstName){
        driver.findElement(firstNameAria).sendKeys(firstName);
    }
    public void populateLastName(String lastName){
        driver.findElement(lastNameAria).sendKeys(lastName);
    }
    public void populateEmail(String email){
        driver.findElement(emailAria).sendKeys(email);
    }
    public void populatePassword(String password){
        driver.findElement(passwordAria).sendKeys(password);
    }
    public void confirmPassword(String password){
        driver.findElement(confirmPasswordAria).sendKeys(password);
    }
    public String passwordStrengthMessage(){
        return driver.findElement(passwordStrength).getText();
    }
    public void createAccountButton(){
        driver.findElement(createAnAccountButton).click();
    }
    public String confirmUserCreated(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(confirmation)).getText();
    }
    public String createNewAccountPageTitle(){
        String createNewAccountPageTitle = "Create New Customer Account";
        return createNewAccountPageTitle;
    }

    public String messageSuccessfulAccountCreated(){
        String confirmationMessage = "Thank you for registering with Main Website Store.";
        return  confirmationMessage;
    }




}
