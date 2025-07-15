package test_cases;
import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.*;

public class TestCase14 extends BaseTest {

    @Test
    public void testPlaceOrderRegisterWhileCheckout() {
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

        // 6. Click Proceed to Checkout
        LoginPage loginPage = cartPage.clickProceedToCheckoutAsGuest();

        // 7. Click Register/Login button (should be on login page already)
        Assert.assertTrue(loginPage.isRegisterLoginButtonVisible(), "Register/Login button should be visible");

        // 8. Fill signup details and create account
        SignupPage signupPage = loginPage.fillSignupForm("John Doe", "johndoe" + System.currentTimeMillis() + "@test.com");
        AccountCreatedPage accountCreatedPage = signupPage.fillSignupDetails("password123", "John", "Doe",
                "Test Company", "123 Test St", "Apt 1",
                "India", "Test State", "Test City",
                "12345", "1234567890");

        // 9. Verify account created and click continue
        Assert.assertTrue(accountCreatedPage.isAccountCreatedMessageVisible(), "Account created message should be visible");
        homePage = accountCreatedPage.clickContinueButton();

        // 10. Verify logged in as username
        Assert.assertTrue(homePage.getLoggedInUserText().contains("Logged in as"), "User should be logged in");

        // 11. Click Cart button
        cartPage = homePage.clickCartButton();

        // 12. Click Proceed to Checkout
        CheckoutPage checkoutPage = cartPage.clickProceedToCheckout();

        // 13. Verify Address Details and Review Order
        Assert.assertTrue(checkoutPage.areAddressDetailsVisible(), "Address details should be visible");
        Assert.assertTrue(checkoutPage.isReviewOrderVisible(), "Review order section should be visible");

        // 14. Enter comment and place order
        PaymentPage paymentPage = checkoutPage.enterCommentAndPlaceOrder("Test order comment");

        // 15. Enter payment details and confirm
        OrderSuccessPage orderSuccessPage = paymentPage.enterPaymentDetailsAndConfirm("John Doe", "4111111111111111",
                "123", "12", "2030");

        // 16. Verify success message
        Assert.assertTrue(orderSuccessPage.isSuccessMessageVisible(), "Success message should be visible");
        Assert.assertTrue(orderSuccessPage.getSuccessMessage().contains("successfully"), "Order should be placed successfully");

        // 17. Delete account
        AccountDeletedPage accountDeletedPage = orderSuccessPage.clickDeleteAccount();

        // 18. Verify account deleted
        Assert.assertTrue(accountDeletedPage.isAccountDeletedMessageVisible(), "Account deleted message should be visible");
        accountDeletedPage.clickContinueButton();
    }
}
