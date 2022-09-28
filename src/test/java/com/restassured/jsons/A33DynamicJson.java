package com.restassured.jsons;

import org.testng.annotations.Test;

import com.restassured.payload.Payload;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
public class A33DynamicJson {

	@Test
	public void DynamicJson() {
		RestAssured.baseURI = "http://216.10.245.166";

		String response = RestAssured.given().log().all()
									   .contentType(ContentType.JSON)
									   .body(Payload.addBook())
									   .when()
									   .post("/Library/Addbook.php")
									   .then().log().all()
									   .extract().response()
									   .asString();
		System.out.println("Response is...."+ response);
				JsonPath jsonPath = new JsonPath(response);
				System.out.println("ID is........."+jsonPath.get("ID"));
	}

	
	@Test
	public void DynamicJson2() 
{
		RestAssured.baseURI = "http://216.10.245.166";

		String response = RestAssured.given().log().all()
									   .contentType(ContentType.JSON)
									   .body(Payload.addBook("XYX123", "BHNNJNN"))
									   .when()
									   .post("/Library/Addbook.php")
									   .then().log().all()
									   .extract().response()
									   .asString();
		System.out.println("Response is...."+ response);
				JsonPath jsonPath = new JsonPath(response);
				System.out.println("ID is........."+jsonPath.get("ID"));
	}

	
	
	
	@Test(dataProvider="BooksData")

	public void addBook(String isbn,String aisle)
	{
	
		RestAssured.baseURI="http://216.10.245.166";

		Response resp=RestAssured.given().

		header("Content-Type","application/json").

		body(Payload.addBook(isbn,aisle)).

		when().

		post("/Library/Addbook.php").

		then().assertThat().statusCode(200).

		extract().response();

	/*
	 * //JsonPath js= ReUsableMethods.rawToJson(resp); // .rawToJson(resp);
	 * 
	 * String id=js.get("ID");
	 * 
	 * System.out.println(id);
	 */

	   

	   //deleteBOok

	}

	/*
	 * @DataProvider(name="BooksData")
	 * 
	 * public Object[][] getData()
	 * 
	 * {
	 * 
	 * //array=collection of elements
	 * 
	 * //multidimensional array= collection of arrays
	 * 
	 * return new Object[][] {‌{"ojfwty","9363"},{"cwetee","4253"}, {"okmfet","533"}
	 * };
	 * 
	 * }
	 */

}
