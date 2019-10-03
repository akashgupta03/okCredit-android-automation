package com.okcredit.report;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RerunFailedTest implements IRetryAnalyzer {

    int iterate = 0;
    int Max_Count = 3;


    @Override
    public boolean retry(ITestResult iTestResult) {
        if (iterate < Max_Count)
            try {
                iterate++;
                return true;
            } catch (Exception e) {

            }
        return false;
    }
}
