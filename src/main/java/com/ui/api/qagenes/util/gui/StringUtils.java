package com.ui.api.qagenes.util.gui;

import org.openqa.selenium.WebElement;

public class StringUtils {

    //This function will give only locator as string for logging purpose from locator object templete e.g.
    // '[[ChromeDriver: chrome on MAC (a58b8e9879020bbf8deae5d305c57d5b)] -> id: onetrust-accept-btn-container]'
    public static String elementToString(WebElement element)
    {
        return (element==null) ? "Element is not available" : element.toString().replaceAll(".*->", "");
    }

}
