package com.okcredit.pages.android;

import com.okcredit.pages.base.BasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class WelcomePage extends BasePage {
    public WelcomePage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }


    @CacheLookup
    @FindBy(id = "logo")
    private WebElement okCreditLogo;
    @CacheLookup
    @FindBy(id = "title")
    private WebElement WelcomeTitle;
    @CacheLookup
    @FindBy(id = "subtitle")
    private WebElement subTitle;
    @FindBys({
            @FindBy(className = "digital_india_1"),
            @FindBy(className = "digital_india_2")
    })
    private WebElement digitalIndiaTitle;
    @CacheLookup
    @FindBy(id = "getStarted")
    private WebElement getStarted;

    public boolean isLogoDisplay() {
        return okCreditLogo.isDisplayed();
    }

    public boolean isWelcomeTitleDisplay() {
        return WelcomeTitle.isDisplayed();
    }

    public boolean isSubTitleDisplay() {
        return subTitle.isDisplayed();
    }

    public MobilePage clickOnGetStarted() {
        clickOnElement(getStarted);
        return new MobilePage(appiumDriver);
    }


}
