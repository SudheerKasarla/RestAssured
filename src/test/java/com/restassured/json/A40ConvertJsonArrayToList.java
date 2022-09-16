package com.restassured.json;

import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;

public class A40ConvertJsonArrayToList {
	
	
	
	@Test
	@SuppressWarnings("unchecked")
	public void convertToJsonArrayToList() {
		
	List<Object> allEmp	=	RestAssured
											.get("https://run.mocky.io/v3/13cf90f3-8aa3-4cea-8316-efe0c256fc6c")
											.as(List.class);
	
	List<Map<String, Object>> allEmp1	=	RestAssured
			.get("https://run.mocky.io/v3/13cf90f3-8aa3-4cea-8316-efe0c256fc6c")
			.as(new TypeRef <List<Map<String, Object>>>() {
			});
	
	
	
			
				Map<String, Object>emp=(Map<String, Object>) allEmp.get(0);
				System.out.println("Employee name is..."+ emp.get("first_name"));
				
		
		
	}

}
