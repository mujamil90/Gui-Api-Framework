package com.ui.api.qagenes.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.ui.api.qagenes.util.gui.Helper.waitAndClickElement;
import static com.ui.api.qagenes.util.gui.SeleniumActions.mouseHover;
import static com.ui.api.qagenes.util.gui.SeleniumWaits.waitForElementToBeVisible;

public class AllTemplates extends BasePage {

    @FindBy(xpath = "(//div[@data-testid='popper-button']/../../..)[1]")
    WebElement firstTemplate;

    @FindBy(xpath = "(//div[@data-testid='popper-button']/../../..)[1]//a")
    WebElement editButton;




   public AllTemplates(WebDriver driver){
        super(driver);
    }

    public AllTemplates clickOnFirstTemplate(){
        waitForElementToBeVisible(firstTemplate);
        mouseHover(firstTemplate);
        waitAndClickElement(editButton);

        return this;

    }
}
