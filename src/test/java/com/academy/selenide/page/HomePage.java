package com.academy.selenide.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class HomePage {
    @FindBy(linkText = "Subscribers")
    private SelenideElement subscriberLink;

    public SubscribersPage goToSubscriber() {
        subscriberLink.click();
        return page(SubscribersPage.class);
    }
}
