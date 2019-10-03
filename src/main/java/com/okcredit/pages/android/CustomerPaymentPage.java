package com.okcredit.pages.android;

import com.okcredit.pages.base.BasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CustomerPaymentPage extends BasePage {
    public CustomerPaymentPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @CacheLookup
    @FindBy(id = "profile_name")
    private WebElement CustomerName;

    @CacheLookup
    @FindBy(id = "empty_tx_text")
    private WebElement emptyTransactionMessage;
    @CacheLookup
    @FindBy(xpath = "//android.widget.TextView[@text='ACCEPT']")
    private WebElement acceptPayment;
    @CacheLookup
    @FindBy(xpath = "//android.widget.TextView[@text='GIVE']")
    private WebElement givePayment;

    @CacheLookup
    @FindBy(id = "amount_box")
    private WebElement amountBox;

    @CacheLookup
    @FindBy(id = "bottom_container_text")
    private WebElement addNotes;
    @CacheLookup
    @FindBy(id = "date_text")
    private WebElement TodayDates;
    @CacheLookup
    @FindBy(id = "btn_submit")
    private WebElement submitNotes;
    @CacheLookup
    @FindBy(id = "bottom_container_right_icon")
    private WebElement addAttachment;
    @CacheLookup
    @FindBy(id = "btn_allow")
    private WebElement allowAccessToApp;

     @CacheLookup
    @FindBy(id = "gallery")
    private WebElement uploadImageByGallery;

     @CacheLookup
    @FindBy(id = "camera")
    private WebElement uploadImageByCamera;



    public void isCustomerNameDisplay(String name) {
        CustomerName.isDisplayed();
        Assert.assertEquals(name, CustomerName.getText());
    }

    public void isEmptyTextMessageDisplay(String message) {
        emptyTransactionMessage.isDisplayed();
        Assert.assertEquals(message, emptyTransactionMessage.getText());
    }


    public void clickOnAcceptPaymentButton() {
        waitElementToBeClickable(acceptPayment);
        clickOnElement(acceptPayment);
    }

    public void clickOnGivenPaymentButton() {
        waitElementToBeClickable(givePayment);
        clickOnElement(givePayment);
    }

    public void enterAmount(int amount) {
        waitElementToBeClickable(amountBox);
        clickOnElement(givePayment);
    }

    public void addPaymentNotes(String notes) {
        waitElementToBeClickable(addNotes);
        sendKeys(addNotes, notes);
        clickOnElement(submitNotes);
    }

    public void addPayment(String notes, int amount) {
        enterAmount(amount);
        addPaymentNotes(notes);
    }

    public void clickOnUploadImage() {
        waitElementToBeClickable(addAttachment);
        clickOnElement(addAttachment);
    }

    public void giveAllowPermission() {
        try {
            allowAccessToApp.isDisplayed();
            clickOnElement(allowAccessToApp);
        }
        catch (Exception e)
        {
            System.out.println("user already have a access");
        }
    }


    public void uploadImageByGallery()
    {
        waitElementToBeClickable(uploadImageByGallery);
        clickOnElement(uploadImageByGallery);
    }
}
