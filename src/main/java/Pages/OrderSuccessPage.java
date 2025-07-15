package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderSuccessPage extends BasePage {

    @FindBy(css = ".alert-success")
    private WebElement successMessage;

    @FindBy(css = "a[href='/delete_account']")
    private WebElement deleteAccountButton;

    public OrderSuccessPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isSuccessMessageVisible() {
        return isElementVisible(successMessage);
    }

    public String getSuccessMessage() {
        return getElementText(successMessage);
    }

    public AccountDeletedPage clickDeleteAccount() {
        waitAndClick(deleteAccountButton);
        return new AccountDeletedPage(driver);
    }
}
