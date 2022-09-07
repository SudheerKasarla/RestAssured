package com.restassured.json;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

public class A31InlineAssertion {
	
	
	@Test
	public void Assertions()
	{
		
		String jsonResponse =""; 
		jsonResponse= RestAssured
		  .given()
			.baseUri("https://restful-booker.herokuapp.com/auth")
			.body("{\r\n"
					+ "    \"username\" : \"admin\",\r\n"
					+ "    \"password\" : \"password123\"\r\n"
					+ "}")
			.contentType(ContentType.JSON)
		  .when()
			.post()
		  .then()
		    .log()
		    .all()
		    .extract()
		    .asString();
		
		JsonPath jsonPath =new JsonPath(jsonResponse);
		Assert.assertNotNull(jsonPath.get("token"));
		
	}
	
	
	
	@Test
	public void inLineAssertions()
	{
		
		RestAssured
		  .given()
			.baseUri("https://restful-booker.herokuapp.com/auth")
			.body("{\r\n"
					+ "    \"username\" : \"admin\",\r\n"
					+ "    \"password\" : \"password123\"\r\n"
					+ "}")
			.contentType(ContentType.JSON)
		  .when()
			.post()
		  .then()
		    .log()
		    .all()
		    .body("token",Matchers.notNullValue())
		    .body("token.length()", Matchers.is(15))
		    .body("token.length()", Matchers.equalTo(15))
		    .body("token", Matchers.matchesRegex("^[a-z0-9]+$"));
		
	}



	
	
	
	@Test
	
	public void inLineAssertionsForCreateBooking()
	{
		RestAssured
		  .given()
		  		.log()
		  		.all()
		  		.baseUri("https://restful-booker.herokuapp.com/booking")
		  .when()
		  	.get()
		  .then()
		  		.log()
		  		.all()
		  		.body("bookingid", Matchers.hasItems(9,10));
	}

}
