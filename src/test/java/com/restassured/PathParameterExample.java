package com.restassured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class PathParameterExample {

	@Test
	public static void PathParameters() {
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
	
	
	
	
	
	
	
	
	@Test
	public void PathParameterGetRequest()
	{
	 RestAssured.given().log().all()
																				.baseUri("https://restful-booker.herokuapp.com/")
																				.basePath("{basePath}/{bookingId}")
																				.pathParam("basePath", "booking")
																				.pathParam("bookingId", 10)
																				.when()
																				.get()
																				.then().log().all().assertThat().statusCode(200);
																				
				
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
