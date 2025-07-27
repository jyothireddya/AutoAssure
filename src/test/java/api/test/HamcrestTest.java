package api.test;

import org.testng.annotations.Test;

import api.endpoints.HamcrestEndpoints;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

public class HamcrestTest {
	 @Test
	    public void validateUserListResponse() {
	        Response response = HamcrestEndpoints.getUsers();

	        response.then()
	                .statusCode(200)
	                .body("page", equalTo(2))
	                .body("data", not(empty()))
	                .body("data[0].email", containsString("@reqres.in"))
	                .body("data.size()", greaterThan(1))
	                .body("data[0].first_name", notNullValue())
	                .log().all();
	    }

}
