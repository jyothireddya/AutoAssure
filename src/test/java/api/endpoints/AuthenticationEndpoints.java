package api.endpoints;

import static io.restassured.RestAssured.given;

import api.utils.SpecBuilder;
import io.restassured.response.Response;

public class AuthenticationEndpoints {
	

	public static Response basicAuthentication(String username, String password) {
        return given()
            .spec(SpecBuilder.basicAuthSpec(username, password))
            .when()
            .when().get("/basic-auth");
    }

    public static Response digestAuthentication(String username, String password) {
        return given()
            .spec(SpecBuilder.digestAuthSpec(username, password))
            .when()
            .when().get("/basic-auth");
    }

    

    public static Response preemptiveBasicAuthentication(String username, String password) {
        return given()
            .spec(SpecBuilder.preemptiveBasicAuthSpec(username, password))
            .when()
            .when().get("/basic-auth");
    }

    public static Response bearerTokenAuthentication(String token) {
        return given()
            .spec(SpecBuilder.bearerTokenSpec(token))
            .when()
            .get(Routes.github_get_url);
    }
    
    public static Response oauth2Authentication(String token) {
        return given()
            .spec(SpecBuilder.oauth2Spec(token))
            .when()
            .get(Routes.github_get_url);
    }

    public static Response apiKeyAuthentication(String apiKey) {
        return given()
            .spec(SpecBuilder.apiKeySpec(apiKey))
            .when()
            .get(Routes.openweather__get_url);
    }
}
