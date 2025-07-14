package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PaymentsDonePage {
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

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div/div/a")
    private WebElement continueButton;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div/a")
    private WebElement downloadInvoice;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div/h2/b")
    private WebElement orderPlaced;

    public PaymentsDonePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
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