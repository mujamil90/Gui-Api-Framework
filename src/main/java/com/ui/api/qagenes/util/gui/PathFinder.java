package com.ui.api.qagenes.util.gui;

import org.openqa.selenium.remote.LocalFileDetector;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ThreadLocalRandom;

public class PathFinder {


   static String USER_DIR = System.getProperty("user.dir");
    private static String getProjectResources()
    {
        Path path = Paths.get(USER_DIR);
        return path+ File.separator +"src" + File.separator;
    }
    private static String getMainResources()
    {
        return getProjectResources() + "main" + File.separator + "resources" +File.separator;
    }

    private static String getTestResources()
    {
        return getProjectResources() + "test" + File.separator + "resources" +File.separator;
    }
   public static String getImagePath()
   {
       return getTestResources() + "images" + File.separator;
   }

    public static String getEnvironmentJsonFile()
    {
        return getMainResources() + File.separator + "environments.json";
    }

    public static String getTestDataJsonFile()
    {
        return getTestResources() + File.separator + "testdata" + File.separator + "testdata.json";
    }

    public static String getTestPropertiesFile()
    {
        return getTestResources() + File.separator + "Config.properties";
    }

    public static String getAccountDataJsonFile(String environment)
    {
        return getTestResources() + File.separator + "accountdata" + File.separator + environment+"AccountData.json";
    }
    public static String getRandomImage() {
        String path = new File(getImagePath()).getAbsolutePath() + "/image"
                + ThreadLocalRandom.current().nextInt(1, 5) + ".png";
        LocalFileDetector detector = new LocalFileDetector();
        File file = detector.getLocalFile(path);
        return file.getAbsolutePath();
    }


}
