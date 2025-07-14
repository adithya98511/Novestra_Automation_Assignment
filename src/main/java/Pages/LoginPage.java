package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By pwdLocator = By.xpath("//input[@placeholder='Password']");
    By emailLocator = By.xpath("//input[@data-qa='login-email']");
    By loginBtn = By.xpath("//button[normalize-space()='Login']");

    public void setPwd (String name){
        driver.findElement(pwdLocator).sendKeys(name);
    }

    public void setEmail (String email){
        driver.findElement(emailLocator).sendKeys(email);
    }

    public void clickLoginButton(){
        driver.findElement(loginBtn).click();
    }



}
