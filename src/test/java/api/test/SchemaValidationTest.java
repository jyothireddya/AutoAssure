package api.test;

import org.testng.annotations.Test;

import api.endpoints.schemaendpoints;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class SchemaValidationTest {
	 @Test(priority = 1)
	    public void testSchemaValidation() {
	        Response response = schemaendpoints.SchemaValidation();

	        response
	            .then()

	            .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("JsonSchema.json"));

	        // Optional: print response
	        System.out.println(response.getBody().asPrettyString());
	    }

}
