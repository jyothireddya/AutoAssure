package api.test;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;


import org.json.JSONArray;
import org.json.JSONObject;

import api.endpoints.JsonPathEndpoints;
import io.restassured.response.Response;
import static org.hamcrest.MatcherAssert.assertThat;

public class JsonPathTests {
	

	  @Test(priority = 1, groups = {"sanity", "functionality", "json"})
    public void testJsonPathApproach1() {
        JsonPathEndpoints.getUsers()
            .then()
            .statusCode(200)
            .header("Content-Type", "application/json; charset=utf-8")
            .body("data[0].first_name", equalTo("Michael"));
    }

	  @Test(priority = 2, groups = {"regression", "functionality", "json"})
    public void testJsonPathApproach2() {
        Response res = JsonPathEndpoints.getUsers();

        assertThat("Status code is incorrect", res.getStatusCode(), is(200));
        assertThat("Content-Type header mismatch",
            res.getHeader("Content-Type"), equalTo("application/json; charset=utf-8"));

        String firstName = res.jsonPath().getString("data[0].first_name");
        assertThat("First name is not 'Michael'", firstName, equalTo("Michael"));
    }


	    @Test(priority = 3, groups = {"regression", "json"})
    public void testAllFirstNames() {
        Response res = JsonPathEndpoints.getUsers();

        JSONObject jsonObject = new JSONObject(res.asString());
        JSONArray dataArray = jsonObject.getJSONArray("data");

        System.out.println("---- All First Names ----");
        for (int i = 0; i < dataArray.length(); i++) {
            JSONObject user = dataArray.getJSONObject(i);
            System.out.println(user.getString("first_name"));
        }

        assertThat("User list is empty", dataArray.length(), greaterThan(0));
    }

	    @Test(priority = 4, groups = {"sanity", "json"})
    public void testFirstNameExists() {
        Response res = JsonPathEndpoints.getUsers();

        JSONObject jsonObject = new JSONObject(res.asString());
        JSONArray dataArray = jsonObject.getJSONArray("data");

        boolean found = false;
        for (int i = 0; i < dataArray.length(); i++) {
            String firstName = dataArray.getJSONObject(i).getString("first_name");
            if ("Michael".equalsIgnoreCase(firstName)) {
                found = true;
                break;
            }
        }

        assertThat("'Michael' should be in the first names list", found, is(true));
    }


}
