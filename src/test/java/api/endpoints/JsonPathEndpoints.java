package api.endpoints;

import static io.restassured.RestAssured.given;

import api.utils.SpecBuilder;
import io.restassured.response.Response;
public class JsonPathEndpoints {
		    
	    
	    public static Response getUsers() {
	        return given()
	            .spec(SpecBuilder.getRequestSpecJosinPath())
	            .when()
	            .get("/users?page=2");
	    }
}
