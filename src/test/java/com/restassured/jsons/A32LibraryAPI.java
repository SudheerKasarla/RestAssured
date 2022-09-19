package com.restassured.jsons;

import org.testng.annotations.Test;

import com.restassured.payload.Payload;
import com.restassured.payload.ReUsableMethods;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

public class A32LibraryAPI {
	
	
	
	@Test
	public void libraryAPI()
	{
		RestAssured.baseURI="http://216.10.245.166";
		String respone=   RestAssured.given().log().all().contentType(ContentType.JSON)
		.body(Payload.addBook())
		.when()
		.post("/Library/Addbook.php")
		.then().log().all().assertThat().statusCode(200)
		.extract().response().asString();
		
		JsonPath jsonPath=	ReUsableMethods.rawToJson(respone);
		String id = jsonPath.get("ID");
		System.out.println("Id is...."+ id);
		
		
	}

}
