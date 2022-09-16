package com.restassured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class DefaultValues2 {
	
	
	  
	

	@Test
	public static void createBooking() {
		
		
		RestAssured.given()
		        .log()
				.all()
				// .baseUri("https://restful-booker.herokuapp.com/")
				.basePath("auth") 
				.contentType(ContentType.JSON)
				.body("{\r\n"
						+ "    \"username\" : \"admin\",\r\n"
						+ "    \"password\" : \"password123\"\r\n"
						+ "}")
		
		
				.post()
				.then()
				.log()
				.all()
				.statusCode(200);

	}

	
	
	
	  @Test public static void createBooking2() {
	  
		  RestAssured.given().log().all()
	  			.baseUri("https://restful-booker.herokuapp.com/") 
	  			.basePath("booking")
	  			.contentType(ContentType.JSON) 
	  			.body("{\r\n" +
	  						" \"firstname\" : \"Brannon\",\r\n" + "   " +
	  						" \"lastname\" : \"James\",\r\n" + " \"totalprice\" : 1,\r\n" +
	  						" \"depositpaid\" : true,\r\n" +"  \"bookingdates\" : {\r\n" +
	  						" \"checkin\" : \"2018-01-01\",\r\n" + " \"checkout\" : \"2019-01-01\"\r\n" +
	  						"  },\r\n" +"   \"additionalneeds\" : \"Breakfast\"\r\n" + "}")
	  			.post()
	  			.then()
	  			.log() 
	  			.all()
	  			.statusCode(200);
	  
	  }
	 
	 
}
