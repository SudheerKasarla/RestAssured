package com.restassured.json;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class A36JsonArrayPayload {
	
	
	@Test
	public void jsonArray()
	{
		Map<String,Object> jsonObjectPayload = new LinkedHashMap<>();
		jsonObjectPayload.put("id", 123);
		jsonObjectPayload.put("first_name", "Hannis");
		jsonObjectPayload.put("last_name", "Coode");
		jsonObjectPayload.put("email", "hcoode0@digg.com");
		jsonObjectPayload.put("gender", "Polygender");
		
		Map<String,Object> jsonObjectPayload2 = new LinkedHashMap<>();
		jsonObjectPayload2.put("id", 1232);
		jsonObjectPayload2.put("first_name", "Hannis2");
		jsonObjectPayload2.put("last_name", "Coode2");
		jsonObjectPayload2.put("email", "hcoode02@digg.com");
		jsonObjectPayload2.put("gender", "Polygender2");
		
		List<Map<String, Object>> allEmp = new ArrayList<>();
		allEmp.add(jsonObjectPayload);
		allEmp.add(jsonObjectPayload2);
		
		RestAssured
				.given()
				.log()
				.all()
				.body(allEmp)
				.get();
		
	}
	

}
