package com.selenium.seleniumfour;



import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumFourFeatures
{
	
	/*
	 * 
	 * 1) Capture Screenshot of the WebElement.
	   2) Open the new Tab on browser
       3) Open new window on browser
       4) Object Location
       5) below (): below () is used to find the element below to the specific web element.
	   6) toLeftOf(): It finds the web element which is left to the specified element.
	   7) toRightOf(): It finds the web element which is right to the specified web element.
	   8) above (): It finds the element which is above the specified element.
	   9) near (): near () target an element that is away from (approx. 50 pixels) from a specified web element.
	   10) Chrome Dev Tools
	   		a) Enable Network Offline
	   		b) Enable Network Online
	   		c) Get COnsole Logs
	   		d) Load Insecure Website
	   		
	   		ChromeDriver <--- ChromiumDriver <-- RemoteWebDriver


WebDriverManager---> No need to download specific browser driver.
	 */
	
	@Test
	public void Screenshoot() throws IOException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		WebElement logo = driver.findElement(By.xpath("//*[@class='orangehrm-login-branding']//img"));
		File file = logo.getScreenshotAs(OutputType.FILE);
		
		File dest = new File("logo.png");
		FileUtils.copyFile(file, dest);
		driver.quit();
	}
	
	
	@Test
	public void openNewTab()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.switchTo().newWindow(WindowType.TAB);
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@Test
	public void openNewWindow()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	
	@Test
	public void Location()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		WebElement logo = driver.findElement(By.xpath("//*[@class='orangehrm-login-branding']//img"));
		
		//Height and width
		logo.getRect().getDimension().getHeight();
		logo.getRect().getDimension().getWidth();
		
		//X & Y co-ordinates
		
		logo.getRect().getX();
		logo.getRect().getY();
		
	}
	
	@Test
	public void RelativeLocators()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(RelativeLocator.with(By.tagName("li")).toLeftOf(By.id("")).below(By.id("")));
	}
	
	
	
	@Test
	public void CaptureScreenShoot() throws IOException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/cell-phones");
		WebElement pageSection=   driver.findElement(By.xpath("//*[@class='side-2']"));
		File src = pageSection.getScreenshotAs(OutputType.FILE);
		File tgt = new File("Tgt.png");
		FileUtils.copyFile(src, tgt);
	}
	
	
	
	@Test
	public void CaptureScreenShotOfSpecificWebElement() throws IOException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/cell-phones");
		WebElement pageSection=   driver.findElement(By.xpath("//*[@class='side-2']"));
		Highlight(pageSection, driver);
		File src = pageSection.getScreenshotAs(OutputType.FILE);
		File tgt = new File("Tgt.png");
		FileUtils.copyFile(src, tgt);
	}
	
	
	
	
	
	public void Highlight(WebElement element, WebDriver driver)
	{
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.border='2px solid red'", element);
	}
	
}
