package com.ui.api.qagenes.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.ui.api.qagenes.drivers.DriverManager.getDriver;
import static com.ui.api.qagenes.util.gui.FileUploader.uploadRandomImagedFile;
import static com.ui.api.qagenes.util.gui.Helper.waitAndClickElement;
import static com.ui.api.qagenes.util.gui.PlatformConstants.SETTINGS_URL;
import static com.ui.api.qagenes.util.gui.SeleniumWaits.*;

public class SettingsPage extends BasePage{

    @FindBy(css = "label[for='upload-avatar']")
    WebElement uploadImageButton;

    @FindBy(css = "[data-test='save-changes-button']")
    WebElement saveButton;

    @FindBy(css = "p[class^='user-avatar-description']")
    WebElement textForProfileImage;

    public SettingsPage(WebDriver driver) {
        super(driver);
    }

    public String getCurrentUrlOfPage(){
        waitForPageToContainsUrl(SETTINGS_URL);
        return getDriver().getCurrentUrl();
    }

    public SettingsPage uploadImage(){
        waitForElementToBeVisible(uploadImageButton);
        uploadRandomImagedFile(uploadImageButton);
        return this;
    }

    public SettingsPage clickSaveButton(){
        waitAndClickElement(saveButton);
        return this;
    }

    public boolean isSaveButtonDisabled(){
        waitForElementToBeDisabled(saveButton);
        return saveButton.isEnabled();
    }

    public String getTextOfUploadImage(){
        waitForElementToBeVisible(textForProfileImage);
        return textForProfileImage.getText();
    }
}
