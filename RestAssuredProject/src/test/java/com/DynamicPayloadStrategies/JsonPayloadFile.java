package com.DynamicPayloadStrategies;
import static io.restassured.RestAssured.given;



import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;
import org.testng.annotations.Test;

import Testing.RestAssuredProject.ReusableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
public class JsonPayloadFile {
@Test
public void addBook() throws IOException
{
//content of the file to string -> content of file can convert into byte-> byte data to string
RestAssured.baseURI="https://rahulshettyacademy.com/";

Response resp=given().

header("Content-Type","application/json")
//"C:\\Users\\LENOVO\Downloads\Library+API.postman_collection.json"
//body(GenerateStringFromResource("C:\\Users\\LENOVO\\Downloads\\Library+API.postman_collection.json")).
.body(new String(Files.readAllBytes(Paths.get("C:\\Users\\LENOVO\\Downloads\\Library+API.postman_collection.json"))))
.when().

post("/Library/Addbook.php").

then().assertThat().statusCode(200).

extract().response();

JsonPath jp = ReusableMethods.rawToJson1(resp);
String id = jp.get("ID");
System.out.println(id);

}

public static String GenerateStringFromResource(String path) throws IOException {



    return new String(Files.readAllBytes(Paths.get(path)));



}

}

