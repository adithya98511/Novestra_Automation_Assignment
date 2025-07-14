package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SingleProductViewPage {
    WebDriver driver;

    public SingleProductViewPage(WebDriver driver) {
        this.driver = driver;

    }

    By reviewVisible = By.xpath("//a[normalize-space()='Write Your Review']");
    By nameLocator = By.xpath("//input[@id='name']");
    By emailLocator = By.xpath("//input[@id='email']");
    By messageLocator = By.xpath("//textarea[@id='review']");
    By submitBtn = By.xpath("//button[@id='button-review']");
    //    By reviewSentSuccess = By.cssSelector("col-md-12 form-group");
    private By reviewSuccessMessage = By.xpath("//*[contains(text(),'Thank you for your review')]");



    public boolean viewReview() {
        return driver.findElement(reviewVisible).isDisplayed();
    }

    // Enter name, email and review
    public void enterName (String name){
        driver.findElement(nameLocator).sendKeys(name);
    }

    public void enterEmail(String email){
        driver.findElement(emailLocator).sendKeys(email);
    }

    public void enterMessage (String message){
        driver.findElement(messageLocator).sendKeys(message);
    }

    // Click 'Submit' button
    public void clickSubmitButton(){
        driver.findElement(submitBtn).click();
    }


    // check visibility of success message
    public boolean isReviewSuccessMessageVisible() {
        return driver.findElement(reviewSuccessMessage).isDisplayed();

    }

    // Get actual message text
    public String getReviewSuccessMessageText() {
        return driver.findElement(reviewSuccessMessage).getText();
    }
}
