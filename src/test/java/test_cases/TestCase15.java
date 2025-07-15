package test_cases;

import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.*;

public class TestCase15 extends BaseTest {

    @Test
    public void testPlaceOrderRegisterBeforeCheckout() {
        // 1. Launch browser and navigate to URL - done in BaseTest

        // 2. Verify home page is visible
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isHomePageVisible(), "Home page should be visible");

        // 3. Click Signup/Login button
        LoginPage loginPage = homePage.clickSignupLoginButton();

        // 4. Fill signup details and create account
        SignupPage signupPage = loginPage.fillSignupForm("Jane Doe", "janedoe" + System.currentTimeMillis() + "@test.com");
        AccountCreatedPage accountCreatedPage = signupPage.fillSignupDetails("password123", "Jane", "Doe",
                "Test Company", "123 Test St", "Apt 2",
                "India", "Test State", "Test City",
                "12345", "9876543210");

        // 5. Verify account created and click continue
        Assert.assertTrue(accountCreatedPage.isAccountCreatedMessageVisible(), "Account created message should be visible");
        homePage = accountCreatedPage.clickContinueButton();

        // 6. Verify logged in as username
        Assert.assertTrue(homePage.getLoggedInUserText().contains("Logged in as"), "User should be logged in");

        // 7. Add products to cart
        homePage.addMultipleProductsToCart(2);

        // 8. Click Cart button
        CartPage cartPage = homePage.clickCartButton();

        // 9. Verify cart page is displayed
        Assert.assertTrue(cartPage.isCartPageDisplayed(), "Cart page should be displayed");

        // 10. Click Proceed to Checkout
        CheckoutPage checkoutPage = cartPage.clickProceedToCheckout();

        // 11. Verify Address Details and Review Order
        Assert.assertTrue(checkoutPage.areAddressDetailsVisible(), "Address details should be visible");
        Assert.assertTrue(checkoutPage.isReviewOrderVisible(), "Review order section should be visible");

        // 12. Enter comment and place order
        PaymentPage paymentPage = checkoutPage.enterCommentAndPlaceOrder("Test order comment");

        // 13. Enter payment details and confirm
        OrderSuccessPage orderSuccessPage = paymentPage.enterPaymentDetailsAndConfirm("Jane Doe", "4111111111111111",
                "123", "12", "2030");

        // 14. Verify success message
        Assert.assertTrue(orderSuccessPage.isSuccessMessageVisible(), "Success message should be visible");
        Assert.assertTrue(orderSuccessPage.getSuccessMessage().contains("successfully"), "Order should be placed successfully");

        // 15. Delete account
        AccountDeletedPage accountDeletedPage = orderSuccessPage.clickDeleteAccount();

        // 16. Verify account deleted
        Assert.assertTrue(accountDeletedPage.isAccountDeletedMessageVisible(), "Account deleted message should be visible");
        accountDeletedPage.clickContinueButton();
    }
}
