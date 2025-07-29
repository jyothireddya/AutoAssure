package api.test;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndopints;
import api.payload.User;
import io.restassured.response.Response;

public class UpdateUserChainingTest {

    Faker faker = new Faker();
    User userPayload;

    public void setupTestData() {
        userPayload = new User();
        userPayload.setName(faker.name().fullName());
        userPayload.setGender("male");
        userPayload.setEmail(faker.internet().emailAddress());
        userPayload.setStatus("inactive"); // Updating status to show difference
    }

    @Test
    public void updateUserTest(ITestContext context) {
        setupTestData();

        int userId = (Integer) context.getSuite().getAttribute("User_Id");

        Response response = UserEndopints.updateUser(userId, userPayload);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200, "❌ User was not updated successfully");

        // Optionally verify updated values
        Assert.assertEquals(response.jsonPath().getString("name"), userPayload.getName(), "❌ Name not updated");
        Assert.assertEquals(response.jsonPath().getString("status"), userPayload.getStatus(), "❌ Status not updated");

        System.out.println("✅ User with ID " + userId + " was updated successfully.");
    }

}
