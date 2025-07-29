package api.utils;


import api.endpoints.Routes;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecBuilder {
	 public static RequestSpecification getRequestSpec() {
	        return new RequestSpecBuilder()
	                .setBaseUri(Routes.post_url )
	                .addHeader("Authorization", "Bearer " + AuthUtil.TOKEN)
	                .setContentType(ContentType.JSON)
	                .setAccept(ContentType.JSON)
	                .build();
	    }

	    public static ResponseSpecification getResponseSpec() {
	        return new ResponseSpecBuilder()
	                .expectContentType(ContentType.JSON)
	                .build();
	    }
	    
	    public static RequestSpecification schemaSpec() {
	        return new RequestSpecBuilder()
	                .setBaseUri(Routes.BASE_SCHEMA_URL)
	                .setBasePath(Routes.SCHEMA_USERS_ENDPOINT)
	                .addHeader("Content-Type", "application/json")
	                .build();
	    }
	    
	    public static RequestSpecification getRequestSpecDataDriven() {
	        return new RequestSpecBuilder()
	                .setBaseUri(Routes.PETSTORE_BASE_URL)
	                .addHeader("Content-Type", "application/json")
	                .build();
	    }
	    
	    public static RequestSpecification basicAuthSpec(String username, String password) {
	        return new RequestSpecBuilder()
	        		  .setBaseUri(Routes.POSTMAN_BASE_URL) 
	            .setAuth(io.restassured.RestAssured.basic(username, password))
	            .build();
	    }

	    public static RequestSpecification digestAuthSpec(String username, String password) {
	        return new RequestSpecBuilder()
	        		  .setBaseUri(Routes.POSTMAN_BASE_URL) 
	            .setAuth(io.restassured.RestAssured.digest(username, password))
	            .build();
	    }

	    public static RequestSpecification preemptiveBasicAuthSpec(String username, String password) {
	        return new RequestSpecBuilder()
	        		  .setBaseUri(Routes.POSTMAN_BASE_URL) 
	        		 .setAuth(io.restassured.RestAssured.preemptive().basic(username, password))
	            .build();
	    }

	    public static RequestSpecification bearerTokenSpec(String token) {
	        return new RequestSpecBuilder()
	            .setBaseUri(Routes.github_url)
	            .addHeader("Authorization", "Bearer " + token)
	            .build();
	    }
	    
	    public static RequestSpecification oauth2Spec(String token) {
	        return new RequestSpecBuilder()
	            .setBaseUri(Routes.github_url)
	            .setAuth(io.restassured.RestAssured.oauth2(token))
	            .build();
	    }

	    public static RequestSpecification apiKeySpec(String apiKey) {
	        return new RequestSpecBuilder()
	            .setBaseUri(Routes.openweather_url)
	            .addQueryParam("appid", apiKey)
	            .build();
	    }

	    
	    public static RequestSpecification getRequestSpecJosinPath() {
	        return new RequestSpecBuilder()
	            .setBaseUri(Routes.Hamcrest_base_url)
	            .setContentType("application/json")
	            .build();
	    }
}
