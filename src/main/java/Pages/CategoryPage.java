package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoryPage extends BasePage {

    @FindBy(css = ".title.text-center")
    private WebElement categoryTitle;

    @FindBy(css = ".features_items")
    private WebElement productsSection;

    public CategoryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isCategoryPageDisplayed() {
        return isElementVisible(categoryTitle);
    }

    public String getCategoryTitle() {
        return getElementText(categoryTitle);
    }

    public boolean areProductsVisible() {
        return isElementVisible(productsSection);
    }
}