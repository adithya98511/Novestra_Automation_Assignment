package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreatedPage extends BasePage {

    @FindBy(css = "h2[data-qa='account-created']")
    private WebElement accountCreatedMessage;

    @FindBy(css = "a[data-qa='continue-button']")
    private WebElement continueButton;

    public AccountCreatedPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isAccountCreatedMessageVisible() {
        return isElementVisible(accountCreatedMessage);
    }

    public String getAccountCreatedMessage() {
        return getElementText(accountCreatedMessage);
    }

    public HomePage clickContinueButton() {
        waitAndClick(continueButton);
        return new HomePage(driver);
    }
}