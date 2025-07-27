package api.test;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.createuserendopintd;
import api.payload.User;
import io.restassured.response.Response;

public class Chaining_UpdateUser {
	Faker faker;
	User userPayload;

	
	public void setupData() { 
		 faker=new Faker();
		userPayload=new User();
		
		userPayload.setName(faker.name().fullName());
		userPayload.setGender("male");
		userPayload.setEmail(faker.internet().emailAddress());
		userPayload.setStatus("active");
		
		
	}
	 
	@Test
	public void updateUser(ITestContext context) {
		   setupData(); // New payload to update
		    int userId = (Integer) context.getSuite().getAttribute("User_Id");
		    Response res = createuserendopintd.updateUser(userId, userPayload);
		    res.then().log().all();
		    Assert.assertEquals(res.getStatusCode(), 200);
	}

}
