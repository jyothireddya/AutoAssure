package api.test;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import api.endpoints.UserEndopints;
import io.restassured.response.Response;

public class ReadUserChainingTest {
    @Test
    public void readUserTest(ITestContext context) {

        int userId = (Integer) context.getSuite().getAttribute("User_Id");

        Response response = UserEndopints.readUser(userId);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200, "❌ Failed to fetch user details");

        System.out.println("✅ User with ID " + userId + " fetched successfully.");
    }
}
