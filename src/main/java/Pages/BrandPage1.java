package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BrandPage1 {

    WebDriver driver;

    public BrandPage1(WebDriver driver) {
        this.driver = driver;

    }

    By BrandName1 = By.xpath("//h2[normalize-space()='Brand - Polo Products']");
    // Locator for all product name elements
    By productTitles = By.cssSelector(".productinfo.text-center p");
    By Brands = By.xpath("//h2[normalize-space()='Brands']");
    By BrandType = By.cssSelector("a[href='/brand_products/H&M']");


    //Verify that user is navigated to brand page
    public String verifyBrandName(){
        return driver.findElement(BrandName1).getText();

    }

    public List<String> getVisibleProductNames() {
        return driver.findElements(productTitles).stream()
                .filter(WebElement::isDisplayed)
                .map(WebElement::getText)
                .toList();
    }


    // Verify that Brands are visible on left side bar
    public String verifyBrands(){
        return driver.findElement(Brands).getText();

    }


    //  Click on any brand name
    public void selectBrand(){
        driver.findElement(BrandType).click();
    }









//    public List<WebElement> getAllProductTitles() {
//        return driver.findElements(productTitles);
//    }

//    // Check if a specific product is visible by name
//    public void isProductVisible() {
//        List<WebElement> products = getAllProductTitles();
//        System.out.println(products);
//        for (WebElement product : products) {
//            if (product.getText().equalsIgnoreCase(productName)) {
//                return product.isDisplayed();
//            }
//        }
//        return false;
//    }

//    // Get visible product names as List<String>
//    public List<String> getVisibleProductNames() {
//        return driver.findElements(productTitles).stream()
//                .filter(WebElement::isDisplayed)
//                .map(WebElement::getText)
//                .toList();
//    }







//    // Method: Get visible product names
//    public List<String> getVisibleProductNames() {
//        return driver.findElements(productNames).stream()
//                .filter(WebElement::isDisplayed)
//                .map(WebElement::getText)
//                .toList();
//    }
//
//    // Method: Check if a specific product is visible
//    public boolean isProductVisible(String productName) {
//        return getVisibleProductNames().stream()
//                .anyMatch(name -> name.equalsIgnoreCase(productName));
//    }






//    //Brand products are displayed
//    // Get all product titles
//    By productTitles = By.cssSelector(".product .product-title");
//
//
}
