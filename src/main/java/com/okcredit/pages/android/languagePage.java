package com.okcredit.pages.android;

import com.okcredit.pages.base.BasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class languagePage extends BasePage {
    public languagePage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @CacheLookup
    @FindBy(id = "logo")
    private WebElement okCreditLogo;
    @CacheLookup
    @FindBy(id = "title")
    private WebElement languageTitle;
    @CacheLookup
    @FindBy(id = "hindi")
    private WebElement hindiLanguage;
    @CacheLookup
    @FindBy(id = "hinglish")
    private WebElement hinglishLanguage;
    @CacheLookup
    @FindBy(id = "punjabi")
    private WebElement punjabiLanguage;
    @CacheLookup
    @FindBy(id = "malayalam")
    private WebElement malayalamLanguage;
    @FindBy(id = "english")
    private WebElement englishLanguage;


    public WelcomePage selectLanguage(String language) {
        if (language.equalsIgnoreCase("hindi"))
            hindiLanguage.click();
        if (language.equalsIgnoreCase("english"))
            englishLanguage.click();
        return new WelcomePage(appiumDriver);

    }

    public boolean isLogoDisplay() {
        return okCreditLogo.isDisplayed();
    }

    public boolean isLanguageTitleIsDisplay() {
        return languageTitle.isDisplayed();
    }

    public WelcomePage selectHindiLanguage() {
        clickOnElement(hindiLanguage);
        return new WelcomePage(appiumDriver);
    }

    public WelcomePage selectEnglishLanguage() {
        clickOnElement(englishLanguage);
        return new WelcomePage(appiumDriver);
    }

    public WelcomePage selectMalyalamLanguage() {
        clickOnElement(malayalamLanguage);
        return new WelcomePage(appiumDriver);
    }
}
