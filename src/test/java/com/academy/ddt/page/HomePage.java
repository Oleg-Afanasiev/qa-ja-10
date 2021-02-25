package com.academy.ddt.page;

import com.academy.ddt.core.BasePage;
import io.qameta.allure.Step;
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

    @Step("goToHome")
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
