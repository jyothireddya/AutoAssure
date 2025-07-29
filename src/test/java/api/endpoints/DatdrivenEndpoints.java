package api.endpoints;

import api.payload.DDPayload;
import api.utils.SpecBuilder;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class DatdrivenEndpoints {
	

    public static Response createUser(DDPayload payload) {
        return given()
                .spec(SpecBuilder.getRequestSpecDataDriven())
                .body(payload)
            .when()
                .post(Routes.PET_POST_URL);  // Only relative path needed
    }

    public static Response readUser(String userName) {
        return given()
                .spec(SpecBuilder.getRequestSpecDataDriven())
                .pathParam("username", userName)
            .when()
                .get(Routes.PET_GET_URL);
    }

    public static Response updateUser(String userName, DDPayload payload) {
        return given()
                .spec(SpecBuilder.getRequestSpecDataDriven())
                .pathParam("username", userName)
                .body(payload)
            .when()
                .put(Routes.PET_UPDATE_URL);
    }

    public static Response deleteUser(String userName) {
        return given()
                .spec(SpecBuilder.getRequestSpecDataDriven())
                .pathParam("username", userName)
            .when()
                .delete(Routes.PET_DELETE_URL);
    }


    }
