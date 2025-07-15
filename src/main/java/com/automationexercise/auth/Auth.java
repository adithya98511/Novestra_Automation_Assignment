package com.automationexercise.auth;

import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.LoginPage;
import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Auth {

    private WebDriver driver;
    private Dotenv dotenv;

    public Auth(WebDriver driver) {
        this.driver = driver;
        this.dotenv = Dotenv.load();
    }

    // Method to get the email from .env file
    private String getEmail() {
        return dotenv.get("USER_EMAIL");  // Fetch email from .env file
    }

    // Method to get the password from .env file
    private String getPassword() {
        return dotenv.get("USER_PASSWORD");  // Fetch password from .env file
    }

    // Method to log in with correct credentials
    public HomePage login() {
        String email = getEmail();
        String  password = getPassword();

        if (email == null || password == null) {
            throw new IllegalArgumentException("Credentials are not set in the .env file.");
        }

        // Navigate to the login page first
        driver.get("https://www.automationexercise.com");

        // Click the Login/Signup link in the navigation
        driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();

        // Now we are on the login page, perform login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();

        // Return HomePage object after successful login
        return new HomePage(driver);
    }

    // Method to log in with invalid credentials (for testing failed login)
    public String loginWithInvalidCredentials(String email, String password) {
        // Navigate to the login page first
        driver.get("https://www.automationexercise.com");

        // Click the Login/Signup link in the navigation
//        driver.findElement(By.linkText("Login / Signup")).click();
        driver.findElement(By.xpath("/html/body/header/div/div/div/div[2]/div/ul/li[4]/a")).click();

        // Now we are on the login page, attempt to log in
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();

        // Return error message if login fails
        return loginPage.getInvalidLoginErrorMessage();
    }
}
