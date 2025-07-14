package com.automationexercise.tests;

import com.automationexercise.auth.Auth;
import com.automationexercise.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginValidTest {

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
    public void testLoginWithValidCredentials() {
        driver.get("https://www.automationexercise.com");

        // Use Auth class to log in
        HomePage homePage = auth.login();

        // Assert that user is logged in by checking account name visibility
        Assert.assertTrue(homePage.isAccountNameVisible("capman"), "Login failed: Account name not displayed");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
