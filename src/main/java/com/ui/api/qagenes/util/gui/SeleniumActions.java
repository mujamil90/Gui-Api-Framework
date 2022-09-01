package com.ui.api.qagenes.util.gui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static com.ui.api.qagenes.drivers.DriverManager.getDriver;

public class SeleniumActions {
    private static final Logger LOG     = LogManager.getLogger (SeleniumActions.class);
    static Actions actions = new Actions(getDriver());

    public static void mouseHover(WebElement element){
        LOG.info("Ready for mouse hover on element : " + StringUtils.elementToString(element));
        actions.moveToElement(element);
        actions.click().build().perform();
        LOG.info("Mouse hover is done on element : " + StringUtils.elementToString(element));
    }
}
