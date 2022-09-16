package com.restassured;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class MeasureResponseTime {
	
	public static void main(String[] args) {
		
		
		  

		Response response= RestAssured
			.given()
				.log()
				.all()
				.baseUri("https://restful-booker.herokuapp.com/")
				.basePath("booking")
				.body("{\r\n"
						+ "    \"firstname\" : \"Jim\",\r\n"
						+ "    \"lastname\" : \"Brown\",\r\n"
						+ "    \"totalprice\" : 111,\r\n"
						+ "    \"depositpaid\" : true,\r\n"
						+ "    \"bookingdates\" : {\r\n"
						+ "        \"checkin\" : \"2018-01-01\",\r\n"
						+ "        \"checkout\" : \"2019-01-01\"\r\n"
						+ "    },\r\n"
						+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
						+ "}")
				.contentType(ContentType.JSON)
			.when()
				.post();
		   long responseTimeInMS = response.time();
		   System.out.println("Response time in MS.  "+responseTimeInMS);
		   
		  long responseTimeInSeconds= response.timeIn(TimeUnit.SECONDS);
		   
		   System.out.println("Response time in Seconds  "+responseTimeInSeconds);
		   
		   response.getTime();
		   
		   response.getTimeIn(TimeUnit.SECONDS);
		   
		   
		   //Assertions
		   
		   
		   
		   response.then().time(Matchers.lessThan(5000L));
		   
		   response.then()
		   		   .time(Matchers.both(Matchers.greaterThan(1000L))
		   		   .and(Matchers.lessThan(6000L)));
		
		   response.then().time(Matchers.lessThan(2L),TimeUnit.SECONDS);
		    
				
				
	}

}
