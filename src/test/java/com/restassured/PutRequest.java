package com.restassured;

import io.restassured.RestAssured;

public class PutRequest {

	public static void main(String[] args) {
	
		
		
		//201 - new Resource is created
		// 200 - Resource is found and Updated
		// 204 --No content
		
		
		RestAssured 
			.given()
				.log()
				.all()
				.baseUri("https://restful-booker.herokuapp.com/")
				.basePath("booking/10")
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
				.put()
			.then()
				.log()
				.all()
				.assertThat()
				.statusCode(200);
		

	}

}
