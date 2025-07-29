package api.endpoints;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import api.payload.User;
import api.utils.SpecBuilder;


public class UserEndopints {
	public static Response createUser(User payload) {
        return given()
                .spec(SpecBuilder.getRequestSpec())
                .body(payload)
            .when()
                .post(Routes.post_url);
    }

    public static Response readUser(int id) {
        return given()
                .spec(SpecBuilder.getRequestSpec())
                .pathParam("id", id)
            .when()
                .get(Routes.get_url);
    }

    public static Response updateUser(int id, User payload) {
        return given()
                .spec(SpecBuilder.getRequestSpec())
                .pathParam("id", id)
                .body(payload)
            .when()
                .put(Routes.update_url);
    }

    public static Response deleteUser(int id) {
        return given()
                .spec(SpecBuilder.getRequestSpec())
                .pathParam("id", id)
            .when()
                .delete(Routes.delete_url);
    }
 
	
}