package com.okcredit.report;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import java.util.HashMap;
import java.util.Map;

public class ExtentTestManager {
    static Map<Integer, ExtentTest> extentTestMap = new HashMap();
    static ExtentReports extent = ExtentManager.getInstance();

    public static ExtentTest getTest() {
        return extentTestMap.get((int) (long) (Thread.currentThread().getId()));
    }

    public static void endTest() {
        extent.endTest(extentTestMap.get((int) (long) (Thread.currentThread().getId())));
    }

    public static ExtentTest startTest(String testName, String desc) {
        ExtentTest test = extent.startTest(testName, desc);
        extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
        return test;
    }
}

