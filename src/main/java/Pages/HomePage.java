package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;

    }

    By Products = By.xpath("(//a[@href='/products'])[1]");
    By Cart = By.xpath("//a[normalize-space()='Cart']");
    private By recommendedItems = By.xpath("//h2[normalize-space()='recommended items']");
    By addToCart = By.xpath("//div[@class='item active']//div[1]//div[1]//div[1]//div[1]//a[1]");
    By viewProduct = By.xpath("//u[normalize-space()='View Cart']");




    // Click on 'Products' button
    public void selectProductsBtn(){
        driver.findElement(Products).click();
    }

    // Click carts button
    public void selectCartBtn(){
        driver.findElement(Cart).click();
    }

    public void scroll() {
        WebElement element = driver.findElement(recommendedItems);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // Scroll to "Write Your Review" section
    public void scrollToRecommendedItems() {
        WebElement element = driver.findElement(recommendedItems);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // Check if it's visible after scrolling
    public boolean isRecommendedItemsVisible() {
        WebElement element = driver.findElement(recommendedItems);
        return element.isDisplayed();
    }

    public void clickAddToCart(){
        driver.findElement(addToCart).click();
    }

    // Click view product
    public void clickViewProduct(){
        driver.findElement(viewProduct).click();
    }


}
