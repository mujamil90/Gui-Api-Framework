package com.ui.api.qagenes.testdata;

import com.ui.api.qagenes.util.gui.PathFinder;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {


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
