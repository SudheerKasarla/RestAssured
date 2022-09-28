package com.restassured;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class DefaultValues {

	@BeforeTest
	public void setup() {
		RestAssured.baseURI = "https://restful-booker.herokuapp.com/";
		RestAssured.basePath = "booking";
		RestAssured.requestSpecification = RestAssured.given().log().all();
		RestAssured.responseSpecification = RestAssured.expect().statusCode(200);
	}

	@Test
	public static void CreateBooking() {

		RestAssured.given().log().all()
				/*
				 * .baseUri("https://restful-booker.herokuapp.com/") .basePath("booking")
				 */
				.contentType(ContentType.JSON)
				.body("{\r\n" + "    \"firstname\" : \"James\",\r\n" + "    \"lastname\" : \"Brown\",\r\n"
						+ "    \"totalprice\" : 111,\r\n" + "    \"depositpaid\" : true,\r\n"
						+ "    \"bookingdates\" : {\r\n" + "        \"checkin\" : \"2018-01-01\",\r\n"
						+ "        \"checkout\" : \"2019-01-01\"\r\n" + "    },\r\n"
						+ "    \"additionalneeds\" : \"Breakfast\"\r\n" + "}")

				.post().then().log().all();
		// .statusCode(200);

	}

	@Test
	public static void CreateBooking2() {

		RestAssured.given()
				/*
				 * .log() .all() .baseUri("https://restful-booker.herokuapp.com/")
				 * .basePath("booking")
				 */
				.contentType(ContentType.JSON)
				.body("{\r\n" + " \"firstname\" : \"Brannon\",\r\n" + "   " + " \"lastname\" : \"James\",\r\n"
						+ " \"totalprice\" : 1,\r\n" + " \"depositpaid\" : true,\r\n" + "  \"bookingdates\" : {\r\n"
						+ " \"checkin\" : \"2018-01-01\",\r\n" + " \"checkout\" : \"2019-01-01\"\r\n" + "  },\r\n"
						+ "   \"additionalneeds\" : \"Breakfast\"\r\n" + "}")

				.post().then().log().all();
		// .statusCode(200);

	}

	@Test
	public void TestDefault() {

		RestAssured.baseURI = "https://restful-booker.herokuapp.com/";
		RestAssured.basePath = "booking";
		RestAssured.requestSpecification = RestAssured.given().log().all();
		RestAssured.requestSpecification
				.body("{\r\n" + " \"firstname\" : \"Brannon2\",\r\n" + "   " + " \"lastname\" : \"James2\",\r\n"
						+ " \"totalprice\" : 1,\r\n" + " \"depositpaid\" : true,\r\n" + "  \"bookingdates\" : {\r\n"
						+ " \"checkin\" : \"2018-01-01\",\r\n" + " \"checkout\" : \"2019-01-01\"\r\n" + "  },\r\n"
						+ "   \"additionalneeds\" : \"Breakfast\"\r\n" + "}");
		Response response = RestAssured.requestSpecification.post();
		ValidatableResponse validateResponse = response.then();

		try {
			// validateResponse.statusCode(200);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("Validate Response is...." + validateResponse.extract().statusCode());

	}

}
