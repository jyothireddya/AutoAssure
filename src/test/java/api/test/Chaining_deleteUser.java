package api.test;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import api.endpoints.createuserendopintd;
import io.restassured.response.Response;

public class Chaining_deleteUser {
	@Test
	public void deleteUser(ITestContext context) {
		
		  int userId = (Integer) context.getSuite().getAttribute("User_Id");
		    Response res = createuserendopintd.deleteUser(userId);
		    res.then().log().all();
		    Assert.assertEquals(res.getStatusCode(), 204);
	}

}
