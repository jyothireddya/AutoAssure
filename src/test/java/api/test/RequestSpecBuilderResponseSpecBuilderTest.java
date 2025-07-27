package api.test;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.RequestSpecBuilderResponseSpecBuilderendpoints;
import io.restassured.response.Response;

public class RequestSpecBuilderResponseSpecBuilderTest {
	Faker faker;
	

	@BeforeClass
	public void setupData() { 
		 faker=new Faker();
		 JSONObject userData = new JSONObject();
	        userData.put("name", faker.name().fullName());
	        userData.put("gender", "male");
	        userData.put("email", faker.internet().emailAddress());
	        userData.put("status", "active");
		
		
	}
	 
	 @Test
	    public void createUser() {
			setupData(); 
			Response res=RequestSpecBuilderResponseSpecBuilderendpoints.getSchemaValidatedResponse();
			res.then().log().all();
		 
			Assert.assertEquals(res.getStatusCode(), 200);
		 
	 }


}
