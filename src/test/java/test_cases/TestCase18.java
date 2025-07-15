package test_cases;

import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.*;

public class TestCase18 extends BaseTest {

    @Test
    public void testViewCategoryProducts() {
        // 1. Launch browser and navigate to URL - done in BaseTest

        // 2. Verify home page is visible
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isHomePageVisible(), "Home page should be visible");

        // 3. Verify categories are visible on left sidebar
        Assert.assertTrue(homePage.areCategoriesVisible(), "Categories should be visible on left sidebar");

        // 4. Click on 'Women' category
        homePage.clickWomenCategory();

        // 5. Click on any category link under 'Women' category (e.g., Dress)
        CategoryPage categoryPage = homePage.clickWomenSubCategory("Dress");

        // 6. Verify category page is displayed and confirm text
        Assert.assertTrue(categoryPage.isCategoryPageDisplayed(), "Category page should be displayed");
        String categoryTitle = categoryPage.getCategoryTitle();
        Assert.assertTrue(categoryTitle.contains("WOMEN") && categoryTitle.contains("DRESS"),
                "Category title should contain 'WOMEN - DRESS PRODUCTS'");

        // 7. Navigate back to home page to access Men category
        driver.navigate().back();
        driver.navigate().back();

        // 8. On left sidebar, click on any sub-category link of 'Men' category
        CategoryPage menCategoryPage = homePage.clickMenSubCategory("Tshirts");

        // 9. Verify user is navigated to that category page
        Assert.assertTrue(menCategoryPage.isCategoryPageDisplayed(), "Men category page should be displayed");
        String menCategoryTitle = menCategoryPage.getCategoryTitle();
        Assert.assertTrue(menCategoryTitle.contains("MEN") && menCategoryTitle.contains("TSHIRTS"),
                "Men category title should contain 'MEN - TSHIRTS PRODUCTS'");
    }