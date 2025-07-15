package com.automationexercise.helpers;

import com.automationexercise.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class UserAccountHelper {

    public static void createAccount(WebDriver driver, HomePage homePage, LoginPage loginPage, SignupPage signupPage, AccountCreatedPage accountCreatedPage) {
        // Navigate to the home page
        homePage.navigateTo("http://automationexercise.com");
        Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");

        // Navigate to login page
        homePage.navigateToLoginPage();

        // Fill in name and email for signup
        String uniqueEmail = "johndoe" + System.currentTimeMillis() / 1000 + "@example.com";
        loginPage.fillSignupForm("John Doe", uniqueEmail);
        loginPage.clickSignupButton();

        // Fill in account details
        signupPage.fillAccountDetails("SecurePassword123", "1", "May", "1990");
        signupPage.selectCheckboxes();
        signupPage.fillAddressInfo("John", "Doe", "Company XYZ", "1234 Elm St", "Suite 567", "Canada", "Ontario", "Toronto", "M5A1A1", "1234567890");
        signupPage.clickCreateAccountButton();

        // Verify account created message
        Assert.assertTrue(accountCreatedPage.isAccountCreatedMessageVisible(), "'Account Created!' message is not visible");
        accountCreatedPage.clickContinueButton();
    }

    // Method to delete a user account
    public static void deleteAccount(WebDriver driver, HomePage homePage, DeleteAccountPage deleteAccountPage) {
        // Click 'Delete Account'
        homePage.deleteAccount();

        // Verify account deleted message
        Assert.assertTrue(deleteAccountPage.isAccountDeletedMessageVisible(), "'Account Deleted!' is not visible");

        // Click continue after deletion
        deleteAccountPage.clickContinueButton();
    }
}
