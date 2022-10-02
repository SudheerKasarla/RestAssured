package com.selenium.listener;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class TestListener implements ITestListener
{
	
	
	/*
	 * https://www.seleniumeasy.com/testng-tutorials/how-to-take-screenshot-for-only-failed-tests-using-webdriver
	 * https://www.seleniumeasy.com/testng-tutorials/retry-stacktrace-and-screenshots-in-report
	 * <listeners>
       			<listener class-name="com.pack.listeners.TestListener"/>
  		</listeners>
	 */
	public void onTestFailure(ITestResult result)
	{
		result.getMethod().getMethodName();
		String methodName=result.getName().toString().trim();
        ITestContext context = result.getTestContext();
       WebDriver driver = (WebDriver)context.getAttribute("driver");
    	try {
			takeScreenShot(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void takeScreenShot(ITestResult result) throws IOException
	{
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		
		Reporter.setCurrentTestResult(result);

		String targetLocation ="";
		String testClassName = getTestClassName(result.getInstanceName()).trim();
		String timeStamp = dateFormat.format(cal.getTime());
		String testMethodName = result.getName().trim();
		String screenShotName = testMethodName +"_"+ timeStamp + ".png";
		ITestContext context = result.getTestContext();
		WebDriver driver = (WebDriver) context.getAttribute("driver");
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File targetFile = new File(targetLocation);
		FileHandler.copy(screenshotFile, targetFile);
		
	}
	public String getTestClassName(String testName) {
		String[] reqTestClassname = testName.split("\\.");
		int i = reqTestClassname.length - 1;
		
		return reqTestClassname[i];
	}
}
