package api.test;

import org.testng.annotations.Test;

import api.endpoints.SchemaEndpoints;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import static org.hamcrest.MatcherAssert.assertThat;

public class SchemaValidationTest {
 
	 @Test(priority = 1, groups = {"sanity", "regression", "schema", "functionality"})
    public void testJsonSchemaValidation() {
        Response response = SchemaEndpoints.getUsersForSchemaValidation();

        // Print formatted response
        System.out.println("Response Body:");
        System.out.println(response.getBody().asPrettyString());

        // Validate against JSON schema 
        response.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("JsonSchema.json"));

        // Optional Hamcrest validation
        assertThat("Status code is not 200", response.getStatusCode() == 200);
    }



}
