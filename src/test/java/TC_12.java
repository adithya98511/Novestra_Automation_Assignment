import Pages.CartPage;
import Pages.HomePage;
import Pages. ProductsPage;
import Pages.ProductsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_12 {
    WebDriver driver;
    HomePage homePage;
    ProductsPage productPage;
    CartPage cartPage;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/User/OneDrive/Desktop/chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.automationexercise.com/");

        homePage = new HomePage(driver);
        productPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
    }

    @Test
    public void verifyAddProductsToCart() {
        // Navigate to Products
        productPage.goToProductsPage();

        // Adding first product, then continue shopping
        productPage.addFirstProductToCart();
//        productPage.clickContinueShopping();

        // Adding second product, then view cart
        productPage.addSecondProductToCart();
        productPage.clickViewCart();

        //Verifying both products are added
        Assert.assertTrue(cartPage.areTwoProductsPresent(), " Cart does not contain two products.");
        System.out.println("✅ Successfully added two products to cart.");
    }
}
