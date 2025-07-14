package TestCases;

import Pages.CartPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProductsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_020{
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

        // Click on 'Products' button
        HomePage homePage = new HomePage(driver);
        homePage.selectProductsBtn();


        ProductsPage productsPage = new ProductsPage(driver);
        // Verify user successfully directed to ALL Products (URL)
        productsPage.VerifyAllProductsURL();
        // Verify user successfully directed to ALL Products (text)
        Assert.assertEquals(productsPage.verifyAllProductsText(), "ALL PRODUCTS" , "Failed to view ALL PRODUCTS");

        // Enter product name in search input
        productsPage.searchProduct("Blue Top");

        // Click search button
        productsPage.clickSearch();

        // Verify 'SEARCHED PRODUCTS' is visible
        Assert.assertEquals(productsPage.getSearchedProductsText(), "SEARCHED PRODUCTS" , "Failed to view SEARCHED PRODUCTS");


        // Call method to check if product blocks are complete
        boolean allVisible = productsPage.isAllProductDetailsDisplayed("Blue Top");

        // Final assertion
        Assert.assertTrue(allVisible, "Some products are missing name, price, image or button.");
        System.out.println(allVisible);

        // Add to cart
        productsPage.clickAddToCart();

        // View cart
        productsPage.clickViewCart();

        // Verify added product is visible in cart
        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.isProductVisibleInCart("Blue Top"),"No such item added to cart");


        // LoginPage
        cartPage.navigateLogin();

        // User LoginPage
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setPwd("asanthi");
        loginPage.setEmail("asanthi@gmail.com");
        loginPage.clickLoginButton();

        // Navigate to homepage after login
        homePage.selectCartBtn();








    }








    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
