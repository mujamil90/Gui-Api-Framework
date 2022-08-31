package com.ui.api.qagenes.util.gui;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static com.ui.api.qagenes.drivers.DriverManager.getDriver;

public class FileUploader {

    public static void uploadRandomImagedFile(WebElement fileElement) {
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        String activateField = "arguments[0].style.height='auto'; arguments[0].style.visibility='visible'; arguments[0].style.display='block';";
        executor.executeScript(activateField, fileElement);
        executor.executeScript(activateField, fileElement.findElement(By.tagName("input")));
        fileElement.findElement(By.tagName("input")).sendKeys(PathFinder.getRandomImage());
    }

    public void uploadImage(WebElement fileElement, String filePath) {
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        String activateField = "arguments[0].style.height='auto'; arguments[0].style.visibility='visible'; arguments[0].style.display='block';";
        executor.executeScript(activateField, fileElement);
        executor.executeScript(activateField, fileElement.findElement(By.tagName("input")));
        fileElement.findElement(By.tagName("input")).sendKeys(filePath);
    }
}
