import Pages.CartPage;
import Pages.HomePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TC_10 {
    WebDriver driver;
    HomePage homePage;
    CartPage cartPage;

    @BeforeClass
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:/Users/User/OneDrive/Desktop/chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.automationexercise.com/");

        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);


    }

    @Test
    public void testHomePageNavigation() {
        homePage.clickNavBarHomeBtn();

        //scroll to footer
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

        // Verify that 'SUBSCRIPTION' is visible
        Assert.assertTrue(homePage.isSubscriptionVisible(), "'SUBSCRIPTION' text is not visible");

        // Enter email address and click arrow button
        homePage.enterEmail("testemail@example.com");
        homePage.clickSubscribeButton();

        // Verify success message is visible
        Assert.assertTrue(homePage.isSuccessMessageVisible(), "Success message not displayed!");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}

