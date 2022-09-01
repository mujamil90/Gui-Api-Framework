package com.ui.api.qagenes.util.gui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static com.ui.api.qagenes.drivers.DriverManager.getDriver;

public class FileUploader {
    private static final Logger LOG     = LogManager.getLogger (FileUploader.class);

    public static void uploadRandomImagedFile(WebElement fileElement) {
        LOG.info("Ready to upload file on element : " + StringUtils.elementToString(fileElement) + "...");
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        String activateField = "arguments[0].style.height='auto'; arguments[0].style.visibility='visible'; arguments[0].style.display='block';";
        executor.executeScript(activateField, fileElement);
        executor.executeScript(activateField, fileElement.findElement(By.tagName("input")));
        fileElement.findElement(By.tagName("input")).sendKeys(PathFinder.getRandomImage());
        LOG.info("File is uploaded for  element : " + StringUtils.elementToString(fileElement));
    }

    public void uploadImage(WebElement fileElement, String filePath) {
        LOG.info("Ready to upload file on element : " + StringUtils.elementToString(fileElement) + "...");
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        String activateField = "arguments[0].style.height='auto'; arguments[0].style.visibility='visible'; arguments[0].style.display='block';";
        executor.executeScript(activateField, fileElement);
        executor.executeScript(activateField, fileElement.findElement(By.tagName("input")));
        fileElement.findElement(By.tagName("input")).sendKeys(filePath);
        LOG.info("File "+filePath+" is uploaded for  element : " + StringUtils.elementToString(fileElement));
    }
}
