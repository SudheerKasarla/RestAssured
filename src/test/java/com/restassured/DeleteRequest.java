package com.restassured;

import io.restassured.RestAssured;

public class DeleteRequest {

	public static void main(String[] args) {
	
		  
		RestAssured 
		.given()
			.log()
			.all()
			.baseUri("https://restful-booker.herokuapp.com/")
			.basePath("booking/10")
			.header("Content-Type", "application/json")
			.header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
		.when()
			.delete()
		.then()
			.assertThat()
			.log()
			.all()
			.statusCode(201);

	}

}
