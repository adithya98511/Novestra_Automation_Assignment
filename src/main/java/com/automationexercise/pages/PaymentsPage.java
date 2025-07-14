package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PaymentsPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    // Locators
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

    public PaymentsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    public PaymentsPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    // Page Actions


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