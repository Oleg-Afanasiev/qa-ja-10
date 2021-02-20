package com.academy.selenide.page;

import com.academy.telesens.lesson06.inheritance.Subscriber;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;

public class SubscribersPage {
    @FindBy(css = "a[name='contact-edit-id']")
    private List<SelenideElement> idS;

    @FindBy(css = "body > div > div:nth-child(4) > div > table > tbody > tr > td:nth-child(3)")
    private List<SelenideElement> fNames;

    private String fNameByIdXPath = "/html/body/div/div[4]/div/table/tbody/tr[td/a[text() = '%d']]/td[3]";

    public List<Subscriber> getAllSubscribers() {
        List<Subscriber> subscribers = new ArrayList<>();
        for (int i = 0; i < idS.size(); i++) {
            Subscriber subscriber = new Subscriber();
            subscriber.setId(Integer.parseInt(idS.get(i).getText().trim()));
            subscriber.setFirstName(fNames.get(i).text().trim());
        }

        return subscribers;
    }

    public Subscriber getSubscriberById(int id) {
        String fName = $(By.xpath(String.format(fNameByIdXPath, id))).text();
        Subscriber subscriber = new Subscriber();
        subscriber.setFirstName(fName);
        return subscriber;
    }
}
