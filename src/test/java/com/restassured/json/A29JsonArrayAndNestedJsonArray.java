package com.restassured.json;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class A29JsonArrayAndNestedJsonArray {
	
	
	
	@Test
	public void jsonPathArray() {
		
		String jsonPath ="[\r\n"
				+ "  {\r\n"
				+ "    \"firstName\": \"KS Reddy\",\r\n"
				+ "    \"lastName\": \"Mahajan\",\r\n"
				+ "    \"Age\": 10,\r\n"
				+ "    \"Salary\": 10.5,\r\n"
				+ "    \"Address\": [\r\n"
				+ "      {\r\n"
				+ "        \"City\": \"Bengaluru\",\r\n"
				+ "        \"Country\": \"India\"\r\n"
				+ "      },\r\n"
				+ "      {\r\n"
				+ "        \"City\": \"Hyd\",\r\n"
				+ "        \"Country\": \"India\"\r\n"
				+ "      }\r\n"
				+ "    ]\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "    \"firstName\": \"KS Reddy2\",\r\n"
				+ "    \"lastName\": \"Mahajan\",\r\n"
				+ "    \"Age\": 10,\r\n"
				+ "    \"Salary\": 10.5,\r\n"
				+ "    \"Married\": true,\r\n"
				+ "     \"Address\": [\r\n"
				+ "      {\r\n"
				+ "        \"City\": \"Bengaluru2\",\r\n"
				+ "        \"Country\": \"India\"\r\n"
				+ "      },\r\n"
				+ "      {\r\n"
				+ "        \"City\": \"Hyd2\",\r\n"
				+ "        \"Country\": \"India\"\r\n"
				+ "      }\r\n"
				+ "    ]\r\n"
				+ "  },\r\n"
				+ "  true,\r\n"
				+ "  \"India\",\r\n"
				+ "  20.3,\r\n"
				+ "  101\r\n"
				+ "]";
		
		
		JsonPath jsPath =new JsonPath(jsonPath);
		
		String city2  = jsPath.get("[0].Address[0].City");
		System.out.println("City is...."+ city2);
		
		
		String city3  = jsPath.get("[1].Address[0].City");
		System.out.println("City3 is...."+ city3);
		
		List<Object> list = jsPath.getList("[0].Address.City");
		
		System.out.println(" List of cities...." + list);
		System.out.println("List cities is...." + jsPath.getList("Address.City"));
		
	}

}
