package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountCreatedPage extends BasePage {

    public AccountCreatedPage(WebDriver driver) {
        super(driver);
    }

    private By accountCreatedMessage = By.xpath("//h2[text()='Account Created!']");
    private By continueButton = By.xpath("//button[text()='Continue']");

    // Verify the 'Account Created!' message is visible
    public boolean isAccountCreatedMessageVisible() {
        return driver.findElement(accountCreatedMessage).isDisplayed();
    }

    // Click the 'Continue' button
    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }
}
