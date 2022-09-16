package com.restassured.json;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class A38MockAPIJsonResponse {
	
	
	
	@Test
	public void mockAPIResponse() 
	{
		
		//https://designer.mocky.io/design
		
		RestAssured
				.given()
				.log()
				.all()
				.get("https://run.mocky.io/v3/2e012f29-433e-4076-9081-d99b5ef981b0")
				.then()
				.log()
				.all();
		
	}

}
