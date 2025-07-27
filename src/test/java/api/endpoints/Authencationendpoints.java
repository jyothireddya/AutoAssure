package api.endpoints;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;

public class Authencationendpoints {
	

    public static Response basicAuthentication(String username, String password) {
        Response res = given()
                .auth().basic(username, password)
            .when()
                .get(Routes.postman_url);

          return res;
    }

    public static Response digestAuthentication(String username, String password) {
        Response res = given()
                .auth().digest(username, password)
            .when()
                .get(Routes.postman_url);

        return res;
    }

    public static Response preemptiveBasicAuthentication(String username, String password) {
        Response res = given()
                .auth().preemptive().basic(username, password)
            .when()
                .get(Routes.postman_url);

        return res;
    }

    public static Response bearerTokenAuthentication(String token) {
        Response res = given()
                .header("Authorization", "Bearer " + token)
           .when()
                .get(Routes.github_url);  // better endpoint for checking user

        return res;
    }

    public static Response oauth2Authentication(String token) {
        Response res = given()
                .auth().oauth2(token)
        .when()
                .get(Routes.github_url);

        return res;
    }

    public static Response apiKeyAuthentication(String apiKey) {
        Response res = given()
                .queryParam("appid", apiKey)
        .when()
                .get(Routes.openweather_url);

        return res;
    }

}
