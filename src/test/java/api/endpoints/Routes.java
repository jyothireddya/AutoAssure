package api.endpoints;

import api.utils.AuthUtil;

public class Routes {
	
	 public static String post_url    = AuthUtil.BASE_URL + "/users";
	    public static String get_url     = AuthUtil.BASE_URL + "/users/{id}";
	    public static String update_url  = AuthUtil.BASE_URL + "/users/{id}";
	    public static String delete_url  = AuthUtil.BASE_URL + "/users/{id}";

	    public static String postman_url = "https://postman-echo.com"; //  public static String postman_url = "https://postman-echo.com"; 
	    public static String postman_get_url = "ttps://postman-echo.com/basic-auth"; 
	    public static String github_url  = "https://api.github.com";
	    public static String github_get_url  = "https://api.github.com/user";// fixed
	    public static String openweather_url  = "https://api.openweathermap.org";
	    public static String openweather__get_url  = "https://api.openweathermap.org/data/2.5/weather?q=London";// fixed

	    public static String reqres_url  = "https://reqres.in/api/users?page=2";

	    public static String Hamcrest_base_url = "https://reqres.in/api";
	    public static String Hamcrest_url = Hamcrest_base_url+ "/users?page=2";
	    
	    public static String Schema_requers_url = "https://reqres.in/api/users?page=2";
	    public static String RSRS_url="https://gorest.co.in/public/v2/users";
	    
	    public static final String BASE_SCHEMA_URL = "https://reqres.in";
	    public static final String SCHEMA_USERS_ENDPOINT = "/api/users";
	    
	    public static final String POSTMAN_BASE_URL = "https://postman-echo.com";
	    
	    public static final String PETSTORE_BASE_URL = "https://petstore.swagger.io/v2";

	    public static final String PET_POST_URL    = "/user";
	    public static final String PET_GET_URL     = "/user/{username}";
	    public static final String PET_UPDATE_URL  = "/user/{username}";
	    public static final String PET_DELETE_URL  = "/user/{username}";
	    
}
