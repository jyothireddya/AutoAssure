package api.endpoints;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;
public class JsonPathEndpoints {
	
	    
	    public static Response getUsers() {
	        return given()
	                .when()
	                .get(Routes.Hamcrest_url);
	    }
}
