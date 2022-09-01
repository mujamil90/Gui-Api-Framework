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

public class JsonSchemaTest {
    @BeforeClass
    public void setUp(){
        loadAllJsonData();
    }

   @Test
   public void testJsonSchemaReusableComponent(){

       given().
              baseUri(getEnvironmentJsonNode(API)).
               when().
               get(REUSABLE_COMPONENTS_URL)
               .then().assertThat()
               .body(JsonSchemaValidator.
                       matchesJsonSchemaInClasspath(REUSABLE_COMPONENTS_JSON));


    }


    @Test(expectedExceptions = AssertionError.class)
    public void testJsonSchemaWithInvalidDataType(){

        given().
                baseUri(getEnvironmentJsonNode(API)).
                when().
                get(REUSABLE_COMPONENTS_URL)
                .then().assertThat()
                .body(JsonSchemaValidator.
                        matchesJsonSchemaInClasspath(INVALID_REUSABLE_COMPONENTS_JSON));

    }

    @Test()
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
