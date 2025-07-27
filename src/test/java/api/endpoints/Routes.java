package api.endpoints;

public class Routes {
	
	 public static String base_url = "https://gorest.co.in/public/v2";  
	    public static String post_url = base_url + "/users";               
	    public static String get_url = base_url + "/users/{id}";
	    public static String update_url = base_url + "/users/{id}";
	    public static String delete_url = base_url + "/users/{id}";
	    
	    
	    public static String postman_url = "https://postman-echo.com/basic-auth";
	    public static String github_url = "https://api.github.com/users/repos";
	    public static String openweather_url  =  "https://home.openweathermap.org/api_keys";
	    
	    public static String Schema_requers_url = "https://reqres.in/api/users?page=2";
	    public static String RSRS_url="https://gorest.co.in/public/v2/users";
	    
	    public static String Hamcrest_base_url = "https://reqres.in/api";
	    public static String Hamcrest_url = Hamcrest_base_url+ "/users?page=2";
	    
	    public static String pet_post_url ="https://petstore.swagger.io/v2/user";
	    public static String pet_get_url= "https://petstore.swagger.io/v2/user/{username}";
	    public static String pet_update_url=  "https://petstore.swagger.io/v2/user/{username}";
	    public static String pet_delete_url= "https://petstore.swagger.io/v2/user/{username}";

	    
}
