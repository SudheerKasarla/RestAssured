package com.restassured;

import io.restassured.RestAssured;

public class GetRequest {

	public static void main(String[] args) {

  
		/*
		 * 1) Build Request 
		 * 2) Hit Request and get Response 
		 * 3) Validate Response
		 */
		
		RestAssured
			.given()
				.log()
				.all()
				.baseUri("https://restful-booker.herokuapp.com/")
				.basePath("booking/{id}")
				
				.pathParam("id", 10)
			.when()
				.get()
			.then()
				.log()
				.all()
				.statusCode(200);
				
			
		
		
		
	}

}
