package com.automationexercise.tests;
import com.automationexercise.helpers.UserAccountHelper;
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

            UserAccountHelper.createAccount(driver, homePage, loginPage, signupPage, accountCreatedPage);

            // 7. Verify logged in user is displayed
            Assert.assertTrue(homePage.isAccountNameVisible("John Doe"), "'Logged in as John Doe' is not visible");

            // 8. Click 'Delete Account'
            UserAccountHelper.deleteAccount(driver, homePage, deleteAccountPage);

        } finally {
            // 11. Close the browser
            driver.quit();
        }
    }
}

