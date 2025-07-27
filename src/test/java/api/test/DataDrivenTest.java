package api.test;

import org.testng.annotations.Test;

import api.payload.DDPayload;
import api.utilities.DataProviderMethods;

import org.testng.Assert;

import api.endpoints.DatdrivenEndpoints;
import io.restassured.response.Response;

public class DataDrivenTest {
	

	 @Test(priority = 1, dataProvider = "Data", dataProviderClass = DataProviderMethods.class)
	    public void testPostUser(String userID, String userName, String fname, String lname, String useremail, String password, String phone) {

	        DDPayload userPayload = new DDPayload();
	        userPayload.setId(Integer.parseInt(userID));
	        userPayload.setUsername(userName);
	        userPayload.setFirstName(fname);
	        userPayload.setLastName(lname);
	        userPayload.setEmail(useremail);
	        userPayload.setPassword(password);
	        userPayload.setPhone(phone);

	        Response response = DatdrivenEndpoints.createUser(userPayload);
	        Assert.assertEquals(response.getStatusCode(), 200);
	    }

	    @Test(priority = 2, dataProvider = "UserNames", dataProviderClass =DataProviderMethods.class)
	    public void testDeleteUserByName(String userName) {
	        Response response = DatdrivenEndpoints.deleteUser(userName);
	        Assert.assertEquals(response.getStatusCode(), 200);
	    }
	}


