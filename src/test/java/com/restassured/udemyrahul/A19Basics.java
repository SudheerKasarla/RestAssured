package com.restassured.udemyrahul;

import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class A19Basics {
	
	
	@Test
	public void A19Json()
	{
		RestAssured.baseURI= "https://rahulshettyacademy.com";
		
				RestAssured
				.given()
				.log()
				.all()
				.basePath("maps/api/place/add/json")
				.queryParam("key", "qaclick123")
				.contentType(ContentType.JSON)
				.body("{\r\n" + 
						"  \"location\": {\r\n" + 
						"    \"lat\": -38.383494,\r\n" + 
						"    \"lng\": 33.427362\r\n" + 
						"  },\r\n" + 
						"  \"accuracy\": 50,\r\n" + 
						"  \"name\": \"Rahul Shetty Academy\",\r\n" + 
						"  \"phone_number\": \"(+91) 983 893 3937\",\r\n" + 
						"  \"address\": \"29, side layout, cohen 09\",\r\n" + 
						"  \"types\": [\r\n" + 
						"    \"shoe park\",\r\n" + 
						"    \"shop\"\r\n" + 
						"  ],\r\n" + 
						"  \"website\": \"http://rahulshettyacademy.com\",\r\n" + 
						"  \"language\": \"French-IN\"\r\n" + 
						"}\r\n" + 
						"")
				.when()
				.post()
				.then()
				.log()
				.all().assertThat().statusCode(200).body("scope", equalTo("APP"))
				.header("server", "Apache/2.4.41 (Ubuntu)").extract().response().toString();
			
	}

}
