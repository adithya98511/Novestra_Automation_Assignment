package com.automationexercise.tests;

import com.automationexercise.auth.Auth;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC03_Login_with_Incorrect_Credentials {

    private WebDriver driver;
    private Auth auth;

    @BeforeClass
    public void setUp() {
        // Initialize WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        auth = new Auth(driver);
    }

    @Test
    public void testLoginWithInvalidPassword() {
        driver.get("https://www.automationexercise.com");

        // Attempt login with invalid credentials
        String errorMessage = auth.loginWithInvalidCredentials("johndoe@example.com", "wrongpassword");

        // Assert the error message displayed
        Assert.assertEquals(errorMessage, "Your email or password is incorrect!", "Error message not displayed as expected");
    }

    @Test
    public void testLoginWithInvalidUsername() {
        driver.get("https://www.automationexercise.com");

        // Attempt login with invalid credentials
        String errorMessage = auth.loginWithInvalidCredentials("wrong@example.com", "123abcABC");

        // Assert the error message displayed
        Assert.assertEquals(errorMessage, "Your email or password is incorrect!", "Error message not displayed as expected");
    }

    @Test
    public void testLoginWithInvalidCredentials() {
        driver.get("https://www.automationexercise.com");

        // Attempt login with invalid credentials
        String errorMessage = auth.loginWithInvalidCredentials("wrong@example.com", "wrongpassword");

        // Assert the error message displayed
        Assert.assertEquals(errorMessage, "Your email or password is incorrect!", "Error message not displayed as expected");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
