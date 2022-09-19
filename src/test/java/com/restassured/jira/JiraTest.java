package com.restassured.jira;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

public class JiraTest 
{
	@Test
	public void Jira()
	{
		
		//Add a comment to issue in JIRA
		SessionFilter sesson = new SessionFilter();
		RestAssured.baseURI ="https://localhost:8080";
		String response=	RestAssured.given().log().all().contentType(ContentType.JSON)
		.body("  \"username\": \"fred\",\r\n"
				+ "    \"password\": \"freds_password\"").log().all().
		filter(sesson)
		.when().post("/rest/auth/1/session").then().extract().response().asString();
		
		String exprectedMessage ="This is my first comment.";
	String addCommentId=	RestAssured.given().log().all()
		.pathParam("Id", "10101").contentType(ContentType.JSON)
		.body(" \"body\": \""+exprectedMessage+"\",\r\n"
				+ "    \"visibility\": {\r\n"
				+ "        \"type\": \"role\",\r\n"
				+ "        \"value\": \"Administrators\"")
		.filter(sesson)
		.when()
		.post("/rest/api/2/issue/{Id}/comment").then().log().all().assertThat().statusCode(200).extract().asString();
		JsonPath jsonPath = new JsonPath(addCommentId);
		String commentId=jsonPath.getString("id");
		
		
		//Add attachment in Jira
		
		//Multipart is used to attach a file
		
		RestAssured.given().log().all()
		.header("X-Atlassian-Toke", "no-check")
		.filter(sesson)
		.contentType(ContentType.MULTIPART)
		.pathParam("Id", "10101")
		.multiPart("file", new File("Jira.txt"))
		.when().post("/rest/api/2/issue/{Id}/attachments").then().log().all().assertThat().statusCode(200);
		
		//Get Issue
		// Limit the response and get only required fields.
		String response2=RestAssured.given().log().all()
		.filter(sesson)
		.pathParam("Id", "10101")
		.queryParam("fields", "comment")   ///With the help of query parameters, we can get only required output.
		.log()
		.all()
		.when()
		.get("/rest/api/2/issue/{Id}").then().log().all().extract().response().asString();
		
		JsonPath jsonPath2 = new JsonPath(response2);
		int commentsCount = jsonPath2.getInt("fields.comment.comments.size()");
		for(int i =0; i< commentsCount;i++)
		{
			 String commentIdIssue =  jsonPath2.get("fields.comment.comments["+i+"]").toString();
			 if (commentIdIssue.equals(addCommentId))
			 {
				  String actualMessage=  jsonPath2.get("fields.comment.comments["+i+"].body").toString();
				  System.out.println("Message is..."+ actualMessage);
				  Assert.assertEquals(exprectedMessage, actualMessage);
				
			}
			
		}
		
		//Https certificate validation--- relaxedHTTPSValidation
		/*
		 * It will take care of https cerificate validation - relaxedHTTPSValidation()
		 */
			RestAssured.given()
			.relaxedHTTPSValidation()
			.contentType(ContentType.JSON);
		
		
		
		
		
	}
	


}
