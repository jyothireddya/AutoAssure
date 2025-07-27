package api.endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;


import api.payload.User;


public class createuserendopintd {
	public static Response createUser(User payload) {

		String bearreToken ="1eb9fce871bbf40fbf59740c5941c6b8174a0fe5decef67377d61c039ff6e354";
        Response res = given()
        		.header("Authorization", "Bearer " + bearreToken)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
            .when()
                .post(Routes.post_url);
    	
	
        return res;
    }
	
	public static Response readUser(int id) {
		String bearreToken ="1eb9fce871bbf40fbf59740c5941c6b8174a0fe5decef67377d61c039ff6e354";
        Response res = given()
        		.header("Authorization", "Bearer " + bearreToken)
                .pathParam("id", id)
            .when()
                .get(Routes.get_url);

        return res;
    }

    public static Response updateUser(int id,User payload) {
    
    	String bearreToken ="1eb9fce871bbf40fbf59740c5941c6b8174a0fe5decef67377d61c039ff6e354";
        Response res = given()
        		.header("Authorization", "Bearer " + bearreToken)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("id", id)
                .body(payload)
            .when()
                .put(Routes.update_url);

        return res;
    }

    public static Response deleteUser(int id) {
    	String bearreToken ="1eb9fce871bbf40fbf59740c5941c6b8174a0fe5decef67377d61c039ff6e354";
    	
        Response res = given()
        		.header("Authorization", "Bearer " + bearreToken)
                .pathParam("id", id)
            .when()
                .delete(Routes.delete_url);

        return res;
    }

 
	
}