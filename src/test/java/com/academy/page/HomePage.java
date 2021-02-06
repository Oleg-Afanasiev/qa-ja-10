package com.academy.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;
    private String baseUrl;

    @FindBy(linkText = "Sign in")
    private WebElement signInLink;

    public HomePage(WebDriver driver, String baseUrl) {
        PageFactory.initElements(driver, this); // необходимо, чтобы проинициализировать аннотированные поля
        this.driver = driver;
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
