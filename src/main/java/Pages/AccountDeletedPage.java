package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountDeletedPage extends BasePage {

    @FindBy(css = "h2[data-qa='account-deleted']")
    private WebElement accountDeletedMessage;

    @FindBy(css = "a[data-qa='continue-button']")
    private WebElement continueButton;

    public AccountDeletedPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isAccountDeletedMessageVisible() {
        return isElementVisible(accountDeletedMessage);
    }

    public String getAccountDeletedMessage() {
        return getElementText(accountDeletedMessage);
    }

    public HomePage clickContinueButton() {
        waitAndClick(continueButton);
        return new HomePage(driver);
    }
}
