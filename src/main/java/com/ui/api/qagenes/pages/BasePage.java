package com.ui.api.qagenes.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.ui.api.qagenes.drivers.DriverManager.getDriver;
import static com.ui.api.qagenes.util.gui.Helper.enterText;
import static com.ui.api.qagenes.util.gui.Helper.waitAndClickElement;
import static com.ui.api.qagenes.util.gui.SeleniumWaits.waitForElementToBeVisible;
import static org.openqa.selenium.support.PageFactory.initElements;


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
    @FindBy(css = "div[class$='modalContainer']")
    WebElement registrationPopUp;

    @FindBy(css = "div[class$='modalContainer'] h3")
    List<WebElement> headersOnPopUp;

    @FindBy(css = "div[class$='modalContainer'] ul li")
    List<WebElement> presentationListPopUp;

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
        enterText(email, "mujamil87@gmail.com");
    }

    public void enterPassword(){
        enterText(password, "Picsart@123");
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
        return registrationPopUp.isDisplayed();
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
