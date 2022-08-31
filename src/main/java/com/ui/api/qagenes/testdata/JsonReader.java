package com.ui.api.qagenes.testdata;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ui.api.qagenes.drivers.DriverManager;
import com.ui.api.qagenes.util.gui.PathFinder;
import com.ui.api.qagenes.util.gui.PlatformConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mozilla.javascript.tools.shell.Environment;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.Properties;

public class JsonReader {
    private static Reader reader;
    public static JsonNode environmentJsonNode, accountDataJsonNode, testDataJsonNode;
    private static final Logger LOG     = LogManager.getLogger (DriverManager.class);

     public static void loadAllJsonData(){
        LOG.info("All Json and Properties file are ready to load");
        PropertiesReader.loadPropertiesFile();
        accountDataJsonNode = loadAccountDataJson();
        environmentJsonNode = getJsonNode(PathFinder.getEnvironmentJsonFile());
        testDataJsonNode = getJsonNode(PathFinder.getTestDataJsonFile());
        LOG.info("All Json and Properties file are loaded");

    }

    private static JsonNode getJsonNode(String filePath) {
        JsonNode jsonNode = null;
        try {
            // create a reader
            reader = Files.newBufferedReader(Paths.get(filePath));
            //create ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();
            //read json file into tree mode
              jsonNode = objectMapper.readTree(reader);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            //close reader
            try {
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return jsonNode;
    }



    public  static String getEnvironmentJsonNode(){
        JsonNode host = environmentJsonNode.path(PropertiesReader.getProperty("Environment"));
        return host.path("url").asText();
    }

    public  static String getAccountDataJsonNode(String key){
        JsonNode host = accountDataJsonNode.path("USER_ACCOUNT");
        return host.path(key).asText();
    }
    public  static String getTestDataJsonNode(String mainNode, String childNode){
        JsonNode host = testDataJsonNode.path(mainNode);
        return host.path(childNode).asText();
    }
    public static JsonNode loadAccountDataJson() {
        JsonNode node = null;
        String envName = PropertiesReader.getProperty("Environment");
        if (isDesiredEnvironment(envName))
               node =  getJsonNode(PathFinder.getAccountDataJsonFile(envName));
        return node;
    }
    private static boolean isDesiredEnvironment(String environment)
    {
        String [] acceptedEnvironments = {"DEMO", "QA", "LOCALHOST", "PRODUCTION", "DEV"};
        boolean isValid = Arrays.stream(acceptedEnvironments).parallel().anyMatch(environment::equals);
         if(isValid) {
             return true;
         }
         else {
             throw new InvalidParameterException("[FAIL] >"+environment+"< Defined environment is not correct. Use \"DEMO\", \"QA\", \"LOCALHOST\", \"PRODUCTION\", \"DEV\" instead.");
         }
    }
}

