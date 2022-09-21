package com.restassured.json;

import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class A35NestedObjectPayloadJavaMap {
	
	
	
	
	
	@Test
	public void nestedJsonObjectPayload() {
		
		
		Map<String,Object> jsonObjectPayload = new LinkedHashMap<>();
		jsonObjectPayload.put("id", 123);
		jsonObjectPayload.put("first_name", "Ram");
		jsonObjectPayload.put("last_name", "Reddy");
		jsonObjectPayload.put("married", false);
		jsonObjectPayload.put("salary", 123.25);
		
		
		
		Map<String,Object> addressMap = new LinkedHashMap<>();
		addressMap.put("no", "123");
		addressMap.put("streetname", "ABC");
		addressMap.put("city", "Hyd");
		addressMap.put("state", "In");
		
		
		jsonObjectPayload.put("address", addressMap);
		
		RestAssured
				.given()
				.log()
				.all()
				.body(jsonObjectPayload)
				.when()
				.get().then().log().all();
	}

}
