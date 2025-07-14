package Pages.HomePage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CategoriesSection
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
