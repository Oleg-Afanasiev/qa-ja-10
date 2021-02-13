package com.academy.page;

import com.academy.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePage extends BasePage {
    private static Logger LOG = LoggerFactory.getLogger(HomePage.class);

    private String baseUrl;

    @FindBy(linkText = "Sign in")
    private WebElement signInLink;

    public HomePage(WebDriver driver, String baseUrl) {
        super(driver);
        this.baseUrl = baseUrl;
    }

    public HomePage goToHome() {
        LOG.debug("HomePage. goToHome {}", baseUrl);
        driver.get(baseUrl);
        return this;
    }

    public LoginPage login() {
        signInLink.click();
        return new LoginPage(driver);
    }
}
