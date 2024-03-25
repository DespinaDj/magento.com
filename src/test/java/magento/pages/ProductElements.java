package magento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductElements {
    private WebDriver driver;
    private WebDriverWait wait;
    public ProductElements(WebDriver driver, WebDriverWait wait){
        this.driver=driver;
        this.wait=wait;
    }
    // region 1. Locators for tops size of the chosen Product
    private By sizeXs = By.id("option-label-size-143-item-166");
    private By sizeS = By.id("option-label-size-143-item-167");
    private By sizeM = By.id("option-label-size-143-item-168");
    private By sizeL = By.id("option-label-size-143-item-169");
    private By sizeXl = By.id("option-label-size-143-item-170");
    //endregion

    // region 2. Locators for the botoms size of the products
    private By thirtyTwo = By.id("option-label-size-143-item-175");
    private By thirtyThree= By.id("option-label-size-143-item-176");
    private By thirtyFour = By.id("option-label-size-143-item-177");
    private By thirtySix = By.id("option-label-size-143-item-178");

    //endregion

    // region 3. Locators for color of the chosen product
    private By black = By.id("option-label-color-93-item-49");
    private By blue = By.id("option-label-color-93-item-50");
    private By orange = By.id("option-label-color-93-item-56");
    private By purple = By.id("option-label-color-93-item-57");
    private By red = By.id("option-label-color-93-item-58");

    //endregion

    // region 4. Other Locators
    private By quantityBox = By.id("qty");
    private By addCardButton = By.id("product-addtocart-button");
    private By confrimation = By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div");


    //endregion

    public void name(String productName){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(productName))).click();

    }

    public void size(String size){
        if(size.equalsIgnoreCase("xs")){
            wait.until(ExpectedConditions.visibilityOfElementLocated(sizeXs)).click();
        }else if(size.equalsIgnoreCase("s")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(sizeS)).click();
        }else if(size.equalsIgnoreCase("m")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(sizeM)).click();
        }else if(size.equalsIgnoreCase("l")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(sizeL)).click();
        }else if(size.equalsIgnoreCase("xl")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(sizeXl)).click();
        }else if(size.equalsIgnoreCase("32")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(thirtyTwo)).click();
        }else if(size.equalsIgnoreCase("33")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(thirtyThree)).click();
        }else if(size.equalsIgnoreCase("34")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(thirtyFour)).click();
        }else if(size.equalsIgnoreCase("36")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(thirtySix)).click();
        }else {
            System.out.println("The chosen size it is not available");
        }
    }
    public void color(String color){
        if(color.equalsIgnoreCase("orange")){
            wait.until(ExpectedConditions.visibilityOfElementLocated(orange)).click();
        }else if(color.equalsIgnoreCase("Purple")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(purple)).click();
        }else if(color.equalsIgnoreCase("Red")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(red)).click();
        }else if(color.equalsIgnoreCase("black")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(black)).click();
        }else if(color.equalsIgnoreCase("blue")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(blue)).click();
        }else{
            System.out.println("The choosen color is not aviable");
        }
    }

    public void quantity(String quantity){
        wait.until(ExpectedConditions.visibilityOfElementLocated(quantityBox)).clear();
        driver.findElement(quantityBox).sendKeys(quantity);
    }
    public void addProductToCard(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(addCardButton)).click();
    }
    public String successfulProductAdd(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(confrimation));
        return driver.findElement(confrimation).getText();
    }





}
