package Oauth;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.PojoClasses.Api;
import com.PojoClasses.CoursesPojo;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath; 
public class Oauthorization {

	public static void main(String[] args) throws InterruptedException {
	String[]	coursesTitles = {"Selenium Webdriver Java", "Cypress", "Protractor"};
		
		
	/*	String response=given().queryParam("access_token", "")
		.when().get("https://rahulshettyacademy.com/getCourse.php").asString();
		
		System.out.println(response);
		
		// Output of Raw - > AUTHENTICATION FAILED !!!! PLEASE ENTER VALID ACCESS TOKEN
		*/
		//******************GetAuthorizationCodeRequest************
	/*	System.setProperty("webdriver.chrome.driver","D:\\Automation\\Chrome\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php&state=verifyjdss");
		driver.findElement(By.cssSelector("[type=email]")).sendKeys("kapilwarghane26@gmail.com");
		driver.findElement(By.cssSelector("[type=email]")).sendKeys(Keys.ENTER);
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("Xavier01!STEV");		
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		String url=driver.getCurrentUrl();  */
		
	
		String url="https://www.googleapis.com/oauth2/v4/token?code=4%2F0AfJohXlbxXT7C2YwTKzW0Evd_D_b60kgup6cP9lSvco3vaFFvUdUKnynnc1YfKYymMeyTA&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&client_secret=erZOWM9g3UtwNRj340YYaK_W&redirect_uri=https://rahulshettyacademy.com/getCourse.php&grant_type=authorization_code#";
		
		
		// So know after we send the GetCode Request we GetAccessToken 
		// To get code value we have to split the url which we get as output
	
		String partialcode=url.split("code=")[1];   // Input for generating access token  
		String code=partialcode.split("&scope")[0];
		System.out.println(code);
		
		// ***************** GetAccessTokenRequest******************
	String accessTokenResponse=	given()
			.urlEncodingEnabled(false).
	    queryParams("code", code).
		queryParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.queryParams("client_secret","erZOWM9g3UtwNRj340YYaK_W")
		.queryParams("redirect_uri","https://rahulshettyacademy.com/getCourse.php")
		.queryParams("grant_type","authorization_code")
		.when().log().all()
		.post("https://www.googleapis.com/oauth2/v4/token")  
		.asString();
	
	     JsonPath jp = new JsonPath(accessTokenResponse);
	     String access_token=jp.getString("access_token");
	     
	     //*************************GetCourseOutput*******************
	   /*  
	     String response=given().queryParam("access_token",access_token)
	    			.when().log().all()
	    			.get("https://rahulshettyacademy.com/getCourse.php").asString();
	    			
	    			System.out.println(response); */
	    			
	    // Till here it is normal response 
	    			
	   //Note --- Now if we have to integrate Pojo class with our response
	    			
	     CoursesPojo gc=given().queryParam("access_token",access_token).expect().defaultParser(Parser.JSON)
	    		.when().get("").as(CoursesPojo.class);
	    		
	    		System.out.println(gc.getInstructor());
	    		System.out.println(gc.getExpertise());
	    		System.out.println(gc.getLinkedIn());
	    		System.out.println(gc.getServices());
	    		System.out.println(gc.getCourses().getApi().get(1).getCourseTitle());
	    		
	    		List<Api> apiCourses=gc.getCourses().getApi();
	    		for(int i=0;i<apiCourses.size();i++) {
	    			if(apiCourses.get(i).getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing")) 
	    			{
	    				System.out.println(apiCourses.get(i).getPrice());
	    			}
	    			
	    			//Get the courses names of WebAutomation
	    			
	    			ArrayList<String> al =new ArrayList<String>();
	    			List<com.PojoClasses.WebAutomation> wa= gc.getCourses().getWebAutomation(); 
	    			
	    			for(int j=0;j<wa.size();j++) 
	    			{
	    			al.add(wa.get(j).getCourseTitle());	
	    			}
	    			// This code is to compare so we have change array  to array list
	    			List<String> expectedList=Arrays.asList(coursesTitles);
	    			Assert.assertTrue(al.equals(expectedList));
	    			
	    			
	    		}
	   
	     
	     
	}

}
