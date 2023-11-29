package com.DynamicPayloadStrategies;

import org.testng.annotations.Test;

import Testing.RestAssuredProject.ReusableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import payloads.DynamicPayload;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class DynamicJson {   // This time we will store that in one Variable and we are using it 
	
	@Test
	public void  addBook()
	{
		RestAssured.baseURI="http://216.10.245.166";
		String response=given().log().all().header("Content-Type","application/json").
		body(DynamicPayload.LibraryApi()).   //body(classname.methodname)
		when().
		post("/Library/Addbook.php")   // Requesttype("Resource")
		.then().log().all().assertThat().statusCode(200)
		.extract().response().asString();
		
		// Reusable Method which helps Raw to convert in Json
		
		JsonPath js=ReusableMethods.rawToJson(response);
		String id = js.get("ID");
		System.out.println(id);
		
		
	}
}
