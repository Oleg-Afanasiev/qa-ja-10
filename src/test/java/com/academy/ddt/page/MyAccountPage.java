package com.academy.ddt.page;

import com.academy.ddt.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
    @FindBy(xpath = "//a[contains(@class, 'account')]/span")
    private WebElement userNameEl;

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }


    public String getUserName() {
        return userNameEl.getText();
    }

    public HomePage logout() {
        return new HomePage(driver, "");
    }
}
