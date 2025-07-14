package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage {
    WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;

    }

    By Brands = By.xpath("//h2[normalize-space()='Brands']");
    By BrandType = By.cssSelector("a[href='/brand_products/Polo']");
    By AllProducts = By.xpath("//h2[normalize-space()='All Products']");
    By search = By.xpath("//input[@id='search_product']");
    By getSearch = By.xpath("//button[@id='submit_search']");
    By getSearchedProducts = By.xpath("//h2[normalize-space()='Searched Products']");
    By searchResultProducts = By.cssSelector(".productinfo.text-center");
    By addToCart = By.xpath("//div[@class='productinfo text-center']//a[@class='btn btn-default add-to-cart'][normalize-space()='Add to cart']");
    By viewCartLink = By.xpath("//u[normalize-space()='View Cart']");
    By viewProduct = By.xpath("//div[4]//div[1]//div[2]//ul[1]//li[1]//a[1]");





    // Verify that Brands are visible on left side bar
    public String verifyBrands(){
        return driver.findElement(Brands).getText();

    }


    //  Click on any brand name
    public void selectBrand(){
        driver.findElement(BrandType).click();
    }

    // Verify user is navigated to ALL PRODUCTS page successfully
    public void VerifyAllProductsURL(){
        driver.get("https://automationexercise.com/products");
    }

    // Verify user is navigated to ALL PRODUCTS page successfully
    public String verifyAllProductsText(){
        return driver.findElement(AllProducts).getText();
    }

    public boolean isInAllProducts(){
        return driver.getCurrentUrl().contains("products");
    }

    // Enter product name in search input
    public void searchProduct(String productName){
        driver.findElement(search).sendKeys(productName);
    }

    // Enter search button
    public void clickSearch(){
        driver.findElement(getSearch).click();
    }


    // Verify 'SEARCHED PRODUCTS' is visible
    public String getSearchedProductsText(){
        return driver.findElement(getSearchedProducts).getText();
    }

    // Method to return all product block elements
    public List<WebElement> getAllProductBlocks() {
        return driver.findElements(searchResultProducts);
    }


    // Main method: verify that all products shown match the search and have all required info
    public boolean isAllProductDetailsDisplayed(String keyword) {
        List<WebElement> products = getAllProductBlocks();

        for (WebElement product : products) {
            // ✅ Check product name contains keyword
            WebElement name = product.findElement(By.tagName("p"));
            String productName = name.getText();
            System.out.println("Name: " + productName);
            if (!name.isDisplayed() || !name.getText().toLowerCase().contains(keyword.toLowerCase())) {
                return false; // product name missing or doesn't match search
            }

            // ✅ Check product price is visible
            WebElement price = product.findElement(By.tagName("h2"));
            String productPrice = price.getText();
            System.out.println("Price: " + productPrice);
            if (!price.isDisplayed()) {
                return false; // price not shown
            }

//            // Check image is visible
//            WebElement img = product.findElement(By.tagName("img"));
//            if (!img.isDisplayed()) {
//                return false; // image not shown
//            }
//
//            // Check 'Add to cart' button is visible
//            WebElement cartBtn = product.findElement(By.cssSelector("a.add-to-cart"));
//            if (!cartBtn.isDisplayed()) {
//                return false; // add to cart button missing
//            }
        }

        // All checks passed for all products
        return true;
    }

    public void clickAddToCart(){
        driver.findElement(addToCart).click();
    }

    public void clickViewCart(){
        driver.findElement(viewCartLink).click();
    }

    // Click view product
    public void clickViewProduct(){
        driver.findElement(viewProduct).click();
    }



}
