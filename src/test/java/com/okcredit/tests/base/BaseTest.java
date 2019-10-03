package com.okcredit.tests.base;

import com.okcredit.pages.android.*;
import com.okcredit.tests.builder.AndroidDriverBuilder;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

import static com.okcredit.AppiumServerUtils.Startserver;
import static com.okcredit.AppiumServerUtils.stopServer;

public class BaseTest {

    public static AppiumDriver appiumDriver;

    public AddCustumer addCustumer;
    public CustomerPaymentPage customerPaymentPage;
    public MobilePage mobilePage;
    public languagePage languagePage;
   public PasswordPage passwordPage;
    public verifyMobilePage verifyMobilePage;
    public WelcomePage welcomePage;

    @BeforeTest(description = "Start appium server", alwaysRun = true)
    public void start() {
        Startserver();
    }

    @AfterTest(description = "Stop Appium server")
    public void teraDown() {
        stopServer();
    }

    @BeforeMethod(description = "Build the Appium driver", alwaysRun = true)
    public void buildDriver() throws IOException, InterruptedException {
        appiumDriver = AndroidDriverBuilder.buildDriver();
        addCustumer = new AddCustumer(appiumDriver);
        customerPaymentPage = new CustomerPaymentPage(appiumDriver);
        mobilePage = new MobilePage(appiumDriver);
        languagePage = new languagePage(appiumDriver);
        passwordPage = new PasswordPage(appiumDriver);
        verifyMobilePage = new verifyMobilePage(appiumDriver);
        welcomePage = new WelcomePage(appiumDriver);

    }
}
