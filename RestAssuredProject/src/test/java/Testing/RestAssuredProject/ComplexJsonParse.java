package Testing.RestAssuredProject;

import io.restassured.path.json.JsonPath;
import junit.framework.Assert;
import payloads.payloadcp;


public class ComplexJsonParse {
	
	public static void main(String[] args) {
		
	JsonPath jp = new JsonPath(payloadcp.CoursePrice());

	//1. Print No of courses returned by API	
	int count= jp.getInt("courses.size()");     // size is a method in array
	System.out.println(count);
	
	//2.Print Purchase Amount
	int totalamount=jp.getInt("dashboard.purchaseAmount");
	System.out.println(totalamount);
	
	//3. Print Title of the first course
	String titleFirstCourse=jp.get("courses[0].title");
	System.out.println(titleFirstCourse);
	
	//4. Print All course titles and their respective Prices
	for(int i=0;i<count;i++) {
	/*	String Titles=jp.get("courses["+i+"].title");
		System.out.println(Titles);*/
		System.out.print(jp.get("courses["+i+"].title").toString());// The reason for using toString method is because 
        System.out.println( "  "+jp.get("courses["+i+"].price").toString());  
	}
	
	//5. Print no of copies sold by RPA Course

	for(int i=0;i<count;i++) {
		String courseTitle=jp.get("courses["+i+"].title");
		if(courseTitle.equalsIgnoreCase("RPA")) {
		int copies=jp.get("courses["+i+"].copies");
		
		System.out.println("RPA Copies "+copies);
		break;
		}
		}
	
	// 6. Verify if Sum of all Course prices matches with Purchase Amount
	
	System.out.println(totalamount);
	int sum=0;
	for(int i=0;i<count;i++) {
		int price=jp.get("courses["+i+"].price");
		int copies=jp.get("courses["+i+"].copies");
		sum=sum+price*copies;
	}
	System.out.println(sum);
	
	if(totalamount==sum) {
		System.out.println("Price matches");
	}else {
		System.out.println("price doesn't matches");
	}
	
	
	}
	
}
