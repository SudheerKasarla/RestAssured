package com.restassured;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.equalToIgnoringWhiteSpace;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.Matchers.startsWith;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.config.HeaderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/*

  
		JsonPath expressions can use the dot–notation.

		1)  $.store.book[0].title

				or the bracket–notation

		2)  $['store']['book'][0]['title']                      

https://qaautomation.expert/2021/06/30/logging-in-rest-assured/


To log all request specification details including parameters, headers and body of the request, log().all() 
needs to be added post given() section.   

given().log().params(). .. // Log only the parameters of the request
given().log().body(). .. // Log only the request body
given().log().headers(). .. // Log only the request headers
given().log().cookies(). .. // Log only the request cookies
given().log().method(). .. // Log only the request method
given().log().path(). .. // Log only the request path

 */

public class ZAllRestAssuredTutorials {

	@Test
	public void putTutorials() {

		RestAssured.given().log().all().header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
				.contentType(ContentType.JSON)
				.body("{\r\n" + "    \"firstname\" : \"James\",\r\n" + "    \"lastname\" : \"Brown\",\r\n"
						+ "    \"totalprice\" : 111,\r\n" + "    \"depositpaid\" : true,\r\n"
						+ "    \"bookingdates\" : {\r\n" + "        \"checkin\" : \"2018-01-01\",\r\n"
						+ "        \"checkout\" : \"2019-01-01\"\r\n" + "    },\r\n"
						+ "    \"additionalneeds\" : \"Breakfast\"\r\n" + "}")
				.when().put().then().assertThat().statusCode(200);
	}

	@Test
	public void pathParameterNamed() {

		RestAssured.given().log().all().baseUri("https://restful-booker.herokuapp.com/")
				.basePath("{basePath}/{bookingId}").pathParam("basePath", "booking").pathParam("bookingId", 10).when()
				.get().then().log().all();
	}

	@Test
	public void unNamedPathParameters() {
		RestAssured.given().log().all().baseUri("https://restful-booker.herokuapp.com/")
				.pathParam("basePath", "booking").when()
				.get("https://restful-booker.herokuapp.com/{basePath}/{bookingId}", 10).then().log().all()
				.statusCode(200);
	}

	@Test
	public void unNamedPathParameters2() {

		Map<String, Object> pathParam = new HashMap<>();
		pathParam.put("basePath", "booking");
		pathParam.put("bookingId", 10);

		RestAssured.given().log().all().baseUri("https://restful-booker.herokuapp.com/")
				.basePath("{basePath}/{bookingId}").pathParams(pathParam).when().get().then().log().all()
				.statusCode(200);
	}

	@Test
	public void pathRequest() {
		RestAssured.given().log().all().baseUri("https://restful-booker.herokuapp.com/").basePath("booking/10")
				.body("{\r\n" + "    \"firstname\" : \"James Bond\",\r\n" + "    \"lastname\" : \"Maharaj\"\r\n" + "}")
				.contentType(ContentType.JSON) // We are passing content in JSON format, we need to mention Content TYPE
				.header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=").when().patch().then().log().all()
				.assertThat().statusCode(200);
	}

	RequestSpecification requestSpecification;

	@Test
	public void createBooking() {
		requestSpecification = RestAssured.given();
		requestSpecification.baseUri("https://restful-booker.herokuapp.com/").basePath("booking").log().all()
				.header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=").contentType(ContentType.JSON)
				.body("{\r\n" + "    \"firstname\" : \"Jim\",\r\n" + "    \"lastname\" : \"Brown\",\r\n"
						+ "    \"totalprice\" : 111,\r\n" + "    \"depositpaid\" : true,\r\n"
						+ "    \"bookingdates\" : {\r\n" + "        \"checkin\" : \"2018-01-01\",\r\n"
						+ "        \"checkout\" : \"2019-01-01\"\r\n" + "    },\r\n"
						+ "    \"additionalneeds\" : \"Breakfast\"\r\n" + "}")
				.when().put().then().log().all().assertThat().statusCode(200);

	}

	@Test
	public void measureResponseTime() {

		Response response = RestAssured.given().log().all().basePath("").baseUri("").contentType(ContentType.JSON)
				.when().post();
		long responseInSeconds = response.time();
		System.out.println("Seconds is..." + responseInSeconds);
		// long responseTimeinMS = response.timeIn(TimeUnit.MILLISECONDS);
		System.out.println("Response in Time is..." + response.getTime());

		response.then().time(Matchers.lessThan(5000L));

		response.then().time(Matchers.both(Matchers.lessThan(5000L)).and(Matchers.greaterThan(6000L)));

		response.then().time(Matchers.lessThan(5000L), TimeUnit.SECONDS);

	}

	@Test
	public void getRequest() {
		RestAssured.given().log().all().baseUri("https://restful-booker.herokuapp.com/").basePath("booking/{bookingId}")
				.pathParam("bookingId", 10).when().get().then().log().all().statusCode(200);
	}

	@Test
	public void extractResponseAsString() {

		String response = RestAssured.given().log().all().baseUri("https://restful-booker.herokuapp.com/")
				.basePath("booking/{bookingId}").pathParam("bookingId", 10)
				.header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=").contentType(ContentType.JSON).when().get()
				.then().log().all().extract().asPrettyString();
		System.out.println("Response is....." + response);

	}

	@Test
	public void deleteRequest() {
		RestAssured.baseURI = "https://restful-booker.herokuapp.com/";
		RestAssured.basePath = "booking/10";

		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.log().all().contentType(ContentType.JSON)
				.header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=").when().delete().then().assertThat().log()
				.all().statusCode(200);
	}

	@Test
	public void headersConfig() {
		RestAssured.given()
				.config(RestAssuredConfig.config()
						.headerConfig(HeaderConfig.headerConfig().overwriteHeadersWithName("header1", "header1")))

				.config(RestAssuredConfig.config()
						.headerConfig(HeaderConfig.headerConfig().mergeHeadersWithName("header1", "value1")))
				.header("Header1", "Value1").header("Header2", "Value2").when().get().then().log().all();
	}

	@Test
	public void jsonPath() {
		String json = "{\r\n" + "  \"firstName\" : \"KS Reddy\",\r\n" + "  \"lastName\"  : \"Mahajan\",\r\n"
				+ "  \"Age\"       : 10,\r\n" + "  \"Address\"   :{\r\n" + "    \"Flatno\" : 001,\r\n"
				+ "    \"Appartment Nmae\" : \"ABC\",\r\n" + "    \"Pin\"   : 100\r\n" + "    \r\n" + "  },\r\n"
				+ "  \"Salary\"    : 10.50,\r\n" + "  \"Married\"   : true\r\n" + "}";

		JsonPath jsonPath = new JsonPath(json);
		String firstName = jsonPath.getString("firstName");
		System.out.println("First name is...." + firstName);

		Object name = jsonPath.get("firstName");
		System.out.println("Name is... " + name);

		System.out.println("$ is......" + (Object) jsonPath.get("$"));
		System.out.println("$ getString is......" + (Object) jsonPath.getString("$"));
		System.out.println("Get string is...." + (Object) jsonPath.getString(""));
		System.out.println("Get is....." + (Object) jsonPath.get());
	}

	@Test
	public void jsonPath2() {
		String jsonObject = "{\r\n" + "  \"firstName\" : \"KS Reddy\",\r\n" + "  \"lastName\"  : \"Mahajan\",\r\n"
				+ "  \"Age\"       : 10,\r\n" + "  \"Address\"   :{\r\n" + "    \"Flatno\" : 001,\r\n"
				+ "    \"Appartment Nmae\" : \"ABC\",\r\n" + "    \"Pin\"   : 100\r\n" + "    \r\n" + "  },\r\n"
				+ "  \"Salary\"    : 10.50,\r\n" + "  \"Married\"   : true\r\n" + "}";

		JsonPath jsonPath = new JsonPath(jsonObject);
		String firstName = jsonPath.getString("firstName");
		int age = jsonPath.getInt("Age");
		double sal = jsonPath.getDouble("Salary");
		boolean marriage = jsonPath.getBoolean("Married");

		System.out.println("Name is..." + firstName + "  Age is....." + age + "  Salary is...." + sal
				+ "  Marriage is..." + marriage);
	}

	@Test
	public void nestedObject() {
		String jsonObject = "{\r\n" + "  \"firstName\" : \"KS Reddy\",\r\n" + "  \"lastName\"  : \"Mahajan\",\r\n"
				+ "  \"Age\"       : 10,\r\n" + "  \"Address\"   :{\r\n" + "    \"Flatno\" : 00100,\r\n"
				+ "    \"Appartment Nmae\" : \"ABC\",\r\n" + "    \"Pin\"   : 100\r\n" + "    \r\n" + "  },\r\n"
				+ "  \"Salary\"    : 10.50,\r\n" + "  \"Married\"   : true\r\n" + "}";

		JsonPath jsonPath = new JsonPath(jsonObject);

		Object flatNo = (Object) jsonPath.get("Address.Flatno");
		int pin = jsonPath.getInt("Address.Pin");
		String sal = jsonPath.getString("Salary");

		System.out.println("Flat is..." + flatNo + " Pin is..." + pin + " Salary is....." + sal);
	}

	@Test
	public void jsonArray() {
		String jsonArray = "[\r\n" + " \"10\",\r\n" + " \"20\",\r\n" + " \"30\",\r\n" + " \"40\",\r\n" + " \"50\"\r\n"
				+ "]\r\n" + "";
		JsonPath jsonPath = new JsonPath(jsonArray);
		System.out.println("JsonArray is...." + jsonPath.getString("[0]"));
		System.out.println("Array size is...." + jsonPath.getList("$").size());
	}

	@SuppressWarnings("unchecked")
	@Test
	public void jsonArray2() {
		String jsonArray = "[\r\n" + "  [\r\n" + "   \"10\",\r\n" + "   \"20\",\r\n" + "   \"30\",\r\n"
				+ "   \"40\",\r\n" + "   \"50\"\r\n" + "  ],\r\n" + "  [\r\n" + "    \"10.1\",\r\n"
				+ "    \"20.2\",\r\n" + "    \"30.3\",\r\n" + "    \"40.4\",\r\n" + "    \"50.5\"\r\n" + "  ]\r\n"
				+ "  \r\n" + "]\r\n" + "";

		JsonPath jsonPath = new JsonPath(jsonArray);
		System.out.println("Array is......" + jsonPath.getString("[1][0]"));

		List<Object> obj = (List<Object>) jsonPath.getList("$").get(0);
		System.out.println("Size is...." + obj.size());

		System.out.println("Start of the array is....." + jsonPath.getList("$").get(0));
	}

	@Test
	public void jsonPathArrays() {
		String jsonArray = "[\r\n" + "  {\r\n" + "    \"firstName\": \"KS Reddy\",\r\n"
				+ "    \"lastName\": \"Mahajan\",\r\n" + "    \"Age\": 10,\r\n" + "    \"Salary\": 10.5,\r\n"
				+ "    \"Address\": [\r\n" + "      {\r\n" + "        \"City\": \"Bengaluru\",\r\n"
				+ "        \"Country\": \"India\"\r\n" + "      },\r\n" + "      {\r\n"
				+ "        \"City\": \"Hyd\",\r\n" + "        \"Country\": \"India\"\r\n" + "      }\r\n" + "    ]\r\n"
				+ "  },\r\n" + "  {\r\n" + "    \"firstName\": \"KS Reddy2\",\r\n"
				+ "    \"lastName\": \"Mahajan\",\r\n" + "    \"Age\": 10,\r\n" + "    \"Salary\": 10.5,\r\n"
				+ "    \"Married\": true,\r\n" + "    \"Address\": [\r\n" + "      {\r\n"
				+ "        \"City\": \"Bengaluru2\",\r\n" + "        \"Country\": \"India\"\r\n" + "      },\r\n"
				+ "      {\r\n" + "        \"City\": \"Hyd2\",\r\n" + "        \"Country\": \"India\"\r\n"
				+ "      }\r\n" + "    ]\r\n" + "  }\r\n" + "]";

		JsonPath jsonPath = new JsonPath(jsonArray);

		System.out.println("Array is.........." + jsonPath.get("[0].Address.City[1]"));

		// System.out.println("Array list is..."+ jsonPath.getList("[0]"));

		System.out.println("Array2 is........." + jsonPath.getList("[0].Address.City"));
	}

	@Test
	public void filters() {
		String fileName = System.getProperty("user.dir") + "\\Data\\Json.txt";
		File file = new File(fileName);

		JsonPath jsonPath = new JsonPath(file);

		System.out.println("Array is..." + jsonPath.getString("[0].last_name"));

		List<String> allFirstNames = jsonPath.getList("first_name");

		System.out.println("All first names is...." + allFirstNames);

		// Find all females

		List<String> allFemales = jsonPath.getList("findAll{it.gender=='Female'}.id");
		System.out.println("List is..." + allFemales);

		// First name is...."Robin" and Last name is... "Hood"

		List<String> gender = jsonPath.getList("findAll{it.first_name == 'Robin' & it.last_name == 'Hood'}.gender");
		System.out.println("Gender is....." + gender);

		List<String> firstName = jsonPath.getList("findAll{it.id >= 5}first_name");
		System.out.println("FirstName is...." + firstName);

		List<String> ID = jsonPath.getList("findAll{it.id}");

		System.out.println("ID is...." + ID.size());

		System.out.println("Json size is..." + jsonPath.get("size()"));

	}

	@Test
	public void filterData() {
		String filePath = System.getProperty("user.dir") + "\\Data\\Json2.txt";

		File file = new File(filePath);

		JsonPath jsonPath = new JsonPath(file);
		System.out.println("Gender is....." + jsonPath.getString("data[0].gender"));

		/*
		 * List<String> gender= jsonPath.getList("data.findAll{it.gender == 'Male'}");
		 * 
		 * System.out.println("All Male is....."+gender);
		 */

		List<String> allFemales = jsonPath.getList("data.findAll{it.gender =='Male' & it.id >=2}");

		System.out.println("All females is......." + allFemales);

	}

	@Test
	public void asserTions() {
		String jsonResponse =

				RestAssured.given().baseUri("https://restful-booker.herokuapp.com/auth")
						.body("{\r\n" + "    \"username\" : \"admin\",\r\n" + "    \"password\" : \"password123\"\r\n"
								+ "}")
						.contentType(ContentType.JSON).when().post().then().log().all().extract().asString();

		JsonPath jsonPath = new JsonPath(jsonResponse);
		Assert.assertNotNull(jsonPath.get("token"));
	}

	@Test
	public void inLineAssertions() {
		RestAssured.given().log().all().contentType(ContentType.JSON)
				.baseUri("https://restful-booker.herokuapp.com/auth")
				.body("{\r\n" + "    \"username\" : \"admin\",\r\n" + "    \"password\" : \"password123\"\r\n" + "}")
				.when().post().then().log().all().body("token", Matchers.notNullValue())
				.body("token.length()", Matchers.is(15)).body("token.length()", Matchers.equalTo(15))
				.body("token", Matchers.matchesRegex("^[a-z0-9]+$"));
	}

	@Test
	public void inLineAssertionsCreateBooking() {
		RestAssured.given().log().all().baseUri("https://restful-booker.herokuapp.com/booking").when().post().then()
				.log().all().body("", Matchers.hasItems(9, 10));
	}

	@Test
	public void jsonSchemaValidator() {
		String response = RestAssured.given().log().all().baseUri("https://restful-booker.herokuapp.com/")
				.basePath("booking")
				.body("{\r\n" + "    \"firstname\" : \"Amod\",\r\n" + "    \"lastname\" : \"Mahajan\",\r\n"
						+ "    \"totalprice\" : 15,\r\n" + "    \"depositpaid\" : false,\r\n"
						+ "    \"bookingdates\" : {\r\n" + "        \"checkin\" : \"2021-01-01\",\r\n"
						+ "        \"checkout\" : \"2021-01-01\"\r\n" + "    },\r\n"
						+ "    \"additionalneeds\" : \"Lunch\"\r\n" + "}")
				.contentType(ContentType.JSON)
				// Hit the request and get the response
				.post()
				// Validate the response
				.then().log().all().extract().asString();

		System.out.println("Response is....." + response);
	}

	@Test
	public void jsonSchemaValidator2() {
		RestAssured.given().log().all().baseUri("https://restful-booker.herokuapp.com/").basePath("booking")
				.contentType(ContentType.JSON)
				.body("{\r\n" + "    \"firstname\" : \"Amod\",\r\n" + "    \"lastname\" : \"Mahajan\",\r\n"
						+ "    \"totalprice\" : 15,\r\n" + "    \"depositpaid\" : false,\r\n"
						+ "    \"bookingdates\" : {\r\n" + "        \"checkin\" : \"2021-01-01\",\r\n"
						+ "        \"checkout\" : \"2021-01-01\"\r\n" + "    },\r\n"
						+ "    \"additionalneeds\" : \"Lunch\"\r\n" + "}")
				.when().post().then().log().all()
				.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("CreateBookingResponseSchema.json"))
				.body(JsonSchemaValidator.matchesJsonSchema(new File("C:\\Users\\sudheer.kasarla\\Downloads\\"
						+ "RestAssured\\RestAssured\\Data\\CreateBookingResponseSchema.json")));

		// MatcherAssert.assertThat(json,
		// JsonSchemaValidator.matchesJsonSchemaInClasspath(""));

	}

	@Test
	public void complexJsonArray() {
		/*
		 * { "employee1": [ { "firstname": "Tom", "salary": 720000, "age": 59,
		 * "lastname": "Mathew" } ], "employee2": [ { "firstname": "Perry", "salary":
		 * 365000, "age": 32, "lastname": "David" } ] }
		 */

		JSONObject data1 = new JSONObject();
		data1.put("firstname", "Tom");
		data1.put("salary", 720000);
		data1.put("age", 59);
		data1.put("lastname", "Mathew");

		JSONObject data2 = new JSONObject();
		data2.put("firstname", "Perry");
		data2.put("salary", 365000);
		data2.put("age", 32);
		data2.put("lastname", "Mathew");

		JSONArray array = new JSONArray();
		array.put(data1);

		JSONArray array2 = new JSONArray();
		array2.put(data2);

		JSONObject obj2 = new JSONObject();
		obj2.put("employee1", data1);
		obj2.put("employee2", data2);

		System.out.println("Complex json data is....." + obj2);

	}

	@SuppressWarnings("deprecation")
	@Test
	public void stringAssertions() {
		String endpoint = "https://restful-booker.herokuapp.com/booking/1";
		RestAssured.given().contentType(ContentType.JSON).when().get(endpoint).then().body("firstname",
				equalTo("Mark"));

		RestAssured.given().contentType(ContentType.JSON).when().get(endpoint).then().body("firstname",
				equalToIgnoringCase("MARk"));

		RestAssured.given().contentType(ContentType.JSON).when().get(endpoint).then().body("firstname",
				containsString("Mark"));

		RestAssured.given().contentType(ContentType.JSON).when().get(endpoint).then().body("firstname",
				startsWith("M"));

		RestAssured.given().contentType(ContentType.JSON).when().get(endpoint).then().body("firstname", endsWith("k"));

		RestAssured.given().contentType(ContentType.JSON).when().get(endpoint).then().body("firstname",
				equalToIgnoringWhiteSpace("   Mark "));

	}

	@Test
	public void collectionAssertions() {
		String endpoint = "https://restful-booker.herokuapp.com/booking/1";
		RestAssured.given().contentType(ContentType.JSON).when().get(endpoint).then().body("totalprice1",
				is(nullValue()));

		RestAssured.given().contentType(ContentType.JSON).when().get(endpoint).then().body("bookingdates",
				hasKey("checkin"));

	}

	@Test
	public void test() {
		String endpoint = "https://restful-booker.herokuapp.com/booking/1";
		RestAssured.given().contentType(ContentType.JSON).when().get(endpoint).then().body("firstname", equalTo("Jim"), // will
																														// fail
				"lastname", equalTo("Smith"), // will fail
				"totalprice", equalTo(314)); // will fail
	}

}
