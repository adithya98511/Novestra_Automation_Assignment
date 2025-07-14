package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage
{
    // login section
    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[1]/div/h2")
    private WebElement loginTitle;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]")
    private WebElement loginEmailInput;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]")
    private WebElement loginPasswordInput;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[1]/div/form/button")
    private WebElement loginSubmitButton;

    //Signup section
    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[1]/div/h2")
    private WebElement signupTitle;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]")
    private WebElement signupName;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]")
    private WebElement signupEmailInput;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[3]/div/form/button")
    private WebElement signupSubmitButton;

}
