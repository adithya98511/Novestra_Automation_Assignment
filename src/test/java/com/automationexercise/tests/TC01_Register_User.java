package com.automationexercise.tests;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC01_Register_User {

    @Test
    public void registerUser() {
        WebDriver driver = new ChromeDriver();

        try {
            // Create Page Objects
            HomePage homePage = new HomePage(driver);
            LoginPage loginPage = new LoginPage(driver);
            SignupPage signupPage = new SignupPage(driver);
            AccountCreatedPage accountCreatedPage = new AccountCreatedPage(driver);
            DeleteAccountPage deleteAccountPage = new DeleteAccountPage(driver);

            // 1. Launch browser and navigate to the URL
            homePage.navigateTo("http://automationexercise.com");

            // 2. Verify home page is visible
            Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");

            // 3. Navigate to login page
            homePage.navigateToLoginPage();

            // 4. Fill in name and email for signup
            String uniqueEmail = "johndoe" + System.currentTimeMillis() / 1000 + "@example.com";
            loginPage.fillSignupForm("John Doe", uniqueEmail);
            loginPage.clickSignupButton();

//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));  // Adjust wait time if necessary

            // 5. Fill in account details and submit
//            Assert.assertTrue(signupPage.isAccountInfoHeadingVisible(), "'Enter Account Information' is not visible");
            signupPage.fillAccountDetails("SecurePassword123", "1", "May", "1990");
            signupPage.selectCheckboxes();
            signupPage.fillAddressInfo("John", "Doe", "Company XYZ", "1234 Elm St", "Suite 567", "Canada", "Ontario", "Toronto", "M5A1A1", "1234567890");
            signupPage.clickCreateAccountButton();

            // 6. Verify account created message and click continue
            Assert.assertTrue(accountCreatedPage.isAccountCreatedMessageVisible(), "'Account Created!' message is not visible");
            accountCreatedPage.clickContinueButton();

            // 7. Verify logged in user is displayed
            Assert.assertTrue(homePage.isLoggedInAsUser(), "'Logged in as John Doe' is not visible");

            // 8. Click 'Delete Account'
            homePage.deleteAccount();

            // 9. Verify account deleted message
            Assert.assertTrue(deleteAccountPage.isAccountDeletedMessageVisible(), "'Account Deleted!' is not visible");

            // 10. Click continue after deletion
            deleteAccountPage.clickContinueButton();

        } finally {
            // 11. Close the browser
            driver.quit();
        }
    }
}

