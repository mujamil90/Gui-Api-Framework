package com.ui.api.qagenes.testdata;

import com.ui.api.qagenes.util.gui.PathFinder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

    private static final Logger LOG     = LogManager.getLogger (Properties.class);
  public static Properties prop ;

     public static Properties loadPropertiesFile() {

        try (InputStream input = new FileInputStream(PathFinder.getTestPropertiesFile())) {
             prop = new Properties();
            // load a properties file
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return prop;
    }

   public static String getProperty(String key){
       return prop.getProperty(key);
   }

}
