package com.DynamicPayloadStrategies;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Testing.RestAssuredProject.ReusableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import payloads.DynamicPayload;

public class ParameterizePayload {

	@Test(dataProvider="BooksData")
	public static void ParaPay(String isbn, String aisle){
		RestAssured.baseURI = "http://216.10.245.166";

		Response resp = given().log().all().header("Content-Type", "application/json")
					.body(DynamicPayload.ExternaldataInp(isbn, aisle))
					.when()
					.post("/Library/Addbook.php")
					.then().log().all()
					.assertThat().statusCode(200).extract().response();

		
		JsonPath jp = ReusableMethods.rawToJson1(resp);
		String id = jp.get("ID");
		System.out.println(id);
		
	}
	
	@DataProvider(name="BooksData")
	public Object[][] getData()
	{
		// Array is collection of Elements
		// MultiDimensional Array = collections of Arrays 
		
		return new Object[][] {{"Billy","Cargill"},{"Luke","Bolton"},{"Jordan","Houghton"}};
	}	
	
	
}
