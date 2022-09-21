package com.restassured.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/*

@CucumberOptions(
		//plugin ={"pretty","html:target/cucumber-reports"},
		//"pretty","junit:target/cucumber-reports/Cucumber.xml"
		//plugin ={"pretty","json:target/cucumber-reports/Cucumber.json"},
		features = "src/test/resources/Features/*.*",
		glue = {"com.restassured.cucumber.stepdefinitions"},
		tags = "@positive", monochrome = true)  
public class CucumberRunnerTest extends AbstractTestNGCucumberTests
{
	
	
	

}*/

//Feature File path, StepDefinitions and parameters we need to pass test runner.
/*
 * features -- Path of the features files
 * glue -Parameter to define STEPDEFINTIONS(Make sure FEATURES and GLUE should have same parent i.e src/test/java
 * 
 * We need to mark the path till the package.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/features",
		glue = "stepDefinitions"
		)
public class CucumberRunnerTest
{
	
}