package com.restassured;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;

public class A22HeadersExample {
	 
	
	
	/*
	 * 
	 * 1. Header are metadata associated with REQUEST and RESPONSE of API.
	 * 2. It may contain Authorization, cookies,body type, proxies, additional data for API to work.
	 * 3. Request and Response both can have associated headers.
	 * 4. Key - Value/s pair.
	 * 
	 * using header() method
	 * using headers() method
	 */
	
	
	
	@Test
	public void passHeader()
	{
		RestAssured
			.given()
			.log()
			.all()
			.header("Header1","value1")
			.header("Header1","value1","value2","value3","value4","value5")
			.when()
			.get();
		
	}
	
	@Test
	public void passHeader2()
	{
		RestAssured
			.given()
			.log()
			.all()
			.header("Header1","value1")
			.header("Header1","value2")
			.when()
			.get();
		
	}
	
	
	
	@Test
	public void passHeader3()
	{
		Header header = new Header("Header1", "value1");
		RestAssured
			.given()
			.log()
			.all()
			.header(header)
			.when()
			.get();
		
	}
	
	
	@Test
	public void passHeader4()
	{
		
		RestAssured
			.given()
			.log()
			.all()
			.headers("h1","h2","A1")
			.when()
			.get();
		
	}
	
	@Test
	public void passHeader5()
	{
		
		Map<String, String> headerMap =new HashMap<>();
		headerMap.put("h1", "v1");
		headerMap.put("h2", "v2");
		headerMap.put("h3", "v3");
		
		
		RestAssured
			.given()
			.log()
			.all()
			.headers(headerMap)
			.when()
			.get();
		
	}
	
	
	
	@Test
	public void passHeader6()
	{
		
		Header header =new Header("Header1", "value1");
		Headers headers =new Headers(header);
		
		
		RestAssured
			.given()
			.log()
			.all()
			.headers(headers)
			.when()
			.get();
		
	}

}
