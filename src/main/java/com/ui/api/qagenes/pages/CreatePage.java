package com.ui.api.qagenes.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static com.ui.api.qagenes.util.gui.Helper.waitAndClickElement;

public class CreatePage extends BasePage{
    @FindBy(css = "[data-testid='create-search-button']")
    WebElement newProjectButton;

    @FindBy(css = "[data-testid='create-upload-button']")
    WebElement uploadButton;

    @FindBy(css = "[data-test='see-all-button']")
    WebElement allTemplatesLink;
    @FindBy(id = "onetrust-accept-btn-container")
    WebElement acceptCookies;

    public CreatePage(WebDriver driver){
        super(driver);

    }

    public CreatePage clickNewProject(){
        waitAndClickElement(newProjectButton);
        return this;
    }

    public CreatePage clickUploadButton(){
        waitAndClickElement(uploadButton);
        return this;
    }
    public CreatePage acceptCookies(){
        waitAndClickElement(acceptCookies);
        return this;
    }

    public CreatePage clickSeeAllTemplatesLink(){
        waitAndClickElement(allTemplatesLink);
        return this;
    }

}
