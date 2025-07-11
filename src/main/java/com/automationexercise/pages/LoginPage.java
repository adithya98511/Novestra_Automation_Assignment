package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    // Locators for login page elements
    private By loginEmailField = By.xpath("//input[@name='email']");
    private By passwordField = By.xpath("//input[@name='password']");
    private By loginButton = By.xpath("//button[@type='submit']");
    private By errorMessage = By.xpath("//p[normalize-space()='Your email or password is incorrect!']");

    private By nameField = By.name("name");
    private By signupEmailField = By.xpath("//input[@data-qa='signup-email']");
    private By signupButton = By.xpath("//button[text()='Signup']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Method to enter email
    public void enterEmail(String email) {
        driver.findElement(loginEmailField).sendKeys(email);
    }

    // Method to enter password
    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    // Method to click login button
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    // Method to get the error message (if any)
    public String getErrorMessage() {
        WebElement error = driver.findElement(errorMessage);
        return error.isDisplayed() ? error.getText() : null;
    }

    public void fillSignupForm(String johnDoe, String uniqueEmail) {
    }

    public void clickSignupButton() {
    }
}
