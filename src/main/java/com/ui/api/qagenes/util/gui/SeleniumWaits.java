package com.ui.api.qagenes.util.gui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.NoSuchElementException;

import static com.ui.api.qagenes.drivers.DriverManager.getDriver;
import static com.ui.api.qagenes.util.gui.PlatformConstants.MAX_WAIT;
import static com.ui.api.qagenes.util.gui.PlatformConstants.MIN_WAIT;


public class SeleniumWaits {

    private static final Logger LOG = LogManager.getLogger(SeleniumWaits.class);
    private static FluentWait getFluentWait()
    {
        LOG.info("Setting up Fluent wait...");
        FluentWait fluentWait = new FluentWait(getDriver())
                .withTimeout(Duration.ofMillis(MAX_WAIT))
                .pollingEvery(Duration.ofMillis(MIN_WAIT))
                .ignoring(NoSuchElementException.class);

        return fluentWait;
    }

    public  static void waitForElementToBeVisible(WebElement element)
    {
        LOG.info("Waiting for web element : " + StringUtils.elementToString(element) +" to be visible");
        getFluentWait().until(ExpectedConditions.visibilityOf(element));

    }
    public  static void waitForElementToBeClickable(WebElement element)
    {
        LOG.info("Waiting for web element : " + StringUtils.elementToString(element) +" to be clickable");
        getFluentWait().until(ExpectedConditions.elementToBeClickable(element));

    }

    public  static void waitForElementToBeDisabled(WebElement element) {
        LOG.info("Waiting for web element : " + StringUtils.elementToString(element) + " to be disabled");
        getFluentWait().until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(element)));
    }

    public  static void waitForPageToContainsUrl(String url) {
        LOG.info("Waiting for page : " + getDriver().getTitle() + " to be have in '" + url+ "' url.");
        getFluentWait().until(ExpectedConditions.urlContains(url));
    }
}
