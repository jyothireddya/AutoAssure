package api.test;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;


import com.github.javafaker.Faker;

import api.endpoints.UserEndopints;
import api.payload.User;
import io.restassured.response.Response;

public class UserChainingTest {

    Faker faker = new Faker();
    User userPayload;

    public void setupTestData() {
        userPayload = new User();
        userPayload.setName(faker.name().fullName());
        userPayload.setGender("male");
        userPayload.setEmail(faker.internet().emailAddress());
        userPayload.setStatus("active");
    }

    @Test
    public void createUserTest(ITestContext context) {
        setupTestData();

        Response response = UserEndopints.createUser(userPayload);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 201, "User creation failed");

        int userId = response.jsonPath().getInt("id");
        System.out.println("✅ Created User ID: " + userId);

        // Pass user ID to next test via context
        context.getSuite().setAttribute("User_Id", userId);
    }

}
