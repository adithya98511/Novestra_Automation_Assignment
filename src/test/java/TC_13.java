import Pages.HomePage;
import Pages.CartPage;
import Pages.ProductsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_13 {
    WebDriver driver;
    HomePage homePage;
    CartPage cartPage;
    ProductsPage productsPage;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/User/OneDrive/Desktop/chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        cartPage = new CartPage(driver);
        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);
        productsPage = new ProductsPage(driver);

    }

    @Test
    public void verifyProductQuantityInCart() {
        //Verify home page
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, "https://automationexercise.com/", "Home page not loaded correctly");

        //Click 'View Product' for first product
        WebElement viewProductBtn = driver.findElement(By.xpath("(//a[contains(text(),'View Product')])[1]"));
        viewProductBtn.click();

        //Verify product detail is opened
        WebElement productInfo = driver.findElement(By.xpath("//div[@class='product-information']"));
        Assert.assertTrue(productInfo.isDisplayed(), "Product detail page did not open");

        //Increase quantity to 4
        WebElement quantityInput = driver.findElement(By.xpath("//input[@id='quantity']"));
        quantityInput.clear();
        quantityInput.sendKeys("4");

        //Click 'Add to cart'
        WebElement addToCartBtn = driver.findElement(By.xpath("//button[contains(text(),'Add to cart')]"));
        addToCartBtn.click();

        //Click 'View Cart' button
        WebElement viewCartBtn = driver.findElement(By.xpath("//u[contains(text(),'View Cart')]"));
        viewCartBtn.click();

        // Verify quantity in cart is 4
        WebElement quantity = driver.findElement(By.xpath("//tr[@id='product-1']//td[@class='cart_quantity']//button"));
        String actualQty = quantity.getText().trim();
        Assert.assertEquals(actualQty, "4", "Product quantity in cart is not as expected");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
