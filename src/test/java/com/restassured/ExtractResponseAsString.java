package com.restassured;

import io.restassured.RestAssured;

public class ExtractResponseAsString {

	public static void main(String[] args) {
		
		  
		//Extract Response body as a string
		
	String ExtractResponse=	
		RestAssured 
		.given()
			.log()
			.all()
			.baseUri("https://restful-booker.herokuapp.com/")
			.basePath("booking")
			.header("Content-Type", "application/json")
			.header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
			.body("{\r\n"
					+ "    \"firstname\" : \"James\",\r\n"
					+ "    \"lastname\" : \"Brown\",\r\n"
					+ "    \"totalprice\" : 111,\r\n"
					+ "    \"depositpaid\" : true,\r\n"
					+ "    \"bookingdates\" : {\r\n"
					+ "        \"checkin\" : \"2018-01-01\",\r\n"
					+ "        \"checkout\" : \"2019-01-01\"\r\n"
					+ "    },\r\n"
					+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
					+ "}")
		.when()
			.post()
		.then()
			.log()
			.all()
			.extract()
			//.body()
			.asPrettyString();
			
	
	System.out.println("Response is..." + ExtractResponse);

	}

}
