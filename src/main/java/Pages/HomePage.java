package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


import java.time.Duration;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;

    By Nav_HomeValidate = By.xpath("//a[normalize-space()='Home']");
    By subscriptionText = By.xpath("//h2[normalize-space()='Subscription']");
    By emailInput = By.id("susbscribe_email");
    By subscribeButton = By.xpath("//i[@class='fa fa-arrow-circle-o-right']");
    By successMessage = By.xpath("//div[@class='alert-success alert']");


    public HomePage(WebDriver driver){
        this.driver = driver;
        //added
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    public void clickNavBarHomeBtn() {
        driver.findElement(Nav_HomeValidate).click();
    }

    public boolean isSubscriptionVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(subscriptionText)).isDisplayed();
    }

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput)).sendKeys(email);
    }

    public void clickSubscribeButton() {
        wait.until(ExpectedConditions.elementToBeClickable(subscribeButton)).click();
    }

    public boolean isSuccessMessageVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).isDisplayed();
    }

}
