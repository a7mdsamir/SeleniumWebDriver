package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductTest extends TestBase{

    String productName = "Apple MacBook Pro 13-inch";
    SearchPage searchPage ;
    ProductDetailsPage productDetailsPage;

    @Test
    public void userCanSearchForProduct(){
        searchPage = new SearchPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        searchPage.productSearch(productName);
        searchPage.openProductDetailsPage();
        Assert.assertTrue(productDetailsPage.productNamebreadCrumb.getText().equalsIgnoreCase(productName));
        Assert.assertEquals(productDetailsPage.productNamebreadCrumb.getText() , productName);
    }
}
