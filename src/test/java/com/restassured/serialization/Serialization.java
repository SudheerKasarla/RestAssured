package com.restassured.serialization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Serialization {

	/*
	 * For Serialization - we need maven repository 1) Jackson DataBind ---
	 * Respository and its dependencies i.e jackson-annotations, jackson-core 2)
	 * GSon Repository
	 * 
	 * 
	 * 
	 */

	@Test
	public void Serialization2() {
		String accessTokenResponse = RestAssured.given().urlEncodingEnabled(false)
				// .queryParams("code",code)
				.queryParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
				.queryParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
				.queryParams("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
				.queryParams("grant_type", "authorization_code").when().log().all()
				.post("https://www.googleapis.com/oauth2/v4/token").asString();
		JsonPath js = new JsonPath(accessTokenResponse);
		String accessToken = js.getString("access_token");

		GetCourse gs = RestAssured.given().queryParam("access_token", accessToken).expect().defaultParser(Parser.JSON)
				.when().get("https://rahulshettyacademy.com/getCourse.php").as(GetCourse.class);
		System.out.println("Linkedin...." + gs.getLinkedIn());

		gs.getCourses().getApi().get(1).getCourseTitle();

		List<Api> apiCourses = gs.getCourses().getApi();
		for (int i = 0; i < apiCourses.size(); i++) {
			if (apiCourses.get(i).getCourseTitle().equalsIgnoreCase("SoapUI webservices Testing")) {
				System.out.println("Course title..." + apiCourses.get(i).getPrice());
			}
		}

		// Get the course names of WebAutomation

		String[] courseTitles = { "Selenium Webdriver Java", "Cypress", "Protractor" };
		List<WebAutomation> wagc = gs.getCourses().getWebAutomation();
		ArrayList<String> as = new ArrayList<String>();
		for (int i = 0; i < wagc.size(); i++) {
			// System.out.println("WebAutomation course title...."+
			// wagc.get(i).getCourseTitle());
			as.add(wagc.get(i).getCourseTitle());
		}

		List<String> expectedList = Arrays.asList(courseTitles);

		Assert.assertTrue(as.equals(expectedList));

	}

	@Test
	public void SerializeTest() {
		AddPlace p = new AddPlace();
		p.setAccuracy(50);
		p.setAddress("India");
		p.setLanguage("English");
		p.setWebsite("https://rahulshettyacademy.com");
		p.setName("Google Maps");
		List<String> mylist = new ArrayList<String>();
		mylist.add("Sports");
		mylist.add("Cricket");
		p.setTypes(mylist);

		Location loc = new Location();
		loc.setLat(23.234567);
		loc.setLng(42.95623);
		p.setLocation(loc);

		RestAssured.baseURI = "https://rahulshettyacademy.com";
		Response res = RestAssured.given().log().all().queryParam("key", "qaclick123").body(p).when()
				.post("/maps/api/place/add/json").then().assertThat().statusCode(200).extract().response();
		String responseString = res.asString();
		System.out.println(responseString);
	}

	@Test
	public void serializeTest() {

		RestAssured.baseURI = "https://rahulshettyacademy.com";
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
		Response res = RestAssured.given().log().all().queryParam("key", "qaclick123").body(p).when()
				.post("/maps/api/place/add/json").then().assertThat().statusCode(200).extract().response();

		String responseString = res.asString();
		System.out.println(responseString);
	}

}
