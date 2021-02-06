package com.academy.test;

import com.academy.telesens.util.PropertyProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.time.Duration;

public class BaseTest {
    private static Logger LOG = LoggerFactory.getLogger(BaseTest.class);

    protected WebDriver driver;

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

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        if (driver != null)
            driver.quit();
    }

    @BeforeMethod
    public void testSetUp(Method method, Object[] parameters) {
        LOG.info("Test '{}' start. Parameters: {}",
                method.getName(), parameters);
    }

    @AfterMethod
    public void testTearDownTest(Method method) {
        LOG.info("Test '{}' finish.", method);
    }
}
