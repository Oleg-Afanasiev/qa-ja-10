package com.academy.kdt;

import com.academy.ddt.core.BaseTest;
import com.academy.kdt.engine.KeywordStep;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class AuthTests extends BaseTest {

    private BaseKDTTest baseKDT;

    @BeforeClass
    public void setUp() {
        baseKDT = new BaseKDTTest(driver);
    }

    @Test(groups={"kdt"}, dataProvider = "kdtProvider")
    public void testIncorrectLogin(List<KeywordStep> steps) {
        baseKDT.kdtTest(steps);
    }

    @DataProvider(name="kdtProvider")
    public Object[][] loginTestProvider() {

        List<KeywordStep> steps = new ArrayList<>();

        // TODO read from csv
        // Home,GOTOURL,,http://automationpractice.com/index.php
        // Home,CLICK,signInLink,
        steps.add(new KeywordStep()
                .withPage("Home")
                .withAction("GOTOURL")
                .withObject("")
                .withValue("http://automationpractice.com/index.php"));

        steps.add(new KeywordStep()
                .withPage("Home")
                .withAction("CLICK")
                .withObject("signInLink")
                .withValue(""));

        steps.add(new KeywordStep()
                .withPage("Login")
                .withAction("INPUT")
                .withObject("login")
                .withValue("test@gmail.com"));

        steps.add(new KeywordStep()
                .withPage("Login")
                .withAction("INPUT")
                .withObject("password")
                .withValue("123"));

        steps.add(new KeywordStep()
                .withPage("Login")
                .withAction("CLICK")
                .withObject("signInButton")
                .withValue(""));

        steps.add(new KeywordStep()
                .withPage("Login")
                .withAction("ASSERT")
                .withObject("msgErrText")
                .withValue("Invalid password."));

//        steps.add(new KeywordStep()
//                .withPage("account")
//                .withAction("CLICK")
//                .withObject("signOutButton")
//                .withValue(""));

        return new Object[][] {
                {steps},
        };
    }
}
