package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CartPage {
    WebDriver driver;
    WebDriverWait wait;

    By Nav_HomeValidate = By.xpath("//a[normalize-space()='Home']");
    By HomeFeatureTxt = By.xpath("//h2[normalize-space()='Features Items']");
    By subscriptionText = By.xpath("//h2[normalize-space()='Subscription']");
    By emailInput = By.xpath("//input[@id='susbscribe_email']");
    By subscribeButton = By.id("subscribe");
    By successMessage = By.xpath("//div[@class='alert-success' and contains(text(),'You have been successfully subscribed!')]");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickNavBarHomeBtn() {
        driver.findElement(Nav_HomeValidate).click();
    }

    public void verifyHomeFeatureTxt() {
        try {

            wait.until(ExpectedConditions.presenceOfElementLocated(HomeFeatureTxt));
            Assert.assertEquals(driver.findElement(HomeFeatureTxt).getText(), "Features Items");

        } catch (TimeoutException e) {
            System.out.println("Timed out waiting for the home page to load.");
            throw e;
        } catch (Exception e) {
            System.out.println("Error occurred while verifying home page: " + e.getMessage());
            throw e;
        }
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
