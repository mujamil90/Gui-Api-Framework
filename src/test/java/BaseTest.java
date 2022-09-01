import com.ui.api.qagenes.enums.Browsers;
import com.ui.api.qagenes.pages.PageGenerator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.ui.api.qagenes.drivers.DriverManager.*;
import static com.ui.api.qagenes.testdata.JsonReader.getEnvironmentJsonNode;
import static com.ui.api.qagenes.testdata.JsonReader.loadAllJsonData;
import static com.ui.api.qagenes.util.gui.PlatformConstants.*;

public class BaseTest  {

    public PageGenerator page ;

    @BeforeMethod (alwaysRun = true)
    public void setup () {
        //Loading all Test and config data
        loadAllJsonData();
        //Create a Chrome driver. All test classes use this.
        createDriver(Browsers.valueOf(BROWSER));
        getDriver().manage().window().maximize();
        getDriver().get(getEnvironmentJsonNode()+CREATE_URL);
        // initializing page generator to create page objects in tests
        page = new PageGenerator(getDriver());

    }
    @AfterMethod (alwaysRun = true)
    public void teardown () {
        quitDriver();
    }
}
