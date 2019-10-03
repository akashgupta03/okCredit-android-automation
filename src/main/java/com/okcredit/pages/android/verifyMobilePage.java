package com.okcredit.pages.android;

import com.okcredit.pages.base.BasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class verifyMobilePage extends BasePage {
    public verifyMobilePage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }


    @CacheLookup
    @FindBy(xpath = "//android.widget.TextView[@text='Verify mobile']")
    private WebElement verifyPageTitle;
    @CacheLookup
    @FindBy(xpath = "//android.widget.TextView[@text='OTP will be sent for verification']")
    private WebElement verifyOTPMessage;
    @CacheLookup
    @FindBy(id = "mobile")
    private WebElement mobileNumber;

    @CacheLookup
    @FindBy(id = "terms")
    private WebElement termAndCondition;
    @CacheLookup
    @FindBy(id = "next")
    private WebElement sendOTP;

    public void verifyPageTitle(String title) {
        waitVisibilityOf(verifyPageTitle);
        Assert.assertEquals(verifyPageTitle.getText(), title);
    }

    public void verifyOTPMessage(String otpMessage) {
        waitVisibilityOf(verifyOTPMessage);
        Assert.assertEquals(verifyOTPMessage.getText(), otpMessage);
    }

    public boolean isTermAndConditionDisplay() {
        try {
            waitVisibilityOf(termAndCondition);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void enterMobileNumber(String mobile) {
        waitElementToBeClickable(mobileNumber);
        sendKeys(mobileNumber, mobile);
    }

    public void enterOTP(String OTP) {
        waitElementToBeClickable(sendOTP);
        sendKeys(sendOTP, OTP);
    }

}
