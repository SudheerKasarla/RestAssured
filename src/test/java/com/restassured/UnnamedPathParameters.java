package com.restassured;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class UnnamedPathParameters {

	@Test
	public static void UnNamedPathparameters() {
  
			RestAssured
				.given()
					.log()
					.all()
					.pathParam("basePath", "booking")
				.when()
					.get("https://restful-booker.herokuapp.com/{basePath}/{bookingID}",20)
				.then()
					.log()
					.all()
					.statusCode(200);

		System.out.println("==================Second===============");	
		
		Map<String, Object> pathParameters = new HashMap<>();
		pathParameters.put("basePath", "booking");
		pathParameters.put("bookingId", 10);
		RestAssured
			.given()
				.log()
				.all()
				.baseUri("https://restful-booker.herokuapp.com/")
				.basePath("{basePath}/{bookingId}")
				.pathParams(pathParameters)
			.when()
				.get() 
			.then()
				.log()
				.all()
				.statusCode(200); 
		
	}

}
