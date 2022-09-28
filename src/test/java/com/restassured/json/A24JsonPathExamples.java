package com.restassured.json;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class A24JsonPathExamples {

	
	
	
	/*
	 * JSON -- Javascript object notation
	 * JsonPath is an expression to refer element in a json document.
	 * It can be called as a query language for JSON document.
	 * RestAssured uses Groovy's GPath notation and not to be confused with Jayway's JsonPath syntax
	 * 
	 * 
	 * Root node is represented using dollar($) sign
	 * Child node is represent using dot(.)
	 * We can't use square bracket [] to represent child node.
	 * 
	 * 
	 * ClassCastException  == Due to casting issue. This issue will occur when we have different type of return.
	 * 
	 * 
	 */
	
	
	
	@Test
	public void jsonPathDemo() {
		
		
		String json ="{\r\n"
				+ "  \"firstName\" : \"KS Reddy\",\r\n"
				+ "  \"lastName\"  : \"Mahajan\",\r\n"
				+ "  \"Age\"       : 10,\r\n"
				+ "  \"Address\"   :{\r\n"
				+ "    \"Flatno\" : 001,\r\n"
				+ "    \"Appartment Nmae\" : \"ABC\",\r\n"
				+ "    \"Pin\"   : 100\r\n"
				+ "    \r\n"
				+ "  },\r\n"
				+ "  \"Salary\"    : 10.50,\r\n"
				+ "  \"Married\"   : true\r\n"
				+ "}";
		
		JsonPath jsonPath = new JsonPath(json);
		String firstName = jsonPath.getString("firstName");
		
		
		  System.out.println("Firstname is..." + firstName);
		  
		  
		  Object fname = jsonPath.get("firstName"); 
		  System.out.println("Name is..."+fname);
		 
		
		
		System.out.println("$ is......"+(Object)jsonPath.get("$"));
		System.out.println("$ getString is......"+(Object)jsonPath.getString("$"));
		System.out.println("Get string is...."+(Object)jsonPath.getString(""));
		System.out.println("Get is....."+(Object)jsonPath.get());  
		
		
	}
	
}
