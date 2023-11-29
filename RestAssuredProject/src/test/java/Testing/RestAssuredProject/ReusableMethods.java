package Testing.RestAssuredProject;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ReusableMethods {

	public static JsonPath rawToJson(String response) {
		// access modifier 
		//static keyword so that we can access the method without creating object
		// JsonPath - Return type
		// rawToJson - method name
		JsonPath js = new JsonPath(response);
		
		return js;
	}

	
	// This is for class ExtDataInput
	public static JsonPath rawToJson1(Response response) {
		// access modifier 
		//static keyword so that we can access the method without creating object
		// JsonPath - Return type
		// rawToJson - method name
	JsonPath jp =response.jsonPath(); 
		
		return jp;
	}
	
}
