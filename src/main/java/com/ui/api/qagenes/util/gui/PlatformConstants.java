package com.ui.api.qagenes.util.gui;


import static com.ui.api.qagenes.testdata.JsonReader.getAccountDataJsonNode;
import static com.ui.api.qagenes.testdata.JsonReader.getTestDataJsonNode;
import static com.ui.api.qagenes.testdata.PropertiesReader.getProperty;
import static com.ui.api.qagenes.util.gui.CommonNodes.*;


public class PlatformConstants  {
    public static String BROWSER= getProperty("Browser");
    public static int MAX_TRY= Integer.parseInt(getProperty("maxRetryFailedTest"));
    public static int TIMEOUT= Integer.parseInt(getProperty("Timeout"));
    public static int MAX_WAIT= Integer.parseInt(getProperty("MaxWait"));
    public static int AVG_WAIT= Integer.parseInt(getProperty("AverageWait"));
    public static int MIN_WAIT= Integer.parseInt(getProperty("MinWait"));
    public static String SETTINGS_URL = getTestDataJsonNode(PARTIAL_URLS, SETTINGS_URLS);
    public static String CREATE_URL = getTestDataJsonNode(PARTIAL_URLS, CREATE_URLS);

    public static String REUSABLE_COMPONENTS_URL = getTestDataJsonNode(PARTIAL_URLS, REUSABLE_URLS);
    public static String UPLOAD_IMAGE_TEXT = getTestDataJsonNode(TEXTS, UPLOAD_TEXT);

    public static String EMAIL = getAccountDataJsonNode("email");
    public static String PASSWORD = getAccountDataJsonNode("password");

}
