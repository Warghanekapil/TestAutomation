package com.GoogleMap;

import static io.restassured.RestAssured.given;
import java.util.ArrayList;
import java.util.List;

import com.PojoGooglemaps.AddPlacePojo;
import com.PojoGooglemaps.Location;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SerializationTest {
	
// Before creating serialization test make sure to add dependencies in POM.XML
	//Jackson-annotations
    // jackson-databind
	//jackson-core
	
	public static void main(String[] args) {
		RestAssured.baseURI="https://rahulshettyacademy.com";
		//Creating Objects for setting values 
		AddPlacePojo ap= new AddPlacePojo();
		ap.setAccuracy(50);
		ap.setAddress("29, side layout, cohen 09");
		ap.setLanguage("French-IN");
		ap.setName("Frontline house");
		ap.setPhone_number("(+91) 983 893 0000");
		ap.setWebsite("https://rahulshettyacademy.com");
		
		//For Location we have to create a Object of Location class -Pojo
		Location l= new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		ap.setLocation(l);
		
		// for setting values in Types return type is list 
		// so we have to create a object for List
		List<String> typ = new ArrayList<String>();
		typ.add("shoe park");
		typ.add("shop");
		ap.setTypes(typ);
		
	
		
		   Response response= given().log().all().queryParam("key","qaclick123" )  // import io.restassured.response.Response;
				   .body(ap)  // here we have pass the object of pojo class which we have created for setting values above 
		   .when().post("/maps/api/place/add/json")
		   .then().assertThat().statusCode(200)		
	   .extract().response();  // To extract output as string
	
		  // String responseString=response.asString();
		  // System.out.println(response);
		   
		 // Object creation of reusable method
		  // String actualAddress=js1.get("address");
		   
		   String responseString=response.asString();
		   System.out.println(responseString);
	}

}
