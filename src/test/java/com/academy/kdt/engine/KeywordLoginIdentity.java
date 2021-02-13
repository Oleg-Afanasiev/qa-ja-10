package com.academy.kdt.engine;

import com.academy.ddt.page.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class KeywordLoginIdentity {
    private WebDriver driver;

    public KeywordLoginIdentity(WebDriver driver) {
        this.driver = driver;
    }

    public void doAction(String action, String object, String value) {
        switch (action) {
            case "INPUT":
                input(object, value);
                break;

            case "CLICK":
                click(object, value);
                break;

            case "ASSERT":
                doAssert(object, value);
                break;

            default:
                throw new UnsupportedOperationException("Unknown action: " + action);
        }
    }

    private void input(String object, String value) {
        switch (object) {
            case "login":
                new LoginPage(driver).inputLogin(value);
                break;

            case "password":
                new LoginPage(driver).inputPassword(value);
                break;
        }
    }

    private void click(String object, String value) {
        switch (object) {
            case "signInButton":
                new LoginPage(driver).submit();
                break;
        }
    }

    private void doAssert(String object, String value) {
        switch (object) {
            case "msgErrText":
                Assert.assertEquals(
                        new LoginPage(driver).getErrorMessage(), value);
                break;

            default:
                throw new RuntimeException("Unsupported operation " + object + " " + value);
        }
    }
}
