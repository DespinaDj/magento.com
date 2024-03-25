package magento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home {
    private WebDriver driver;
    private WebDriverWait wait;

    public Home(WebDriver driver, WebDriverWait wait){
        this.driver=driver;
        this.wait = wait;
    }

    public void navigateToHomePage(){
        driver.navigate().to("https://magento.softwaretestingboard.com/");
    }

    public void crateAnAccount() {
        driver.findElement(By.linkText("Create an Account")).click();
    }
    public void signOut(){
        String text = driver.findElement(loginUser).getText();
        wait.until(ExpectedConditions.visibilityOfElementLocated(arrayDown)).click();
        driver.findElement(signOut).click();
    }
    public By loginUser = By.className("logged-in");
    private By arrayDown = By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/span");
    private By signOut = By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[3]/a");
    private By login = By.partialLinkText("Sign In");
    private By topsLink = By.linkText("Tops");
    private By bottomsLink = By.linkText("Bottoms");
    private By myCart = By.partialLinkText("My Cart");
    private By proceedToCheckoutButton = By.id("top-cart-btn-checkout");
    private By numberOfAddedItems = By.xpath("//*[@id=\"minicart-content-wrapper\"]/div[2]/div[1]/span[1]");
    private By itemsOnCart = By.xpath("//*[@id=\"minicart-content-wrapper\"]/div[2]/div[1]/span[2]");
    public void navigateToSingInPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(login)).click();
    }
    public void navigateToWomenPage(){
        driver.navigate().to("https://magento.softwaretestingboard.com/women.html");
    }
    public void navigateToMenPage(){
        driver.navigate().to("https://magento.softwaretestingboard.com/men.html");
    }

    public void chooseCategory(String category){
        if (category.equalsIgnoreCase("tops")){
            driver.findElement(topsLink).click();
        }else if(category.equalsIgnoreCase("bottoms")){
            driver.findElement(bottomsLink).click();
        } else {
            System.out.println("You chosen category is unavailable");
        }

    }
    public String getCurrentPageTitle(){
        return driver.getTitle();
    }

    public void myCart(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(myCart)).click();
    }
    public String numberOfItemsOnCart(){
        String number = wait.until(ExpectedConditions.visibilityOfElementLocated(numberOfAddedItems)).getText();
        String text =  wait.until(ExpectedConditions.visibilityOfElementLocated(itemsOnCart)).getText();
        String returnText = number + " " + text;
        return returnText;
    }

    public void proceedToCheckout(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(proceedToCheckoutButton)).click();
    }
}
