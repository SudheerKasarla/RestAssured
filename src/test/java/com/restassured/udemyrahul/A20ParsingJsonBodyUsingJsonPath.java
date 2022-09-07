package com.restassured.udemyrahul;

import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.restassured.payload.Payload;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

public class A20ParsingJsonBodyUsingJsonPath {
	// validate if Add Place API is workimg as expected
	// Add place-> Update Place with New Address -> Get Place to validate if New
	// address is present in response

	/*
	 * RestAssured.b="https://rahulshettyacademy.com"; String
	 * response=given().log().all()
	 * .queryParam("key","qaclick123").header("Content-Type","application/json")
	 * .body(Payload.addPlace()).when().post("maps/api/place/add/json")
	 * .then().assertThat().statusCode(200).body("scope", equalTo("APP"))
	 * .header("server", "Apache/2.4.18 (Ubuntu)")
	 */

	@Test
	public void parJson() {

		/*
		 * String response = RestAssured.given().log().all()
		 * .baseUri("https://rahulshettyacademy.com") .queryParam("key","qaclick123")
		 * .contentType(ContentType.JSON) .body(Payload.addPlace()) .when()
		 * .post("maps/api/place/add/json") .then() .log() .all() .
		 * assertThat().statusCode(200) .body("scope", equalTo("APP")) .header("server",
		 * "Apache/2.4.41 (Ubuntu)"). extract().response().toString();
		 * 
		 * System.out.println("Response is..."+ response);
		 */

		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response2 = RestAssured.given().log().all().queryParam("key", "qaclick123")
				.header("Content-Type", "application/json").body(Payload.addPlace()).when()
				.post("maps/api/place/add/json").then().assertThat().statusCode(200).body("scope", equalTo("APP"))
				.header("server", "Apache/2.4.41 (Ubuntu)").extract().response().asString();
		JsonPath js = new JsonPath(response2);

		Object name = js.getString("place_id");
		System.out.println("Place Id is....." + name);
	}

	@Test
	public void jsonXml() {
		// TODO Auto-generated method stub
		// validate if Add Place API is workimg as expected
		// Add place-> Update Place with New Address -> Get Place to validate if New
		// address is present in response

		// given - all input details
		// when - Submit the API -resource,http method
		// Then - validate the response
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response = RestAssured.given().log().all().queryParam("key", "qaclick123")
				.header("Content-Type", "application/json").body(Payload.addPlace()).when()
				.post("maps/api/place/add/json").then().assertThat().statusCode(200).body("scope", equalTo("APP"))
				.header("server", "Apache/2.4.41 (Ubuntu)").extract().response().asString();

		System.out.println("Response is........" + response);
		JsonPath js = new JsonPath(response); // for parsing Json
		String placeId = js.getString("place_id");

		System.out.println("Place id is...." + placeId);
		
		// Update place
		String newAddress = "Summer Walk, Africa";
		RestAssured.given().log().all().queryParam("key", "qaclick123").contentType(ContentType.JSON)
		.body("{\r\n"
				+ "  \"place_id\":\""+placeId+"\",\r\n"
				+ "  \"address\" : \""+newAddress+"\",\r\n"
				+ "      \"key\" : \"qaclick123\"\r\n"
				+ "}")
		.when()
		.put("maps/api/place/update/json")
		.then().assertThat().statusCode(200).log().all()
		.body("msg", equalTo("Address successfully updated"));
		
		
		
		
		//Get Place
		String getResponse=
		RestAssured.given().log().all().queryParam("key", "qaclick123")
		.queryParam("key", "qaclick123")
		.queryParam("place_id", placeId)
		.when()
		.get("maps/api/place/get/json")
		.then().assertThat()
		.log().all().statusCode(200).extract().response().asString();
		
		JsonPath jsonPath = new JsonPath(getResponse);
		String newAddress2=	jsonPath.getString("address");
		Assert.assertEquals(newAddress,newAddress2);
	}
	
	
	@Test
	public void A26JsonArraySize()
	{
		
		JsonPath jsonPath = new JsonPath(Payload.CoursePrice());
		int count=jsonPath.getInt("courses.size()");
		System.out.println("Size is...."+ count);
	}

}
