package com.restassured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class DeleteRequest {

	@Test
	public static void Delete() {

			RestAssured.given().log().all()
			.baseUri("https://restful-booker.herokuapp.com/")
			.basePath("booking/10")
			.header("Content-Type", "application/json")
			.header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
			.header("Cookie", "token=abc123")
			.when()
			.delete().then().log().all()
			.assertThat()
			.log().all().statusCode(201);

	}

}
