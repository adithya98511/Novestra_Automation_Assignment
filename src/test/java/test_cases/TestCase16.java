package test_cases;

import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.*;

public class TestCase16 extends BaseTest {

    @Test
    public void testPlaceOrderLoginBeforeCheckout() {
        // Pre-requisite: You need to have a registered user account
        String existingEmail = "testuser@example.com";
        String existingPassword = "password123";

        // 1. Launch browser and navigate to URL - done in BaseTest

        // 2. Verify home page is visible
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isHomePageVisible(), "Home page should be visible");

        // 3. Click Signup/Login button
        LoginPage loginPage = homePage.clickSignupLoginButton();

        // 4. Login with existing credentials
        homePage = loginPage.login(existingEmail, existingPassword);

        // 5. Verify logged in as username
        Assert.assertTrue(homePage.getLoggedInUserText().contains("Logged in as"), "User should be logged in");

        // 6. Add products to cart
        homePage.addMultipleProductsToCart(2);

        // 7. Click Cart button
        CartPage cartPage = homePage.clickCartButton();

        // 8. Verify cart page is displayed
        Assert.assertTrue(cartPage.isCartPageDisplayed(), "Cart page should be displayed");

        // 9. Click Proceed to Checkout
        CheckoutPage checkoutPage = cartPage.clickProceedToCheckout();

        // 10. Verify Address Details and Review Order
        Assert.assertTrue(checkoutPage.areAddressDetailsVisible(), "Address details should be visible");
        Assert.assertTrue(checkoutPage.isReviewOrderVisible(), "Review order section should be visible");

        // 11. Enter comment and place order
        PaymentPage paymentPage = checkoutPage.enterCommentAndPlaceOrder("Test order comment");

        // 12. Enter payment details and confirm
        OrderSuccessPage orderSuccessPage = paymentPage.enterPaymentDetailsAndConfirm("Test User", "4111111111111111",
                "123", "12", "2030");

        // 13. Verify success message
        Assert.assertTrue(orderSuccessPage.isSuccessMessageVisible(), "Success message should be visible");
        Assert.assertTrue(orderSuccessPage.getSuccessMessage().contains("successfully"), "Order should be placed successfully");

        // 14. Delete account
        AccountDeletedPage accountDeletedPage = orderSuccessPage.clickDeleteAccount();

        // 15. Verify account deleted
        Assert.assertTrue(accountDeletedPage.isAccountDeletedMessageVisible(), "Account deleted message should be visible");
        accountDeletedPage.clickContinueButton();
    }
}