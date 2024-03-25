package magento.tests;

import magento.pages.*;
import magento.utilities.DriverBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    public WebDriverWait wait;
    public DriverBase driverBase;
    //region chose Browser
    private static String browserName = "edge";
    //endregion
    //region Initialize methods
    public ProductElements productElements;
    public Home home;
    public RegisterNewAccount registerNewAccount;
    public Login login;

    public Checkout checkout;
    //endregion

    // region 1. New User data
    public String firstName ="Despina";
    public String lastName ="Stojanovska";
    public String[] email ={"example1Mail50@yahoo.com", "exampleMail52@yahoo.com"};
    public String password ="Testing1@";
    //endregion

    // region 2. Product Details
    public String[] productName = {"Nora Practice Tank", "Apollo Running Short"};
    public String[] productCategory = {"Tops", "Bottoms"};
    public String[] productSize = {"s", "36"};
    public String[] productColor ={"orange", "black"};
    public String[] productQuantity = {"1", "1"};
    //endregion

    // region 3. Shipping Address Details
    public String company ="QA Tester-Junior";
    public String street0 ="Hristo Smirnenski";
    public String street1 ="42A";
    public String street2 ="Center";
    public String city ="Skopje";
    public String contry ="MK";
    public String postCode ="1000";
    public String phoneNumber ="+389070070070";
    //endregion


    @BeforeSuite
    public void setUp(){
        driverBase = new DriverBase();
        driver = driverBase.initiateDriver(browserName);
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        home = new Home(driver,wait);
        productElements = new ProductElements(driver,wait);
        registerNewAccount = new RegisterNewAccount(driver, wait);
        login = new Login(driver,wait);
        checkout = new Checkout(driver,wait);

    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}
