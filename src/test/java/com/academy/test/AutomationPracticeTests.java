package com.academy.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class AutomationPracticeTests extends BaseTest {
    private String baseUrl = "http://automationpractice.com/index.php";

    @Test(dataProvider = "authDataProvider")
    public void testAuth(String userName, String password, String errMsgExpected) {
        driver.get(baseUrl);
        WebElement elSignIn = driver.findElement(By.linkText("Sign in"));
        elSignIn.click();
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys(userName);
        driver.findElement(By.id("passwd")).click();
        driver.findElement(By.id("passwd")).clear();
        driver.findElement(By.id("passwd")).sendKeys(password);
        driver.findElement(By.xpath("//button[@id='SubmitLogin']/span")).click();

        String errMsgActual = driver.findElement(By.xpath("//*[@id='center_column']/div[1]/ol/li")).getText();
        Assert.assertEquals(errMsgActual, errMsgExpected);
    }

    @Test
    @Ignore
    public void testWomenCategory() {

    }

    @DataProvider(name = "authDataProvider")
    public Object[][] authDataProvider() {
        // username,pwd,Invalid email address.
        // username@gmail.com,,Password is required.

        Object[] case1 = {"username", "pwd", "Invalid email address."};
        Object[] case2 = {"username@gmail.com", "", "Password is required."};

        List<Object[]> cases = new ArrayList<>();
        cases.add(case1);
        cases.add(case2);

        // 1 способ создание массива из списка
//        Object[][] tmp = new Object[0][0];
//        Object[][] result = cases.toArray(tmp);

        // 2 способ создание массива из списка
        Object[][] result = cases.toArray(Object[][]::new);
        return result;

//        return new Object[][]{
//            case1, case2
//        };
    }
}
