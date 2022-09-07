package com.restassured.json;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;

public class A39ConvertJsonToJavaMap {
	
	
	
	@Test
	public void convertJsonToJavaMap() 
	{
		
		Map<?, ?> jsonResponseAsMap = RestAssured
				.given()
				.log()
				.all()
				.get("https://run.mocky.io/v3/2e012f29-433e-4076-9081-d99b5ef981b0")
				.as(Map.class);
		
				String firstname= (String) jsonResponseAsMap.get("first_name");
				
				System.out.println(firstname);
				
				jsonResponseAsMap.keySet().forEach(k -> System.out.println(k));
	}
	
	
	
	@Test
	public void convertNestedJsonToJavaMap() {
		
		Map jsonResponseAsMap = RestAssured
										
					.given()
					.log()
					.all()
					.get("https://run.mocky.io/v3/0a9cd9dc-b13d-421b-957f-8621577e882c")
					.as(Map.class);
		
					Map<String,String> skillsMap= (Map<String,String>) jsonResponseAsMap.get("skills");
					System.out.println(skillsMap.get("name"));
					System.out.println(skillsMap.get("proficiency"));
		
	}
	
	
	
	@Test
	public void convertJsonToJavaMapWithGenerics() 
	{
		
		System.out.println("Generics....................................");
		Map<String, Object> jsonResponseAsMap = RestAssured
				.given()
				.log()
				.all()
				.get("https://run.mocky.io/v3/2e012f29-433e-4076-9081-d99b5ef981b0")
				.as(new TypeRef<Map<String,Object>>() {});
		
				String firstname= (String) jsonResponseAsMap.get("first_name");
				
				System.out.println(firstname);
				
				jsonResponseAsMap.keySet().forEach(k -> System.out.println("Value is...."+  k));
	}

}
