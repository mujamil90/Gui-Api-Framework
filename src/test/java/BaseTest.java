import com.ui.api.qagenes.enums.Browsers;
import com.ui.api.qagenes.pages.PageGenerator;
import com.ui.api.qagenes.testdata.JsonReader;
import com.ui.api.qagenes.testdata.PropertiesReader;
import com.ui.api.qagenes.util.gui.PlatformConstants;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import static com.ui.api.qagenes.drivers.DriverManager.*;
import static com.ui.api.qagenes.testdata.JsonReader.*;

public class BaseTest  {

    public PageGenerator page ;

    @BeforeMethod (alwaysRun = true)
    public void setup () {
        //Create a Chrome driver. All test classes use this.
        loadAllJsonData();
        createDriver(Browsers.valueOf(PlatformConstants.BROWSER));
        getDriver().manage().window().maximize();
        getDriver().get(getEnvironmentJsonNode()+"create");

        page = new PageGenerator(getDriver());

    }
    @AfterMethod (alwaysRun = true)
    public void teardown () {
        quitDriver();
    }
}
