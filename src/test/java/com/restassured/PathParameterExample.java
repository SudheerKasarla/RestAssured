package com.restassured;

import io.restassured.RestAssured;

public class PathParameterExample {

	public static void main(String[] args) {

		  
		
		RestAssured
			.given()
				.log()
				.all()
				.baseUri("https://restful-booker.herokuapp.com/")
				//Named Parameters
				.basePath("{basePath}/{bookingId}")
				.pathParam("basePath", "booking")
				.pathParam("bookingId", 10)
			.when()
				.get()
			.then()
				.log()
				.all()
				.statusCode(200);
	}

}
