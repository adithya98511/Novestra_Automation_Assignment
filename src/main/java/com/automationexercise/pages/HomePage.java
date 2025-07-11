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


    public void deleteAccount() {
    }
}