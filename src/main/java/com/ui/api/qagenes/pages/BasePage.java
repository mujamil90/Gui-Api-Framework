package com.ui.api.qagenes.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import static com.ui.api.qagenes.util.gui.Helper.enterText;
import static com.ui.api.qagenes.util.gui.Helper.waitAndClickElement;
import static com.ui.api.qagenes.util.gui.PlatformConstants.EMAIL;
import static com.ui.api.qagenes.util.gui.PlatformConstants.PASSWORD;
import static com.ui.api.qagenes.util.gui.SeleniumWaits.waitForElementToBeVisible;


public class BasePage extends PageGenerator {
    @CacheLookup
    @FindBy(name = "username")
    WebElement email;
    @CacheLookup
    @FindBy(name = "password")
    WebElement password;

    @FindBy(css = "ul.bannerContent")
    WebElement allBanners;
    @CacheLookup
    @FindBy(css = "div[class^='formContainer']")
    WebElement registrationPopUp;

    @FindBy(css = "[data-test='login-button']")
    WebElement loginButton;

    @FindBy(css = "[data-test='login']")
    WebElement loginButtonOnPopUp;

    @FindBy(css = "[title='User avatar']")
    WebElement userAvatar;

    @FindBy(css = "[data-test='settings-button']")
    WebElement settingOption;

    public BasePage(WebDriver driver){
        super(driver);
   }
    public boolean checkPresenceOfRegistrationPopUp(){
        waitForElementToBeVisible(registrationPopUp);
        return registrationPopUp.isDisplayed();
    }

    public void enterEmail(){
        enterText(email, EMAIL);
    }

    public void enterPassword(){
        enterText(password, PASSWORD);
    }
    public void navigateToLoginPopUp(){
        waitForElementToBeVisible(loginButton);
        waitAndClickElement(loginButton);
    }

    public void clickLoginButton(){
        waitAndClickElement(loginButtonOnPopUp);
    }
    public void doLogin(){
        this.navigateToLoginPopUp();
        this.enterEmail();
        this.enterPassword();
        this.clickLoginButton();
        this.checkPresenceOfUserAvatar();

    }

    public boolean checkPresenceOfUserAvatar(){
        waitForElementToBeVisible(userAvatar);
        return userAvatar.isDisplayed();
    }

    public void clickUserAvatar(){
        waitAndClickElement(userAvatar);
    }

    public void clickSettingsOption(){
        waitAndClickElement(settingOption);
    }
    public void navigateToSettingPage(){
        this.clickUserAvatar();
        this.clickSettingsOption();

    }

}
