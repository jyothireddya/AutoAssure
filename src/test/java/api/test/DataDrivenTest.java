package api.test;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

import api.endpoints.DatdrivenEndpoints;
import api.payload.DDPayload;
import api.utils.DataProviderMethods;
import io.restassured.response.Response;

public class DataDrivenTest {
	

	 @Test( priority = 1, 
		        dataProvider = "Data", 
		        dataProviderClass = DataProviderMethods.class,
		        groups = {"datadriven", "regression", "functionality"})
	    public void testCreateAndDeleteUser(String userID, String userName, String firstName,
	                                        String lastName, String email, String password, String phone) {

	        DDPayload userPayload = new DDPayload();
	        userPayload.setId(Integer.parseInt(userID));
	        userPayload.setUsername(userName);
	        userPayload.setFirstName(firstName);
	        userPayload.setLastName(lastName);
	        userPayload.setEmail(email);
	        userPayload.setPassword(password);
	        userPayload.setPhone(phone);
	        userPayload.setUserStatus(1);

	        // Create user
	        Response createResponse = DatdrivenEndpoints.createUser(userPayload);
	        createResponse.then().log().all().statusCode(200);

	        // Delete user
	        Response deleteResponse = DatdrivenEndpoints.deleteUser(userName);
	        deleteResponse.then().log().all()
	                .statusCode(200)
	                .body("message", containsString(userName));
	    }

	 @Test( priority = 2,
		        dataProvider = "UserNames",
		        dataProviderClass = DataProviderMethods.class,
		        groups = {"datadriven", "sanity", "regression"}
		    )
	    public void testDeleteUserByName(String userName) {

	        Response response = DatdrivenEndpoints.deleteUser(userName);

	        response.then().log().all()
	                .statusCode(anyOf(equalTo(200), equalTo(404)));
	    }
	}


