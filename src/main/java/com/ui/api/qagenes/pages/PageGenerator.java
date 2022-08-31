package com.ui.api.qagenes.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class PageGenerator {
     WebDriver driver;
    //Constructor
    public PageGenerator(WebDriver driver){
        this.driver = driver;
    }
    //JAVA Generics to Create and return a New Page
    public  <TPage extends BasePage> TPage getInstanceOfPage (Class<TPage> pageClass) {
        try {
            //Initialize the Page with its elements and return it.
            return PageFactory.initElements(driver,  pageClass);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
