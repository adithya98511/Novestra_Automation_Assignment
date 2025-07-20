package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductsPage {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    By productsNavBtn = By.xpath("//a[@href='/products']");
    By firstProductCard = By.xpath("(//div[@class='col-sm-9 padding-right']//div[2]//div[1]//div[1]//div[2]");
    By secondProductCard = By.xpath("(//div[3]//div[1]//div[1]//div[2]");
    By addToCart1 = By.xpath("(//div[@class='col-sm-9 padding-right']//div[2]//div[1]//div[1]//div[2]//div[1]//a[1]");
    By addToCart2 = By.xpath("(//div[3]//div[1]//div[1]//div[2]//div[1]//a[1]");
    By viewCartBtn = By.xpath("//i[@class='fa fa-shopping-cart']");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
    }

    public void goToProductsPage() {
        wait.until(ExpectedConditions.elementToBeClickable(productsNavBtn)).click();
    }

    public void addFirstProductToCart() {
        WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(firstProductCard));
        actions.moveToElement(product).perform();
        wait.until(ExpectedConditions.elementToBeClickable(addToCart1)).click();
    }

    public void addSecondProductToCart() {
        WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(secondProductCard));
        actions.moveToElement(product).perform();
        wait.until(ExpectedConditions.elementToBeClickable(addToCart2)).click();
    }

    public void clickViewCart() {
        wait.until(ExpectedConditions.elementToBeClickable(viewCartBtn)).click();
    }
}
