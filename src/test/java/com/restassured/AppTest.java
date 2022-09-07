package com.restassured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class AppTest {

	public static void main(String[] args) {

		RequestSpecification requestspecification = RestAssured.given();
		requestspecification.log().all();

		requestspecification.baseUri("https://restful-booker.herokuapp.com/");
		requestspecification.basePath("booking");
		requestspecification.contentType(ContentType.JSON);
		requestspecification.when();
		requestspecification.body("{\r\n"
				+ "    \"firstname\" : \"Jim\",\r\n"
				+ "    \"lastname\" : \"Brown\",\r\n"
				+ "    \"totalprice\" : 111,\r\n"
				+ "    \"depositpaid\" : true,\r\n"
				+ "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2018-01-01\",\r\n"
				+ "        \"checkout\" : \"2019-01-01\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
				+ "}");
		Response response = requestspecification.post();
		ValidatableResponse validateresponse = response.then().log().all();
		validateresponse.statusCode(200);

	}
}
