package com.restassured.jiraand2oauth;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class OAuth2DotZero
{
	

	@Test
	public void OAuth()
	{
		//How to get code:
		//https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php
		
		//String url ="https://rahulshettyacademy.com/getCourse.php?state=verifyfjdss&code=4%2FvAHBQUZU6o4WJ719NrGBzSELBFVBI9XbxvOtYpmYpeV47bFVExkaxWaF_XR14PHtTZf7ILSEeamywJKwo_BYs9M&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&session_state=0c32992f0d47e93d273922018ade42d1072b9d1f..a35c&prompt=none#";
		
		    System.setProperty("", "");
		    
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.get("https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php");
			driver.findElement(By.cssSelector("email")).sendKeys("emainname");
			driver.findElement(By.cssSelector("")).sendKeys(Keys.ENTER);
			driver.findElement(By.cssSelector("email")).sendKeys("password");
			driver.findElement(By.cssSelector("")).sendKeys(Keys.ENTER);
			String url=   driver.getCurrentUrl();
			String code= url.split("code=")[1].split("&scope")[0];
			
			
		//urlEncodingEnabled(false)  === It will not encode the special characters.
		
		 String accessTokenResponse=  RestAssured.given().urlEncodingEnabled(false)
		.queryParam("code", code)
		.queryParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.queryParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
		.queryParams(" redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
		.queryParams("grant_type","authorization_code")
		.when().log().all()
		.post("https://www.googleapis.com/oauth2/v4/token").asString();
		 JsonPath jsonPath = new JsonPath(accessTokenResponse);
		String accessToken= jsonPath.getString("access_token");
		
		
		
		
		
		String response=  RestAssured.given().queryParam("access_token", accessToken)
		  .when().log().all()
		  .get("https://rahulshettyacademy.com/getCourse.php").asString();
		System.out.println("Response is..."+response);
	}
	
	
	
	@Test
	public void ClientOAuth()
	{
		
	}
}
