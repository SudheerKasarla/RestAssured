package com.restassured.json;

import java.io.File;

import org.hamcrest.MatcherAssert;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;

	public class A32CreateBookingWithSchemaValidator {

		public void jsonSchemaValidator() {
			// Setup request
			RestAssured
				.given()
				.log()
				.all()
				.baseUri("https://restful-booker.herokuapp.com/")
				.basePath("booking")
				.body("{\r\n" + 
					"    \"firstname\" : \"Amod\",\r\n" + 
					"    \"lastname\" : \"Mahajan\",\r\n" + 
					"    \"totalprice\" : 15,\r\n" + 
					"    \"depositpaid\" : false,\r\n" + 
					"    \"bookingdates\" : {\r\n" + 
					"        \"checkin\" : \"2021-01-01\",\r\n" + 
					"        \"checkout\" : \"2021-01-01\"\r\n" + 
					"    },\r\n" + 
					"    \"additionalneeds\" : \"Lunch\"\r\n" + 
					"}")
				.contentType(ContentType.JSON)
				// Hit the request and get the response
				.post()
				// Validate the response 
				.then()
				.log()
				.all()
				.statusCode(200)
				.body(JsonSchemaValidator
						.matchesJsonSchemaInClasspath("CreateBookingResponseSchema.json"))
				.body(JsonSchemaValidator
						.matchesJsonSchema
						(new File("C:\\AmodMahajanAnother\\Youtube\\APIBatchDec\\restassuredProjectMse\\src\\test\\java\\RestfulBooker\\CreateBookingResponseSchema1.json")));
				
			
		}
		
		
		
		public void validateJsonAgainstSchema() {
			String json = "{\r\n" + 
					"    \"bookingid\": 1,\r\n" + 
					"    \"booking\": {\r\n" + 
					"        \"firstname\": \"Jim\",\r\n" + 
					"        \"lastname\": \"Brown\",\r\n" + 
					"        \"totalprice\": 111,\r\n" + 
					"        \"depositpaid\": true,\r\n" + 
					"        \"bookingdates\": {\r\n" + 
					"            \"checkin\": \"2018-01-01\",\r\n" + 
					"            \"checkout\": \"2019-01-01\"\r\n" + 
					"        },\r\n" + 
					"        \"additionalneeds\": \"Breakfast\"\r\n" + 
					"    }\r\n" + 
					"}";
			
			MatcherAssert.assertThat(json, 
					JsonSchemaValidator.matchesJsonSchemaInClasspath("CreateBookingResponseSchema.json"));
		
		}
	
}
