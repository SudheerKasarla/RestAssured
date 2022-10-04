package com.selenium.listener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer
{
	private int retryCount=0;
	private int maxRetryCount=3;
	
	@Override
	public boolean retry(ITestResult result) 
	{
	
		if (retryCount< maxRetryCount)
		{
			System.out.println("Retrying test name " + result.getName() + "with status  " +getResultStatusName(result.getStatus()) + "for retry count  "
					+(retryCount+1) + "in time(s)");
			
			retryCount++;
			return true;
		}

		return false;
	}
	
	public String getResultStatusName(int status)
	{
		String resultName =null;
		if (status ==1)
		{
			resultName ="Success";
			
		}else if (status ==2)
		{
			resultName ="Failure";
			
		}
		else if (status ==3)
		{
			resultName ="Skip";
			
		}
		
		return resultName;
		
	}

}
