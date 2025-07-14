package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignupPage extends BasePage {

    public SignupPage(WebDriver driver) {
        super(driver);
    }

    private By accountInfoHeading = By.xpath("//h2[text()='Enter Account Information']");
    private By passwordField = By.id("password");
    private By dayDropdown = By.id("days");
    private By monthDropdown = By.id("months");
    private By yearDropdown = By.id("years");
    private By newsletterCheckbox = By.id("newsletter");
    private By offersCheckbox = By.id("optin");
    private By firstNameField = By.id("first_name");
    private By lastNameField = By.id("last_name");
    private By companyField = By.id("company");
    private By address1Field = By.id("address1");
    private By address2Field = By.id("address2");
    private By countryField = By.id("country");
    private By stateField = By.id("state");
    private By cityField = By.id("city");
    private By zipcodeField = By.id("zipcode");
    private By mobileField = By.id("mobile_number");
    private By createAccountButton = By.xpath("//button[text()='Create Account']");

    // Check if the 'Enter Account Information' heading is visible
    public boolean isAccountInfoHeadingVisible() {
        return driver.findElement(accountInfoHeading).isDisplayed();
    }

    // Fill the account details
    public void fillAccountDetails(String password, String day, String month, String year) {
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(dayDropdown).sendKeys(day);
        driver.findElement(monthDropdown).sendKeys(month);
        driver.findElement(yearDropdown).sendKeys(year);
    }

    // Select checkboxes for newsletter and offers
    public void selectCheckboxes() {
        driver.findElement(newsletterCheckbox).click();
        driver.findElement(offersCheckbox).click();
    }

    // Fill the address details
    public void fillAddressDetails(String firstName, String lastName, String company, String address1, String address2, String country, String state, String city, String zipcode, String mobile) {
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(companyField).sendKeys(company);
        driver.findElement(address1Field).sendKeys(address1);
        driver.findElement(address2Field).sendKeys(address2);
        driver.findElement(countryField).sendKeys(country);
        driver.findElement(stateField).sendKeys(state);
        driver.findElement(cityField).sendKeys(city);
        driver.findElement(zipcodeField).sendKeys(zipcode);
        driver.findElement(mobileField).sendKeys(mobile);
    }

    // Click the 'Create Account' button
    public void clickCreateAccountButton() {
        driver.findElement(createAccountButton).click();
    }
}