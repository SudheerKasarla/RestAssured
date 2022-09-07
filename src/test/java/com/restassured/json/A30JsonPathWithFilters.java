package com.restassured.json;

import java.io.File;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class A30JsonPathWithFilters {
	
	
	@Test
	public static void filters()
	{
		String filePath = System.getProperty("user.dir")+ "\\Data\\Json.txt";
		
		File jsonArrayFile =new File(filePath);
		
		JsonPath jsonPath =new JsonPath(jsonArrayFile);
		System.out.println(jsonPath.getString("[0].first_name"));
		
		List<String> allFirstNames = jsonPath.getList("first_name");
		
		System.out.println("All first names ...." + allFirstNames);
		
		/*
		 * 
		 * 1. findAll -->  
		 */
		
		List<String> allFemaleFirstNames =   jsonPath.getList("findAll{it.gender == 'Female'}.first_name");
		
		System.out.println("All female names is....." + allFemaleFirstNames);
		
		String email = jsonPath.getString("find{it.first_name == 'Robin8' & it.last_name == 'Hood8'}.email");
		System.out.println("Email id is...." + email);
		
		List<String> allEmail = jsonPath.getList("findAll{it.first_name == 'Robin8' | it.last_name == 'Hood8'}.email");
		System.out.println("Email id is...." + allEmail);
		
		List<String> allIDs = jsonPath.getList("findAll{it.id >= 5}.first_name");
		System.out.println("Email id is...." + allIDs);
		
		System.out.println("Json size is...."+ jsonPath.getInt("size()"));
		
		
		
	}
	
	
	
	
	@Test
	public void filtersData()
	{

		String filePath = System.getProperty("user.dir")+ "\\Data\\Json2.txt";
		
		File jsonArrayFile =new File(filePath);
		
		JsonPath jsonPath =new JsonPath(jsonArrayFile);
		System.out.println(jsonPath.getString("data[0].first_name"));
		
		
		
		List<String> allFemaleFirstNames = jsonPath.getList("data.findAll{it.gender == 'Female'}.first_name");
		
		
		System.out.println("Female names is...." + allFemaleFirstNames);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
