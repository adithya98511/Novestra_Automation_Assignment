package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage extends BasePage {

    @FindBy(css = "input[name='name_on_card']")
    private WebElement nameOnCardField;

    @FindBy(css = "input[name='card_number']")
    private WebElement cardNumberField;

    @FindBy(css = "input[name='cvc']")
    private WebElement cvcField;

    @FindBy(css = "input[name='expiry_month']")
    private WebElement expiryMonthField;

    @FindBy(css = "input[name='expiry_year']")
    private WebElement expiryYearField;

    @FindBy(css = "button[data-qa='pay-button']")
    private WebElement payAndConfirmButton;

    public PaymentPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public OrderSuccessPage enterPaymentDetailsAndConfirm(String nameOnCard, String cardNumber,
                                                          String cvc, String expiryMonth, String expiryYear) {
        waitAndSendKeys(nameOnCardField, nameOnCard);
        waitAndSendKeys(cardNumberField, cardNumber);
        waitAndSendKeys(cvcField, cvc);
        waitAndSendKeys(expiryMonthField, expiryMonth);
        waitAndSendKeys(expiryYearField, expiryYear);
        waitAndClick(payAndConfirmButton);
        return new OrderSuccessPage(driver);
    }
}
