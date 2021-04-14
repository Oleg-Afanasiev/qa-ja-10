package com.academy.selenide;

import com.academy.selenide.page.HomePage;
import com.academy.selenide.page.SubscribersPage;
import com.academy.telesens.lesson06.inheritance.Subscriber;
import com.academy.telesens.lesson07.enumeration.Gender;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class SelenideTests {
    private static final String BASE_URL = "http://localhost:8081";

    @BeforeClass
    public void beforeClass() {
        Configuration.browser = "chrome"; // запуск в браузере "chrome"
        Configuration.timeout = 10;  // настройка таймаута неявных ожиданий (10 сек)
        Configuration.startMaximized = true; // при старте распахиваем окно на весь экран

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false)
        );
    }

    @Test(dataProvider = "subscriberProvider")
    public void testAddSubscriber(Subscriber expectedSubscriber) {
        // Этот тест использует паттерн PageObject
        // Данные для теста получаем от провайдера "subscriberProvider"
        // 'expectedSubscriber' - эталонный абонента, кот. создаем
        HomePage homePage = open(BASE_URL, HomePage.class);  // открываем страницу по url и дальше используем HomePage
        SubscribersPage subscribersPage = homePage.goToSubscriber(); // переходим на страницу абонентов
        List<Subscriber> before = subscribersPage.getAllSubscribers(); // читаем список всех абонентов со страницы

        // Здесь хардкод - нужно разложить по логику по классам Page
        // add new subscriber
        $(By.id("add")).click(); // Нажимаем кнопку добавить
        $(By.id("fname")).setValue(expectedSubscriber.getFirstName()); // вводим имя
        $(By.id("lname")).setValue(expectedSubscriber.getLastName()); // вводим фамилию
        if (expectedSubscriber.getGender() == Gender.MALE) { // нажимаем пол
            $(By.id("MALE")).click();
        } else {
            $(By.id("FEMALE")).click();
        }
        $(By.id("age")).setValue(String.valueOf(expectedSubscriber.getAge())); // заполняем возраст
        $("body > div > form > button").click();

        // хардкод закончился - используем паттерн page
        Subscriber actualSubscriber = subscribersPage.getLastSubscriber(); // получаем последнего абонента из списка
        expectedSubscriber.setId(actualSubscriber.getId()); // записываем id в эталонный абонент (id был сгенерирован автоматически при создании)
        Assert.assertEquals(actualSubscriber, expectedSubscriber); // сравниваем созданный абонент с эталонным по всем полям (в т.ч. по id)

        List<Subscriber> after = subscribersPage.getAllSubscribers(); // получаем список всех абонентов после создания
        Assert.assertEquals(after.size(), before.size() + 1); // проверяем, что размер списка стал на единицу больше
        before.add(actualSubscriber); // добавляем в список, полученный до создания созданного абоннета
        // sort by id
        before.sort(Comparator.comparingInt(Subscriber::getId)); // сортируем списки по id
        after.sort(Comparator.comparingInt(Subscriber::getId));

        Assert.assertEquals(after, before); // теперь проверям, что списки до и после - одинаковые
    }

    @AfterClass
    public void afterClass() {
        closeWindow();
    }

    @DataProvider(name = "subscriberProvider")
    public Object[][] subscriberProvider() {
        // подготавливаем данные для нового абонента
        Subscriber subscriber = new Subscriber();
        subscriber.setFirstName("testFirstName");
        subscriber.setLastName("testLastName");
        subscriber.setAge(28);
        subscriber.setGender(Gender.MALE);
        return new Object[][] {
                {subscriber}
        };
    }
}
