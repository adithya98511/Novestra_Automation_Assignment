package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BrandPage2 {
    WebDriver driver;

    public BrandPage2(WebDriver driver) {
        this.driver = driver;

    }

    By BrandName2 = By.xpath("//h2[normalize-space()='Brand - Polo Products']");
    // Locator for all product name elements
    By productTitlesBrand2 = By.cssSelector(".productinfo.text-center p");


    // Verify that user is navigated to that brand page and can see products
    public List<String> getVisibleProductNames2() {
        return driver.findElements(productTitlesBrand2).stream()
                .filter(WebElement::isDisplayed)
                .map(WebElement::getText)
                .toList();
    }



}
