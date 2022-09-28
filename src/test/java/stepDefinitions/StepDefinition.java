package stepDefinitions;

import java.io.IOException;

import org.junit.runner.RunWith;


import com.restassured.payload.TestDataBuild;
import com.restassured.payload.Utils;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

@RunWith(Cucumber.class)
public class StepDefinition extends Utils
{
	
	RequestSpecification reqSpec;
	ResponseSpecification resSpec;
	Response response;
	TestDataBuild data = new TestDataBuild();

	

	


	@Given("Add Place Payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String language, String address) throws IOException 
	{
		reqSpec=	RestAssured.given().spec(requestSpecification()).body(data.addPlacePayLoad(name, language, address));
	}



	@When("user calls {string} with Post http request")
	public void user_calls_with_post_http_request(String string) 
	{
	    
	}
	@Then("the API call got success with the status code {int}")
	public void the_api_call_got_success_with_the_status_code(Integer int1)
	{
	   
	}
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String string, String string2) 
	{
	    
	}



	@Given("User is on NetBanking landing page")
	public void user_is_on_net_banking_landing_page() {
	   System.out.println("Net banking page.......");
	}
	@When("User login in the login page")
	public void user_login_in_the_login_page() {
		   System.out.println("Login page .......");
	}



	@And("I should see Home page")
	public void i_should_see_home_page() 
	{
		System.out.println("And statement ..............");
	    
	}
	
	


	@When("I should see default Home page")
	public void i_should_see_default_home_page() 
	{
		System.out.println("And statement is........");
	  
	}



}
