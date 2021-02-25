package com.academy.selenide;

import com.academy.selenide.page.HomePage;
import com.academy.selenide.page.SubscribersPage;
import com.academy.telesens.lesson06.inheritance.Subscriber;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class SelenideTests {
    private String baseUrl = "http://localhost:8081";

    @BeforeClass
    public void beforeClass() {
        Configuration.browser = "chrome";
        Configuration.timeout = 10;
        Configuration.startMaximized = true;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false)
        );
    }

    @Test
    public void testAddSubscriber(Subscriber expectedSubscriber) {
        HomePage homePage = open(baseUrl, HomePage.class);
        SubscribersPage subscribersPage = homePage.goToSubscriber();
        List<Subscriber> before = subscribersPage.getAllSubscribers();

        // add new subscriber
        $(By.id("add")).click();
        $(By.id("fname")).setValue("test2");
        $(By.id("lname")).setValue("test2");
        $(By.id("FEMALE")).click();
        $(By.id("age")).setValue("24");
        $("body > div > form > button").click();

        Subscriber actualSubscriber = subscribersPage.getLastSubscriber();
        Assert.assertEquals(actualSubscriber, expectedSubscriber);

        List<Subscriber> after = subscribersPage.getAllSubscribers();
        Assert.assertEquals(after.size(), before.size() + 1);
        before.add(actualSubscriber);
        // sort by id
        before.sort(Comparator.comparingInt(Subscriber::getId));
        after.sort(Comparator.comparingInt(Subscriber::getId));

        Assert.assertEquals(after, before);
    }

    @AfterClass
    public void afterClass() {
        closeWindow();
    }
}
