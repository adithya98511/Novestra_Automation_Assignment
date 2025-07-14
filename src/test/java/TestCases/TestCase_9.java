package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.time.Duration;

public class TestCase_9 {

    public static void main(String[] args) {
        // 1. Launch browser
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Public\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try {
            // 2. Navigate to URL
            driver.get("https://automationexercise.com");

            // 3. Verify that home page is visible successfully
            WebElement homeSlider = driver.findElement(By.id("slider")); // or any reliable element
            if (homeSlider.isDisplayed()) {
                System.out.println("Home page is visible.");
            } else {
                System.out.println("Home page is NOT visible.");
            }

            // 4. Click on 'Products' button
            WebElement productsBtn = driver.findElement(By.xpath("//a[@href='/products']"));
            productsBtn.click();

            // 5. Verify user is navigated to ALL PRODUCTS page successfully
            WebElement allProductsHeader = driver.findElement(By.xpath("//h2[contains(text(),'All Products')]"));
            if (allProductsHeader.isDisplayed()) {
                System.out.println("Navigated to ALL PRODUCTS page.");
            } else {
                System.out.println("Failed to navigate to ALL PRODUCTS page.");
            }

            // 6. Enter product name in search input and click search button
            WebElement searchInput = driver.findElement(By.id("search_product"));
            WebElement searchButton = driver.findElement(By.id("submit_search"));

            searchInput.sendKeys("T-Shirt"); // You can change keyword
            searchButton.click();

            // 7. Verify 'SEARCHED PRODUCTS' is visible
            WebElement searchedProductsText = driver.findElement(By.xpath("//h2[contains(text(),'Searched Products')]"));
            if (searchedProductsText.isDisplayed()) {
                System.out.println("'SEARCHED PRODUCTS' is visible.");
            } else {
                System.out.println("'SEARCHED PRODUCTS' is NOT visible.");
            }

            // 8. Verify all the products related to search are visible
            List<WebElement> searchedItems = driver.findElements(By.xpath("//div[@class='features_items']/div[contains(@class,'col-sm-4')]"));
            if (!searchedItems.isEmpty()) {
                System.out.println(" " + searchedItems.size() + " searched product(s) visible:");
                for (WebElement product : searchedItems) {
                    // Extract only the <p> element inside the product card (product name)
                    WebElement nameElement = product.findElement(By.xpath(".//div[@class='productinfo text-center']/p"));
                    System.out.println("     " + nameElement.getText());
                }
            } else {
                System.out.println(" No searched products found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Optional: close the browser after test
            driver.quit();
        }
    }
}
