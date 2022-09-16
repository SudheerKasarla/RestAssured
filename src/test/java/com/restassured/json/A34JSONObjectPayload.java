package com.restassured.json;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class A34JSONObjectPayload {
	
	
	
	
	@Test
	public void simpleJsonObjectUsingMap() {
		
		
		Map<String,String> jsonObjectPayload = new HashMap<>();
		jsonObjectPayload.put("id", "123");
		jsonObjectPayload.put("first_name", "Ram");
		jsonObjectPayload.put("last_name", "Reddy");
		jsonObjectPayload.put("married", "false");
		jsonObjectPayload.put("salary", "123.25");
		
		
		RestAssured
			.given()
			.log()
			.all()
			.body(jsonObjectPayload)
			.get();
		
		
	}
	
	@Test
	public void simpleJsonObjectUsingMap2() {
		
		
		Map<String,Object> jsonObjectPayload = new LinkedHashMap<>();;
		jsonObjectPayload.put("id", 123);
		jsonObjectPayload.put("first_name", "Ram");
		jsonObjectPayload.put("last_name", "Reddy");
		jsonObjectPayload.put("married", false);
		jsonObjectPayload.put("salary", 123.25);
		
		
		RestAssured
			.given()
			.log()
			.all()
			.body(jsonObjectPayload)
			.get();
		
		
	}

}
