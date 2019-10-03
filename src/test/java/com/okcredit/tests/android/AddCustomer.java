package com.okcredit.tests.android;

import com.okcredit.tests.annotation.Author;
import com.okcredit.tests.annotation.TestCaseNotes;
import com.okcredit.tests.annotation.TesterName;
import com.okcredit.tests.base.BaseTest;
import com.okcredit.utils.Categories;
import org.testng.annotations.Test;

public class AddCustomer extends BaseTest {


    @Author(name = TesterName.AKASH)
    @TestCaseNotes(Steps = "Login to Ok Credit Application || Select English Language|| If User present then its lands On Password Page|| land to home page ||click on Add custumer button|| add customer with name and mobile number", expecatedResult = "user successfully added the customer")
    @Test(groups = {Categories.OK_REGRESSION, Categories.OK_SMOKE})
    public void Login() throws InterruptedException {
        languagePage.isLanguageTitleIsDisplay();
        languagePage.isLogoDisplay();
        languagePage.selectEnglishLanguage();
        welcomePage.isLogoDisplay();
        welcomePage.isSubTitleDisplay();
        welcomePage.isWelcomeTitleDisplay();
        welcomePage.clickOnGetStarted();
        mobilePage.isOkCreditLogoIconDisplay();
        mobilePage.isMobileNumberMessageDisplay();
        mobilePage.EnterMobileNumber("7879556515");
        passwordPage.isOkCreditLogoIconDisplay();
        passwordPage.isEnterPasswordMessageDisplay();
        passwordPage.enterPassword("123456");
        passwordPage.verifyUserSuccessfullyLogin();


    }
}
