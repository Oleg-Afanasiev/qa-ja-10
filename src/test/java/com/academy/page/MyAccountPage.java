package com.academy.page;

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
}
