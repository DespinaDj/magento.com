package magento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Checkout {
    WebDriver driver;
    WebDriverWait wait;
    private Select select;

    public Checkout(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    private By emailArea = By.id("customer-email");
    private By firstName = By.name("firstname");
    private By lastName = By.name("lastname");
    private By companyArea = By.name("company");
    private By streetAdress1 = By.name("street[0]");
    private By streetAddress2 = By.name("street[1]");
    private By streetAddress3 = By.name("street[2]");
    private By cityArea = By.name("city");
    private By stateProvince = By.name("region_id");
    private By zipPostalCode = By.name("postcode");
    private By contryArea = By.name("country_id");
    private By phoneNumber = By.name("telephone");
    private By shippingMethod1 = By.name("ko_unique_1");
    private By shippingMethod2 = By.name("ko_unique_2");
    private By nextButton = By.xpath("//*[@id=\"shipping-method-buttons-container\"]/div/button/span");
    private By placeOrderButton = By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[4]/div/button/span");



    private By paymentPageTitle = By.xpath(" //*[@id=\"checkout-payment-method-load\"]/div/div/div[1]");

    public void populateCompany(String company) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(companyArea)).sendKeys(company);
    }

    public void populateAddressArea(String address1, String address2, String address3) {
        driver.findElement(streetAdress1).sendKeys(address1);
        driver.findElement(streetAddress2).sendKeys(address2);
        driver.findElement(streetAddress3).sendKeys(address3);
    }

    public void populateCity(String city) {
        driver.findElement(cityArea).sendKeys(city);
    }

    public void populatePostCode(String postcode) {
        driver.findElement(zipPostalCode).sendKeys(postcode);
    }

    public void selectContry(String contry) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(contryArea));
        select = new Select(element);
        wait.until(ExpectedConditions.visibilityOfElementLocated(contryArea)).click();
        select.selectByValue(contry);
    }
    public void selectStateProvince(String state) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(stateProvince));
        select = new Select(element);
        select.selectByValue(state);
    }
    public void selectShippingMethod(String method) {
        if (method.equalsIgnoreCase("0")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(shippingMethod1)).click();
        } else {
            wait.until(ExpectedConditions.visibilityOfElementLocated(shippingMethod2)).click();
        }
    }
    public void populatePhoneArea(String phone){
        wait.until(ExpectedConditions.visibilityOfElementLocated(phoneNumber)).sendKeys(phone);
    }

    public void nextButton() {
        By radioButton = By.xpath("//*[@id=\"checkout-shipping-method-load\"]/table/tbody/tr/td[1]/input");
        wait.until(ExpectedConditions.elementToBeSelected(radioButton));
        driver.findElement(nextButton).click();
    }

    public String reviewAndPaymentsTitle(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(paymentPageTitle)).getText();
    }
    public void placeOrder() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(placeOrderButton)).click();
    }
    public String confirmationPurchase() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("base"))).getText();
    }
}
