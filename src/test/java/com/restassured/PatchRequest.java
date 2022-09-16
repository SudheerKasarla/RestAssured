package com.restassured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PatchRequest {

	public static void main(String[] args) {

		
		  
		RestAssured
			.given()
				.log()
				.all()
				.baseUri("https://restful-booker.herokuapp.com/")
				.basePath("booking/10")
				.body("{\r\n"
						+ "    \"firstname\" : \"James Bond\",\r\n"
						+ "    \"lastname\" : \"Maharaj\"\r\n"
						+ "}")
				.contentType(ContentType.JSON)   //We are passing content in JSON format, we need to mention Content TYPE
				.header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
			.when()
				.patch()
			.then()
				.log()
				.all()
				.assertThat()
				.statusCode(200);

	}

}
