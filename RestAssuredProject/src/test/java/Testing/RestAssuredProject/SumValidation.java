package Testing.RestAssuredProject;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import junit.framework.Assert;
import payloads.payloadcp;

public class SumValidation {

	@Test
	public void sumofCourses()
	{
		JsonPath jp = new JsonPath(payloadcp.CoursePrice());
		int count= jp.getInt("courses.size()");
		int totalamount=jp.getInt("dashboard.purchaseAmount");
		
		System.out.println(totalamount);
		int sum=0;
		for(int i=0;i<count;i++) {
			int price=jp.get("courses["+i+"].price");
			int copies=jp.get("courses["+i+"].copies");
			sum=sum+price*copies;
		}
		System.out.println(sum);
		
		/*if(totalamount==sum) {
			System.out.println("Price matches");
		}else {
			System.out.println("price doesn't matches");
		}*/
		
		Assert.assertEquals(totalamount, sum);  //Using TestNG assertions
	}
	
}
