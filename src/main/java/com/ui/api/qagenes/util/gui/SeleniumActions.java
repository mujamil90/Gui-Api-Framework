package com.ui.api.qagenes.util.gui;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static com.ui.api.qagenes.drivers.DriverManager.getDriver;

public class SeleniumActions {
    static Actions actions = new Actions(getDriver());

    public static void mouseHover(WebElement element){

        actions.moveToElement(element);
        actions.click().build().perform();

    }
}
