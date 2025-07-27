package api.endpoints;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;

public class schemaendpoints {


	 public static Response SchemaValidation() {
	   Response res = given()

		
	   .when()
	   .get(Routes.Schema_requers_url);
	   return res;

}}
