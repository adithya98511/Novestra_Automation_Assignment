package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(name = "name")
    private WebElement signupNameField;

    @FindBy(css = "input[data-qa='signup-email']")
    private WebElement signupEmailField;

    @FindBy(css = "button[data-qa='signup-button']")
    private WebElement signupButton;

    @FindBy(css = "input[data-qa='login-email']")
    private WebElement loginEmailField;

    @FindBy(css = "input[data-qa='login-password']")
    private WebElement loginPasswordField;

    @FindBy(css = "button[data-qa='login-button']")
    private WebElement loginButton;

    @FindBy(css = "a[href='/login']")
    private WebElement registerLoginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public SignupPage fillSignupForm(String name, String email) {
        waitAndSendKeys(signupNameField, name);
        waitAndSendKeys(signupEmailField, email);
        waitAndClick(signupButton);
        return new SignupPage(driver);
    }

    public HomePage login(String email, String password) {
        waitAndSendKeys(loginEmailField, email);
        waitAndSendKeys(loginPasswordField, password);
        waitAndClick(loginButton);
        return new HomePage(driver);
    }

    public boolean isRegisterLoginButtonVisible() {
        return isElementVisible(registerLoginButton);
    }
}