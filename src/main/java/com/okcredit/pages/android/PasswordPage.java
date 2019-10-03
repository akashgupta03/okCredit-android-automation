package com.okcredit.pages.android;

import com.okcredit.pages.base.BasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class PasswordPage extends BasePage {
    public PasswordPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }


    @CacheLookup
    @FindBy(id = "image_logo")
    private WebElement okCreditPasswordPageLogo;
    @CacheLookup
    @FindBy(xpath = "//android.widget.TextView[@text='Enter Password']")
    private WebElement enterPasswordMessage;

    @CacheLookup
    @FindBy(id = "mobile")
    private WebElement userMobile;

    @CacheLookup
    @FindBy(id = "password")
    private WebElement enterPassword;
    @CacheLookup
    @FindBy(id = "forgot")
    private WebElement forgetPasswordLink;

    @CacheLookup
    @FindBy(id = "ok")
    private WebElement okButton;

    @CacheLookup
    @FindBy(id = "import_button")
    private WebElement importCustomerIcon;

    public boolean isOkCreditLogoIconDisplay() {
        try {
            waitVisibilityOf(okCreditPasswordPageLogo);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isEnterPasswordMessageDisplay() {
        try {
            waitVisibilityOf(enterPasswordMessage);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void verifyUserMobileNumber(String mobile) {
        waitVisibilityOf(userMobile);
        Assert.assertEquals(mobile, userMobile.getText());

    }

    public void enterPassword(String password) {
        waitElementToBeClickable(enterPassword);
        sendKeys(enterPassword, password);
        clickOnElement(okButton);
    }

    public void clickOnForgetPasswordLink() {
        waitElementToBeClickable(forgetPasswordLink);
        clickOnElement(enterPassword);
    }

    public void verifyUserSuccessfullyLogin() {
       Assert.assertTrue(importCustomerIcon.isDisplayed());
    }


}
