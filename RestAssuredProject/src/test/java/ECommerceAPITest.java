import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import eCom.Pojo.CreateOrderResponse;
import eCom.Pojo.LoginRequest;
import eCom.Pojo.LoginResponse;
import eCom.Pojo.OrderDetail;
import eCom.Pojo.Orders;
import eCom.Pojo.ViewOrderDetailResponse;

public class ECommerceAPITest {

	public static void main(String[] args) {

		RequestSpecification req= new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").setContentType(ContentType.JSON).build();
		
		// For Body Setting Values for that create object
		LoginRequest loginRequest = new LoginRequest();
		loginRequest.setUserEmail("kevxavier@mymail.com");
		loginRequest.setUserPassword("newPassword02!");
		
		RequestSpecification reqLogin=given().log().all().spec(req).body(loginRequest);
		
		// To get response as class we created a Pojo class 
		LoginResponse loginResponse = reqLogin.when().post("/api/ecom/auth/login").then().log().all().extract().response().as(LoginResponse.class);
		// Now we can get token
		String token =loginResponse.getToken();
		System.out.println("Authorization : "+token);
		String userId=loginResponse.getUserId();
		System.out.println("UserID : "+userId);
		
		System.out.println("**********************ADDPRODUCT******************");
		// here we don't have to send JSON so we removed contentType
		RequestSpecification addProductBasereq=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addHeader("authorization",token).build();
		
		RequestSpecification  reqAddProduct= given().log().all().spec(addProductBasereq)
		.param("productName", "Iphone15 ProMax")
		.param("productAddedBy", userId)
		.param("productCategory", "Mobiles")
		.param("productSubCategory", "Apple")
		.param("productPrice", "950")
		.param("productDescription", "Apple Iphone 15")
		.param("productFor", "Everyone")
		.multiPart("productImage",new File("C:\\Users\\LENOVO\\Desktop\\API Testing Ecom\\Apple Iphone 15.png"));
		
		String addProductResponse= reqAddProduct.when().post("/api/ecom/product/add-product")
		.then().log().all().extract().response().asString();   // Since there are only 2 fields so we don't extract response as pojo class we get it as string
		JsonPath js= new JsonPath(addProductResponse);
		String productId=js.get("productId");
		System.out.println("productId : "+productId);
		
		System.out.println("*******************CREATEORDER**********************");
		
		//Since here we have to send JSON so we needed to add contentType
		RequestSpecification createOrderBasereq=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addHeader("authorization", token).setContentType(ContentType.JSON).build();

		// For calling body from created Orders.Pojo -step1 create a OrderDetail object and set values 
		
		OrderDetail orderDetail= new OrderDetail();
		orderDetail.setCountry("India");
		orderDetail.setProductOrderedId(productId);
		
		// 2 step create List for OrderDetail object to call in list
		
		List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
		orderDetailList.add(orderDetail);
		
		Orders orders=new Orders();
		orders.setOrders(orderDetailList);  // This method is expecting a list of orders 
		
		RequestSpecification createOrderReq=given().log().all().spec(createOrderBasereq).body(orders);
		
		//String responseAddOrder=createOrderReq.when().post("/api/ecom/order/create-order").then().log().all().extract().response().asString();
		
		CreateOrderResponse responseAddOrder=createOrderReq.when().post("/api/ecom/order/create-order").then().log().all().extract().response().as(CreateOrderResponse.class);
		
		System.out.println(responseAddOrder);
		
		List<String> ordersId=responseAddOrder.getOrders();
		
		System.out.println(ordersId);
		
		String ordID=ordersId.get(0);
		
		System.out.println("orderID -> "+ordID);
		
	// Note here we can also use selenium to add validations
		// and checking product id by login to web
		
		System.out.println("*********************VIEWORDERDETAILS*************************");
	 
		RequestSpecification viewOrderDetailsreq=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("id", ordersId)
				.addHeader("authorization", token).setContentType(ContentType.JSON).build();
	
		RequestSpecification viewdetails=given().log().all().spec(viewOrderDetailsreq);
		ViewOrderDetailResponse  viewOrder = viewdetails.when().get("/api/ecom/order/get-orders-details").then().log().all().extract().response().as(ViewOrderDetailResponse.class);
		
		//System.out.println(viewOrder);
	
		System.out.println("***************************deleteProduct*********************");
	
		RequestSpecification deleteProductBasereq=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addHeader("authorization", token).setContentType(ContentType.JSON).build();
	
		RequestSpecification deleteProdreq=given().log().all().spec(deleteProductBasereq).pathParam("productId", productId);
	
	String deleteProductResponse=	deleteProdreq.when().delete("/api/ecom/product/delete-product/{productId}").then().log().all().extract().response().asString();
	JsonPath jp=new JsonPath(deleteProductResponse);
	Assert.assertEquals("Product Deleted Successfully", jp.get("message"));
	
	System.out.println("************************DELETEORDER****************************");
	
	RequestSpecification delOrderBasereq=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
			.addHeader("authorization", token).setContentType(ContentType.JSON).build();
	
	RequestSpecification deleteOrdreq=given().log().all().spec(deleteProductBasereq).pathParam("ordID", ordID);
	
	String deleteOrderResponse=	deleteOrdreq.when().delete("/api/ecom/order/delete-order/{ordID}").then().log().all().extract().response().asString();
	JsonPath jp1=new JsonPath(deleteOrderResponse);
	System.out.println("delete order status"+deleteOrderResponse);
	
	
	}

}
