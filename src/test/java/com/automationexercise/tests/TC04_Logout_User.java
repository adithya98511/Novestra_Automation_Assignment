package com.automationexercise.tests;

import com.automationexercise.auth.Auth;
import com.automationexercise.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC04_Logout_User {

    @Test
    public void logoutUser() {
        WebDriver driver = new ChromeDriver();

        try {
            // Create Auth object to handle login
            Auth auth = new Auth(driver);

            // 1. Login using the Auth class
            HomePage homePage = auth.login();  // This will log in using credentials from .env file
            // Create Page Objects

            // 3. Verify that the user is logged in
            Assert.assertTrue(homePage.isLoggedInAsUser(), "'Logged in as' is not visible");

            // 4. Click the 'Logout' button
            homePage.logout();

            // 5. Verify that the user is logged out
            Assert.assertTrue(homePage.isLogoutButtonVisible(), "Logout button is visible, user might not have been logged out");

            // Alternatively, you can verify that a "Login" link appears after logout
            Assert.assertTrue(driver.getTitle().contains("Automation Exercise"), "Page title doesn't match after logout");

        } finally {
            // 6. Close the browser
            driver.quit();
        }
    }
}

