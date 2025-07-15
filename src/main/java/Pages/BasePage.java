package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected void waitAndClick(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    protected void waitAndSendKeys(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
    }

    protected boolean isElementVisible(WebElement element) {
        try {
            return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    protected String getElementText(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element)).getText();
    }

    public static class CategoriesSection
    {
        @FindBy(xpath = "/html/body/section[2]/div/div/div[1]/div/h2")
        private WebElement categoriesTitle;

        @FindBy(xpath = "//*[@id=\"accordian\"]/div[1]/div[1]/h4/a")
        private WebElement womenSectionButton;

        @FindBy(xpath = "//*[@id=\"accordian\"]/div[2]/div[1]/h4/a")
        private WebElement mansSectionButton;

        @FindBy(xpath = "//*[@id=\"accordian\"]/div[3]/div[1]/h4/a")
        private WebElement childSectionButton;
    }
}
