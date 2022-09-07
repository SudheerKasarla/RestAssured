package com.restassured.json;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class A37NestedJsonJsonMap {

	@Test
	public void jsonPayLoadUsingArray() {

		List<Map<String, Object>> finalPayload = new ArrayList<Map<String, Object>>();

		Map<String, Object> firstJsonObject = new LinkedHashMap<String, Object>();
		firstJsonObject.put("id", 1);
		firstJsonObject.put("first_name", "Claire");
		firstJsonObject.put("last_name", "Dennerley");
		firstJsonObject.put("email", "cdennerley0@uol.com.br");
		firstJsonObject.put("gender", "Male");

		List<String> mobileno = Arrays.asList("123432156", "23456234");
		firstJsonObject.put("mobileno", mobileno);

		Map<String, Object> skillSet1 = new HashMap<>();
		skillSet1.put("name", "Testing");
		skillSet1.put("proficiency", "medium");

		firstJsonObject.put("skills", skillSet1);

		Map<String, Object> secondJsonObject = new LinkedHashMap<String, Object>();
		secondJsonObject.put("id", 2);
		secondJsonObject.put("first_name", "Claire2");
		secondJsonObject.put("last_name", "Dennerley2");
		secondJsonObject.put("email", "cdennerley02@uol.com.br");
		secondJsonObject.put("gender", "Male2");

		List<Map<String, Object>> skillsList = new LinkedList<Map<String, Object>>();
		skillsList.add(skillSet1);

		Map<String, Object> javaSkill = new HashMap<String, Object>();
		javaSkill.put("name", "Java");
		javaSkill.put("proficiency", "Medium");

		List<String> allCert = Arrays.asList("OCP 11", "OCP 12");
		javaSkill.put("certifications", allCert);

		skillsList.add(javaSkill);

		secondJsonObject.put("skills", skillsList);

		finalPayload.add(firstJsonObject);
		finalPayload.add(secondJsonObject);

		RestAssured.given().log().all().body(finalPayload).get();

		/*
		 * output
		 *  [ 
		 *  	{ "id": 1, 
		 *  		"first_name": "Claire", 
		 *  		"last_name": "Dennerley",
		 * 		"email": "cdennerley0@uol.com.br", 
		 * 		"gender": "Male", 
		 * 		"mobileno": ["123432156", "23456234" ],
		 * 		 "skills": { 
		 * 				"name": "Testing",
		 * 		 		"proficiency":"medium" 
		 * 					} }, 
		 *      { "id": 2, 
		 *      	"first_name": "Claire2", 
		 *      	"last_name": "Dennerley2",
		 * 		"email": "cdennerley02@uol.com.br", 
		 * 		"gender": "Male2", 
		 * 		"skills": 
		 * 				[ 
		 * 					{ 
		 * 						"name":"Testing", 
		 * 						"proficiency": "medium"
		 * 					 }, 
		 * 					{ "name": "Java", 
		 * 						"certifications": ["OCP 11", "OCP 12" ]
		 * 						, "proficiency": "Medium" 
		 * 					} 
		 * 				]
		 * 	 } 
		 * ]
		 * 
		 * 
		 * 
		 */

	}

}
