package Testing.RestAssuredProject;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import payloads.AddPlace;

import static io.restassured.RestAssured.*;  // this is for given
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

public class basics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RestAssured.baseURI="https://rahulshettyacademy.com/";
	   String response= given().log().all().queryParam("key","qaclick123" ).header("Content-Type","application/json").body(AddPlace.methodfirst()) //In body we have used static method which is created in payload
	   .when().post("/maps/api/place/add/json")
	   .then().assertThat().statusCode(200)
	   .body("scope",equalTo("APP")).header("Server", "Apache/2.4.52 (Ubuntu)")  //Validations we have added
	   .extract().response().asString();  // To extract output as string
	   
	   System.out.println(response);
	   
	   // so consider we need the place id from response, so to do it there is a class for JSON parse (i.e. to extract particular value from json body)
	   System.out.println("*************************Fetch Place ID ********************************");
	  JsonPath js = new JsonPath(response);   //
	   String placeID=js.get("place_id");
	   System.out.println(placeID);
	   
	   
	   System.out.println("*******************************Update Place*********************************");
	   
	   //Add place -> Update place with new address -> get place to variable if new address is present in response
	   
	   //new address
	   String newAddress="70 Summer walk, USA";
	   
	   given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
	   .body("{\r\n"
	   		+ "\"place_id\":\""+placeID+"\",\r\n"
	   		+ "\"address\":\""+newAddress+"\",\r\n"      
	   		+ "\"key\":\"qaclick123\"\r\n"
	   		+ "}")
	   .when().put("maps/api/place/update/json")  //.when().put("Resource")
	   .then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));
	   
	   
	   System.out.println("*******************************Get Place *********************************");
	   
	 String getPlaceResponse=  given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeID)
	   .when().get("maps/api/place/get/json")
	   .then().assertThat().log().all().statusCode(200)
	   .extract().response().asString();
	   
	  //JsonPath js1 = new JsonPath(getPlaceResponse);   //if we don't use reusable methods
	 
	 JsonPath js1=ReusableMethods.rawToJson(getPlaceResponse);  // Object creation of reusable method
	   String actualAddress=js1.get("address");
	 System.out.println(actualAddress);
	 //cucumber Junit, Testng  
	 // adding assertions with help of testng assertion
	 Assert.assertEquals(actualAddress, newAddress);
	 
	 
	}

}
