package TestCases;

import Pages.CartPage;
import Pages.HomePage;
import Pages.ProductsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_022{
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

        // Scroll to Recommended Items
        homePage.scrollToRecommendedItems();

        Assert.assertTrue(homePage.isRecommendedItemsVisible(), "Recommended Items is not visible");

        homePage.clickAddToCart();
        homePage.clickViewProduct();

        CartPage cartPage = new CartPage(driver);
        // Verify added product is visible in cart

        Assert.assertTrue(cartPage.isProductVisibleInCart("Stylish Dress"),"No such item added to cart");







    }






    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
