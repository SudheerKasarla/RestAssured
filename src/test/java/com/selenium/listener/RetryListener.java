package com.selenium.listener;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

public class RetryListener implements IAnnotationTransformer
{
	
	
	/*
	 *  In TestNG add listeners.
	 * <listeners>
        <listener class-name="com.pack.test.RetryListener"/>
  </listeners>
	 */
	
	@SuppressWarnings("rawtypes")
	@Override
	public void transform(ITestAnnotation testannotation, Class testClass, Constructor testConstructor, Method testMethod)
	{
			Class<? extends IRetryAnalyzer>  retry = testannotation.getRetryAnalyzerClass();
			
			if (retry == null)	{
				testannotation.setRetryAnalyzer(Retry.class);
			}
		
	}
	
	

}
