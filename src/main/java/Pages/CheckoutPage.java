package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends BasePage {

    @FindBy(css = ".checkout-information")
    private WebElement addressDetails;

    @FindBy(css = ".review-order")
    private WebElement reviewOrder;

    @FindBy(css = "textarea[name='message']")
    private WebElement commentTextArea;

    @FindBy(css = "a[href='/payment']")
    private WebElement placeOrderButton;

    @FindBy(css = "a[href='/login']")
    private WebElement registerLoginButton;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean areAddressDetailsVisible() {
        return isElementVisible(addressDetails);
    }

    public boolean isReviewOrderVisible() {
        return isElementVisible(reviewOrder);
    }

    public PaymentPage enterCommentAndPlaceOrder(String comment) {
        waitAndSendKeys(commentTextArea, comment);
        waitAndClick(placeOrderButton);
        return new PaymentPage(driver);
    }

    public LoginPage clickRegisterLoginButton() {
        waitAndClick(registerLoginButton);
        return new LoginPage(driver);
    }
}
