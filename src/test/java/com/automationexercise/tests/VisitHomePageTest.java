package com.automationexercise.tests;

import com.automationexercise.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class VisitHomePageTest {
/**
 * Checks if Home Page is visited.
 * Does not interact.
 * Ideal for checking if project runs.
 * */
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testVisitHomePage() {
        driver.get("https://www.automationexercise.com");

        // Create HomePage object
        HomePage homePage = new HomePage(driver);

        // Verify that the page is loaded by checking the title (or any other method)
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "Automation Exercise", "Page title is incorrect");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
