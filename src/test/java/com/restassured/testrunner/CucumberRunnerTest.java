package com.restassured.testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		//plugin ={"pretty","html:target/cucumber-reports"},
		//"pretty","junit:target/cucumber-reports/Cucumber.xml"
		//plugin ={"pretty","json:target/cucumber-reports/Cucumber.json"},
		features = "src/test/resources/Features/*.*",
		glue = {"com.restassured.cucumber.stepdefinitions"},
		tags = "@positive", monochrome = true)
public class CucumberRunnerTest extends AbstractTestNGCucumberTests{
	
	
	

}
