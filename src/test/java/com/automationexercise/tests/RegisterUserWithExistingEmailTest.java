package com.automationexercise.tests;

import com.automationexercise.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterUserWithExistingEmailTest {

    @Test
    public void registerUserWithExistingEmail() {
        WebDriver driver = new ChromeDriver();

        try {
            // Load credentials from .env file
            String existingEmail = "johndoe@examlpe.com";  // Fetch the existing email from .env file
            String name = "John Doe";  // You can set a fixed name for this test

            // Create LoginPage object to access signup form
            LoginPage loginPage = new LoginPage(driver);

            // 1. Launch browser and navigate to the URL
            driver.get("http://automationexercise.com");

            // 2. Verify home page is visible
            Assert.assertTrue(driver.getTitle().contains("Automation Exercise"), "Home page is not visible");

            // 3. Click on 'Signup / Login' button
            loginPage.clickLoginButton();

            // 4. Verify 'New User Signup!' is visible
            Assert.assertTrue(loginPage.isNewUserSignupVisible(), "'New User Signup!' is not visible");

            // 5. Enter name and existing email address
            loginPage.fillSignupForm(name, existingEmail);

            // 6. Click 'Signup' button
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
