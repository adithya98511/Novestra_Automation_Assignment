package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage extends BasePage {

    @FindBy(id = "id_gender1")
    private WebElement titleMr;

    @FindBy(id = "id_gender2")
    private WebElement titleMrs;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "days")
    private WebElement dayDropdown;

    @FindBy(id = "months")
    private WebElement monthDropdown;

    @FindBy(id = "years")
    private WebElement yearDropdown;

    @FindBy(id = "newsletter")
    private WebElement newsletterCheckbox;

    @FindBy(id = "optin")
    private WebElement specialOffersCheckbox;

    @FindBy(id = "first_name")
    private WebElement firstNameField;

    @FindBy(id = "last_name")
    private WebElement lastNameField;

    @FindBy(id = "company")
    private WebElement companyField;

    @FindBy(id = "address1")
    private WebElement address1Field;

    @FindBy(id = "address2")
    private WebElement address2Field;

    @FindBy(id = "country")
    private WebElement countryDropdown;

    @FindBy(id = "state")
    private WebElement stateField;

    @FindBy(id = "city")
    private WebElement cityField;

    @FindBy(id = "zipcode")
    private WebElement zipcodeField;

    @FindBy(id = "mobile_number")
    private WebElement mobileNumberField;

    @FindBy(css = "button[data-qa='create-account']")
    private WebElement createAccountButton;

    public SignupPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public AccountCreatedPage fillSignupDetails(String password, String firstName, String lastName,
                                                String company, String address1, String address2,
                                                String country, String state, String city,
                                                String zipcode, String mobileNumber) {
        waitAndClick(titleMr);
        waitAndSendKeys(passwordField, password);

        Select daySelect = new Select(dayDropdown);
        daySelect.selectByValue("15");

        Select monthSelect = new Select(monthDropdown);
        monthSelect.selectByValue("5");

        Select yearSelect = new Select(yearDropdown);
        yearSelect.selectByValue("1990");

        waitAndClick(newsletterCheckbox);
        waitAndClick(specialOffersCheckbox);

        waitAndSendKeys(firstNameField, firstName);
        waitAndSendKeys(lastNameField, lastName);
        waitAndSendKeys(companyField, company);
        waitAndSendKeys(address1Field, address1);
        waitAndSendKeys(address2Field, address2);

        Select countrySelect = new Select(countryDropdown);
        countrySelect.selectByVisibleText(country);

        waitAndSendKeys(stateField, state);
        waitAndSendKeys(cityField, city);
        waitAndSendKeys(zipcodeField, zipcode);
        waitAndSendKeys(mobileNumberField, mobileNumber);

        waitAndClick(createAccountButton);
        return new AccountCreatedPage(driver);
    }
}