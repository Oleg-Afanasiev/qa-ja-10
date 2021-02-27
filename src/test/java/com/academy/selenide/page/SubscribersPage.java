package com.academy.selenide.page;

import com.academy.telesens.lesson06.inheritance.Subscriber;
import com.academy.telesens.lesson07.enumeration.Gender;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;

public class SubscribersPage {
    @FindBy(css = "a[name='contact-edit-id']")
    private List<SelenideElement> idS;

    @FindBy(css = "tr > td:nth-child(3)")
    private List<SelenideElement> fNames;

    @FindBy(css = "tr > td:nth-child(4)")
    private List<SelenideElement> lNames;

    @FindBy(css = "tr > td:nth-child(5)")
    private List<SelenideElement> ageNames;

    @FindBy(css = "tr > td:nth-child(6)")
    private List<SelenideElement> genderNames;

    @FindBy(css = "body > div > div:nth-child(4) > div > table > tbody > tr:last-child > td:nth-child(2)")
    private SelenideElement lastId;

    @FindBy(css = "body > div > div:nth-child(4) > div > table > tbody > tr:last-child > td:nth-child(3)")
    private SelenideElement lastFistName;

    @FindBy(css = "body > div > div:nth-child(4) > div > table > tbody > tr:last-child > td:nth-child(4)")
    private SelenideElement lastLastName;

    @FindBy(css = "body > div > div:nth-child(4) > div > table > tbody > tr:last-child > td:nth-child(5)")
    private SelenideElement lastAge;

    @FindBy(css = "body > div > div:nth-child(4) > div > table > tbody > tr:last-child > td:nth-child(6)")
    private SelenideElement lastGender;

    private String fNameByIdXPathTempl = "//tr[td/a[text() = '%d']]/td[3]";
    private String lNameByIdXPathTempl = "//tr[td/a[text() = '%d']]/td[4]";
    private String ageNameByIdXPathTempl = "//tr[td/a[text() = '%d']]/td[5]";
    private String genderNameByIdXPathTempl = "//tr[td/a[text() = '%d']]/td[6]";

    public List<Subscriber> getAllSubscribers() {
        List<Subscriber> subscribers = new ArrayList<>();
        for (int i = 0; i < idS.size(); i++) {
            Subscriber subscriber = new Subscriber();
            subscriber.setId(Integer.parseInt(idS.get(i).getText().trim()));
            subscriber.setFirstName(fNames.get(i).text().trim());
            subscriber.setLastName(lNames.get(i).text().trim());
            subscriber.setAge(Integer.parseInt(ageNames.get(i).text().trim()));
            subscriber.setGender(Gender.parse(genderNames.get(i).text().trim()));

            subscribers.add(subscriber);
        }

        return subscribers;
    }

    public Subscriber getLastSubscriber() {
        Subscriber subscriber = new Subscriber();

        subscriber.setId(Integer.parseInt(lastId.text().trim()));
        subscriber.setFirstName(lastFistName.text().trim());
        subscriber.setLastName(lastLastName.text().trim());
        subscriber.setAge(Integer.parseInt(lastAge.text().trim()));
        subscriber.setGender(Gender.parse(lastGender.text().trim()));

        return subscriber;
    }

    public Subscriber getSubscriberById(int id) {
        String fName = $(By.xpath(String.format(fNameByIdXPathTempl, id))).text();
        String lName = $(By.xpath(String.format(lNameByIdXPathTempl, id))).text();
        String ageName = $(By.xpath(String.format(ageNameByIdXPathTempl, id))).text();
        String genderName = $(By.xpath(String.format(genderNameByIdXPathTempl, id))).text();
        Subscriber subscriber = new Subscriber();
        subscriber.setFirstName(fName);
        subscriber.setLastName(lName);
        subscriber.setAge(Integer.parseInt(ageName));
        subscriber.setGender(Gender.parse(genderName));
        return subscriber;
    }
}
