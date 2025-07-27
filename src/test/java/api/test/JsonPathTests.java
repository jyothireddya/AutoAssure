package api.test;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.json.JSONArray;
import org.json.JSONObject;

import api.endpoints.JsonPathEndpoints;
import io.restassured.response.Response;

public class JsonPathTests {
	
	@Test(priority = 1)
    public void testJsonPathApproach1() {
        JsonPathEndpoints.getUsers()
                .then()
                .statusCode(200)
                .header("Content-Type", "application/json; charset=utf-8")
                .body("data[0].first_name", equalTo("Michael"));
    }

 
    @Test(priority = 2)
    public void testJsonPathApproach2() {
        Response res = JsonPathEndpoints.getUsers();

        assertEquals(res.getStatusCode(), 200);
        assertEquals(res.header("Content-Type"), "application/json; charset=utf-8");

        String firstName = res.jsonPath().getString("data[0].first_name");
        assertEquals(firstName, "Michael");
    }

  
    @Test(priority = 3)
    public void testAllFirstNames() {
        Response res = JsonPathEndpoints.getUsers();

        JSONObject jsonObject = new JSONObject(res.asString());
        JSONArray dataArray = jsonObject.getJSONArray("data");

        System.out.println("---- All First Names ----");
        for (int i = 0; i < dataArray.length(); i++) {
            JSONObject user = dataArray.getJSONObject(i);
            System.out.println(user.getString("first_name"));
        }
    }

    @Test(priority = 4)
    public void testFirstNameExists() {
        Response res = JsonPathEndpoints.getUsers();

        JSONObject jsonObject = new JSONObject(res.asString());
        JSONArray dataArray = jsonObject.getJSONArray("data");

        boolean found = false;
        for (int i = 0; i < dataArray.length(); i++) {
            String firstName = dataArray.getJSONObject(i).getString("first_name");
            if (firstName.equalsIgnoreCase("Michael")) {
                found = true;
                break;
            }
        }

        assertTrue(found, "'Michael' not found in the user list");
    }

}
