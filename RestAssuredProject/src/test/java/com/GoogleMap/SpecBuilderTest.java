package com.GoogleMap;

import static io.restassured.RestAssured.given;
import java.util.ArrayList;
import java.util.List;

import com.PojoGooglemaps.AddPlacePojo;
import com.PojoGooglemaps.Location;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecBuilderTest {
	
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
		ap.setName("Dream house");
		ap.setPhone_number("(+91) 983 893 0001");
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
		
		// Step 1 First create object for request
		RequestSpecification req= new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key","qaclick123").setContentType(ContentType.JSON).build();
		
		// Step 2 - Integrate request to using spec()
		RequestSpecification reqSpec= given().spec(req).body(ap);
		
		// step 3 -  create object for responseSpecbuilder
		ResponseSpecification resSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	
		// step 4 - integrate with Response 
	     Response response= reqSpec.when().post("/maps/api/place/add/json").then().spec(resSpec).extract().response();	   
   
	     String responseString=response.asString();
         System.out.println(responseString);
	
		   
	}

}
