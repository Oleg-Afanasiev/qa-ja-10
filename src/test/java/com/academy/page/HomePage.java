package com.academy.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    private String baseUrl;

    @FindBy(linkText = "Sign in")
    private WebElement signInLink;

    public HomePage(WebDriver driver, String baseUrl) {
        super(driver);
        this.baseUrl = baseUrl;
    }

    public HomePage goToHome() {
        driver.get(baseUrl);
        return this;
    }

    public LoginPage login() {
        signInLink.click();
        return new LoginPage(driver);
    }
}
