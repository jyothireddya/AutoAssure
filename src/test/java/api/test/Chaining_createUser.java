package api.test;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;


import com.github.javafaker.Faker;

import api.endpoints.createuserendopintd;
import api.payload.User;
import io.restassured.response.Response;

public class Chaining_createUser {
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
	public void CreateUser(ITestContext context) {
		setupData(); 
		Response res=createuserendopintd.createUser(userPayload);
		res.then().log().all();
		
		
		Assert.assertEquals(res.getStatusCode(), 201);
		
		
		  int userId = res.jsonPath().getInt("id");
		    System.out.println("Created User ID: " + userId);
		    context.getSuite().setAttribute("User_Id", userId);
	}

}
