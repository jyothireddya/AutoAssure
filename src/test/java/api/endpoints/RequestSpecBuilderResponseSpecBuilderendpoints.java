package api.endpoints;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class RequestSpecBuilderResponseSpecBuilderendpoints {
	private static final String token = "1eb9fce871bbf40fbf59740c5941c6b8174a0fe5decef67377d61c039ff6e354";



    // ✅ Create reusable request specification
    public static RequestSpecification getRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri("https://gorest.co.in/public/v2")
                .addHeader("Authorization", "Bearer " + token)
                .addHeader("Accept", "application/json")
                .setContentType("application/json")
                .build();
    }

    // ✅ Create reusable response specification
    public static ResponseSpecification getResponseSpec() {
        return new ResponseSpecBuilder()
                .expectStatusCode(201)
                .expectContentType("application/json")
                .expectBody("id", notNullValue())
                .build();
    }

    // 🔍 Optional GET method to validate schema or retrieve resources
    public static Response getSchemaValidatedResponse() {
        return given()
                .spec(getRequestSpec())
        .when()
                .get(Routes.RSRS_url);
    }}
