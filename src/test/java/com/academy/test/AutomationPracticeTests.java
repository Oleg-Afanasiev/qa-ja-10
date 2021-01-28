package com.academy.test;

import com.academy.telesens.util.PropertyProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.util.concurrent.TimeUnit;

public class AutomationPracticeTests {
    private WebDriver driver;
    private String baseUrl = "http://automationpractice.com/index.php";

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", PropertyProvider.get("driver.chrome"));
        System.setProperty("webdriver.gecko.driver", PropertyProvider.get("driver.firefox"));
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testAuth() {
        driver.get(baseUrl);
        WebElement elSignIn = driver.findElement(By.linkText("Sign in"));
        elSignIn.click();
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("username");
        driver.findElement(By.id("passwd")).click();
        driver.findElement(By.id("passwd")).clear();
        driver.findElement(By.id("passwd")).sendKeys("pwd");
        driver.findElement(By.xpath("//button[@id='SubmitLogin']/span")).click();

        String errMsgExpected = "Invalid email address.1";
        String errMsgActual = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li")).getText();
        Assert.assertEquals(errMsgActual, errMsgExpected);
    }

    @Test
    public void testWomenCategory() {

    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
    }
}
