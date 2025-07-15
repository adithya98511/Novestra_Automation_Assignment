package test_cases;

import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.*;

public class TestCase17 extends BaseTest {

    @Test
    public void testRemoveProductsFromCart() {
        // 1. Launch browser and navigate to URL - done in BaseTest

        // 2. Verify home page is visible
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isHomePageVisible(), "Home page should be visible");

        // 3. Add products to cart
        homePage.addMultipleProductsToCart(2);

        // 4. Click Cart button
        CartPage cartPage = homePage.clickCartButton();

        // 5. Verify cart page is displayed
        Assert.assertTrue(cartPage.isCartPageDisplayed(), "Cart page should be displayed");

        // 6. Get initial cart size
        int initialCartSize = cartPage.getCartItemsCount();

        // 7. Click 'X' button to remove first product
        cartPage.removeProductFromCart(0);

        // 8. Verify product is removed from cart
        Assert.assertTrue(cartPage.isProductRemovedFromCart(initialCartSize),
                "Product should be removed from cart");
    }
}