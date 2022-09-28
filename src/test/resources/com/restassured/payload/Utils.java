package com.restassured.payload;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

public class Utils 
{
	
	public static RequestSpecification resquestSpecification;
    
	public RequestSpecification requestSpecification() throws IOException {
		if (resquestSpecification == null) {
			try {
				PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
				resquestSpecification = (RequestSpecification) new RequestSpecBuilder()
													.setBaseUri(getGlobalValue("baseUrl")).addQueryParam("key", "qaclick123")
													.addFilter(RequestLoggingFilter.logRequestTo(log))
													.addFilter(ResponseLoggingFilter.logResponseTo(log));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		return resquestSpecification;
	}

	public static String getGlobalValue(String key) throws IOException {

		Properties prop = new Properties();

		FileInputStream fis = new FileInputStream(
				new File(System.getProperty("user.dir") + "\\src\\test\\resources\\global.properties"));
		prop.load(fis);
		return prop.getProperty(key);

	}

}
