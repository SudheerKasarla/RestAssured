package com.restassured.payload;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import io.restassured.specification.RequestSpecification;

public class Utils 
{
	RequestSpecification resquestSpecification;
	
	public void requestSpecification()
	{
		
	}
	
	public static String getGlobalValue(String key) throws IOException
	{
		
		Properties prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\global.properties"));
			prop.load(fis);
		
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prop.getProperty(key);
	
		
	}

}
