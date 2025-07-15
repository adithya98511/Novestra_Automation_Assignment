package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    private By loginLink = By.xpath("//a[normalize-space()='Signup / Login']");
    private By loggedInAsText = By.xpath("//a[contains(text(), 'Logged in as')]//b[text()='capman']");
    private By logoutButton = By.xpath("(//a[normalize-space()='Logout'])[1]");

    private By deleteAccountButton = By.xpath("(//a[normalize-space()='Delete Account'])[1]");

    // Navigate to the login page
    public void navigateToLoginPage() {
        driver.findElement(loginLink).click();
    }

    // Check if the home page is visible
    public boolean isHomePageVisible() {
        return driver.getTitle().contains("Automation Exercise");
    }

    // Check if the logged-in user is displayed
    public boolean isLoggedInAsUser() {
        return driver.findElement(loggedInAsText).isDisplayed();
    }

    public boolean isAccountNameVisible(String username) {
        // Create a dynamic XPath based on the passed username
        By dynamicLoggedInAsText = By.xpath("//a[contains(text(), 'Logged in as')]//b[text()='" + username + "']");

        try {
            // Attempt to find the element based on the dynamic XPath
            WebElement accountNameElement = driver.findElement(dynamicLoggedInAsText);
            return accountNameElement.isDisplayed(); // Returns true if the element is visible
        } catch (NoSuchElementException e) {
            return false; // Returns false if the element is not found
        }
    }

    // Click the logout button
    public void logout() {
        driver.findElement(logoutButton).click();
    }

    // Verify if the "Logout" button is visible
    public boolean isLogoutButtonVisible() {
        return driver.findElement(logoutButton).isDisplayed();
    }


    public void deleteAccount() {
        driver.findElement(deleteAccountButton).click();
    }
}