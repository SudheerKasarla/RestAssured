package com.restassured.jsons;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.restassured.payload.Payload;
import com.restassured.payload.ReUsableMethods;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;


public class RestBasics {

	
	@Test
	public void basicAPI() {


		//Validate if Add Place API is working as expected.
		
		
		//given - all input details
		//when - submit the API
		//then - validate the response
		
		
		/*
		 * RestAssured.baseURI ="{\r\n" + "  \"location\": {\r\n" +
		 * "    \"lat\": -38.383494,\r\n" + "    \"lng\": 33.427362\r\n" + "  },\r\n" +
		 * "  \"accuracy\": 50,\r\n" + "  \"name\": \"Rahul Shetty Academy\",\r\n" +
		 * "  \"phone_number\": \"(+91) 983 893 3937\",\r\n" +
		 * "  \"address\": \"29, side layout, cohen 09\",\r\n" + "  \"types\": [\r\n" +
		 * "    \"shoe park\",\r\n" + "    \"shop\"\r\n" + "  ],\r\n" +
		 * "  \"website\": \"http://rahulshettyacademy.com\",\r\n" +
		 * "  \"language\": \"French-IN\"\r\n" + "}\r\n" + "";
		 */
		RestAssured
			.given()
				.queryParam("key", "qaclick123")
				.baseUri("https://rahulshettyacademy.com/")
				.basePath("maps/api/place/add/json")
				.contentType(ContentType.JSON)
				.body("{\r\n" + 
							"  \"location\": {\r\n" + 
							"    \"lat\": -38.383494,\r\n" + 
							"    \"lng\": 33.427362\r\n" + 
							"  },\r\n" + 
							"  \"accuracy\": 50,\r\n" + 
							"  \"name\": \"Rahul Shetty Academy\",\r\n" + 
							"  \"phone_number\": \"(+91) 983 893 3937\",\r\n" + 
							"  \"address\": \"29, side layout, cohen 09\",\r\n" + 
							"  \"types\": [\r\n" + 
							"    \"shoe park\",\r\n" + 
							"    \"shop\"\r\n" + 
							"  ],\r\n" + 
							"  \"website\": \"http://rahulshettyacademy.com\",\r\n" + 
							"  \"language\": \"French-IN\"\r\n" + 
							"}\r\n" + 
							"")
		.when()
				.post()
		.then().log().all().assertThat().statusCode(200)
				.body("scope", Matchers.equalTo("APP"))
				.header("server", "Apache/2.4.18 (Ubuntu)");
		
	}

	
	
	
	
	
	@Test
	public void basicAPI2() {


		//Validate if Add Place API is working as expected.
		
		
		//given - all input details
		//when - submit the API
		//then - validate the response
		
		
		/*
		 * RestAssured.baseURI ="{\r\n" + "  \"location\": {\r\n" +
		 * "    \"lat\": -38.383494,\r\n" + "    \"lng\": 33.427362\r\n" + "  },\r\n" +
		 * "  \"accuracy\": 50,\r\n" + "  \"name\": \"Rahul Shetty Academy\",\r\n" +
		 * "  \"phone_number\": \"(+91) 983 893 3937\",\r\n" +
		 * "  \"address\": \"29, side layout, cohen 09\",\r\n" + "  \"types\": [\r\n" +
		 * "    \"shoe park\",\r\n" + "    \"shop\"\r\n" + "  ],\r\n" +
		 * "  \"website\": \"http://rahulshettyacademy.com\",\r\n" +
		 * "  \"language\": \"French-IN\"\r\n" + "}\r\n" + "";
		 */
		RestAssured
			.given()
				.queryParam("key", "qaclick123")
				.baseUri("https://rahulshettyacademy.com/")
				.basePath("maps/api/place/add/json")
				.contentType(ContentType.JSON)
				.body("{\r\n" + 
							"  \"location\": {\r\n" + 
							"    \"lat\": -38.383494,\r\n" + 
							"    \"lng\": 33.427362\r\n" + 
							"  },\r\n" + 
							"  \"accuracy\": 50,\r\n" + 
							"  \"name\": \"Rahul Shetty Academy\",\r\n" + 
							"  \"phone_number\": \"(+91) 983 893 3937\",\r\n" + 
							"  \"address\": \"29, side layout, cohen 09\",\r\n" + 
							"  \"types\": [\r\n" + 
							"    \"shoe park\",\r\n" + 
							"    \"shop\"\r\n" + 
							"  ],\r\n" + 
							"  \"website\": \"http://rahulshettyacademy.com\",\r\n" + 
							"  \"language\": \"French-IN\"\r\n" + 
							"}\r\n" + 
							"")
		.when()
				.post()
		.then().log().all().assertThat().statusCode(200)
				.body("scope", Matchers.equalTo("APP"))
				.header("Server", "Apache/2.4.18 (Ubuntu)");
		
	}
	
	@Test
	public void basicAPI3()
	{
		String response = RestAssured
		.given()
			.queryParam("key", "qaclick123")
			.baseUri("https://rahulshettyacademy.com/")
			.basePath("maps/api/place/add/json")
			.contentType(ContentType.JSON)
			.body(Payload.addPlace())
	.when()
			.post()
	.then().assertThat().statusCode(200)
			.body("scope", Matchers.equalTo("APP"))
		
			.extract().response().asString();
		
		System.out.println("Response is..."+response);
		
		JsonPath jsonpath =new JsonPath(response);
		String placeId=jsonpath.getString("place_id");
		System.out.println("Place ID is..."+ placeId); 
		
		String newAddress = "Summer Walk, Africa";
		 RestAssured
			.given().log().all()
				.queryParam("key", "qaclick123")
				.baseUri("https://rahulshettyacademy.com/")
				.basePath("maps/api/place/update/json")
				.contentType(ContentType.JSON)
				.body("{\r\n" + 
						"\"place_id\":\""+placeId+"\",\r\n" + 
						"\"address\":\""+newAddress+"\",\r\n" + 
						"\"key\":\"qaclick123\"\r\n" + 
						"}")
				.when()
					.put("maps/api/place/add/json")
				.then()
				.log().all()
					.assertThat().statusCode(200).log().all();//body("m", null)
		 
		
		 //Get place
		 
		String getPlaceResponse= RestAssured
			.given().log().all()
			.baseUri("https://rahulshettyacademy.com/")
			.queryParam("key", "qaclick123")
			.queryParam("place_id", placeId)
			.when().get("maps/api/place/get/json")
			.then().assertThat().log().all().statusCode(200).extract().response().asString();
		 
		// JsonPath jsonPath = new JsonPath(getPlaceResponse);
		JsonPath jsonPath =ReUsableMethods.rawToJson(getPlaceResponse);
		 String actualAddress = jsonPath.getString("address");
		 
		 System.out.println("Actual Address..........."+ actualAddress);
		 Assert.assertEquals(actualAddress, newAddress);
				
		
	}

}
