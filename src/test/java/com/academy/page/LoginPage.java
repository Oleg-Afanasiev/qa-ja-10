package com.academy.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(id="email")
    private WebElement loginField;

    @FindBy(id="passwd")
    private WebElement passwordField;

//    @FindBy(xpath = "//button[@id='SubmitLogin']/span")
    @FindBy(id = "SubmitLogin")
    private WebElement submitButton;

    @FindBy(xpath = "//*[@id='center_column']/div[1]/ol/li")
    private WebElement errMessageEl;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this); // необходимо, чтобы проинициализировать аннотированные поля
    }

    public LoginPage inputLogin(String userName) {
        loginField.click();
        loginField.clear();
        loginField.sendKeys(userName);
        return this;
    }

    public LoginPage inputPassword(String password) {
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);
        return this;
    }

    public LoginPage submit() {
        submitButton.click();
        return this;
    }

    public String getErrorMessage() {
        return errMessageEl.getText();
    }
}
