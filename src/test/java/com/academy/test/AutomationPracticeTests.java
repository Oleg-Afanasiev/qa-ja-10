package com.academy.test;

import com.academy.telesens.util.PropertyProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.Assertion;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AutomationPracticeTests {
    private WebDriver driver;
    private String baseUrl = "http://automationpractice.com/index.php";

    @BeforeGroups
    public void setUpGroup() {
    }

    @Parameters("browser")
    @BeforeClass(alwaysRun = true)
    public void setUp(@Optional("chrome") String browser)  {
        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", PropertyProvider.get("driver.chrome"));
                driver = new ChromeDriver();
                break;

            case "firefox":
                System.setProperty("webdriver.gecko.driver", PropertyProvider.get("driver.firefox"));
                driver = new FirefoxDriver();
                break;

            default:
                throw new IllegalArgumentException(
                        String.format("Browser %s not supported", browser));
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

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

        String errMsgActual = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li")).getText();
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

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        if (driver != null)
            driver.quit();
    }
}
