package com.restassured.jsons;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.restassured.payload.Payload;

import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {
	
	
	@Test
	public void complexJson()
	{
		JsonPath jsonpath =new JsonPath(Payload.CoursePrice());
		int count = jsonpath.getInt("courses.size()");
		System.out.println("Count is..."+ count);
		
		//Purchase amount
		
		int purchaseAmount=jsonpath.getInt("dashboard.purchaseAmount");
		
		System.out.println("Purchase amount is..."+purchaseAmount);
		
		//print title of the course
		
		String title= jsonpath.getString("courses[0].title");
		
		System.out.println("Title is...."+title);
		
		
		//Print all course title
		
		for (int i = 0; i < count; i++) {
			String courseTitle=jsonpath.get("courses["+i+"].title");
			String price =jsonpath.get("courses["+i+"].price").toString();
			System.out.println("Title is..."+ courseTitle+"------"+ price);
			
		}
		
		
		
		// Print Number of coupies sold by RPA
		
		for (int i = 0; i < count; i++) {
			String courseTitle=jsonpath.get("courses["+i+"].title");
			
			if (courseTitle.equalsIgnoreCase("rpa"))
			{
						int copies =jsonpath.get("courses["+i+"].copies");
						System.out.println("Copies is..."+ copies);
						break;
			}
			
			
			String price =jsonpath.get("courses["+i+"].price").toString();
			System.out.println("Title is..."+ courseTitle+"------"+ price);
			
		}
		
		//Verify sum of all Course prices matches the Purchase Amount.
		
		int sum =0;
		for (int i = 0; i < count; i++) 
		{
			int price=jsonpath.get("courses["+i+"].price") ;
			int copies=jsonpath.get("courses["+i+"].copies") ;
			int amount =price * copies;
			sum =sum+amount;
			System.out.println("Sum  is............."+sum);
			
		}
		
		Assert.assertEquals(purchaseAmount, sum);
		
	}
	
	
	
	
	
	

}
