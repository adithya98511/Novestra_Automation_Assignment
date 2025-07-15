package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountCreatedPage extends BasePage {

    public AccountCreatedPage(WebDriver driver) {
        super(driver);
    }

    private By accountCreatedMessage = By.xpath("(//b[normalize-space()='Account Created!'])[1]");
    private By continueButton = By.xpath("(//a[normalize-space()='Continue'])[1]");

    // Verify the 'Account Created!' message is visible
    public boolean isAccountCreatedMessageVisible() {
        return driver.findElement(accountCreatedMessage).isDisplayed();
    }

    // Click the 'Continue' button
    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }
}
