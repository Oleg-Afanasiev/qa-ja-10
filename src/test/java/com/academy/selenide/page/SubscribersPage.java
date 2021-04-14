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
    // шаблоны xpath локаторов для получения имени/фамилии/возраста/пола по id
    // id будет подставляться вместо %d
    private static final String F_NAME_BY_ID_X_PATH_TMPL = "//tr[td/a[text() = '%d']]/td[3]";
    private static final String L_NAME_BY_ID_X_PATH_TMPL = "//tr[td/a[text() = '%d']]/td[4]";
    private static final String AGE_NAME_BY_ID_X_PATH_TMPL = "//tr[td/a[text() = '%d']]/td[5]";
    private static final String GENDER_NAME_BY_ID_X_PATH_TMPL = "//tr[td/a[text() = '%d']]/td[6]";

    @FindBy(css = "a[name='contact-edit-id']")
    private List<SelenideElement> idS; // список всех id из списка абонентов

    @FindBy(css = "tr > td:nth-child(3)")
    private List<SelenideElement> fNames; // список всех имен из списка абонентов

    @FindBy(css = "tr > td:nth-child(4)")
    private List<SelenideElement> lNames; // список всех имен из списка абонентов

    @FindBy(css = "tr > td:nth-child(5)")
    private List<SelenideElement> ageNames;

    @FindBy(css = "tr > td:nth-child(6)")
    private List<SelenideElement> genderNames;

    @FindBy(css = "body > div > div:nth-child(4) > div > table > tbody > tr:last-child > td:nth-child(2)")
    private SelenideElement lastId; // id последней записи в списке

    @FindBy(css = "body > div > div:nth-child(4) > div > table > tbody > tr:last-child > td:nth-child(3)")
    private SelenideElement lastFistName; // имя последней записи в списке

    @FindBy(css = "body > div > div:nth-child(4) > div > table > tbody > tr:last-child > td:nth-child(4)")
    private SelenideElement lastLastName;

    @FindBy(css = "body > div > div:nth-child(4) > div > table > tbody > tr:last-child > td:nth-child(5)")
    private SelenideElement lastAge;

    @FindBy(css = "body > div > div:nth-child(4) > div > table > tbody > tr:last-child > td:nth-child(6)")
    private SelenideElement lastGender;

    public List<Subscriber> getAllSubscribers() {
        // формируем список абонентов из списков со значениями id/имени/фамилии...
        List<Subscriber> subscribers = new ArrayList<>();
        for (int i = 0; i < idS.size(); i++) { // цикл по элементам списка
            Subscriber subscriber = new Subscriber(); // создаем объект абонент
            subscriber.setId(Integer.parseInt(idS.get(i).getText().trim())); // записываем id из списка
            subscriber.setFirstName(fNames.get(i).text().trim()); // записываем имя из списка
            subscriber.setLastName(lNames.get(i).text().trim()); // ...
            subscriber.setAge(Integer.parseInt(ageNames.get(i).text().trim()));
            subscriber.setGender(Gender.parse(genderNames.get(i).text().trim()));

            subscribers.add(subscriber);
        }

        return subscribers;
    }

    public Subscriber getLastSubscriber() {
        // создаем абонента последнего по списку, используя соотв. локаторы
        Subscriber subscriber = new Subscriber();

        subscriber.setId(Integer.parseInt(lastId.text().trim()));
        subscriber.setFirstName(lastFistName.text().trim());
        subscriber.setLastName(lastLastName.text().trim());
        subscriber.setAge(Integer.parseInt(lastAge.text().trim()));
        subscriber.setGender(Gender.parse(lastGender.text().trim()));

        return subscriber;
    }

    public Subscriber getSubscriberById(int id) {
        // создаем абонента по id, используя локаторы шаблоны, в кот. нужно id подставлять
        String fName = $(By.xpath(String.format(F_NAME_BY_ID_X_PATH_TMPL, id))).text();
        String lName = $(By.xpath(String.format(L_NAME_BY_ID_X_PATH_TMPL, id))).text();
        String ageName = $(By.xpath(String.format(AGE_NAME_BY_ID_X_PATH_TMPL, id))).text();
        String genderName = $(By.xpath(String.format(GENDER_NAME_BY_ID_X_PATH_TMPL, id))).text();
        Subscriber subscriber = new Subscriber();
        subscriber.setFirstName(fName);
        subscriber.setLastName(lName);
        subscriber.setAge(Integer.parseInt(ageName));
        subscriber.setGender(Gender.parse(genderName));
        return subscriber;
    }
}
