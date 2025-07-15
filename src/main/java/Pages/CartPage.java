package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import java.util.List;

public class CartPage extends BasePage {

    @FindBy(css = ".cart_info")
    private WebElement cartTable;

    @FindBy(css = "a.btn-default.check_out")
    private WebElement proceedToCheckoutButton;

    @FindBy(css = "#cart_items")
    private WebElement cartItems;

    @FindBy(css = ".cart_quantity_delete")
    private List<WebElement> deleteButtons;

    @FindBy(css = "#cart_info_table tbody tr")
    private List<WebElement> cartRows;

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isCartPageDisplayed() {
        return isElementVisible(cartTable);
    }

    public CheckoutPage clickProceedToCheckout() {
        waitAndClick(proceedToCheckoutButton);
        return new CheckoutPage(driver);
    }

    public LoginPage clickProceedToCheckoutAsGuest() {
        waitAndClick(proceedToCheckoutButton);
        return new LoginPage(driver);
    }

    public void removeProductFromCart(int productIndex) {
        if (productIndex < deleteButtons.size()) {
            waitAndClick(deleteButtons.get(productIndex));
        }
    }

    public boolean isProductRemovedFromCart(int initialCartSize) {
        return cartRows.size() < initialCartSize;
    }

    public int getCartItemsCount() {
        return cartRows.size();
    }
}