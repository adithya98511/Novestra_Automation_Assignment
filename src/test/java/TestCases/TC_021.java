package TestCases;

import Pages.HomePage;
import Pages.ProductsPage;
import Pages.SingleProductViewPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_021 {
    WebDriver driver;

    @BeforeTest
    public void OpenWebPage() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://automationexercise.com/");
    }

    @Test
    public void Test(){

        HomePage homePage = new HomePage(driver);
        homePage.selectProductsBtn();

        // Verify user successfully directed to All Products Page
        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertTrue(productsPage.isInAllProducts(), "Failed to load page");

        // Click view products
        productsPage.clickViewProduct();

        // Verify 'Write Your Review' is visible
        SingleProductViewPage singleProductViewPage = new SingleProductViewPage(driver);
        Assert.assertTrue(singleProductViewPage.viewReview(), "No place to review");

        // Write review
        singleProductViewPage.enterName("Asanthi");
        singleProductViewPage.enterEmail("asanthi@gmail.com");
        singleProductViewPage.enterMessage("Test");

        // Click 'Submit' button
        singleProductViewPage.clickSubmitButton();

        // Verify success message 'Thank you for your review.'
        Assert.assertTrue(singleProductViewPage.isReviewSuccessMessageVisible(), "Success message not visible!");






    }






    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
