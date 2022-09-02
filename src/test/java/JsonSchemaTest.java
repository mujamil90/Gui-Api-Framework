import io.qameta.allure.*;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import static com.ui.api.qagenes.testdata.JsonReader.getEnvironmentJsonNode;
import static com.ui.api.qagenes.testdata.JsonReader.loadAllJsonData;
import static com.ui.api.qagenes.util.api.JsonSchemaConfigurations.getJsonSchemaConfigs;
import static com.ui.api.qagenes.util.gui.CommonNodes.*;
import static com.ui.api.qagenes.util.gui.PlatformConstants.REUSABLE_COMPONENTS_URL;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidatorSettings.settings;
//@Listeners({LoggingListener.class })
@Epic("Tests for Reusable components schema")
@Feature("Reusable components's schema validation")
public class JsonSchemaTest {
    @BeforeClass
    public void setUp(){
        loadAllJsonData();
    }

    @Test(priority = 0, description = "Verify Json schema for reusable component request")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Description: Validating json schema against json response body for reusable component")
    @Story("As a user, I want to validate Json schema for reusable component request")
   public void testJsonSchemaReusableComponent(){

       given().
              baseUri(getEnvironmentJsonNode(API)).
               when().
               get(REUSABLE_COMPONENTS_URL)
               .then().assertThat()
               .body(JsonSchemaValidator.
                       matchesJsonSchemaInClasspath(REUSABLE_COMPONENTS_JSON));


    }

    @Test(expectedExceptions = AssertionError.class, priority = 0, description = "Verify  invalid Json schema for reusable component request")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Description: Validating invalid json schema against json response body for reusable component")
    @Story("As a user, I want to validate invalid Json schema for reusable component request")
    public void testJsonSchemaWithInvalidDataType(){

        given().
                baseUri(getEnvironmentJsonNode(API)).
                when().
                get(REUSABLE_COMPONENTS_URL)
                .then().assertThat()
                .body(JsonSchemaValidator.
                        matchesJsonSchemaInClasspath(INVALID_REUSABLE_COMPONENTS_JSON));

    }

    @Test(priority = 0, description = "Verify  Json schema for specific schema version against reusable component request")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description: Validating  json schema for specific schema version against json response body for reusable component")
    @Story("As a user, I want to validate  Json schema for specific schema version against reusable component request")
    public void testJsonSchemaWithSpecificSchemaVersion(){

        given().
                baseUri(getEnvironmentJsonNode(API)).
                when().
                get(REUSABLE_COMPONENTS_URL)
                .then().assertThat()
                .body(JsonSchemaValidator.
                        matchesJsonSchemaInClasspath(REUSABLE_COMPONENTS_JSON).using(getJsonSchemaConfigs()));

    }

    @Ignore
    @Test()
    public void testJsonSchemaWithSpecificSchemaWithLessRestriction(){

        given().
                baseUri(getEnvironmentJsonNode(API)).
                when().
                get(REUSABLE_COMPONENTS_URL)
                .then().assertThat()
                .body(JsonSchemaValidator.
                        matchesJsonSchemaInClasspath(REUSABLE_COMPONENTS_JSON).using(settings().with().checkedValidation(false)));

    }
}
