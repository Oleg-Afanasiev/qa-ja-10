package com.academy.kdt.engine;

import com.academy.ddt.page.HomePage;
import com.academy.telesens.util.PropertyProvider;
import org.openqa.selenium.WebDriver;

public class KeywordHomeIdentity {
    private WebDriver driver;
    private String baseUrl = "http://automationpractice.com/index.php";

    public KeywordHomeIdentity(WebDriver driver) {
        this.driver = driver;
    }

    public void doAction(String action, String object, String value) {
        switch (action) {
            case "GOTOURL":
                new HomePage(driver, value).goToHome();
                break;

            case "CLICK":
                click(object, value);
                break;

        }
    }

    private void click(String object, String value) {
        switch (object) {
            case "signInLink":
                new HomePage(driver, baseUrl).login();
                break;
        }
    }
}
