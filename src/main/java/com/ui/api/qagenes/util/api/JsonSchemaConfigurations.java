package com.ui.api.qagenes.util.api;

import com.github.fge.jsonschema.SchemaVersion;
import com.github.fge.jsonschema.cfg.ValidationConfiguration;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.module.jsv.JsonSchemaValidatorSettings.settings;


public class JsonSchemaConfigurations {
    /**
     *  This function will set up the validation to always use the JSON schema version 4 and
     *  set up  global custom rules to validate JSON schema.
     *
     * @return will be Json factory instance with applied configurations.
     */
    public static JsonSchemaFactory getJsonSchemaConfigs(){
        JsonSchemaFactory jsonSchemaFactory = JsonSchemaFactory.newBuilder()
                .setValidationConfiguration(
                        ValidationConfiguration.newBuilder()
                                .setDefaultVersion(SchemaVersion.DRAFTV4).freeze())
                .freeze();
/**By default, the json-schema-validator runs checked validations on the JSON response String. This means that if the schema defines
      an array in Json then the validator will always be expecting an array as the value for odds, hence a response where odds is a String will fail validation. So
  if we would like to be less strict with our responses, we can add a global custom rule during validation with Setting and the validation check set to false. **/
        JsonSchemaValidator.settings = settings()
                .with().jsonSchemaFactory(jsonSchemaFactory)
                .and().with().checkedValidation(false);
        return jsonSchemaFactory;
    }
}
