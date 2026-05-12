package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.*;

public class FlipkartTest extends BaseTest {

    @Test
    public void flipkartAutomationTest() {

        HomePage home = new HomePage(driver);
        SearchPage search = new SearchPage(driver);
        ProductPage product = new ProductPage(driver);
        CartPage cart = new CartPage(driver);

        home.closeLoginPopup();
        home.searchProduct("mobile");

        search.verifySearchResults();
        search.addProductsToCompare();
        search.click10thPhone();

        product.addProductToCart();

        cart.increaseQty();
        cart.removeProduct();
    }
}
