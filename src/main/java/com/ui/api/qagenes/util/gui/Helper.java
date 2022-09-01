package com.ui.api.qagenes.util.gui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import static com.ui.api.qagenes.util.gui.SeleniumWaits.waitForElementToBeClickable;
import static com.ui.api.qagenes.util.gui.SeleniumWaits.waitForElementToBeVisible;


public class Helper {

    private static final Logger LOG = LogManager.getLogger(SeleniumWaits.class);

    public static void waitAndClickElement(WebElement element){
        waitForElementToBeClickable(element);
        LOG.info("Ready to click on web element : " + StringUtils.elementToString(element));
        element.click();
        LOG.info("clicked on web element : " + StringUtils.elementToString(element) +" to be visible");
    }

    public static void enterText(WebElement element, String text){
        waitForElementToBeVisible(element);
        LOG.info("Ready to type "+text+" in web element : " + StringUtils.elementToString(element));
        element.sendKeys(text);
        LOG.info("sent keys "+ text+" to web element : " + StringUtils.elementToString(element) +" to be visible");
    }
}
