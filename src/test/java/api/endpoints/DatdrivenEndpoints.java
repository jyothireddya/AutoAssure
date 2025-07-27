package api.endpoints;

import api.payload.DDPayload;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class DatdrivenEndpoints {
	
	  public static Response createUser (DDPayload payload)
	    {
	        Response response=given()
	                .contentType(ContentType.JSON)
	                .accept(ContentType.JSON)
	                .body (payload)
	                .when()
	                .post(Routes.pet_post_url);
	        
	        return response;
	    }
	  public static Response readUser (String userName)
	  {
	      Response response=given()
	          .pathParam("username", userName)
	          .when()
	          .get(Routes.pet_get_url);

	      return response;
	  }

	  public static Response updateUser (String userName, DDPayload  payload)
	  {
	      Response response=given()
	          .contentType(ContentType.JSON)
	          .accept(ContentType.JSON)
	          .pathParam("username", userName)
	          .body (payload)
	          .when()
	          .put(Routes.pet_update_url);

	      return response;
	  }
	  public static Response deleteUser(String userName)
	  {
	      Response response=given()
	          .pathParam("username",userName)
	          .when()
	          .delete(Routes.pet_delete_url);
	      return response;
	  }
}
