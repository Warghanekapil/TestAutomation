package com.DynamicPayloadStrategies;

import org.testng.annotations.Test;

import Testing.RestAssuredProject.ReusableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import payloads.DynamicPayload;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import static io.restassured.RestAssured.*;

public class ExtDataInput {

	@Test
	public static void DataInp() {

	RestAssured.baseURI = "http://216.10.245.166";

	Response resp = given().log().all().header("Content-Type", "application/json")
				.body(DynamicPayload.ExternaldataInp("tyler", "smith"))
				.when()
				.post("/Library/Addbook.php")
				.then().log().all()
				.assertThat().statusCode(200).extract().response();

	
	JsonPath js = ReusableMethods.rawToJson1(resp);
	String id = js.get("ID");
	System.out.println(id);
	

	
	}
	
	

}
