package magento.utilities;

import org.testng.annotations.DataProvider;

public class Product {
    @DataProvider(name = "women-product-data")
    public Object [][] productData(){
        return new Object[][]{
                {"Tops","Nora Practice Tank", "m", "orange", "1"},
                {"Bottoms","Bess Yoga Short", "32", "blue", "2"}
        };
    }
}
