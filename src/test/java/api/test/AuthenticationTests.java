package api.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.testng.annotations.Test;

import api.endpoints.AuthenticationEndpoints;
import io.restassured.response.Response;

public class AuthenticationTests {
	
	public String username = "postman";
	public String password = "password";

	public String githubToken = "Enter your Token Here";
	public String openWeatherApiKey = "726c270fb34f3a5b25a68f117a92dde5";

	 @Test(priority = 1, groups = {"sanity", "functionality"})
	    public void testBasicAuthentication() {
	        Response res = AuthenticationEndpoints.basicAuthentication(username, password);
	        res.then().log().all();
	         /*  .statusCode(200)
	           .body("authenticated", equalTo(true));*/
	        
	        assertThat("Status code should be 200", res.getStatusCode(), is(200));
	        assertThat("Response body should contain authenticated: true", 
	                   res.jsonPath().getBoolean("authenticated"), is(true));
	    }

	  @Test(priority = 2, groups = {"regression", "functionality"})
	    public void testDigestAuthentication() {
	        Response res = AuthenticationEndpoints.digestAuthentication(username, password);
	        res.then().log().all()
	           .statusCode(200)
	           .body("authenticated", equalTo(true));
	    }


	    @Test(priority = 3, groups = {"sanity", "regression"})
	    public void testPreemptiveBasicAuthentication() {
	        Response res = AuthenticationEndpoints.preemptiveBasicAuthentication(username, password);
	        res.then().log().all()
	           .statusCode(200)
	           .body("authenticated", equalTo(true));
	    }

	    @Test(priority = 4, groups = {"regression", "functionality"})
	    public void testBearerTokenAuthentication() {
	        Response res = AuthenticationEndpoints.bearerTokenAuthentication(githubToken);
	        res.then().log().all()
	           .statusCode(200);

	        assertThat(res.getStatusCode(), is(200));
	    }

	    @Test(priority = 5, groups = {"sanity"})
	    public void testOAuth2Authentication() {
	        Response res = AuthenticationEndpoints.oauth2Authentication(githubToken);
	        res.then().log().all()
	           .statusCode(200);

	        assertThat(res.getStatusCode(), is(200));
	    }

	    @Test(priority = 6, groups = {"regression"})
	    public void testAPIKeyAuthentication() {
	        Response res = AuthenticationEndpoints.apiKeyAuthentication(openWeatherApiKey);
	        res.then().log().all()
	           .statusCode(200);

	        assertThat(res.getStatusCode(), is(200));
	    }
}
