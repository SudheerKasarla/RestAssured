package stepDefinitions;

import org.junit.runner.RunWith;

import com.restassured.ResponseSpecification;
import com.restassured.payload.TestDataBuild;
import com.restassured.payload.Utils;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@RunWith(Cucumber.class)
public class StepDefinition extends Utils
{
	
	RequestSpecification resquestSpecification;
	ResponseSpecification responseSpecification;
	Response response;
	TestDataBuild data = new TestDataBuild();

	

	

	@Given("Add Place Payload")
	public void add_place_payload() {
	    
	}
	@When("user calls {string} with Post http request")
	public void user_calls_with_post_http_request(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("the API call got success with the status code {int}")
	public void the_api_call_got_success_with_the_status_code(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
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
