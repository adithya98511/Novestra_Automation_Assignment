package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeleteAccountPage extends BasePage {

    public DeleteAccountPage(WebDriver driver) {
        super(driver);
    }

    private By accountDeletedMessage = By.xpath("(//b[normalize-space()='Account Deleted!'])[1]");
    private By continueButton = By.xpath("(//a[normalize-space()='Continue'])[1]");

    // Verify the 'Account Deleted!' message is visible
    public boolean isAccountDeletedMessageVisible() {
        return driver.findElement(accountDeletedMessage).isDisplayed();
    }

    // Click the 'Continue' button after account deletion
    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }
}
