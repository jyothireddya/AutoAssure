package api.endpoints;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class HamcrestEndpoints {

    public static Response getUsers() {
        return given()
                   .when()
                   .get(Routes.Hamcrest_url);
    }

}
