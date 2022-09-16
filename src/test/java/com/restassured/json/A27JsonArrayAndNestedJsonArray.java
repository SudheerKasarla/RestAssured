package com.restassured.json;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class A27JsonArrayAndNestedJsonArray {
	
	
	/*
	 * Json array 
	 * 
	 */
	
	
	
	    /*
	          [
  				{
    				"firstName": "KS Reddy",
    				"lastName": "Mahajan",
    				"Age": 10,
    				"Salary": 10.5,
    				"Address" : 
    				[
      					{
        					"City" : "Bengaluru",
        					"Country" : "India"
      					},
      					{
         					"City" : "Hyd",
        					"Country" : "India"
      					}
    		  		]
  				},
  				{
    				"firstName": "KS Reddy2",
    				"lastName": "Mahajan",
    				"Age": 10,
    				"Salary": 10.5,
    				"Married": true
  				},
  				true,
  				"India",
  				20.30,
  				101
			]
	 * 
	 */
	
	
	
	
	@Test
	public void jsonArray() {
		
		String jsonArray = "[\r\n"
				+ " \"10\",\r\n"
				+ " \"20\",\r\n"
				+ " \"30\",\r\n"
				+ " \"40\",\r\n"
				+ " \"50\"\r\n"
				+ "]\r\n"
				+ "";
		
		JsonPath jsonPath =new JsonPath(jsonArray);
		System.out.println(jsonPath.getString("[0]"));  //Output : 10
		System.out.println("Size is..." + jsonPath.getList("$").size());   //Output : 5
	}
	
	
	
	
	
	
	
	@Test
	public void nestedJsonArray() {
		
		
		String jsonPath = "[\r\n"
				+ "  [\r\n"
				+ "   \"10\",\r\n"
				+ "   \"20\",\r\n"
				+ "   \"30\",\r\n"
				+ "   \"40\",\r\n"
				+ "   \"50\"\r\n"
				+ "  ],\r\n"
				+ "  [\r\n"
				+ "    \"10\",\r\n"
				+ "    \"20\",\r\n"
				+ "    \"30\",\r\n"
				+ "    \"40\",\r\n"
				+ "    \"50\"\r\n"
				+ "  ]\r\n"
				+ "  \r\n"
				+ "]\r\n"
				+ "";
		
		
		JsonPath jPath =new JsonPath(jsonPath);
		
		System.out.println("JsonElement is..."+ jPath.getString("[1][2]"));
		System.out.println("Json Element is..." + jPath.getList("$").size());   //output : 2
		
		@SuppressWarnings("unchecked")
		List<Object> innerList  =  (List<Object>)jPath.getList("$").get(0);
		
		System.out.println("Inner list...."+ innerList.size());
	}
	
	
	
}
