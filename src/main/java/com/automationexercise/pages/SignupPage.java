package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignupPage extends BasePage {

    public SignupPage(WebDriver driver) {
        super(driver);
    }

    // Locator for 'Enter Account Information' heading
    private By accountInfoHeading = By.xpath("//h2[text()='Enter Account Information']");

    // Locator for the 'Title' radio buttons
    private By mrRadioButton = By.id("id_gender1");
    private By mrsRadioButton = By.id("id_gender2");

    // Locators for the 'Name' and 'Email' fields
    private By nameField = By.id("name");
    private By emailField = By.id("email");

    // Locator for the 'Password' field
    private By passwordField = By.id("password");

    // Locators for the 'Date of Birth' select fields
    private By dayDropdown = By.id("days");
    private By monthDropdown = By.id("months");
    private By yearDropdown = By.id("years");

    // Locator for the 'Newsletter' checkbox
    private By newsletterCheckbox = By.id("newsletter");

    // Locator for the 'Special offers' checkbox
    private By specialOffersCheckbox = By.id("optin");

    // Locators for Address Information fields
    private By firstNameField = By.id("first_name");
    private By lastNameField = By.id("last_name");
    private By companyField = By.id("company");
    private By address1Field = By.id("address1");
    private By address2Field = By.id("address2");
    private By countryDropdown = By.id("country");
    private By stateField = By.id("state");
    private By cityField = By.id("city");
    private By zipcodeField = By.id("zipcode");
    private By mobileNumberField = By.id("mobile_number");

    // Locator for 'Create Account' button
    private By createAccountButton = By.xpath("//button[@data-qa='create-account']");

    // Locator for error message when email already exists
    private By errorMessage = By.xpath("//p[contains(text(),'Email Address already exist!')]");


    // Check if the 'Enter Account Information' heading is visible
    public boolean isAccountInfoHeadingVisible() {
        return driver.findElement(accountInfoHeading).isDisplayed();
    }

    // Method to get the 'Enter Account Information' heading
    public By getAccountInfoHeading() {
        return accountInfoHeading;
    }

    // Method to fill in the 'Name' field
    public void enterName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    // Method to fill in the 'Email' field
    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    // Method to fill in the 'Password' field
    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    // Method to select the day from the Date of Birth dropdown
    public void selectDay(String day) {
        driver.findElement(dayDropdown).sendKeys(day);
    }

    // Method to select the month from the Date of Birth dropdown
    public void selectMonth(String month) {
        driver.findElement(monthDropdown).sendKeys(month);
    }

    // Method to select the year from the Date of Birth dropdown
    public void selectYear(String year) {
        driver.findElement(yearDropdown).sendKeys(year);
    }

    // Method to check the 'Newsletter' checkbox
    public void checkNewsletter() {
        driver.findElement(newsletterCheckbox).click();
    }

    // Method to check the 'Special offers' checkbox
    public void checkSpecialOffers() {
        driver.findElement(specialOffersCheckbox).click();
    }

    // Method to fill in the address fields
    public void fillAddressInfo(String firstName, String lastName, String company, String address1, String address2, String country, String state, String city, String zipcode, String mobile) {
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(companyField).sendKeys(company);
        driver.findElement(address1Field).sendKeys(address1);
        driver.findElement(address2Field).sendKeys(address2);
        driver.findElement(countryDropdown).sendKeys(country);
        driver.findElement(stateField).sendKeys(state);
        driver.findElement(cityField).sendKeys(city);
        driver.findElement(zipcodeField).sendKeys(zipcode);
        driver.findElement(mobileNumberField).sendKeys(mobile);
    }

    // Method to get the error message displayed when email already exists
    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }

    // Methods for Title selection
    public void selectMrTitle() {
        driver.findElement(mrRadioButton).click();
    }

    public void selectMrsTitle() {
        driver.findElement(mrsRadioButton).click();
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
        driver.findElement(specialOffersCheckbox).click();
    }

    // Fill the address details
//    public void fillAddressDetails(String firstName, String lastName, String company, String address1, String address2, String country, String state, String city, String zipcode, String mobile) {
//        driver.findElement(firstNameField).sendKeys(firstName);
//        driver.findElement(lastNameField).sendKeys(lastName);
//        driver.findElement(companyField).sendKeys(company);
//        driver.findElement(address1Field).sendKeys(address1);
//        driver.findElement(address2Field).sendKeys(address2);
//        driver.findElement(countryField).sendKeys(country);
//        driver.findElement(stateField).sendKeys(state);
//        driver.findElement(cityField).sendKeys(city);
//        driver.findElement(zipcodeField).sendKeys(zipcode);
//        driver.findElement(mobileField).sendKeys(mobile);
//    }

    // Click the 'Create Account' button
    public void clickCreateAccountButton() {
        driver.findElement(createAccountButton).click();
    }
}