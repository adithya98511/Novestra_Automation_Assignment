package TestCases;

import Pages.BrandPage1;
import Pages.BrandPage2;
import Pages.HomePage;
import Pages.ProductsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TC_019 {
    WebDriver driver;

    @BeforeTest
    public void OpenWebPage() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://automationexercise.com/");
    }

    @Test
    public void Test(){

        // Click on 'Products' button
        HomePage homePage = new HomePage(driver);
        homePage.selectProductsBtn();


        // Verify that Brands are visible on left side bar
        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertEquals(productsPage.verifyBrands(), "BRANDS", "Brands text not visible or incorrect");


        productsPage.selectBrand();

        // Verify that user is navigated to brand page and brand products are displayed
        BrandPage1 brandPage1 = new BrandPage1(driver);
        List<String> visibleProducts = brandPage1.getVisibleProductNames();

        if (visibleProducts.isEmpty()) {
            System.out.println("No products are visible on the page.");
        } else {
            System.out.println("Products available on the page:");
            visibleProducts.forEach(product -> System.out.println(" - " + product));
        }


        // On left side bar, click on any other brand link
        Assert.assertEquals(brandPage1.verifyBrands(), "BRANDS", "Brands text not visible or incorrect");

        brandPage1.selectBrand();

        // Verify that user is navigated to that brand page and can see products
        BrandPage2 brandPage2 = new BrandPage2(driver);
        List<String> visibleProductsBrand2 = brandPage2.getVisibleProductNames2();

        if (visibleProducts.isEmpty()) {
            System.out.println("No products are visible on the page.");
        } else {
            System.out.println("Products available on the page:");
            visibleProducts.forEach(product -> System.out.println(" - " + product));
        }










//        Assert.assertEquals(brandPage1.verifyBrandName(), "BRAND - POLO PRODUCTS", "User did not direct to Polo Brand Page");
//
//        brandPage1.isProductVisible();
//        Assert.assertTrue(brandPage1.isProductVisible("Blue Top"), "'Product A' is not visible on the page");
//        Assert.assertTrue(brandPage1.isProductVisible("Fancy Green Top"), "'Product B' is not visible on the page");
    }







    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
