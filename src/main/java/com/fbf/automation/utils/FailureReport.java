package com.fbf.automation.utils;

import org.testng.*;

/**
 * Custom report.
 */
public class FailureReport implements ITestListener {
    long startTime;
    @Override

    public void onStart(ITestContext arg0) {

        System.out.println("Start Of Execution(TEST)->"+arg0.getName());
        startTime = System.currentTimeMillis();

    }

    @Override

    public void onTestStart(ITestResult arg0) {

        System.out.println("Test Started->"+arg0.getName());

    }

    @Override

    public void onTestSuccess(ITestResult arg0) {

        System.out.println("Test Pass->"+arg0.getName());

    }

    @Override

    public void onTestFailure(ITestResult arg0) {

        System.out.println("Test Failed->"+arg0.getName());
    }

    @Override

    public void onTestSkipped(ITestResult arg0) {

        System.out.println("Test Skipped->"+arg0.getName());

    }

    @Override

    public void onFinish(ITestContext arg0) {

        System.out.println("END Of Execution(TEST)->"+arg0.getName());
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Test Suite Completed time in milli seconds: " + totalTime);

    }

    @Override

    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {

        // TODO Auto-generated method stub



    }

}
