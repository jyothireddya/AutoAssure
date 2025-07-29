package api.endpoints;



import api.utils.SpecBuilder;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SchemaEndpoints {



    public static Response getUsersForSchemaValidation() {
        return RestAssured.given()
                .spec(SpecBuilder.schemaSpec())
                .when()
                .get();
    }
	 
}
