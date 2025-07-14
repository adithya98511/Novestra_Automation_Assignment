package com.automationexercise.pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    // Common actions can go here, for example:
    public void navigateTo(String url) {
        driver.get(url);
    }
}
