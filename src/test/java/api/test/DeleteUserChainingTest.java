package api.test;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import api.endpoints.UserEndopints;
import io.restassured.response.Response;

public class DeleteUserChainingTest {
	   @Test
	    public void deleteUserTest(ITestContext context) {
	        int userId = (Integer) context.getSuite().getAttribute("User_Id");

	        Response response = UserEndopints.deleteUser(userId);
	        response.then().log().all();

	        Assert.assertEquals(response.getStatusCode(), 204, "❌ User was not deleted successfully");

	        System.out.println("✅ User with ID " + userId + " was deleted successfully.");
	    }

}
