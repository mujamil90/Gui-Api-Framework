package com.ui.api.qagenes.listeners;

import io.qameta.allure.Attachment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IClass;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import static com.ui.api.qagenes.drivers.DriverManager.getDriver;

public class LoggingListener extends  TestListenerAdapter {

    private static final Logger LOG     = LogManager.getLogger (LoggingListener.class);

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    //Text attachments for Allure
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    //Text attachments for Allure
    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }

    //HTML attachments for Allure
    @Attachment(value = "{0}", type = "text/html")
    public static String attachHtml(String html) {
        return html;
    }

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
        Object testClass = tr.getInstance();


        //Allure ScreenShotRobot and SaveTestLog
        if (getDriver() != null) {
            System.out.println("Screenshot captured for test case:" + getTestMethodName(tr));
            saveScreenshotPNG(getDriver());
        }

        //Save a log on allure.
        saveTextLog(getTestMethodName(tr) + " failed and screenshot taken!");
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
