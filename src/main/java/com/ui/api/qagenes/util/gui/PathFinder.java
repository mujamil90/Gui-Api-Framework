package com.ui.api.qagenes.util.gui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.LocalFileDetector;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ThreadLocalRandom;

public class PathFinder {

    private static final Logger LOG     = LogManager.getLogger (PathFinder.class);
   static String USER_DIR = System.getProperty("user.dir");
    private static String getProjectResources()
    {
        LOG.info("Setting up path for source folder...");
        Path path = Paths.get(USER_DIR);
        return path+ File.separator +"src" + File.separator;
    }
    private static String getMainResources()
    {
        LOG.info("Setting up path for resource folder in main...");
        return getProjectResources() + "main" + File.separator + "resources" +File.separator;
    }

    private static String getTestResources()
    {
        LOG.info("Setting up path for resource folder in test...");
        return getProjectResources() + "test" + File.separator + "resources" +File.separator;
    }
   public static String getImagePath()
   {
       LOG.info("Setting up path for test images...");
       return getTestResources() + "images" + File.separator;
   }

    public static String getEnvironmentJsonFile()
    {
        LOG.info("Setting up path for environment.json file...");
        return getMainResources() + File.separator + "environments.json";
    }

    public static String getTestDataJsonFile()
    {
        LOG.info("Setting up path for testdata.json file...");
        return getTestResources() + File.separator + "testdata" + File.separator + "testdata.json";
    }

    public static String getTestPropertiesFile()
    {
        LOG.info("Setting up path for config.properties file...");
        return getTestResources() + File.separator + "Config.properties";
    }
    public static String getAccountDataJsonFile(String environment)
    {
        LOG.info("Setting up path for AccountData.json file...");
        return getTestResources() + File.separator + "accountdata" + File.separator + environment+"AccountData.json";
    }
    public static String getRandomImage() {
        LOG.info("Setting up path for test image file...");
        String path = new File(getImagePath()).getAbsolutePath() + "/image"
                + ThreadLocalRandom.current().nextInt(1, 5) + ".png";
        LocalFileDetector detector = new LocalFileDetector();
        File file = detector.getLocalFile(path);
        return file.getAbsolutePath();
    }


}
