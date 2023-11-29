package payloads;

import com.DynamicPayloadStrategies.ExtDataInput;

public class DynamicPayload {
	
	// Previously we have seen that our payload is stored in return type as shown in block
	/*public String LibraryApi() {
		
		return"{\r\n"
				+ "\r\n"
				+ "\"name\":\"Learn Appium Automation with Java\",\r\n"
				+ "\"isbn\":\"bcdlo\",\r\n"
				+ "\"aisle\":\"225817\",\r\n"
				+ "\"author\":\"John foe\"\r\n"
				+ "}\r\n"
				+ "";
	}*/
	
	// This time we will store that in one Variable  -
	public static String LibraryApi() {  // this method is used in DynamicJson file
		
		String DynPayload = "{\r\n"
				+ "\r\n"
				+ "\"name\":\"Learn Selenium Automation with Java\",\r\n"
				+ "\"isbn\":\"abuiocd\",\r\n"
				+ "\"aisle\":\"22040787\",\r\n"
				+ "\"author\":\"John foe\"\r\n"
				+ "}\r\n"
				+ "";
		
		return DynPayload;
	}
	
	public static String ExternaldataInp(String isbn, String aisle) {
		
		String externalPayload="{\r\n"
				+ "\r\n"
				+ "\"name\":\"Learn Selenium Automation with Java\",\r\n"
				+ "\"isbn\":\""+isbn+"\",\r\n"
				+ "\"aisle\":\""+aisle+"\",\r\n"
				+ "\"author\":\"John foe\"\r\n"
				+ "}";
		
		return externalPayload;
	}
	
	
	}

