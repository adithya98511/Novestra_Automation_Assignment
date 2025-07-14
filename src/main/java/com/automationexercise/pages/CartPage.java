package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CartPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    // Locators
    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[3]/a")
    private WebElement cartButton;

    @FindBy(xpath = "//*[@id=\"cart_items\"]/div/div[1]/ol/li[2]")
    private WebElement cartPageTitle;

    @FindBy(xpath = "//*[@id=\"do_action\"]/div[1]/div/div/a")
    private WebElement proceedToCheckoutButton;

    @FindBy(xpath = "//*[@id=\"checkoutModal\"]/div/div/div[2]/p[2]/a")
    private WebElement registerLoginButton;

    @FindBy (xpath = "//*[@id=\"checkoutModal\"]/div/div/div[3]/button")
    private WebElement stayOnCartButton;

    @FindBy(xpath = "//*[@id=\"product-2\"]/td[6]/a")
    private WebElement removeProductButton;

    @FindBy(xpath = "//*[@id=\"cart_info_table\"]/thead/tr/td[2]")
    private WebElement productDescription;

    @FindBy(xpath = "//*[@id=\"address_delivery\"]")
    private WebElement deliveryAddress;

    @FindBy(xpath = "//*[@id=\"address_invoice\"]")
    private WebElement billingAddress;

    @FindBy(xpath = "//*[@id=\"cart_info\"]/table")
    private WebElement orderReviewTable;

    @FindBy(xpath = "//*[@id=\"ordermsg\"]/textarea")
    private WebElement commentTextArea;

    @FindBy(xpath = "//*[@id=\"cart_items\"]/div/div[7]/a")
    private WebElement placeOrderButton;

    @FindBy(xpath = "//*[@id=\"payment-form\"]/div[1]/div/input")
    private WebElement nameOnCardInput;

    @FindBy(xpath = "//*[@id=\"payment-form\"]/div[2]/div/input")
    private WebElement cardNumberInput;

    @FindBy(xpath = "//*[@id=\"payment-form\"]/div[3]/div[1]/input")
    private WebElement cvcInput;

    @FindBy(xpath = "//*[@id=\"payment-form\"]/div[3]/div[2]/input")
    private WebElement expiryMonthInput;

    @FindBy(xpath = "//*[@id=\"payment-form\"]/div[3]/div[3]/input")
    private WebElement expiryYearInput;

    @FindBy(xpath = "//*[@id=\"submit\"]")
    private WebElement payAndConfirmButton;

    @FindBy(css = "div.alert-success")
    private WebElement successMessage;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    // Page Actions
    public void navigateToCart() {
        cartButton.click();
        wait.until(ExpectedConditions.visibilityOf(cartPageTitle));
    }

    public boolean isCartPageDisplayed() {
        return cartPageTitle.isDisplayed() &&
                cartPageTitle.getText().contains("Shopping Cart");
    }

    public void proceedToCheckout() {
        proceedToCheckoutButton.click();
    }

    public void clickRegisterLogin() {
        registerLoginButton.click();
    }

    public void removeProduct() {
        removeProductButton.click();
        wait.until(ExpectedConditions.invisibilityOf(productDescription));
    }

    public boolean isProductInCart() {
        try {
            return productDescription.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void enterComment(String comment) {
        commentTextArea.sendKeys(comment);
    }

    public void placeOrder() {
        placeOrderButton.click();
    }

    public boolean areAddressDetailsVisible() {
        return deliveryAddress.isDisplayed() && billingAddress.isDisplayed();
    }

    public boolean isOrderReviewVisible() {
        return orderReviewTable.isDisplayed();
    }

    public void enterPaymentDetails(String name, String cardNumber, String cvc, String month, String year) {
        nameOnCardInput.sendKeys(name);
        cardNumberInput.sendKeys(cardNumber);
        cvcInput.sendKeys(cvc);
        expiryMonthInput.sendKeys(month);
        expiryYearInput.sendKeys(year);
    }

    public void payAndConfirmOrder() {
        payAndConfirmButton.click();
    }

    public boolean isOrderSuccess() {
        return wait.until(ExpectedConditions.visibilityOf(successMessage)).isDisplayed() &&
                successMessage.getText().contains("Your order has been placed successfully!");
    }

    // Helper method to wait for page load
    private void waitForPageLoad() {
        wait.until(driver -> {
            String state = (String) ((org.openqa.selenium.JavascriptExecutor) driver)
                    .executeScript("return document.readyState");
            return state.equals("complete");
        });
    }
}