package com.okcredit.pages.android;

import com.okcredit.pages.base.BasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class MobilePage extends BasePage {
    public MobilePage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }


    @CacheLookup
    @FindBy(id = "image_logo")
    private WebElement okCreditLogo;
    @CacheLookup
    @FindBy(xpath = "//android.widget.TextView[@text='Enter Mobile Number']")
    private WebElement mobileNumberMessage;

    @CacheLookup
    @FindBy(id = "mobile")
    private WebElement enterMobileNumber;

    @CacheLookup
    @FindBy(id = "ok")
    private WebElement clickOnOkButton;


    public boolean isOkCreditLogoIconDisplay() {
        try {
            waitVisibilityOf(okCreditLogo);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isMobileNumberMessageDisplay() {
        try {
            waitVisibilityOf(mobileNumberMessage);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void EnterMobileNumber(String mobile) {
        waitElementToBeClickable(enterMobileNumber);
sendKeys(enterMobileNumber,mobile);
        clickOnElement(clickOnOkButton);
    }


}
