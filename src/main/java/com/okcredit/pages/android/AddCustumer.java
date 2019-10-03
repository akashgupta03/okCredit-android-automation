package com.okcredit.pages.android;

import com.okcredit.pages.base.BasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AddCustumer extends BasePage {
    public AddCustumer(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @CacheLookup
    @FindBy(id = "icon")
    private WebElement addCostumeIcon;


    @CacheLookup
    @FindBy(id = "title")
    private WebElement addCustomerTitle;

    @CacheLookup
    @FindBy(id = "subtitle")
    private WebElement addCustomerSubTitle;
    @CacheLookup
    @FindBy(id = "import_button")
    private WebElement importCustomerIcon;

    @CacheLookup
    @FindBy(id = "fabAddCustomer")
    private WebElement addCustomerButton;
    @CacheLookup
    @FindBy(id = "input_name")
    private WebElement enterYourName;
    @CacheLookup
    @FindBy(id = "name_button")
    private WebElement submitName;
    @CacheLookup
    @FindBy(id = "input_phone")
    private WebElement enterMobileNumber;
    @CacheLookup
    @FindBy(id = "phone_button")
    private WebElement submitPhone;


    public boolean isTitleDisplay() {
        try {
            waitVisibilityOf(addCustomerButton);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }


    public void verifyTitle() {
        waitVisibilityOf(addCustomerButton);
        Assert.assertEquals(addCostumeIcon.getText(), "Ok credit", String.format("title should be %s but fount %s", "Ok credit", addCostumeIcon.getText()));
    }

    public boolean isSubTitleDisplay() {
        try {
            waitVisibilityOf(addCustomerSubTitle);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isAddCustomerIconDisplay() {
        try {
            waitVisibilityOf(addCostumeIcon);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }


    public boolean isImportCustomerIconDisplay() {
        try {
            waitVisibilityOf(importCustomerIcon);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void clickOnAddCostumerButton() {
        waitElementToBeClickable(addCustomerButton);
        clickOnElement(addCustomerButton);
    }

    public String clickOnEnterYourName(String name) {
        waitElementToBeClickable(enterYourName);
        sendKeys(enterYourName, name);
        clickOnElement(submitName);
        return name;
    }

    public void clickOnEnterMobileNumber(String mobile) {
        waitElementToBeClickable(enterMobileNumber);
        sendKeys(enterMobileNumber, mobile);
        clickOnElement(submitPhone);
    }

    public void addCostumer(String name, String number) {
        clickOnEnterYourName(name);
        clickOnEnterMobileNumber(number);
    }


}
