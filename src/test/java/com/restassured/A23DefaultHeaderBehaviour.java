package com.restassured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.config.HeaderConfig;
import io.restassured.config.RestAssuredConfig;

public class A23DefaultHeaderBehaviour {
	
	
	 
	
	@Test
	public void defaultBehaviour() {
		
		
		RestAssured
		 .given()
			.header("header1","value1")
			.header("header1", "value2")
			.log()
			.all()
		.when()
			.get();
	}
	
	
	
	
	@Test
	public void overwriteHeaderValue() 
	{
		RestAssured
			.given()
			.config(RestAssuredConfig.config()
					  .headerConfig(HeaderConfig
							  .headerConfig()
							  .overwriteHeadersWithName("header1","header2")))    // It will overwrite header and don't merge it.
			.config(RestAssuredConfig.config()
						.headerConfig(HeaderConfig.headerConfig()
								.mergeHeadersWithName("header1")))
			.header("header1","value1")
			.header("header1", "value2")
			.header("header3", "value3")
			.header("header3", "value4")
			.header("header2", "value5")
			.log()
			.all()
			.when()
			.get();
	}

}
