import Pages.HomePage;
import Pages.CartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_11 {
    WebDriver driver;
    HomePage homePage;
    CartPage cartPage;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/User/OneDrive/Desktop/chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.automationexercise.com/");

        cartPage = new CartPage(driver);
        homePage = new HomePage(driver);
    }

    @Test
    public void verifySubscriptionOnCartPage() {
        // Click Cart from navbar
        driver.findElement(By.xpath("//i[@class='fa fa-shopping-cart']")).click();

        // Scroll to bottom
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        // Verify 'SUBSCRIPTION' is visible
        Assert.assertTrue(cartPage.isSubscriptionVisible(), "'SUBSCRIPTION' text not visible on Cart page");

        // Enter email and click subscribe
        cartPage.enterEmail("testemail@example.com");
        cartPage.clickSubscribeButton();

        // Verify success message
        Assert.assertTrue(cartPage.isSuccessMessageVisible(), "Success message not displayed!");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
