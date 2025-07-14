package com.automationexercise.tests;

import com.automationexercise.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC05_Register_User_with_Existing_Email {

    @Test
    public void registerUserWithExistingEmail() {
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

            // 4. Fill in name and an existing email for signup
            loginPage.fillSignupForm("John Doe", "johndoe@example.com");
            loginPage.clickSignupButton();

            // 7. Verify error 'Email Address already exist!' is visible
            String errorMessage = loginPage.getErrorMessage();
            Assert.assertEquals(errorMessage, "Email Address already exist!", "Error message is not as expected");

        } finally {
            // 8. Close the browser
            driver.quit();
        }
    }
}
