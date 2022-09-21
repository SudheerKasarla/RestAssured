package com.restassured.json;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class A25JsonPathJsonObject {
	
	
	
	
	
	
	@Test
	public void jsonPath()
	{
		
		String jsonObject ="{\r\n"
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
	
		JsonPath jp =new JsonPath(jsonObject);
		String firstName= jp.getString("firstName");
	
	
		System.out.println("Firstname is..." + firstName);
		
		int age = jp.getInt("Age");
		System.out.println("Age is..."+age);
		
		double salary =jp.getDouble("Salary");
		System.out.println("Salary is..." + salary);
		
		boolean married = jp.getBoolean("Married");
		System.out.println(married);
		
		
		
		
		
	}
	
	
	@Test
	public void nestedJsonObject() {

		String jsonObject ="{\r\n"
			+ "  \"firstName\" : \"KS Reddy\",\r\n"
			+ "  \"lastName\"  : \"Mahajan\",\r\n"
			+ "  \"Age\"       : 10,\r\n"
			+ "  \"Address\"   :{\r\n"
			+ "    \"Flatno\" : 00100,\r\n"
			+ "    \"Appartment Nmae\" : \"ABC\",\r\n"
			+ "    \"Pin\"   : 100\r\n"
			+ "    \r\n"
			+ "  },\r\n"
			+ "  \"Salary\"    : 10.50,\r\n"
			+ "  \"Married\"   : true\r\n"
			+ "}";
		
		
		JsonPath jp =new JsonPath(jsonObject);
		int pin = jp.get("Address.Pin");
		System.out.println("Pin is..."+ pin);
		
		
		Object obj= jp.get("Address.Flatno");
		System.out.println("Address is......" +obj);
	}
	
	
	
	
	
	
}
