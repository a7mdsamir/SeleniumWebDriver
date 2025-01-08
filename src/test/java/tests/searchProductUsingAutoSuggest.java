package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class searchProductUsingAutoSuggest extends TestBase{
    String searchTxt = " Mac";
    String productName = "Apple MacBook Pro 13-inch";
    SearchPage searchPage ;
    ProductDetailsPage productDetailsPage;

    @Test
    public void userCanSearchUsingAutoSuggest(){
        try{
        searchPage = new SearchPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        searchPage.searchProductUsingAutoSuggest(searchTxt);

        Assert.assertTrue(productDetailsPage.productNamebreadCrumb.getText().equalsIgnoreCase(productName));
        Assert.assertEquals(productDetailsPage.productNamebreadCrumb.getText() , productName);
        } catch (Exception e){
            System.out.println("Error occurred "+ e.getMessage());
        }

    }
}
