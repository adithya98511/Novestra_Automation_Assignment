package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage {
    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;

    }

    By cartDetails = By.cssSelector(".cart_info");


    // Verify added product is in the cart
    public boolean isProductVisibleInCart(String expectedProduct) {
        List<WebElement> cartItems = driver.findElements(cartDetails);

        for (WebElement item : cartItems) {
            String cartProductName = driver.findElement(By.cssSelector(".cart_description a")).getText();
            System.out.println(cartProductName);

            if (cartProductName.equals(expectedProduct)) {
                return true;
            }
        }
        return false;


    }

    // Go to login
    public void navigateLogin() {
        driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();
    }

}


