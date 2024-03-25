package magento.tests;

import org.testng.Assert;
import org.testng.annotations.Test;


public class AllTests extends BaseTest{

    @Test
    public void createNewAccount(){
        System.out.println("create New Account test in progress");
        home.navigateToHomePage();
        home.crateAnAccount();
        Assert.assertEquals(home.getCurrentPageTitle(),registerNewAccount.createNewAccountPageTitle());

        registerNewAccount.populateFirstName(firstName);
        registerNewAccount.populateLastName(lastName);
        registerNewAccount.populateEmail(email[0]);
        registerNewAccount.populatePassword(password);
        Assert.assertEquals(registerNewAccount.passwordStrengthMessage(),"Strong");
        registerNewAccount.confirmPassword(password);

        registerNewAccount.createAccountButton();
        Assert.assertEquals(registerNewAccount.confirmUserCreated(), registerNewAccount.messageSuccessfulAccountCreated());
        home.signOut();
    }


    @Test
    public void addProductToCart(){
        System.out.println("add Product To Cart test in progress");
        home.navigateToHomePage();

        home.navigateToWomenPage();
        Assert.assertEquals(home.getCurrentPageTitle(),"Women");

        home.chooseCategory(productCategory[0]);
        Assert.assertEquals(home.getCurrentPageTitle(), "Tops - Women");

        productElements.name(productName[0]);
        productElements.size(productSize[0]);
        productElements.color(productColor[0]);
        productElements.quantity(productQuantity[0]);
        productElements.addProductToCard();

        Assert.assertEquals(productElements.successfulProductAdd(), "You added " + productName[0] + " to your shopping cart.");

        home.navigateToMenPage();
        Assert.assertEquals(home.getCurrentPageTitle(),"Men");

        home.chooseCategory(productCategory[1]);
        Assert.assertEquals(home.getCurrentPageTitle(), productCategory[1] + " - Men");

        productElements.name(productName[1]);
        productElements.size(productSize[1]);
        productElements.color(productColor[1]);
        productElements.quantity(productQuantity[1]);
        productElements.addProductToCard();
        Assert.assertEquals(productElements.successfulProductAdd(), "You added " + productName[1] + " to your shopping cart.");
        home.myCart();
        Assert.assertEquals(home.numberOfItemsOnCart(), "2 Items in Cart");
        home.proceedToCheckout();
    }
    @Test
    public void registerAddProductsAndProceedToCheckout() throws InterruptedException{

        home.navigateToHomePage();
        home.crateAnAccount();
        Assert.assertEquals(home.getCurrentPageTitle(),registerNewAccount.createNewAccountPageTitle());

        registerNewAccount.populateFirstName(firstName);
        registerNewAccount.populateLastName(lastName);
        registerNewAccount.populateEmail(email[1]);
        registerNewAccount.populatePassword(password);
        Assert.assertEquals(registerNewAccount.passwordStrengthMessage(),"Strong");
        registerNewAccount.confirmPassword(password);

        registerNewAccount.createAccountButton();
        Assert.assertEquals(registerNewAccount.confirmUserCreated(), registerNewAccount.messageSuccessfulAccountCreated());

        home.navigateToHomePage();

        home.navigateToWomenPage();
        Assert.assertEquals(home.getCurrentPageTitle(),"Women");

        home.chooseCategory(productCategory[0]);
        Assert.assertEquals(home.getCurrentPageTitle(), "Tops - Women");

        productElements.name(productName[0]);
        productElements.size(productSize[0]);
        productElements.color(productColor[0]);
        productElements.quantity(productQuantity[0]);
        productElements.addProductToCard();

        Assert.assertEquals(productElements.successfulProductAdd(), "You added " + productName[0] + " to your shopping cart.");

        home.navigateToMenPage();
        Assert.assertEquals(home.getCurrentPageTitle(),"Men");

        home.chooseCategory(productCategory[1]);
        Assert.assertEquals(home.getCurrentPageTitle(), productCategory[1] + " - Men");

        productElements.name(productName[1]);
        productElements.size(productSize[1]);
        productElements.color(productColor[1]);
        productElements.quantity(productQuantity[1]);
        productElements.addProductToCard();
        Assert.assertEquals(productElements.successfulProductAdd(), "You added " + productName[1] + " to your shopping cart.");
        home.myCart();
        Assert.assertEquals(home.numberOfItemsOnCart(), "2 Items in Cart");
        home.proceedToCheckout();
        Assert.assertEquals(home.getCurrentPageTitle(), "Checkout");

        checkout.populateCompany(company);
        checkout.populateAddressArea(street0, street1,street2);
        checkout.populateCity(city);
        checkout.populatePostCode(postCode);
        checkout.selectContry(contry);
        checkout.populatePhoneArea(phoneNumber);
        checkout.nextButton();

        Assert.assertEquals(checkout.reviewAndPaymentsTitle(), "Payment Method");
        Thread.sleep(4000);

        checkout.placeOrder();
        Thread.sleep(4000);
        Assert.assertEquals(checkout.confirmationPurchase(), "Thank you for your purchase!");

    }
}
