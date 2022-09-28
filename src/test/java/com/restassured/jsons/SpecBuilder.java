package com.restassured.jsons;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.restassured.serialization.AddPlace;
import com.restassured.serialization.Location;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

/*
 * RequestSpecBuilder is used to develop a common method,where it can used as common object for request.
 * 
 * 	.build() --- Is used to build the operation.
 * 
 * 
 */



public class SpecBuilder {

	@Test
	public void SpecBuilder2() {
		AddPlace p = new AddPlace();
		p.setAccuracy(50);
		p.setAddress("29, side layout, cohen 09");
		p.setLanguage("French-IN");
		p.setPhNumber("(+91) 983 893 3937");
		p.setWebsite("https://rahulshettyacademy.com");
		p.setName("Frontline house");
		List<String> myList = new ArrayList<String>();
		myList.add("shoe park");
		myList.add("shop");

		p.setTypes(myList);
		Location l = new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		p.setLocation(l);
		
		
		RequestSpecification rsb = new RequestSpecBuilder()
														.setBaseUri("https://rahulshettyacademy.com")
														.addQueryParam("key", "qaclick123")
														.setContentType(ContentType.JSON)
														.build();
		
		ResponseSpecification responseSpecification = 	new ResponseSpecBuilder()
																							.expectStatusCode(200)
																							.expectContentType(ContentType.JSON)
																							.build();
		
		RequestSpecification requestSpecification = RestAssured.given()
																									.spec(rsb)
																									.body(p);
		
		Response response =requestSpecification.when()
																			.post("/maps/api/place/add/json")
																			.then()
																			.spec(responseSpecification)
																			.extract()
																			.response();
		
		String responseString = response.toString();
		System.out.println("Response string..............."+responseString);

	}

}
