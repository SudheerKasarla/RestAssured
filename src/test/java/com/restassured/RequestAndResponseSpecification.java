package com.restassured;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class RequestAndResponseSpecification {

	public static void main(String[] args) {

	
  
   	    RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification
				.log()
				.all()
				.baseUri("https://restful-booker.herokuapp.com/")
				.basePath("booking")
				.contentType(ContentType.JSON)
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
						+ "}");
		

		ResponseSpecification responseSpecification = RestAssured.expect();
		responseSpecification.statusCode(200);
		responseSpecification.contentType(ContentType.JSON);
		responseSpecification.time(Matchers.lessThan(5000L));
		
		
	
		
	
		
		/*
		 * RestAssured.given().parameters("firstName", "John", "lastName",
		 * "Doe").when().post("/greetXML") .then().body("greeting.firstName",
		 * equalTo("John"));
		 */

		
		
		RestAssured
			.given(requestSpecification,responseSpecification)
			//.spec(requestSpecification)
				/*
				 * .body("{\r\n" + "    \"firstname\" : \"James\",\r\n" +
				 * "    \"lastname\" : \"Brown\",\r\n" + "    \"totalprice\" : 111,\r\n" +
				 * "    \"depositpaid\" : true,\r\n" + "    \"bookingdates\" : {\r\n" +
				 * "        \"checkin\" : \"2018-01-01\",\r\n" +
				 * "        \"checkout\" : \"2019-01-01\"\r\n" + "    },\r\n" +
				 * "    \"additionalneeds\" : \"Breakfast\"\r\n" + "}")
				 */
			
			.post()
			.then()
			.log()
			.all();
			//.spec(responseSpecification);
	}
}
