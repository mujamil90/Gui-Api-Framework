package com.ui.api.qagenes.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IClass;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
public class LoggingListener extends  TestListenerAdapter {

    private static final Logger LOG     = LogManager.getLogger (LoggingListener.class);

    @Override
    public void onTestStart(ITestResult tr) {
        LOG.info("Test case is started -> "+ tr.getName());
        log("Test Started....");
    }

    @Override
    public void onTestSuccess(ITestResult tr) {

        log("Test '" + tr.getName() + "' PASSED");
        LOG.info("Test '" + tr.getName() + "' PASSED");

        // This will print the class name in which the method is present
        log(tr.getTestClass());

        // This will print the priority of the method.
        // If the priority is not defined it will print the default priority as
        // 'o'
        log("Priority of this method is " + tr.getMethod().getPriority());
    }

    @Override
    public void onTestFailure(ITestResult tr) {

        log("Test '" + tr.getName() + "' is  FAILED");
        LOG.info("Test '" + tr.getName() + "' is  FAILED");
        log("Priority of this method is " + tr.getMethod().getPriority());
    }

    @Override
    public void onTestSkipped(ITestResult tr) {

        LOG.info("Test '" + tr.getName() + "' is SKIPPED");
    }

    private void log(String methodName) {
        System.out.println(methodName);
    }

    private void log(IClass testClass) {
        System.out.println(testClass);
    }
}
